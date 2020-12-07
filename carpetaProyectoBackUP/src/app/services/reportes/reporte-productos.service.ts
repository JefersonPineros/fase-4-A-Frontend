import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { RespuestasServices } from 'src/app/Models/respuestasServices';
@Injectable({
  providedIn: 'root'
})
export class ReporteProductosService {

  constructor(private httpClient: HttpClient) { }
  public reporteProducto(tipo: string): Observable<RespuestasServices>{
    return this.httpClient.get<RespuestasServices>('/api/productos/reporte/' + tipo);
  }
  public reporteUsuarios(tipo: string): Observable<RespuestasServices>{
    return this.httpClient.get<RespuestasServices>('/api/usuario/reporte/' + tipo);
  }
  public reporteEventos(tipo: string): Observable<RespuestasServices>{
    return this.httpClient.get<RespuestasServices>('/api/eventos/reporte/' + tipo);
  }
}
