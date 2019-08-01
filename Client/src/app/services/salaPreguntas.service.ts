import { Injectable } from '@angular/core';
import { SalaPregunta } from '../Models/salaPregunta';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class SalaPreguntasService {
  url = environment.url + 'salasPreguntas/';
  constructor(private http: HttpClient) { }

  getSalaPreguntasById(id) {
    return this.http.get(this.url + 'obtenerSalaspreguntas/' + id).toPromise().then(r => {
      return r;
    }).catch(e => {
      return e.body;
    });
  }

  getAllSalasPreguntas() {
    return this.http.get(this.url + 'obtenerSalasPreguntas').toPromise().then(r => {
      return r;
    }).catch(e => {
      return e.body;
    });
  }

  postSalasPreguntas(salapreguntas: SalaPregunta) {
    return this.http.post(this.url + 'guardarSalasPreguntas', salapreguntas).toPromise().then(r => {
      return r;
    }).catch(e => {
      return e.body;
    });
  }
}
