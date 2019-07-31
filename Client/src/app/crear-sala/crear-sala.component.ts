import { Component, OnInit } from '@angular/core';
import { Sala } from '../Models/sala';
import { ExpositorService } from '../services/expositor.service';
import { Expositor } from '../Models/expositor';
import { SalaService } from '../services/salas.service';
import { ToastrService } from 'ngx-toastr';

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

  constructor(private expositoresServices: ExpositorService, private salaServices: SalaService, private toastr: ToastrService) {
    this.sala = new Sala();
    this.expositor = new Expositor();
  }

  ngOnInit() {
    this.estado = false;
    this.sala.codigo = Math.random().toString(36).substring(7).toUpperCase();
    this.obtenerExpositores();
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
        this.toastr.success('Registo de Sala!', 'Creado con Exito!');
        console.log(response);
      }).catch(error => {
        this.toastr.error('Los Datos Son Incorrectos!', 'Oops algo ha salido mal!');
      });
    }).catch(er => {

    });
  }
  guardarSala() {
    this.sala.estado = 'Inactivo';
    this.obtenerExpositor(this.expositor.id);

  }

}
