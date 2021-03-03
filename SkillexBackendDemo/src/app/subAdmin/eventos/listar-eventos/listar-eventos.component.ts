import { Component, OnInit } from '@angular/core';
import { Evento } from 'src/app/Models/EventoModel';
import { RespuestasServices } from 'src/app/Models/respuestasServices';
import { EventosService } from '../../../services/admin/eventos/eventos.service';
import { ReporteProductosService } from '../../../services/reportes/reporte-productos.service';
import Swal from 'sweetalert2';
import { UpdateServiceService } from 'src/app/services/update-service.service';
import { descargarPDF } from 'src/app/Controller/descargaPDF-controller';

@Component({
  selector: 'app-listar-eventos',
  templateUrl: './listar-eventos.component.html',
  styleUrls: ['./listar-eventos.component.css']
})
export class ListarEventosComponent extends descargarPDF implements OnInit {
  public listaEventos: Array<Evento>;
  constructor(private eventosService: EventosService,
    private reportesServices: ReporteProductosService,
    private updateService: UpdateServiceService) {
    super();
    this.listaEventos = new Array<Evento>();
  }

  ngOnInit(): void {
    this.eventosService.listarEventos().subscribe(
      resp => {
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
        this.descargar(resp);
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
      if (item.idEventos === idEvento) {
        this.updateService.sendEvent(item);
      }
    }
  }
  eliminarEvento(id: number): void {
    Swal.fire({
      title: 'Eliminar usuario!',
      text: '¿Esta seguro de eliminar este evento?',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Confirmar'
    }).then((result) => {
      if (result.isConfirmed) {
        this.eventosService.eliminarEvento(id).subscribe(
          resp => {
            if (resp.codigo === '001') {
              Swal.fire(
                'Eliminado!',
                'Evento eliminado correctamente',
                'success'
              );
            }
          },
          err => {
            Swal.fire({
              position: 'top-end',
              icon: 'error',
              title: 'No se pudo eliminar el usuario',
              showConfirmButton: false,
              timer: 3000
            });
          }
        );
      }
    });
  }

}
