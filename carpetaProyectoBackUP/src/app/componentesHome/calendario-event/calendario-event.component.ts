import { Component, OnInit, EventEmitter, Output } from '@angular/core';
import dayGridPlugin from '@fullcalendar/daygrid';
import esLocale from '@fullcalendar/core/locales/es';
import frLocale from '@fullcalendar/core/locales/fr';
import { IdiomaServiceService } from '../../services/idioma-service.service';
import * as Cookie from 'js-cookie';
import { EventosService } from 'src/app/services/admin/eventos/eventos.service';
import { Evento } from 'src/app/Models/EventoModel';
import { CalendarOptions, DateSelectArg, EventClickArg, EventApi, Calendar } from '@fullcalendar/angular';
import { event } from 'jquery';
@Component({
  selector: 'app-calendario-event',
  templateUrl: './calendario-event.component.html',
  styleUrls: ['./calendario-event.component.css']
})
export class CalendarioEventComponent implements OnInit {
  public calendarEvents: Array<any>;
  public idiomaSelected: string;
  public listaEvent: Array<Evento>;
  @Output() pasarId: EventEmitter<number> = new EventEmitter<number>();

  calendarOptions: CalendarOptions;
  calendarPlugins = [dayGridPlugin];
  locales = [esLocale, frLocale];

  constructor(private idiomaService: IdiomaServiceService, private eventosService: EventosService) {
    this.listaEvent = new Array<Evento>();
    this.calendarEvents = new Array();
    this.idiomaService.getIdioma().subscribe(
      idioma => {
        if (idioma != null) {
          this.idiomaSelected = idioma;
        }
      }
    );
    this.eventosService.listarEventos().subscribe(
      resp => {
        this.listaEvent = resp;
        this.getEvento();
      },
      error => {
        console.log(error);
      }
    );
  }

  ngOnInit(): void {

    let getIdiomaCookye = Cookie.get('idioma');
    if (getIdiomaCookye != null) {
      if (getIdiomaCookye === 'espanol') {
        this.idiomaSelected = getIdiomaCookye;
      } else {
        this.idiomaSelected = getIdiomaCookye;
      }
    } else {
      this.idiomaSelected = 'espanol';
    }
  }

  getEvento(): void {
    for (let evento of this.listaEvent) {
      let ev: Object;
      ev = { title: evento.nombre_evento, date: evento.fecha_evento, idEvent: evento.idEventos };
      this.calendarEvents.push(ev);
    }

    if (this.idiomaSelected === 'espanol') {
      this.calendarOptions = {
        events: this.calendarEvents,
        eventClick: (info) => {
          info.jsEvent.preventDefault();
          this.lanzarEvento(info.event.extendedProps.idEvent);
        },
        eventColor: '#EC0707',
        eventBackgroundColor: '#EC0707',
        locale: esLocale,
      };
    } else {
      this.calendarOptions = {
        events: this.calendarEvents,
        eventClick: (info) => {
          this.lanzarEvento(info.event.extendedProps.idEvent);
        },
        eventColor: '#EC0707',
        eventBackgroundColor: '#EC0707',
      };
    }
  }

  lanzarEvento(event: any): void{
    console.log(event);
    this.pasarId.emit(event);
  }
}
