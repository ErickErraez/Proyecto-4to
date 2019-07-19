import { HttpClient, HttpHeaders} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Sala } from './../Models/sala';
import { Observable } from 'rxjs';

@Injectable({
   providedIn: 'root'
 })
export class SalaService {

   url = 'http//Prueba';
   sala: Observable<any>;
   salas: Observable<any>;

   constructor(private http: HttpClient) {}

   getSala(){
      return this.http.get(this.url);
   }

   getSalaId(id:string){
   return (this.sala = this.http.get(this.url));
   }

   postSala(sala: Sala){
   
   }
}