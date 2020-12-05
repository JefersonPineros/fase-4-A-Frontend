import { Component, OnInit } from '@angular/core';
import { Evento } from 'src/app/Models/EventoModel';
import { EventosService } from '../../../services/admin/eventos/eventos.service';
@Component({
  selector: 'app-listar-eventos',
  templateUrl: './listar-eventos.component.html',
  styleUrls: ['./listar-eventos.component.css']
})
export class ListarEventosComponent implements OnInit {
  public listaEventos: Array<Evento>;
  constructor(private eventosService: EventosService) {
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

}
