import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class VeterinarioService {

  private ROOT_URL = 'http://localhost:8090/catcare/veterinarios'; // Replace with the actual API URL

  constructor(private http: HttpClient) {}

  getAllVeterinarios(): Observable<any[]> {
    return this.http.get<any[]>(`${this.ROOT_URL}/all`);
  }

  getVeterinarioById(veterinarioId: number): Observable<any> {
    return this.http.get<any>(`${this.ROOT_URL}/find?id=${veterinarioId}`);
  }

  agregarVeterinario(veterinario: any): Observable<any> {
    return this.http.post<any>(`${this.ROOT_URL}/agregar`, veterinario);
  }

  eliminarVeterinario(veterinarioId: number): Observable<any> {
    return this.http.delete<any>(`${this.ROOT_URL}/delete/${veterinarioId}`);
  }

  actualizarVeterinario(veterinarioId: number, veterinario: any): Observable<any> {
    return this.http.put<any>(`${this.ROOT_URL}/update/${veterinarioId}`, veterinario);
  }

}
