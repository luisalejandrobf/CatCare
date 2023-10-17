import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TratamientoService {

  private ROOT_URL = 'http://localhost:8090/catcare/tratamientos';

  constructor(private http: HttpClient) {}

  // Obtener todos los tratamientos
  getAllTratamientos(): Observable<any[]> {
    return this.http.get<any[]>(`${this.ROOT_URL}/all`);
  }

  // Obtener un tratamiento por su ID
  getTratamientoById(tratamientoId: number): Observable<any> {
    return this.http.get<any>(`${this.ROOT_URL}/find?id=${tratamientoId}`);
  }

  // Agregar un nuevo veterinario
  agregarTratamiento(tratamiento: any): Observable<any> {
    return this.http.post<any>(`${this.ROOT_URL}/agregar`, tratamiento);
  }

  // Eliminar un tratamiento por su ID
  eliminarTratamiento(tratamientoId: number): Observable<any> {
    return this.http.delete<any>(`${this.ROOT_URL}/delete/${tratamientoId}`);
  }

  // Actualizar los datos de un tratamiento
  actualizarTratamiento(tratamientoId: number, tratamiento: any): Observable<any> {
    return this.http.put<any>(`${this.ROOT_URL}/update/${tratamientoId}`, tratamiento);
  }
}
