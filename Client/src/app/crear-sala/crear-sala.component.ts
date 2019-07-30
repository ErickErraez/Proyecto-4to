import { Component, OnInit } from '@angular/core';
import { Sala } from '../Models/sala';
import { ExpositorService } from '../services/expositor.service';
import { Expositor } from '../Models/expositor';
import { SalaService } from '../services/salas.service';

@Component({
  selector: 'app-crear-sala',
  templateUrl: './crear-sala.component.html',
  styleUrls: ['./crear-sala.component.scss']
})
export class CrearSalaComponent implements OnInit {

  sala: Sala;
  expositor: Expositor;
  estado: boolean;
  expositores: any = [];

  constructor(private expositoresServices: ExpositorService, private salaServices: SalaService) {
    this.sala = new Sala();
    this.expositor = new Expositor();
  }

  ngOnInit() {
    this.estado = false;
    this.sala.codigo = Math.random().toString(36).substring(7).toUpperCase();
    this.obtenerExpositores();
  }

  tipoEstado() {
    if (this.estado) {
      this.estado = false;
      this.sala.estado = 'Inactivo';
    } else {
      this.estado = true;
      this.sala.estado = 'Activo';
    }
  }

  obtenerExpositores() {
    this.expositoresServices.getAllExpositores().then(respuesta => {
      this.expositores = respuesta;
      console.log(this.expositores);
    }).catch(error => {
      console.log('error');
    });
  }

  obtenerExpositor(id) {
    this.expositoresServices.getExpositorById(parseInt(id)).then(res => {
      this.expositor = res;
      this.sala.expositores = this.expositor;
      this.salaServices.postSala(this.sala).then(response => {
        console.log(response);
      }).catch(error => {

      });
    }).catch(er => {

    });
  }
  guardarSala() {
    this.obtenerExpositor(this.expositor.id);

  }

}
