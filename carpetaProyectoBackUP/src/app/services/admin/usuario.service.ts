import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { NewUser } from 'src/app/componentesHome/sesion/Models/newUser';
import { RespuestasServices } from '../../Models/respuestasServices';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  constructor(private httpClient: HttpClient) { }
  
  crearUsuario(newUser: NewUser): Observable<RespuestasServices>{
    return this.httpClient.post<RespuestasServices>('/api/usuario/crear/', newUser);
  }
}
