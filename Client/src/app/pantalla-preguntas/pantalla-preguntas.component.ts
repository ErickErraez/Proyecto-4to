import { Component, OnInit } from '@angular/core';
import { PreguntasService } from '../services/pregunta.service';
import { PruebaService } from '../services/prueba.service';

@Component({
  selector: 'app-pantalla-preguntas',
  templateUrl: './pantalla-preguntas.component.html',
  styleUrls: ['./pantalla-preguntas.component.scss']
})
export class PantallaPreguntasComponent implements OnInit {

  constructor(private prueba: PruebaService) {
 this.prueba.getPreguntas();
  
   }

  ngOnInit() {
  }

}
