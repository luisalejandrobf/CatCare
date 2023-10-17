import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DrogaService {

  private ROOT_URL = 'http://localhost:8090/catcare/drogas';

  constructor(private http: HttpClient) {}

  //Obtener todas las drogas
  getAllDrogas(): Observable<any[]> {
    return this.http.get<any[]>(`${this.ROOT_URL}/all`);
  }

  // Obtener una droga por su ID
  getDrogaById(drogaId: number): Observable<any> {
    return this.http.get<any>(`${this.ROOT_URL}/find?id=${drogaId}`);
  }

  // Agregar una nueva droga
  agregarDroga(droga: any): Observable<any> {
    return this.http.post<any>(`${this.ROOT_URL}/agregar`, droga);
  }

  // Eliminar una droga por su ID
  eliminarDroga(drogaId: number): Observable<any> {
    return this.http.delete<any>(`${this.ROOT_URL}/delete/${drogaId}`);
  }

  // Actualizar los datos de una droga
  actualizarDroga(drogaId: number, droga: any): Observable<any> {
    return this.http.put<any>(`${this.ROOT_URL}/update/${drogaId}`, droga);
  }

}
