import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PruebaService {

  constructor(private http: HttpClient) {

  }

  getPreguntas() {
    this.http.get("//192.168.43.126:8080/preguntas/obtenerPreguntas").subscribe(resposne => {
      console.log(resposne);
    })
  }
}
