import { Component, OnInit } from '@angular/core';
import { Sala } from '../Models/sala';
import { SalaService } from '../services/salas.service';
import { SalaPreguntasService } from '../services/salaPreguntas.service';
import { ToastrService } from 'ngx-toastr';
import { Preguntas } from '../Models/preguntas';



@Component({
  selector: 'app-pantalla-preguntas',
  templateUrl: './pantalla-preguntas.component.html',
  styleUrls: ['./pantalla-preguntas.component.scss']
})
export class PantallaPreguntasComponent implements OnInit {

  isSala: boolean = false;
  salas: any = [];
  salaPreguntas: any = [];
  preguntas: any = [];
  preguntasSeleccionadas: any = [];
  sala: Sala;
  pregunta: Preguntas;
  index: any;

  public hora: any = 0;
  public minutos: any = 0;
  public segundos: any = 0;

  public con = 0;
  public colection: Array<any> = [];
  public contador: any;
  seleccionado = false;
  cont: any;

  constructor(private salaServices: SalaService, private salaPreguntasServices: SalaPreguntasService, private toastr: ToastrService) {
    this.sala = new Sala();
    this.pregunta = new Preguntas();
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
    if (id !== undefined) {
      this.salaServices.getSalaById(parseInt(id)).then(r => {
        this.sala = r;
        this.isSala = true;
      }).catch(e => {
        console.log(e);
      });
    } else {
      this.toastr.error('Debe seleccionar almenos una Sala!', 'Oops se encontro un error!');
    }
  }

  actualizarEstadoSala(estado) {
    this.sala.estado = estado;
    this.salaServices.putSala(this.sala).then(r => {
      console.log(r);
      this.sala = r;
    }).catch(e => {

    });
  }

  start() {
    this.actualizarEstadoSala('Activo');
    if (this.contador == undefined) {
      this.contador = setInterval(() => {
        this.segundos += 1;
        if (this.segundos == 60) {
          this.segundos = 0;
          this.minutos += 1;
          if (this.minutos == 60) {
            this.minutos = 0;
            this.hora += 1;
            if (this.hora == 24) {
              this.hora = 0;
            }
          }
        }
      }
        , 1000);
    }
  }
  lapso() {
    let obj: any = {};
    obj.hora = this.hora;
    obj.minutos = this.minutos;
    obj.segundos = this.segundos;

    this.con += 1;
    this.colection.push(obj);
  }
  stop() {
    this.actualizarEstadoSala('Inactivo');
    clearInterval(this.contador);
    this.hora = 0;
    this.minutos = 0;
    this.segundos = 0;
    this.contador = null;
  }

  obtenerSalaPreguntas() {
    this.salaPreguntasServices.getAllSalasPreguntas().then(r => {
      this.salaPreguntas = r;
    }).catch(e => {
      console.log("no OK")
    })
  }

  obtenerSelecionado() {
    if (this.seleccionado) {
      this.seleccionado = false;

    } else {
      this.seleccionado = true;

    }

  }
  onSelect(actual): void {
    this.cont = 0;
    for (var i = 0; i < this.salaPreguntas.length; i++) {
      if (this.salaPreguntas[i].salas.id == this.sala.id) {
        this.preguntas.push(this.salaPreguntas[i].preguntas);
        if (document.getElementById(this.cont+= 1).checked) {
          this.preguntasSeleccionadas.push(actual);
        } else {
          this.index = this.preguntasSeleccionadas.indexOf(actual.id);
          this.preguntasSeleccionadas.splice(this.index, 1);
        }
      }
    }
  }
}