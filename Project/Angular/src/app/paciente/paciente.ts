import { Cliente } from "../cliente/cliente";

export interface Paciente {
  id: number;
  nombre: string;
  raza: string;
  edad: string;
  peso: string;
  enfermedad?: string;
  estado: string;
  foto?: string;
  cliente: Cliente
}
