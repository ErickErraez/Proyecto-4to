import { Injectable } from '@angular/core';
import { Images } from '../Models/images';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ImagesService {
  url = environment.url + 'imagenes/';
  constructor(private http: HttpClient) { }

  getImagesById(id) {
    return this.http.get(this.url + 'obtenerImagenes/' + id).toPromise().then(r => {
      return r;
    }).catch(e => {
      return e.body;
    });
  }

  getAllImages() {
    return this.http.get(this.url + 'obtenerImagenes').toPromise().then(r => {
      return r;
    }).catch(e => {
      return e.body;
    });
  }

  postImages(images) {
    return this.http.post(this.url + 'guardarImagenes', images).toPromise().then(r => {
      return r;
    }).catch(e => {
      return e.body;
    });
  }
}
