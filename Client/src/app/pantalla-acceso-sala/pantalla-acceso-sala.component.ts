import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-pantalla-acceso-sala',
  templateUrl: './pantalla-acceso-sala.component.html',
  styleUrls: ['./pantalla-acceso-sala.component.scss']
})
export class PantallaAccesoSalaComponent implements OnInit {

  codigoQr: string;

  constructor() { }

  ngOnInit() {
    this.codigoQr = 'http://192.168.1.8:4200/formular-pregunta';
  }

}
