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

  public listarAlbumes(): Observable<AlbumesMusicaModel> {
    return this.httpClient.get<AlbumesMusicaModel>(environment.apiBaseUrl + '/api/albumes');
  }
  public crearAlbum(album: AlbumesMusicaModel): Observable<any>{
    return this.httpClient.post<any>(environment.apiBaseUrl + '/api/albumes', album)
  }
}
