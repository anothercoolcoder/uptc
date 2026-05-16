import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Estudiante } from './Interfaces/estudiante.interface';
import { catchError, map, Observable, of } from 'rxjs';
@Injectable({
  providedIn: 'root',
})
export class GestionEstudiantesService {
  private baseUrl = 'http://127.0.0.1:8081';

  constructor(private http: HttpClient) {}

  getEstudiantes(): Observable<Estudiante[]> {
    return this.http.get<Estudiante[]>(`${this.baseUrl}/listar`);
  }
  agregarEstudiante(estudiante: Estudiante): Observable<Estudiante> {
    return this.http.post<Estudiante>(`${this.baseUrl}/guardar`, estudiante);
  }
  eliminarEstudiante(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/borrar/${id}`, { responseType: 'text' });
  }
  actualizarEstudiante(id: number, estudiante: Estudiante): Observable<any> {
    return this.http.put<Estudiante>(`${this.baseUrl}/actualizar/${id}`, estudiante);
  }
}
