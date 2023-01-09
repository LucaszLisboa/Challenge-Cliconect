import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { catchError, retry, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PacienteService {

  SERVER_URL = 'http://localhost:8080'

  constructor(private http: HttpClient ) { }

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  }


  public getPacientes() {
    return this.http.get(`${this.SERVER_URL}/pacientes`)
      .pipe(
        retry(2),
        catchError(this.handleError)
      );
  }

  public getPacienteById(id: number) {
    return this.http.get(`${this.SERVER_URL}/pacientes/${id}`)
      .pipe(
        retry(2),
        catchError(this.handleError)
      );
  }

  public createPaciente(paciente: any) {
    return this.http.post(`${this.SERVER_URL}/pacientes`, paciente)
      .pipe(
        retry(2),
        catchError(this.handleError)
      );
  }

  public updatePaciente(paciente: any) {
    return this.http.put(`${this.SERVER_URL}/pacientes/`, paciente)
      .pipe(
        retry(1),
        catchError(this.handleError)
      );
  }

  public deletePaciente(id: number) {
    return this.http.delete(`${this.SERVER_URL}/pacientes/${id}`)
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
