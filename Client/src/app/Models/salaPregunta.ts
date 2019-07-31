import { Sala } from './sala';
import { Preguntas } from './preguntas';

export class SalaPregunta {
  id?: number;
  salas: Sala;
  preguntas: Preguntas;
}
