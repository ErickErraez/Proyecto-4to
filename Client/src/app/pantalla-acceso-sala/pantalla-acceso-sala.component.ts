import { Component, OnInit } from '@angular/core';
import { SalaService } from '../services/salas.service';
import { Sala } from '../Models/sala';

@Component({
  selector: 'app-pantalla-acceso-sala',
  templateUrl: './pantalla-acceso-sala.component.html',
  styleUrls: ['./pantalla-acceso-sala.component.scss']
})
export class PantallaAccesoSalaComponent implements OnInit {

  codigoQr: string;
  salas: any = [];
  sala: Sala;
  isSala: boolean;

  constructor(private salaServices: SalaService) {
    this.sala = new Sala();
    this.obtenerSalas();
    this.isSala = false;
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
      this.codigoQr = 'http://localhost:4200/formular-pregunta/' + this.sala.codigo;
    }).catch(e => {
      console.log(e);
    });
  }

}
