import { Component, OnInit } from '@angular/core';
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
  public album: Array<any>;
  constructor(private albumesServices: MusicaServiciosService) {

    this.albumesServices.listarAlbumes().subscribe(
      resp => {
        console.log(resp);
      }
    );

    this.visible = false;
    this.album = [
      {
        "nameAlbum": "Black album",
        "visible": false,
        "autor": "James Hetfield",
        "imagenAlbum": "../../assets/imagenes/albumes/BlackAlbum metallica.jpg",
        "canciones": [
          { "cancion": "Enter Sandman", "duracion": "5:29" },
          { "cancion": "Sad but True", "duracion": "5:24" },
          { "cancion": "Holier Than Thou", "duracion": "3:47" },
          { "cancion": "The Unforgiven", "duracion": "6:26" },
          { "cancion": "Wherever I May Roam", "duracion": "6:42" },
          { "cancion": "Don't Tread on Me", "duracion": "3:59" },
          { "cancion": "Through the Never", "duracion": "4:01" },
          { "cancion": "Of Wolf and Man", "duracion": "4:16" },
          { "cancion": "The God That Failed", "duracion": "5:05" },
          { "cancion": "My Friend of Misery", "duracion": "6:47" },
          { "cancion": "The Struggle Within", "duracion": "3:51" }
        ]
      }, {
        "nameAlbum": "American idiot",
        "visible": false,
        "autor": "James Hetfield",
        "imagenAlbum": "../../assets/imagenes/albumes/greenDay-AmericanIdiot.jpg",
        "canciones": [
          { "cancion": "Enter Sandman", "duracion": "5:29" },
          { "cancion": "Sad but True", "duracion": "5:24" },
          { "cancion": "Holier Than Thou", "duracion": "3:47" },
          { "cancion": "The Unforgiven", "duracion": "6:26" },
          { "cancion": "Wherever I May Roam", "duracion": "6:42" },
          { "cancion": "Don't Tread on Me", "duracion": "3:59" },
          { "cancion": "Through the Never", "duracion": "4:01" },
          { "cancion": "Of Wolf and Man", "duracion": "4:16" },
          { "cancion": "The God That Failed", "duracion": "5:05" },
          { "cancion": "My Friend of Misery", "duracion": "6:47" },
          { "cancion": "The Struggle Within", "duracion": "3:51" }
        ]
      }, {
        "nameAlbum": "The number of beast",
        "visible": false,
        "autor": "James Hetfield",
        "imagenAlbum": "../../assets/imagenes/albumes/ironMaiden-TheNumberOfTheBeast.png",
        "canciones": [
          { "cancion": "Enter Sandman", "duracion": "5:29" },
          { "cancion": "Sad but True", "duracion": "5:24" },
          { "cancion": "Holier Than Thou", "duracion": "3:47" },
          { "cancion": "The Unforgiven", "duracion": "6:26" },
          { "cancion": "Wherever I May Roam", "duracion": "6:42" },
          { "cancion": "Don't Tread on Me", "duracion": "3:59" },
          { "cancion": "Through the Never", "duracion": "4:01" },
          { "cancion": "Of Wolf and Man", "duracion": "4:16" },
          { "cancion": "The God That Failed", "duracion": "5:05" },
          { "cancion": "My Friend of Misery", "duracion": "6:47" },
          { "cancion": "The Struggle Within", "duracion": "3:51" }
        ]
      }, {
        "nameAlbum": "Fuerza Metal",
        "visible": false,
        "autor": "James Hetfield",
        "imagenAlbum": "../../assets/imagenes/albumes/ursus-FuerzaMetal.jpg",
        "canciones": [
          { "cancion": "Enter Sandman", "duracion": "5:29" },
          { "cancion": "Sad but True", "duracion": "5:24" },
          { "cancion": "Holier Than Thou", "duracion": "3:47" },
          { "cancion": "The Unforgiven", "duracion": "6:26" },
          { "cancion": "Wherever I May Roam", "duracion": "6:42" },
          { "cancion": "Don't Tread on Me", "duracion": "3:59" },
          { "cancion": "Through the Never", "duracion": "4:01" },
          { "cancion": "Of Wolf and Man", "duracion": "4:16" },
          { "cancion": "The God That Failed", "duracion": "5:05" },
          { "cancion": "My Friend of Misery", "duracion": "6:47" },
          { "cancion": "The Struggle Within", "duracion": "3:51" }
        ]
      }, {
        "nameAlbum": "La muerte",
        "visible": false,
        "autor": "James Hetfield",
        "imagenAlbum": "../../assets/imagenes/albumes/laPestilacia-Lamuerte.jpg",
        "canciones": [
          { "cancion": "Enter Sandman", "duracion": "5:29" },
          { "cancion": "Sad but True", "duracion": "5:24" },
          { "cancion": "Holier Than Thou", "duracion": "3:47" },
          { "cancion": "The Unforgiven", "duracion": "6:26" },
          { "cancion": "Wherever I May Roam", "duracion": "6:42" },
          { "cancion": "Don't Tread on Me", "duracion": "3:59" },
          { "cancion": "Through the Never", "duracion": "4:01" },
          { "cancion": "Of Wolf and Man", "duracion": "4:16" },
          { "cancion": "The God That Failed", "duracion": "5:05" },
          { "cancion": "My Friend of Misery", "duracion": "6:47" },
          { "cancion": "The Struggle Within", "duracion": "3:51" }
        ]
      }
    ]
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
  mensajeEnvio(album: number, cancion: number) {
    console.log("Album: " + album, "Cancion: " + cancion);
    alertify.success('Canción enviada exitosamente');
  }

}
