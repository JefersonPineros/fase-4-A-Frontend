import { Component, OnDestroy, OnInit } from '@angular/core';
import { MusicaServiciosService } from 'src/app/services/admin/musica/musica-servicios.service';
import Swal from 'sweetalert2';
import { NgxSpinnerService } from 'ngx-spinner';

declare let alertify: any;
@Component({
  selector: 'app-procesar-canciones',
  templateUrl: './procesar-canciones.component.html',
  styleUrls: ['./procesar-canciones.component.css']
})
export class ProcesarCancionesComponent implements OnInit , OnDestroy {

  public listaSolicitudes: any;
  public componenteActivo = true;
  constructor(private albumService: MusicaServiciosService, private spinner: NgxSpinnerService) {
    this.buscarCanciones();
  }
  ngOnDestroy(): void {
    this.componenteActivo = false;
  }

  ngOnInit(): void {
    
  }

  timer() {
    setTimeout(() => { this.buscarCanciones(); }, 15000);
  }

  buscarCanciones(): void{
    this.albumService.listarCancionesSolicitadas().subscribe(
      resp => {
        if (resp.length  > 0) {
          this.listaSolicitudes = resp;
        } else  {
          this.listaSolicitudes = [];
        }
        if (this.componenteActivo) {
          this.timer();
        }
      },
      err => {
        this.listaSolicitudes = [];
        if (this.componenteActivo) {
          this.timer();
        }
      }
    );
  }

  procesar(idSolicitud: number): void {
    this.spinner.show()
    this.albumService.procesarSolicitud(idSolicitud).subscribe(
      resp => {
        this.spinner.hide();
        console.log(resp);
        alertify.success('Solicitud exitosa');
        this.buscarCanciones();
      },
      error => {
        this.buscarCanciones();
      }
    );
  }
}
