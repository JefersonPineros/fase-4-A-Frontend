import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, FormBuilder, Validators } from '@angular/forms';
import { Evento } from 'src/app/Models/EventoModel';
import { UpdateServiceService } from 'src/app/services/update-service.service';
import { EventosService } from '../../../services/admin/eventos/eventos.service';
import Swal from 'sweetalert2';
import { NgxSpinnerService } from 'ngx-spinner';

@Component({
  selector: 'app-actualizar-evento',
  templateUrl: './actualizar-evento.component.html',
  styleUrls: ['./actualizar-evento.component.css']
})
export class ActualizarEventoComponent implements OnInit {
  public evento: Evento;
  public fechaEvent: Date;
  public formEvent2: FormGroup;
  public tipoEvento: any[];
  constructor(
    private updateService: UpdateServiceService,
    private eventService: EventosService,
    private spinner: NgxSpinnerService
    ) {
    this.evento = new Evento();
    this.tipoEvento = [
      { id: '1', tipo: 'Promoción' },
      { id: '2', tipo: 'Descuentos' },
      { id: '3', tipo: 'Tematico' },
      { id: '4', tipo: 'Toque' },
    ];
   }

  ngOnInit(): void {
    this.updateService.getEvento().subscribe(
      resp => {
        this.evento = resp;
        console.log(this.evento);
      },
      err => {
        console.log(err);
      }
    );

    this.fechaEvent = new Date();
    this.formEvent2 = new FormGroup({
      nameEvent: new FormControl(this.evento.nombre_evento, Validators.required),
      fechaEvent: new FormControl(this.evento.fecha_evento, Validators.required),
      autorEvent: new FormControl(this.evento.autor_evento, Validators.required),
      eventType: new FormControl(this.evento.tipo_evento, Validators.required),
      serviceEvent: new FormControl(this.evento.servicio_ofrecido, Validators.required)
    });
  }
  get f(){ return this.formEvent2.controls; }

  onSubmit(): void {
    this.spinner.show();
    console.log(this.evento);
    this.eventService.actualizarEvento(this.evento).subscribe(
      resp => {
        this.spinner.hide();
        if (resp.codigo === '001') {
          Swal.fire({
            icon: 'success',
            title: 'Eventos actualizado exitosamente',
            text: 'Ninguna novedad al actualizar el evento ',
            onClose: () => {
            }
          });
        }
      },
      err => {
        this.spinner.hide();
        console.log(err);
      }
    );
  }
}
