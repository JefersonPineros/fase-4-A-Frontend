import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { NewUser } from 'src/app/componentesHome/sesion/Models/newUser';
import { UserModel } from 'src/app/Models/userModel';
import { RespuestasServices } from '../../Models/respuestasServices';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  constructor(private httpClient: HttpClient) { }
  crearUsuario(newUser: NewUser): Observable<RespuestasServices>{
    return this.httpClient.post<RespuestasServices>('/api/usuario/crear/', newUser);
  }
  listarUsuario(): Observable<UserModel[]>{
    return this.httpClient.get<UserModel[]>('/api/usuario/');
  }
  eliminarUsuario(id: number): Observable<RespuestasServices>{
    return this.httpClient.delete<RespuestasServices>('/api/usuario/' + id);
  }
  updateUsuario(usuarios: NewUser): Observable<RespuestasServices>{
    console.log(usuarios);
    return this.httpClient.post<RespuestasServices>('/api/usuario/actualizar', usuarios);
  }
  actualizaFechalogin(id: number): Observable<RespuestasServices>{
    return this.httpClient.get<RespuestasServices>('/api/usuario/fechalogin/id=' + id);
  }
  cargueMasivo(file: File): Observable<RespuestasServices> {
    const formdata = new FormData();
    formdata.append('file', file);
    return this.httpClient.post<RespuestasServices>('/api/usuario/cargueMasivo', formdata);
  }
}
