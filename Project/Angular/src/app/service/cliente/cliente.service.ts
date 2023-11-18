import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {Cliente} from "../../cliente/cliente";
import {User} from "../../model/user";

@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  // RECORDAR HACER npm install rxjs

  // Generado con ng generate service service/cliente/cliente
  // Agregar HttpClientModule a imports en module.ts

  private ROOT_URL = 'http://localhost:8090/catcare/clientes';

  constructor(private http: HttpClient) {}

  // Obtener todos los clientes
  getAllClientes(): Observable<any[]> {
    return this.http.get<any[]>(`${this.ROOT_URL}/all`);
  }

  // Obtener un paciente por el  ID del cliente
  getPacientesByClienteId(clienteId: number): Observable<any[]> {
    return this.http.get<any[]>(`${this.ROOT_URL}/mascotas/${clienteId}`);
  }

  // Obtener un cliente por su ID
  getClienteById(clienteId: number): Observable<any> {
    return this.http.get<any>(`${this.ROOT_URL}/find?id=${clienteId}`);
  }

  // Agregar un nuevo cliente
  agregarCliente(cliente: any): Observable<any> {
    return this.http.post<any>(`${this.ROOT_URL}/agregar`, cliente);
  }

  // Eliminar un cliente por su ID
  eliminarCliente(clienteId: number): Observable<any> {
    return this.http.delete<any>(`${this.ROOT_URL}/delete/${clienteId}`);
  }

  // Actualizar los datos de un cliente
  actualizarCliente(clienteId: number, cliente: any): Observable<any> {
    return this.http.put<any>(`${this.ROOT_URL}/update/${clienteId}`, cliente);
  }

  verificarInicioSesion(user:User): Observable<string>{
    return this.http.post(`${this.ROOT_URL}/login`, user,
      {
        responseType: "text"
      });
  }

  clienteHome():Observable<Cliente>{
    return this.http.get<Cliente>("http://localhost:8090/catcare/clientes/details");
  }

  // Obtener todos los clientes filtrados con DTO
  getAllClientes_filtered(): Observable<any[]> {
    return this.http.get<any[]>(`${this.ROOT_URL}/allFiltered`);
  }

}
