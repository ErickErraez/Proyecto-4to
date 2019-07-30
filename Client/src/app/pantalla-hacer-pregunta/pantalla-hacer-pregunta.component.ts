import { Component, OnInit } from '@angular/core';
import { Preguntas } from '../Models/preguntas';
import { ActivatedRoute } from '@angular/router';
import { PreguntasService } from '../services/pregunta.service';
import { SalaService } from '../services/salas.service';
import { Sala } from '../Models/sala';

@Component({
  selector: 'app-pantalla-hacer-pregunta',
  templateUrl: './pantalla-hacer-pregunta.component.html',
  styleUrls: ['./pantalla-hacer-pregunta.component.scss']
})
export class PantallaHacerPreguntaComponent implements OnInit {

  codigo: any = null;
  preguntas: Preguntas;
  sala: Sala;

  constructor(private root: ActivatedRoute, private preguntasService: PreguntasService, private salaServices: SalaService) {
    this.preguntas = new Preguntas();
    this.sala = new Sala();
    this.codigo = this.root.snapshot.params['codigo'];
    this.obtenerPreguntaById();
  }
  ngOnInit() {

  }

  obtenerPreguntaById() {
    console.log(this.codigo);
    this.salaServices.getSalaById(this.codigo).then(response => {
      this.sala = response;
    }).catch(e => {

    });

  }
}
