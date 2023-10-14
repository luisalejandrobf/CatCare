import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DrogaService {
  
  private ROOT_URL = 'http://localhost:8090/catcare/drogas';

  constructor(private http: HttpClient) {}

  getAllDrogas(): Observable<any[]> {
    return this.http.get<any[]>(`${this.ROOT_URL}/all`);
  }

  getDrogaById(drogaId: number): Observable<any> {
    return this.http.get<any>(`${this.ROOT_URL}/find?id=${drogaId}`);
  }

  agregarDroga(droga: any): Observable<any> {
    return this.http.post<any>(`${this.ROOT_URL}/agregar`, droga);
  }

  eliminarDroga(drogaId: number): Observable<any> {
    return this.http.delete<any>(`${this.ROOT_URL}/delete/${drogaId}`);
  }

  actualizarDroga(drogaId: number, droga: any): Observable<any> {
    return this.http.put<any>(`${this.ROOT_URL}/update/${drogaId}`, droga);
  }
  
}
