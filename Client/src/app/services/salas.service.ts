import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Injectable } from '@angular/core';
import { Sala } from '../Models/sala';

@Injectable({
  providedIn: 'root'
})
export class SalaService {

  url = environment.url + 'salas/';

  constructor(private http: HttpClient) { }

  getSalaById(id) {
    return this.http.get(this.url + 'obtenerSalas/' + id).toPromise().then(r => {
      return r;
    }).catch(e => {
      return e.body;
    });
  }

  getSalaByCode(codigo) {
    return this.http.get(this.url + 'obtenerSalasCodigo/' + codigo).toPromise().then(r => {
      return r;
    }).catch(e => {
      return e.body;
    });
  }

  getAllSala() {
    return this.http.get(this.url + 'obtenerSalas').toPromise().then(r => {
      return r;
    }).catch(e => {
      return e.body;
    });
  }

  postSala(sala) {
    return this.http.post(this.url + 'guardarSalas', sala).toPromise().then(r => {
      return r;
    }).catch(e => {
      return e.body;
    });
  }

  putSala(sala){
    return this.http.put(this.url + 'actualizarSalas/'  + sala.id, sala).toPromise().then(r => {
      return r;
    }).catch(e => {
      return e.body;
    });
  }
}
