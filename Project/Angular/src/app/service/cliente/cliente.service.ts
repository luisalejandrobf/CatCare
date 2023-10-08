import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  // RECORDAR HACER npm install rxjs

  // Generado con ng generate service service/cliente/cliente
  // Agregar HttpClientModule a imports en module.ts

  private ROOT_URL = 'http://localhost:8090/catcare/clientes';

  constructor(private http: HttpClient) {}

  getAllClientes(): Observable<any[]> {
    return this.http.get<any[]>(`${this.ROOT_URL}/all`);
  }

  getPacientesByClienteId(clienteId: number): Observable<any[]> {
    return this.http.get<any[]>(`${this.ROOT_URL}/mascotas/${clienteId}`);
  }

  getClienteById(clienteId: number): Observable<any> {
    return this.http.get<any>(`${this.ROOT_URL}/find?id=${clienteId}`);
  }

  agregarCliente(cliente: any): Observable<any> {
    return this.http.post<any>(`${this.ROOT_URL}/agregar`, cliente);
  }

  eliminarCliente(clienteId: number): Observable<any> {
    return this.http.delete<any>(`${this.ROOT_URL}/delete/${clienteId}`);
  }

  actualizarCliente(clienteId: number, cliente: any): Observable<any> {
    return this.http.put<any>(`${this.ROOT_URL}/update/${clienteId}`, cliente);
  }


}
