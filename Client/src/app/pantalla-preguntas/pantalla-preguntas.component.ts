import { Component, OnInit } from '@angular/core';
import { Sala } from '../Models/sala';
import { SalaService } from '../services/salas.service';

@Component({
  selector: 'app-pantalla-preguntas',
  templateUrl: './pantalla-preguntas.component.html',
  styleUrls: ['./pantalla-preguntas.component.scss']
})
export class PantallaPreguntasComponent implements OnInit {

  isSala: boolean = false;
  salas: any = [];
  sala: Sala;

  constructor(private salaServices: SalaService) {
    this.sala = new Sala();
    this.obtenerSalas();
  }

  ngOnInit() {
  }

  obtenerSalas() {
    this.salaServices.getAllSala().then(r => {
      this.salas = r;
      console.log(this.salas);
    }).catch(e => {
      console.log(e);
    });
  }

  obtenerSala(id) {
    this.salaServices.getSalaById(parseInt(id)).then(r => {
      this.sala = r;
      this.isSala = true;
    }).catch(e => {
      console.log(e);
    });
  }

}
