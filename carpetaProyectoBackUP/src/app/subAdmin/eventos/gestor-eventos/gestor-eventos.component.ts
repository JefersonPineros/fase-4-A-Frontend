import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, FormBuilder, Validators } from '@angular/forms';
import { CreateEvent } from 'src/app/Models/model-create-event';
import { EventosService } from '../../../services/admin/eventos/eventos.service';
import { Evento } from '../../../Models/EventoModel';
import * as Cookie from 'js-cookie';
import Swal from 'sweetalert2';
interface HtmlInputEvent extends Event {
  target: HTMLInputElement & EventTarget;
}
@Component({
  selector: 'app-gestor-eventos',
  templateUrl: './gestor-eventos.component.html',
  styleUrls: ['./gestor-eventos.component.css']
})
export class GestorEventosComponent implements OnInit {
  formEvent: FormGroup;
  public newEvent: Evento;
  public fileToUpdate;
  public evento: any[];
  public createEvent: CreateEvent;
  public allTypes: [];
  public selectedFile: File;
  public fechaEvent: Date;

  public nameImg = 'No ha seleccionado una imagen';
  constructor(
    private fb: FormBuilder, private eventoService: EventosService
  ) {
    this.newEvent = new Evento();
    this.evento = [
      { id: '1', tipo: 'Promoción' },
      { id: '2', tipo: 'Descuentos' },
      { id: '3', tipo: 'Tematico' },
      { id: '4', tipo: 'Toque' },
    ];
    this.createEvent = new CreateEvent(null, '', '', '', '', '');
  }
  ngOnInit(): void {
    this.fechaEvent = new Date();
    this.formEvent = new FormGroup({
      nameEvent: new FormControl(this.newEvent.nombre_evento, Validators.required),
      fechaEvent: new FormControl(this.newEvent.fecha_evento, Validators.required),
      autorEvent: new FormControl(this.newEvent.autor_evento, Validators.required),
      eventType: new FormControl(this.newEvent.tipo_evento, Validators.required),
      serviceEvent: new FormControl(this.newEvent.servicio_ofrecido, Validators.required),
      imagenUrl: new FormControl(this.newEvent.imagen_evento, Validators.required)
    });
  }
  get f(){return this.formEvent.controls; }

  updateFile(event: HtmlInputEvent) {
    if (event.target.files && event.target.files[0]) {
      this.selectedFile = event.target.files[0];
      this.nameImg = this.selectedFile.name;
      const  reader  = new FileReader();
      reader.readAsDataURL(this.selectedFile);
      reader.onload = (): void => {
        const base64String: string = (reader.result as string).match(/.+;base64,(.+)/)[1];
        this.newEvent.imagen_evento = 'data:' + this.selectedFile.type + ';base64,' + base64String;
        console.log(this.nameImg);
        this.newEvent.nombre_imagen = this.nameImg;
      };
    }
  }
  onSubmit() {
    // tslint:disable-next-line: radix
    this.newEvent.usuario_idUsuarios = parseInt(sessionStorage.getItem('idUsuario'));
    this.eventoService.crearEvento(this.newEvent).subscribe(
      resp => {
        if (resp.codigo === '001'){
          Swal.fire({
            icon: 'success',
            title: 'Eventos creado exitosamente',
            text: 'Ninguna novedad al crear el evento ',
            onClose: () => {
            }
          });
        }
      },
      error => {
        console.log(error);
      }
    );
  }
  get typeEvent() {
    return this.formEvent.get('typeEvent');
  }
}
