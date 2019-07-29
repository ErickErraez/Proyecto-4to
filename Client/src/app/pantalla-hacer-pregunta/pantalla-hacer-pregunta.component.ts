import { Component, OnInit } from '@angular/core';
import { Preguntas } from '../Models/preguntas';

@Component({
  selector: 'app-pantalla-hacer-pregunta',
  templateUrl: './pantalla-hacer-pregunta.component.html',
  styleUrls: ['./pantalla-hacer-pregunta.component.scss']
})
export class PantallaHacerPreguntaComponent implements OnInit {

  preguntas: Preguntas;

  constructor() {
    this.preguntas = new Preguntas();
  }

  ngOnInit() {
  }

}
