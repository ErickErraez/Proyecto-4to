import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import { Expositor } from '../Models/expositor';

@Injectable({
  providedIn: 'root'
})
export class ExpositorService {

  url = environment.url + 'expositores/';

  constructor(private http: HttpClient) { }

  getExpositorById(id) {
    return this.http.get(this.url + 'obtenerExpositor' + id);
  }

  getAllExpositores() {
    return this.http.get(this.url + 'obtenerExpositores');
  }

  postExpositor(expositor: Expositor) {
    return this.http.post(this.url + 'guardarExpositores', expositor).toPromise().then(r => {
      return r;
    }).catch(e => {
      return e.body;
    });
  }

}
