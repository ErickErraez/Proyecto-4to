import { Expositor } from './expositor';

export class Sala {
    id?: number;
    codigo: string;
    nombre: string;
    tema: string;
    capacidad: string;
    preguntasPermitidas: number;
    expositores: Expositor;
    estado: string;
}
