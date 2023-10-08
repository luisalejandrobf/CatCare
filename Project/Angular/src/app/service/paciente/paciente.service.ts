import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PacienteService {

  // Generado con ng generate service service/paciente/paciente

  private ROOT_URL = 'http://localhost:8090/catcare/pacientes'; // Replace with the actual API URL

  constructor(private http: HttpClient) {}

  getAllPacientes(): Observable<any[]> {
    return this.http.get<any[]>(`${this.ROOT_URL}/all`);
  }

  getPacienteById(pacienteId: number): Observable<any> {
    return this.http.get<any>(`${this.ROOT_URL}/find?id=${pacienteId}`);
  }

  agregarPaciente(paciente: any): Observable<any> {
    return this.http.post<any>(`${this.ROOT_URL}/agregar`, paciente);
  }

  eliminarPaciente(pacienteId: number): Observable<any> {
    return this.http.delete<any>(`${this.ROOT_URL}/delete/${pacienteId}`);
  }

  actualizarPaciente(pacienteId: number, paciente: any): Observable<any> {
    return this.http.put<any>(`${this.ROOT_URL}/update/${pacienteId}`, paciente);
  }

}
