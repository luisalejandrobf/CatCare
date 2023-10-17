import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PacienteService {

  // Generado con ng generate service service/paciente/paciente

  private ROOT_URL = 'http://localhost:8090/catcare/pacientes';

  constructor(private http: HttpClient) {}

  // Obtiene una colección de todos los pacientes.
  getAllPacientes(): Observable<any[]> {
    return this.http.get<any[]>(`${this.ROOT_URL}/all`);
  }

  // Obtiene un paciente por su ID.
  getPacienteById(pacienteId: number): Observable<any> {
    return this.http.get<any>(`${this.ROOT_URL}/find?id=${pacienteId}`);
  }

  // Agrega un nuevo paciente.
  agregarPaciente(paciente: any): Observable<any> {
    return this.http.post<any>(`${this.ROOT_URL}/agregar`, paciente);
  }

  // Elimina un paciente por su ID.
  eliminarPaciente(pacienteId: number): Observable<any> {
    return this.http.delete<any>(`${this.ROOT_URL}/delete/${pacienteId}`);
  }

  // Actualiza la información de un paciente.
  actualizarPaciente(pacienteId: number, paciente: any): Observable<any> {
    return this.http.put<any>(`${this.ROOT_URL}/update/${pacienteId}`, paciente);
  }

//Obtener tratamiento por medio deel ID de paciente
  getTratamientosByPacienteId(pacienteId: number): Observable<any[]> {
    return this.http.get<any[]>(`${this.ROOT_URL}/tratamientos/${pacienteId}`);
  }

}
