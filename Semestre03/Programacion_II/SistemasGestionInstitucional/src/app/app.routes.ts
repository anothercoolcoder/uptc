import { Routes } from '@angular/router';
import { ListarEstudiante } from './gestion-estudiantes/listar-estudiante/listar-estudiante';
import { ListarEstudiantesComponent } from './gestion-estudiantes/listar-estudiante/listar-estudiante.component';

export const routes: Routes = [
  {path:'listar',component: ListarEstudiantesComponent}
];
