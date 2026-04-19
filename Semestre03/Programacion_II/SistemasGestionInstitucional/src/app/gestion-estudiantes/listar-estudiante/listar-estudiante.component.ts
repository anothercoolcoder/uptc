import { ChangeDetectorRef, Component } from '@angular/core';
import { Estudiante } from '../Interfaces/estudiante.interface';
import { GestionEstudiantesService } from '../gestion-estudiantes.service';
import { Router } from '@angular/router';
import { NgFor, NgIf } from '@angular/common';
@Component({
 selector: 'app-listar-estudiantes',
 standalone: true,
 imports: [NgFor, NgIf],
 templateUrl: './listar-estudiantes.component.html',
 styleUrl: './listar-estudiantes.component.css'
})
export class ListarEstudiantesComponent {
public estudiantes: Estudiante[]= [];
 constructor(private estudianteService: GestionEstudiantesService,
  private router: Router,
  private cdr: ChangeDetectorRef) {}
 ngOnInit(): void {

   this.estudianteService.getEstudiantes().subscribe({
    next: (result) => {
     console.log('Respuesta completa: ', result);
     this.estudiantes = result;
    this.cdr.detectChanges();
    },
    error: (err) =>{
     console.error('Error al obtener los datos: ', err);
    }
   });
   console.log(this.estudiantes);
  }
}
