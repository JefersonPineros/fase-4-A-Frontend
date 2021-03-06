import { Component, OnInit } from '@angular/core';
import { AlbumesMusicaModel } from '../Models/model-musica';
import { MusicaServiciosService } from '../services/admin/musica/musica-servicios.service';

declare var $: any;
declare let alertify: any;
@Component({
  selector: 'app-musica',
  templateUrl: './musica.component.html',
  styleUrls: ['./musica.component.css']
})
export class MusicaComponent implements OnInit {
  public visible: boolean;
  public album: Array<AlbumesMusicaModel>;
  public buscarAlbum: any;
  constructor(private albumesServices: MusicaServiciosService) {

    this.consultarAlbumes(),
    this.visible = false;
  }

  consultarAlbumes(): void {
    this.albumesServices.listarAlbumes().subscribe(
      resp => {
        this.album = resp;       
      }
    );
  }

  ngOnInit(): void {
    $('.toast').toast({
      autohide: true
    })
  }

  hideOrShow(itemSeleccionado: number) {
    for (let i: number = 0; i <= this.album.length; i++) {
      if (itemSeleccionado === i) {
        if (this.album[i].visible) {
          this.album[i].visible = false;
        } else {
          this.album[i].visible = true;
        }
      }
    }
  }
  mensajeEnvio(idCancion: number) {
    let idUsuario = sessionStorage.getItem('idUsuario');
    this.albumesServices.solicitarCancion('mesa 1',idCancion, parseInt(idUsuario)).subscribe(
      resp => {
        alertify.success('Canción enviada exitosamente');
      }
    );
  }

  buscarAlbumes(): void {
    if (this.buscarAlbum === null || this.buscarAlbum === '' || this.buscarAlbum === undefined) {
      this.consultarAlbumes();
    } else {
      this.album = this.album.filter(
        item => {
          return item.nombreAlbum.toLowerCase().indexOf(this.buscarAlbum.toLowerCase()) > -1;
        }
      );
    }
  }
}
