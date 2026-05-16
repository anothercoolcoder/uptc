import { Component } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { GestionEstudiantesService } from '../gestion-estudiantes.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Estudiante } from '../Interfaces/estudiante.interface';
@Component({
  selector: 'app-crear-estudiantes',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './crear-estudiantes.html',
  styleUrl: './crear-estudiantes.css',
})
export class CrearEstudiantes {
  public estudianteForm = new FormGroup({
    id: new FormControl<number | null>(null),
    nombre: new FormControl<string>(''),
    edad: new FormControl<number | null>(null),
    genero: new FormControl<string>(''),
  });
  constructor(
    private estudianteService: GestionEstudiantesService,
    private activatedRoute: ActivatedRoute,
    private router: Router,
  ) {}
  get currentStudent(): Estudiante {
    const estudiante = this.estudianteForm.value as Estudiante;
    return estudiante;
  }

  onSubmit(): void {
    if (this.estudianteForm.invalid) return;

    this.estudianteService.agregarEstudiante(this.currentStudent).subscribe({
      next: (estudiante) => {
        console.log(`${estudiante.nombre} creado con éxito`);
        this.router.navigate(['/']);
      },
      error: (err) => {
        console.error('Error al conectar con Spring Boot:', err);
      },
    });
  }
}
