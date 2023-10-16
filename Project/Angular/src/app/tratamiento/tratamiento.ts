import { Droga } from "../droga/droga";
import { Paciente } from "../paciente/paciente";
import { Veterinario } from "../veterinario/veterinario";
import {Cliente} from "../cliente/cliente";

export interface Tratamiento{
  id: number;
  fechaDeInicio: Date;
  paciente: Paciente;
  droga: Droga;
  veterinario: Veterinario;
}
