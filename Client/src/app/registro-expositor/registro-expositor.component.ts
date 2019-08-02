import { Component, OnInit, ViewChild } from '@angular/core';
import { Images } from '../Models/images';
import { Expositor } from '../Models/expositor';
import { ExpositorService } from '../services/expositor.service';
import { ImagesService } from '../services/images.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-registro-expositor',
  templateUrl: './registro-expositor.component.html',
  styleUrls: ['./registro-expositor.component.scss']
})
export class RegistroExpositorComponent implements OnInit {

  srcFoto: any = 'assets/image/director.png';
  expositor: Expositor;
  images: Images;

  constructor(private expositorServices: ExpositorService, private imagenServices: ImagesService, private toastr: ToastrService) {
    this.images = new Images();
    this.expositor = new Expositor();
  }

  ngOnInit() {
  }

  CodificarArchivo(event) {
    const reader = new FileReader();
    if (event.target.files && event.target.files.length > 0) {
      const file = event.target.files[0];
      reader.readAsDataURL(file);
      reader.onload = () => {
        console.log(file);
        this.images.nombre = file.name;
        this.images.tipo = file.type;
        this.images.adjunto = reader.result.toString().split(',')[1];
        this.srcFoto = 'data:' + this.images.tipo + ';base64,' + this.images.adjunto;
      };
    }
  }

  guardarExpositor() {
    if (this.images.adjunto !== undefined) {
      this.imagenServices.postImages(this.images).then(res => {
        this.expositorServices.postExpositor(this.expositor).then(r => {
          this.expositor = r;
          this.expositor.imagenes = res;
          this.expositorServices.putExpositorImg(this.expositor).then(respuesta => {
            this.toastr.success('Expositor registrado con exito!', 'Registro realizado con Exito');
          }).catch(er => {
            this.toastr.error('Ha ocurrido un error al guardar la foto!', 'Oops algo ha salido mal');
          });
        }).catch(e => {
          this.toastr.error('Ha ocurrido un error al guardar el Expositor!', 'Oops algo ha salido mal');
        });
      }).catch(error => {
        this.toastr.error('Ha ocurrido un error al guardar la foto!', 'Oops algo ha salido mal');
      });
    } else {
      this.toastr.error('Debes ingresar una foto!', 'Oops algo ha salido mal');
    }

  }

}
