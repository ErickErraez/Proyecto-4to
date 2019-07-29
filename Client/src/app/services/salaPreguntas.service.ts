import { Injectable } from '@angular/core';
import { SalaPregunta } from '../Models/salaPregunta';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class SalaPreguntasService {
  url = environment.url + 'salaPreguntas/';
  constructor(private http: HttpClient) { }

  getImagesById(id) {
    return this.http.get(this.url + 'obtenerSalaPreguntas' + id).toPromise().then(r => {
      return r;
    }).catch(e => {
      return e.body;
    });
  }

  getAllImages() {
    return this.http.get(this.url + 'obtenerSalaPreguntas').toPromise().then(r => {
      return r;
    }).catch(e => {
      return e.body;
    });
  }

  postImages(salapreguntas: SalaPregunta) {
    return this.http.post(this.url + 'guardarSalaPreguntas', salapreguntas).toPromise().then(r => {
      return r;
    }).catch(e => {
      return e.body;
    });
  }
}