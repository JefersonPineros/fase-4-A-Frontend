import { Component, OnInit } from '@angular/core';
import { MusicaServiciosService } from 'src/app/services/admin/musica/musica-servicios.service';
import Swal from 'sweetalert2';
import { NgxSpinnerService } from 'ngx-spinner';

declare let alertify: any;
@Component({
  selector: 'app-procesar-canciones',
  templateUrl: './procesar-canciones.component.html',
  styleUrls: ['./procesar-canciones.component.css']
})
export class ProcesarCancionesComponent implements OnInit {

  public listaSolicitudes: any;
  constructor(private albumService: MusicaServiciosService, private spinner: NgxSpinnerService) {
    this.albumService.listarCancionesSolicitadas().subscribe(
      resp => {
        this.listaSolicitudes = resp;
      },
      err => {
        console.log(err);
      }
    );
  }

  ngOnInit(): void {
  }

  procesar(idSolicitud: number): void {
    this.spinner.show()
    this.albumService.procesarSolicitud(idSolicitud).subscribe(
      resp => {
        this.spinner.hide();
        console.log(resp);
        alertify.success('Solicitud exitosa');
      }
    );
  }
}
