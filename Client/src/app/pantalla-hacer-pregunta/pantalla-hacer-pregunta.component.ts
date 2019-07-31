import { Component, OnInit } from '@angular/core';
import { Preguntas } from '../Models/preguntas';
import { ActivatedRoute } from '@angular/router';
import { PreguntasService } from '../services/pregunta.service';
import { SalaService } from '../services/salas.service';
import { Sala } from '../Models/sala';
import { SalaPreguntasService } from '../services/salaPreguntas.service';
import { SalaPregunta } from '../Models/salaPregunta';

@Component({
  selector: 'app-pantalla-hacer-pregunta',
  templateUrl: './pantalla-hacer-pregunta.component.html',
  styleUrls: ['./pantalla-hacer-pregunta.component.scss']
})
export class PantallaHacerPreguntaComponent implements OnInit {

  codigo: any = null;
  preguntas: Preguntas;
  sala: Sala;
  salaPreguntas: SalaPregunta;

  constructor(private root: ActivatedRoute, private salaPreguntaServices: SalaPreguntasService,
    private preguntasService: PreguntasService, private salaServices: SalaService) {
    this.preguntas = new Preguntas();
    this.salaPreguntas = new SalaPregunta();
    this.sala = new Sala();
    this.codigo = this.root.snapshot.params['codigo'];
    this.obtenerPreguntaById();
  }
  ngOnInit() {
    sessionStorage.setItem('showNav', 'false');
  }

  obtenerPreguntaById() {
    console.log(this.codigo);
    this.salaServices.getSalaByCode(this.codigo).then(response => {
      this.sala = response;
    }).catch(e => {

    });
  }

  guardarPregunta() {
    this.preguntasService.postPreguntas(this.preguntas).then(r => {
      this.preguntas = r;
      this.salaPreguntas.salas = this.sala;
      this.salaPreguntas.preguntas = this.preguntas;
      this.salaPreguntaServices.postSalasPreguntas(this.salaPreguntas).then(res => {
        console.log(res);
      }).catch(e => {

      });
    }).catch(e => {

    });
  }

}
