import { Component, OnInit, ViewChild } from '@angular/core';

@Component({
  selector: 'app-registro-expositor',
  templateUrl: './registro-expositor.component.html',
  styleUrls: ['./registro-expositor.component.scss']
})
export class RegistroExpositorComponent implements OnInit {

  srcFoto: any = 'assets/image/director.png';
  nombreArchivo: any;
  tipoArchivo: any;
  adjuntoArchivo: any;

  constructor() { }

  ngOnInit() {
  }

  CodificarArchivo(event) {
    const reader = new FileReader();
    if (event.target.files && event.target.files.length > 0) {
      const file = event.target.files[0];
      reader.readAsDataURL(file);
      reader.onload = () => {
        console.log(file);
        this.nombreArchivo = file.name;
        this.tipoArchivo = file.type;
        this.adjuntoArchivo = reader.result.toString().split(',')[1];
        this.srcFoto = 'data:' + this.tipoArchivo + ';base64,' + this.adjuntoArchivo;
      };
    }
  }

}
  