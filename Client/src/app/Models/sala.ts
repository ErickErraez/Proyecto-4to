import { Expositor } from './expositor';

export class Sala {
  id?: number;
  codigo: string;
  nombre: string;
  tema: string;
  capacidad: number;
  preguntasPermitidas: number;
  personasIngresadas: number;
  expositores: Expositor;
  estado: string;
}
