import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {Cliente} from "../../cliente/cliente";
import {Veterinario} from "../../veterinario/veterinario";
import {User} from "../../model/user";

@Injectable({
  providedIn: 'root'
})
export class VeterinarioService {

  private ROOT_URL = 'http://localhost:8090/catcare/veterinarios';

  constructor(private http: HttpClient) {}

  // Obtener todos los veterinarios
  getAllVeterinarios(): Observable<any[]> {
    return this.http.get<any[]>(`${this.ROOT_URL}/all`);
  }

  // Obtener un veterinario por su ID
  getVeterinarioById(veterinarioId: number): Observable<any> {
    return this.http.get<any>(`${this.ROOT_URL}/find?id=${veterinarioId}`);
  }

  // Agregar un nuevo veterinario
  agregarVeterinario(veterinario: any): Observable<any> {
    return this.http.post<any>(`${this.ROOT_URL}/agregar`, veterinario);
  }

  // Eliminar un veterinario por su ID
  eliminarVeterinario(veterinarioId: number): Observable<any> {
    return this.http.delete<any>(`${this.ROOT_URL}/delete/${veterinarioId}`);
  }

  // Actualizar los datos de un veterinario
  actualizarVeterinario(veterinarioId: number, veterinario: any): Observable<any> {
    return this.http.put<any>(`${this.ROOT_URL}/update/${veterinarioId}`, veterinario);
  }

  //Obtener tratamientos por el ID del veterinario
  getTratamientosByVeterinarioId(veterinarioId: number): Observable<any[]> {
    return this.http.get<any[]>(`${this.ROOT_URL}/tratamientos/${veterinarioId}`);
  }

  //Obtener cantidad de veterinarios activos
  getVeterinariosActivos(): Observable<any> {
    return this.http.get<any[]>(`${this.ROOT_URL}/veterinariosActivos`);
  }

  //Obtener cantidad de veterinarios inactivos
  getVeterinariosInactivos(): Observable<any> {
    return this.http.get<any[]>(`${this.ROOT_URL}/veterinariosInactivos`);
  }

  // Verificar inicio de sesión de un veterinario
  verificarInicioSesion(user:Veterinario): Observable<string> {
    return this.http.post(`${this.ROOT_URL}/login`, user,
      {
        responseType: "text"
      });
  }

  veterinarioHome():Observable<Veterinario>{
    return this.http.get<Veterinario>("http://localhost:8090/catcare/veterinarios/details");
  }

}




