import { Component, OnInit } from '@angular/core';
import dayGridPlugin from '@fullcalendar/daygrid'
import { Calendar } from '@fullcalendar/core';
import esLocale from '@fullcalendar/core/locales/es';
import frLocale from '@fullcalendar/core/locales/fr';
import { IdiomaServiceService } from '../../services/idioma-service.service';
import * as Cookie from 'js-cookie';
@Component({
  selector: 'app-calendario-event',
  templateUrl: './calendario-event.component.html',
  styleUrls: ['./calendario-event.component.css']
})
export class CalendarioEventComponent implements OnInit {
  public calendarEvents;
  public idiomaSelected: string;

  calendarPlugins = [dayGridPlugin];
  locales = [esLocale, frLocale];

  constructor(private idiomaService: IdiomaServiceService) {
    this.idiomaService.getIdioma().subscribe(
      idioma => {
        if (idioma != null) {
          this.idiomaSelected = idioma;
        }
      }
    )
  }

  ngOnInit(): void {
    this.calendarEvents = [
      { title: 'Heavy metal night', date: '2020-05-02' },
      { title: 'Metallica', date: '2020-05-26' },
      { title: 'Metal de las montañas', date: '2020-05-28' }
    ];
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

}
