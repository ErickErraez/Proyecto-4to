import { Component, OnInit } from '@angular/core';
import { Preguntas } from '../Models/preguntas';
import { ActivatedRoute } from '@angular/router';
import { PreguntasService } from '../services/pregunta.service';
import { SalaService } from '../services/salas.service';
import { Sala } from '../Models/sala';
import { SalaPreguntasService } from '../services/salaPreguntas.service';
import { SalaPregunta } from '../Models/salaPregunta';
import { ToastrService } from 'ngx-toastr';

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
  cont: number = 0;

  constructor(private root: ActivatedRoute, private salaPreguntaServices: SalaPreguntasService,
    private preguntasService: PreguntasService, private salaServices: SalaService, private toastr: ToastrService) {
    this.preguntas = new Preguntas();
    this.salaPreguntas = new SalaPregunta();
    this.sala = new Sala();
    this.codigo = this.root.snapshot.params['codigo'];
    this.obtenerSala();
  }
  ngOnInit() {
    sessionStorage.setItem('showNav', 'false');
    this.obtenerPersonasPermitidas();
  }

  obtenerSala() {
    this.salaServices.getSalaByCode(this.codigo).then(response => {
      this.sala = response;
    }).catch(e => {

    });
  }

  guardarPregunta() {
    this.obtenerSala();
    if (this.sala.personasIngresadas <= this.sala.capacidad) {
      if (this.cont < this.sala.preguntasPermitidas) {
        if (this.sala.estado === 'Activo') {
          this.preguntasService.postPreguntas(this.preguntas).then(r => {
            this.preguntas = r;
            this.salaPreguntas.salas = this.sala;
            this.salaPreguntas.preguntas = this.preguntas;
            this.salaPreguntaServices.postSalasPreguntas(this.salaPreguntas).then(res => {
              this.cont += 1;
              this.toastr.success('Felicitaciones!', 'La pregunta se ha registrado con exito');
              this.preguntas = new Preguntas();
            }).catch(e => {
              this.toastr.error('Algo ha salido mal!', 'Oops lo sentimos!');
            });
          }).catch(e => {
            this.toastr.error('Algo ha salido mal!', 'Oops lo sentimos!');
          });
        }
        if (this.sala.estado === 'Inactivo') {
          this.toastr.error('La sala se ha cerrado!', 'Oops lo sentimos!');
        }
      } else {
        this.toastr.error('Has alcanzado el maximo de preguntas permitidas!', 'Oops lo sentimos!');
      }
    } else {
      this.toastr.error('La sala ha alcanzado el maximo de usuario!', 'Oops lo sentimos!');
    }
  }
  obtenerPersonasPermitidas() {
    this.salaServices.getSalaByCode(this.codigo).then(response => {
      this.sala = response;
      if (this.sala.personasIngresadas <= this.sala.capacidad) {
        this.sala.personasIngresadas += 1;
        this.salaServices.putSala(this.sala).then(r => {
        }).catch(e => {

        });
      }
    }).catch(e => {

    });


  }

}
