import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Estudiante } from './Interfaces/estudiante.interface';
import { catchError, map, Observable, of } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class GestionEstudiantesService {
  private baseUrl = "http://127.0.0.1:5000";

 private apiListar: string = `${this.baseUrl}/listaPersonas`;

 constructor(private http: HttpClient) { }
 getEstudiantes():Observable<Estudiante[]> {

  return this.http.get<Estudiante[]>(this.apiListar);
 }

}
