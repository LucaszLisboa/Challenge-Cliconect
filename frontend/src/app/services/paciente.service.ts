import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { catchError, Observable, retry, throwError } from 'rxjs';
import { Paciente } from '../models/paciente';

@Injectable({
  providedIn: 'root'
})
export class PacienteService {

  SERVER_URL = 'http://localhost:8080/pacientes'

  constructor(private http: HttpClient ) { }

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  }


  public getPacientes(): Observable<Paciente[]> {
    return this.http.get<Paciente[]>(`${this.SERVER_URL}`)
      .pipe(
        retry(2),
        catchError(this.handleError)
      );
  }

  public getPacienteById(id: number): Observable<Paciente> {
    return this.http.get<Paciente>(`${this.SERVER_URL}/${id}`)
      .pipe(
        retry(2),
        catchError(this.handleError)
      );
  }

  public createPaciente(paciente: Paciente): Observable<Paciente> {
    return this.http.post<Paciente>(`${this.SERVER_URL}`, JSON.stringify(paciente), this.httpOptions)
      .pipe(
        retry(2),
        catchError(this.handleError)
      );
  }

  public updatePaciente(paciente: Paciente): Observable<Paciente> {
    return this.http.put<Paciente>(`${this.SERVER_URL}/${paciente.id}`, JSON.stringify(paciente), this.httpOptions)
      .pipe(
        retry(1),
        catchError(this.handleError)
      );
  }

  public deletePaciente(paciente: Paciente) {
    return this.http.delete<Paciente>(`${this.SERVER_URL}/${paciente.id}`, this.httpOptions)
      .pipe(
        retry(1),
        catchError(this.handleError)
      )
  }

  handleError(error: HttpErrorResponse) {
    let errorMessage = '';
    if(error.error instanceof ErrorEvent) {
      errorMessage = error.error.message;
    } else {
      errorMessage = `Codigo de erro: ${error.status}\nMessage: ${error.message}`;
    }
    console.log(errorMessage);
    return throwError(errorMessage);
  }
}
