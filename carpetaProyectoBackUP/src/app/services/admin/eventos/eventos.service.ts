import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Evento } from '../../../Models/EventoModel';
import { RespuestasServices } from 'src/app/Models/respuestasServices';

@Injectable({
  providedIn: 'root'
})
export class EventosService {

  constructor(private httpClient: HttpClient) { }

  listarEventos(): Observable<Evento[]>{
    return this.httpClient.get<Evento[]>('/api/eventos/');
  }
  crearEvento(evento: Evento): Observable<RespuestasServices>{
    return this.httpClient.post<RespuestasServices>('/api/eventos', evento);
  }
  getEvento(id: number): Observable<Evento> {
    return this.httpClient.get<Evento>('/api/eventos/getEvento/' + id);
  }
  getLastEvento(): Observable<Evento> {
    return this.httpClient.get<Evento>('/api/eventos/getEvento');
  }
}
