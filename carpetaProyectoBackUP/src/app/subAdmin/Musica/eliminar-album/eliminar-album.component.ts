import { Component, OnInit } from '@angular/core';
import { MusicaServiciosService } from 'src/app/services/admin/musica/musica-servicios.service';
import { AlbumesMusicaModel } from '../../../Models/model-musica';
import Swal from 'sweetalert2';
import { NgxSpinnerService } from 'ngx-spinner';
@Component({
  selector: 'app-eliminar-album',
  templateUrl: './eliminar-album.component.html',
  styleUrls: ['./eliminar-album.component.css']
})
export class EliminarAlbumComponent implements OnInit {

  public listaAl: Array<AlbumesMusicaModel>;

  constructor(private albumesServices: MusicaServiciosService, private spinner: NgxSpinnerService) { 
    this.listaAl = new Array<AlbumesMusicaModel>();
  }

  ngOnInit(): void {
    this.albumesServices.listarAlbumes().subscribe(
      resp => {
        this.listaAl = resp;
      },
      err => {
        console.log(err);
      }
    );
  }
  
  eliminarAlbum(idAlbum): void {
    this.spinner.show();
    this.albumesServices.eliminarAlbum(idAlbum).subscribe(
      resp => {
        this.spinner.hide();
        Swal.fire({
          position: 'top-end',
          icon: 'success',
          title: 'Proceso exitoso',
          text: 'Se ha eliminado el album correctamente',
          showConfirmButton: false,
          timer: 1500
        });
      },
      err => {
        this.spinner.hide();
        Swal.fire({
          position: 'top-end',
          icon: 'error',
          title: 'Se presento un error',
          text: 'No se pudo realizar la creación del album, intente nueva mente.',
          showConfirmButton: false,
          timer: 1500
        });
      }
    )
  }
}
