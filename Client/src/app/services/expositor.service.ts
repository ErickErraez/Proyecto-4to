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
    return this.http.get(this.url + 'obtenerExpositor' + id).toPromise().then(r => {
      return r;
    }).catch(e => {
      return e.body;
    });
  }

  getAllExpositores() {
    return this.http.get(this.url + 'obtenerExpositores').toPromise().then(r => {
      return r;
    }).catch(e => {
      return e.body;
    });
  }

  postExpositor(expositor: Expositor) {
    return this.http.post(this.url + 'guardarExpositores', expositor).toPromise().then(r => {
      return r;
    }).catch(e => {
      return e.body;
    });
  }

  putExpositorImg(expositor: Expositor) {
    return this.http.put(this.url + 'expofoto', expositor).toPromise().then(r => {
      return r;
    }).catch(e => {
      return e.body;
    });

  }

}
