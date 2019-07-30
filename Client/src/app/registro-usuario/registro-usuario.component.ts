import { Component, OnInit } from '@angular/core';
import { Preguntas } from '../Models/preguntas';

@Component({
  selector: 'app-registro-usuario',
  templateUrl: './registro-usuario.component.html',
  styleUrls: ['./registro-usuario.component.scss']
})
export class RegistroUsuarioComponent implements OnInit {

  preguntas: Preguntas;
  constructor() {
    this.preguntas = new Preguntas();
  }

  ngOnInit() {
  }

}
