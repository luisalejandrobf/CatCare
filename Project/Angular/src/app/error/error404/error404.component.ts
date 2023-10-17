import { Component } from '@angular/core';

@Component({
  selector: 'app-error404',
  templateUrl: './error404.component.html',
  styleUrls: ['./error404.component.css']
})
// Componente para mostrar un mensaje de error cuando se encuentra con un error 404 (Página no encontrada).
export class Error404Component {
  errorMessage: string = 'La página que estás buscando no existe.';
  errorId: number = 404;

  constructor() { }
}
