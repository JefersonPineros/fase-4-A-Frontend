import { Component, OnInit } from '@angular/core';
import { MusicaServiciosService } from 'src/app/services/admin/musica/musica-servicios.service';
import Swal from 'sweetalert2';
declare let alertify: any;
@Component({
  selector: 'app-procesar-canciones',
  templateUrl: './procesar-canciones.component.html',
  styleUrls: ['./procesar-canciones.component.css']
})
export class ProcesarCancionesComponent implements OnInit {

  public listaSolicitudes: any;
  constructor(private albumService: MusicaServiciosService) {
    this.albumService.listarCancionesSolicitadas().subscribe(
      resp => {
        this.listaSolicitudes = resp;
        console.log(this.listaSolicitudes);
      },
      err => {
        console.log(err);
      }
    );
  }

  ngOnInit(): void {
  }

  procesar(idSolicitud: number): void {
    this.albumService.procesarSolicitud(idSolicitud).subscribe(
      resp => {
        console.log(resp);
        alertify.success('Solicitud exitosa');
      }
    );
  }
}
