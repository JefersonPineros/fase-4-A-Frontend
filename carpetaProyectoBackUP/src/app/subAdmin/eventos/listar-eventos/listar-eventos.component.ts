import { Component, OnInit } from '@angular/core';
import { Evento } from 'src/app/Models/EventoModel';
import { RespuestasServices } from 'src/app/Models/respuestasServices';
import { EventosService } from '../../../services/admin/eventos/eventos.service';
import { ReporteProductosService } from '../../../services/reportes/reporte-productos.service';
import Swal from 'sweetalert2';
import { UpdateServiceService } from 'src/app/services/update-service.service';

@Component({
  selector: 'app-listar-eventos',
  templateUrl: './listar-eventos.component.html',
  styleUrls: ['./listar-eventos.component.css']
})
export class ListarEventosComponent implements OnInit {
  public listaEventos: Array<Evento>;
  constructor(private eventosService: EventosService,
              private reportesServices: ReporteProductosService,
              private updateService: UpdateServiceService) {
    this.listaEventos = new Array<Evento>();
  }

  ngOnInit(): void {
    this.eventosService.listarEventos().subscribe(
      resp => {
        console.log(resp);
        this.listaEventos = resp;
      },
      error => {
        console.log(error);
      }
    );
  }
  reporte(): void {
    this.reportesServices.reporteEventos('pdf').subscribe(
      resp => {
        Swal.fire({
          icon: 'success',
          title: 'Se ha descargado el documento',
          text: 'Verifique en descargas',
          onClose: () => {

          }
        });
      },
      error => {
        Swal.fire({
          icon: 'success',
          title: 'Se ha presentado un error',
          text: 'No se pudo descargar el documento, intente nueva mente',
          onClose: () => {
          }
        });
      }
    );
  }
  actualizarEvento(idEvento: number): void {
    for (let item of this.listaEventos) {
      if  (item.idEventos === idEvento ) {
        this.updateService.sendEvent(item);
      }
    }
  }

}
