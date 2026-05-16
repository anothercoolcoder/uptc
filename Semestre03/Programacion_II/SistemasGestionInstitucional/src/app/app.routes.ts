import { Routes } from '@angular/router';
import { ListarEstudiantes } from './gestion-estudiantes/listar-estudiante/listar-estudiante';
import { CrearEstudiantes } from './gestion-estudiantes/crear-estudiantes/crear-estudiantes';
export const routes: Routes = [
  {path:'listar',component: ListarEstudiantes},
  {path: 'crear',component: CrearEstudiantes}
];
