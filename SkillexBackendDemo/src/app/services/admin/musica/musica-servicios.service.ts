import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../../../environments/environment'
import { AlbumesMusicaModel } from '../../../Models/model-musica';

@Injectable({
  providedIn: 'root'
})
export class MusicaServiciosService {

  constructor(private httpClient: HttpClient) { }

  public listarAlbumes(): Observable<AlbumesMusicaModel[]> {
    return this.httpClient.get<AlbumesMusicaModel[]>(environment.apiBaseUrl + '/api/albumes');
  }
  public crearAlbum(album: AlbumesMusicaModel): Observable<any>{
    return this.httpClient.post<any>(environment.apiBaseUrl + '/api/albumes', album)
  }
  public eliminarAlbum(idAlbum: number): Observable<any> {
    return this.httpClient.delete(environment.apiBaseUrl + '/api/albumes/' + idAlbum);
  }
  public listarCancionesSolicitadas(): Observable<any> {
    return this.httpClient.get(environment.apiBaseUrl + '/api/albumes/listarcancioncessolicitadas');
  }
  public procesarSolicitud(idSolicitud: number): Observable<any> {
    return this.httpClient.get(environment.apiBaseUrl + '/api/albumes/actualizarSolicitud/estado=' + true + '&solicitud=' + idSolicitud);
  }
  public solicitarCancion(mesa: string, idCancion: number, idUsuario: number): Observable<any> {
    return this.httpClient.get(environment.apiBaseUrl + '/api/albumes/solicitar/mesa=' + mesa +'&idCancion=' + idCancion + '&idUsuario=' + idUsuario);
  }
}
