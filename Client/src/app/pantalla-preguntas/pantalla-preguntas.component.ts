import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-pantalla-preguntas',
  templateUrl: './pantalla-preguntas.component.html',
  styleUrls: ['./pantalla-preguntas.component.scss']
})
export class PantallaPreguntasComponent implements OnInit {

  isSala: boolean = false;

  constructor() { }

  ngOnInit() {
  }

}
