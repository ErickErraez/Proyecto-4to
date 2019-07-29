import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { SalaPregunta } from './../Models/salaPregunta';
import { Observable } from 'rxjs';

@Injectable({
   providedIn: 'root'
})
export class PreguntasService {

   url = 'http//192.168.43.126:8080/preguntas/obtenerPreguntas';
   sala: Observable<any>;
   salas: Observable<any>;

   constructor(private http: HttpClient) { }

   getSala() {
      return this.http.get('http//192.168.43.126:8080/preguntas/obtenerPreguntas');
   }

   getSalaId(id?: number) {
      this.http.get('http//192.168.43.126:8080/preguntas/obtenerPreguntas').subscribe(r => {
         console.log(r);
      });
   }

   postSala(salaPregunta: SalaPregunta) {

   }
}