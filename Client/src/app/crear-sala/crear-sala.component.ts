import { Component, OnInit } from '@angular/core';
import { Sala } from '../Models/sala';

@Component({
  selector: 'app-crear-sala',
  templateUrl: './crear-sala.component.html',
  styleUrls: ['./crear-sala.component.scss']
})
export class CrearSalaComponent implements OnInit {

  sala: Sala;

  constructor() {
    this.sala = new Sala();
  }

  ngOnInit() {
  }

}
