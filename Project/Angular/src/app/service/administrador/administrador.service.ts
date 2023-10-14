import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AdministradorService {

  private ROOT_URL = 'http://localhost:8090/catcare/administradores';

  constructor(private http: HttpClient) {}

  getAllAdministradores(): Observable<any[]> {
    return this.http.get<any[]>(`${this.ROOT_URL}/all`);
  }

  getAdministradorById(administradorId: number): Observable<any> {
    return this.http.get<any>(`${this.ROOT_URL}/find?id=${administradorId}`);
  }

  agregarAdministrador(administrador: any): Observable<any> {
    return this.http.post<any>(`${this.ROOT_URL}/agregar`, administrador);
  }

  eliminarAdministrador(administradorId: number): Observable<any> {
    return this.http.delete<any>(`${this.ROOT_URL}/delete/${administradorId}`);
  }

  actualizarAdministrador(administradorId: number, administrador: any): Observable<any> {
    return this.http.put<any>(`${this.ROOT_URL}/update/${administradorId}`, administrador);
  }
}
