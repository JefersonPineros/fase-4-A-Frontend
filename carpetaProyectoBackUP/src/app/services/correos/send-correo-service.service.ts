import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { RespuestasServices } from '../../Models/respuestasServices';
import { environment } from '../../../environments/environment';
@Injectable({
  providedIn: 'root'
})
export class SendCorreoServiceService {

  constructor(private httpClient: HttpClient) { }

  public recuperar(email: string): Observable<RespuestasServices> {
    return this.httpClient.get<RespuestasServices>(environment.apiBaseUrl + '/api/usuario/recuperar/email=' + email);
  }
  public correoMasivo(asunto: string, mensaje: string): Observable<RespuestasServices> {
    return this.httpClient.get<RespuestasServices>(environment.apiBaseUrl + '/api/usuario/correoMasivo/asunto=' + asunto + '&mensaje=' + mensaje);
  }
}
