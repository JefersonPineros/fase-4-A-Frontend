import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Evento } from '../../../Models/EventoModel';
import { RespuestasServices } from 'src/app/Models/respuestasServices';
import { environment } from '../../../../environments//environment';

@Injectable({
  providedIn: 'root'
})
export class EventosService {

  constructor(private httpClient: HttpClient) { }

  listarEventos(): Observable<Evento[]> {
    return this.httpClient.get<Evento[]>(environment.apiBaseUrl + '/api/eventos/');
  }
  crearEvento(evento: Evento): Observable<RespuestasServices> {
    return this.httpClient.post<RespuestasServices>(environment.apiBaseUrl + '/api/eventos', evento);
  }
  getEvento(id: number): Observable<Evento> {
    return this.httpClient.get<Evento>(environment.apiBaseUrl + '/api/eventos/getEvento/' + id);
  }
  getLastEvento(): Observable<Evento> {
    return this.httpClient.get<Evento>(environment.apiBaseUrl + '/api/eventos/getEvento');
  }
  actualizarEvento(evento: Evento): Observable<RespuestasServices> {
    return this.httpClient.post<RespuestasServices>(environment.apiBaseUrl + '/api/eventos/actualizar/', evento);
  }
  eliminarEvento(id: number): Observable<RespuestasServices> {
    return this.httpClient.delete<RespuestasServices>(environment.apiBaseUrl + '/api/eventos/' + id);
  }
}
