import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TratamientoService {

  private ROOT_URL = 'http://localhost:8090/catcare/tratamientos';

  constructor(private http: HttpClient) {}

  getAllTratamientos(): Observable<any[]> {
    return this.http.get<any[]>(`${this.ROOT_URL}/all`);
  }

  getTratamientoById(tratamientoId: number): Observable<any> {
    return this.http.get<any>(`${this.ROOT_URL}/find?id=${tratamientoId}`);
  }

  agregarTratamiento(tratamiento: any): Observable<any> {
    return this.http.post<any>(`${this.ROOT_URL}/agregar`, tratamiento);
  }

  eliminarTratamiento(tratamientoId: number): Observable<any> {
    return this.http.delete<any>(`${this.ROOT_URL}/delete/${tratamientoId}`);
  }

  actualizarTratamiento(tratamientoId: number, tratamiento: any): Observable<any> {
    return this.http.put<any>(`${this.ROOT_URL}/update/${tratamientoId}`, tratamiento);
  }
}
