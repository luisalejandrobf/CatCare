import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {Cliente} from "../../cliente/cliente";
import {Administrador} from "../../administrador/administrador";
import {User} from "../../model/user";
import {Veterinario} from "../../veterinario/veterinario";

@Injectable({
  providedIn: 'root'
})
export class AdministradorService {

  private ROOT_URL = 'http://localhost:8090/catcare/administradores';

  constructor(private http: HttpClient) {}

  // Obtener todos los Administradores
  getAllAdministradores(): Observable<any[]> {
    return this.http.get<any[]>(`${this.ROOT_URL}/all`);
  }

// Obtener un administrador por su ID
  getAdministradorById(administradorId: number): Observable<any> {
    return this.http.get<any>(`${this.ROOT_URL}/find?id=${administradorId}`);
  }


  // Agregar un nuevo administrador
  agregarAdministrador(administrador: any): Observable<any> {
    return this.http.post<any>(`${this.ROOT_URL}/agregar`, administrador);
  }

  // Eliminar un administrador por su ID
  eliminarAdministrador(administradorId: number): Observable<any> {
    return this.http.delete<any>(`${this.ROOT_URL}/delete/${administradorId}`);
  }

  // Actualizar los datos de un administrador
  actualizarAdministrador(administradorId: number, administrador: any): Observable<any> {
    return this.http.put<any>(`${this.ROOT_URL}/update/${administradorId}`, administrador);
  }

  // Verificar inicio de sesión de un administrador
  verificarInicioSesion(user:User): Observable<string> {
    return this.http.post(`${this.ROOT_URL}/login`, user,
      {
        responseType: "text"
      });
  }

  administradorHome():Observable<Administrador>{
    return this.http.get<Administrador>("http://localhost:8090/catcare/administradores/details");
  }

}

