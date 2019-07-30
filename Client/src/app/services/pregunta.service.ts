import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Preguntas } from './../Models/preguntas';
import { environment } from 'src/environments/environment';

@Injectable({
   providedIn: 'root'
})
export class PreguntasService {
   url = environment.url + 'preguntas/';

   constructor(private http: HttpClient) { }

   getPreguntasById(id) {
      return this.http.get(this.url + 'obtenerPreguntas/' + id).toPromise().then(r => {
        return r;
      }).catch(e => {
        return e.body;
      });
    }

    getAllPreguntas() {
      return this.http.get(this.url + 'obtenerPreguntas').toPromise().then(r => {
        return r;
      }).catch(e => {
        return e.body;
      });
    }

    postPreguntas(preguntas: Preguntas) {
      return this.http.post(this.url + 'guardarPreguntas', preguntas).toPromise().then(r => {
        return r;
      }).catch(e => {
        return e.body;
      });
    }
}