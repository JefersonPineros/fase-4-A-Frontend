import { Component, OnInit, Input, Output, EventEmitter, OnChanges, SimpleChanges, OnDestroy } from '@angular/core';
import { IdiomaServiceService } from '../../services/idioma-service.service';
import * as Cookie from 'js-cookie';
import { Observable } from 'rxjs';
import { EventosService } from 'src/app/services/admin/eventos/eventos.service';
import { Evento } from 'src/app/Models/EventoModel';
import { NgxSpinnerService } from 'ngx-spinner';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-info-event',
  templateUrl: './info-event.component.html',
  styleUrls: ['./info-event.component.css']
})
export class InfoEventComponent implements OnInit, OnChanges, OnDestroy {
  public idiomaSelected: string;
  public lastEvento: Evento;
  suscripcionEvento: Subscription;

  @Input() idEvento: number;

  @Output() evento: EventEmitter<number> = new EventEmitter<number>();
  constructor(private IdiomaService: IdiomaServiceService, private eventosService: EventosService, private spinner: NgxSpinnerService) {
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
  ngOnDestroy(): void {
    // this.suscripcionEvento.unsubscribe();
  }
  ngOnChanges(): void {
    this.consultarEvento(this.idEvento);
  }

  ngOnInit(): void {
    let getIdiomaCookye = sessionStorage.getItem('idioma');
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
    if (id !== undefined) {
      this.spinner.show();
      this.suscripcionEvento = this.eventosService.getEvento(id).subscribe(
        resp => {
          this.lastEvento = resp;
          this.spinner.hide();
        },
        error => {
          this.spinner.hide();
        }
      );
    }
  }
}
