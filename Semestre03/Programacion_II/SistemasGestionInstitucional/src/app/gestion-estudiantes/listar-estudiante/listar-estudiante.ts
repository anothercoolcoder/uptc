import { Component, OnInit } from '@angular/core'; // Añadido OnInit
import { Estudiante } from '../Interfaces/estudiante.interface';
import { GestionEstudiantesService } from '../gestion-estudiantes.service';
import { Router } from '@angular/router';
import { NgFor, NgIf } from '@angular/common';

@Component({
  selector: 'app-listar-estudiantes',
  standalone: true,
  imports: [NgFor, NgIf],
  templateUrl: './listar-estudiante.html',
  styleUrl: './listar-estudiante.css',
})
export class ListarEstudiantes implements OnInit {
  public estudiantes: Estudiante[] = [];

  constructor(
    private estudianteService: GestionEstudiantesService,
    private router: Router,
  ) {}

  ngOnInit(): void {
    this.cargarEstudiantes();
  }

  cargarEstudiantes(): void {
    this.estudianteService.getEstudiantes().subscribe({
      next: (data) => (this.estudiantes = data),
      error: (err) => console.error('Error al cargar:', err),
    });
  }

  eliminar(id: number | undefined): void {
    if (id && confirm('¿Seguro que deseas eliminar este registro?')) {
      // Usa el método borrar de tu servicio
      this.estudianteService.eliminarEstudiante(id).subscribe({
        next: () => {
          // Filtra el arreglo local para actualizar la tabla sin recargar
          this.estudiantes = this.estudiantes.filter((e) => e.id !== id);
          alert('Eliminado con éxito');
        },
        error: (err) => console.error('Error al borrar:', err),
      });
    }
  }

  editar(estudiante: Estudiante): void {
    // Navega a la ruta de edición usando el ID del estudiante
    this.router.navigate(['/editar-estudiante', estudiante.id]);
  }
}
