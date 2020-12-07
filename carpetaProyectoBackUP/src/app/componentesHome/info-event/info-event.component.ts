import { Component, OnInit, Input, Output, EventEmitter, OnChanges, SimpleChanges } from '@angular/core';
import { IdiomaServiceService } from '../../services/idioma-service.service';
import * as Cookie from 'js-cookie';
import { Observable } from 'rxjs';
import { EventosService } from 'src/app/services/admin/eventos/eventos.service';
import { Evento } from 'src/app/Models/EventoModel';
@Component({
  selector: 'app-info-event',
  templateUrl: './info-event.component.html',
  styleUrls: ['./info-event.component.css']
})
export class InfoEventComponent implements OnInit, OnChanges {
  public idiomaSelected: string;
  public lastEvento: Evento;
  @Input() idEvento: number;

  @Output() evento: EventEmitter<number> = new EventEmitter<number>();
  constructor(private IdiomaService: IdiomaServiceService, private eventosService: EventosService) {
    this.lastEvento = new Evento();
    this.IdiomaService.getIdioma().subscribe(
      idioma => {
        if (idioma != null) {
          this.idiomaSelected = idioma;
        }
      }
    );
    this.eventosService.getLastEvento().subscribe(
      resp => {
        this.lastEvento = resp;
      },
      error => {
        console.log(error);
      }
    );
  }
  ngOnChanges(): void {
    this.consultarEvento(this.idEvento);
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

  consultarEvento(id: number) {
    console.log(id);
    this.eventosService.getEvento(id).subscribe(
      resp => {
        this.lastEvento = resp;
        console.log(resp);
      },
      error => {
        console.log(error);
      }
    );
  }
}
