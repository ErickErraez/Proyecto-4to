import { Component, OnInit } from '@angular/core';
import { Sala } from '../Models/sala';
import { SalaService } from '../services/salas.service';
import { SalaPreguntasService } from '../services/salaPreguntas.service';
import { ToastrService } from 'ngx-toastr';
import { Preguntas } from '../Models/preguntas';
import jsPDF from 'jspdf';

@Component({
  selector: 'app-pantalla-preguntas',
  templateUrl: './pantalla-preguntas.component.html',
  styleUrls: ['./pantalla-preguntas.component.scss']
})
export class PantallaPreguntasComponent implements OnInit {

  isSala = false;
  salas: any = [];
  salaPreguntas: any = [];
  preguntas: any = [];
  sala: Sala;
  pregunta: Preguntas;
  index: any;
  textoTotal: any;
  lines: any;
  rows: any;
  format: any;
  fontSize: any;
  dimtext: any;
  ht: any;
  wt: any;
  x: any = 15;
  y: any = 25;
  count: any;
  imgData: any;
  dimensionArray: any;

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
    }).catch(e => {
      this.toastr.error('No se ha podido obtener Salas!', 'Oops algo ha salido mal');
    });
  }

  obtenerSala(id) {
    if (id !== undefined) {
      this.salaServices.getSalaById(parseInt(id)).then(r => {
        this.sala = r;
        this.isSala = true;
      }).catch(e => {
        this.toastr.error('No se ha podido obtener la Sala!', 'Oops algo ha salido mal');
      });
    } else {
      this.toastr.error('Debe seleccionar almenos una Sala!', 'Oops se encontro un error!');
    }
  }

  actualizarEstadoSala(estado) {
    this.sala.estado = estado;
    this.salaServices.putSala(this.sala).then(r => {

      this.sala = r;
    }).catch(e => {

    });
  }

  start() {
    this.actualizarEstadoSala('Activo');
    if (this.contador === undefined) {
      this.contador = setInterval(() => {
        this.segundos += 1;
        if (this.segundos === 60) {
          this.segundos = 0;
          this.minutos += 1;
          if (this.minutos === 60) {
            this.minutos = 0;
            this.hora += 1;
            if (this.hora === 24) {
              this.hora = 0;
            }
          }
        }
      }
        , 1000);
    }
  }
  lapso() {
    const obj: any = {};
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
      console.log(r);
    }).catch(e => {
      this.toastr.error('No se ha podido encontrar salas!', 'Oops algo ha salido mal');
    });
  }

  agregar(data) {
    // Agregamos el elemento
    this.preguntas.push(data);
  }

  quitar(data) {
    // Filtramos el elemento para que quede fuera
    this.preguntas = this.preguntas.filter(s => s !== data);
  }

  generarPdf() {
    this.x = 20;
    this.y = 130;
    this.fontSize = 14;
    const rojo = '#ef0606';
    const azul = '#0F1939';
    const doc = new jsPDF('p', 'mm', this.format, true);
    doc.rect(10, 10, 190, 275);
    this.imgData = 'data:' + this.sala.expositores.imagenes.tipo + ';base64,' + this.sala.expositores.imagenes.adjunto;
    doc.addImage(this.imgData, 'JPEG', 20, 40, 40, 60);
    doc.setFontSize(20);
    doc.setTextColor(rojo);
    doc.text(this.sala.nombre, 60, 25);
    doc.setTextColor(azul);
    doc.setFontSize(16);
    doc.text('Expositor: ' + this.sala.expositores.nombre + ' ' + this.sala.expositores.apellido, 65, 60);
    doc.text('Tema tratado: ' + this.sala.tema, 65, 70);
    doc.text('Listado de Preguntas:', 30, 120);
    doc.setFontSize(this.fontSize);
    doc.setFontStyle('arial');
    for (let i = 0; i < this.preguntas.length; i++) {
      this.textoTotal = i + 1 + '. ' + this.preguntas[i].nombre + ' // ' + this.preguntas[i].pregunta;
      doc.text(this.x, this.y, this.textoTotal);
      this.y += 10;
    }
    doc.save('preguntas.pdf');
  }

  encabezado() {

  }

}

