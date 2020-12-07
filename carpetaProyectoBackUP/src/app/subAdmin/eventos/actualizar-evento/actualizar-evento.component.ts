import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Evento } from 'src/app/Models/EventoModel';
import { UpdateServiceService } from 'src/app/services/update-service.service';

@Component({
  selector: 'app-actualizar-evento',
  templateUrl: './actualizar-evento.component.html',
  styleUrls: ['./actualizar-evento.component.css']
})
export class ActualizarEventoComponent implements OnInit {
  public evento: Evento;
  public fechaEvent: Date;
  public formEvent: FormGroup;
  constructor(private updateService: UpdateServiceService) { }

  ngOnInit(): void {
    this.updateService.getEvento().subscribe(
      resp => {
        this.evento = resp;
      },
      err => {
        console.log(err);
      }
    );
    this.fechaEvent = new Date();

    this.formEvent = new FormGroup({
      nameEvent: new FormControl(this.evento.nombre_evento, Validators.required),
      fechaEvent: new FormControl(this.evento.fecha_evento, Validators.required),
      autorEvent: new FormControl(this.evento.autor_evento, Validators.required),
      eventType: new FormControl(this.evento.tipo_evento, Validators.required),
      serviceEvent: new FormControl(this.evento.servicio_ofrecido, Validators.required),
      imagenUrl: new FormControl(this.evento.imagen_evento, Validators.required)
    });
  }
  get f(){return this.formEvent.controls; }
  onSubmit() {}
}
