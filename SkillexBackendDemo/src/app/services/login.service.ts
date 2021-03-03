import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, delay } from 'rxjs/operators';
import { Observable, Subject } from 'rxjs';
import { UserModel } from '../Models/userModel';
import {environment} from '../../environments/environment';
@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private subject = new Subject<any>();
  constructor(private httpCliente: HttpClient) {

  }

  solicitarAcceso(email: string, pass: string): Observable<UserModel> {
    return this.httpCliente.get<UserModel>(environment.apiBaseUrl+'/api/usuario/access/email=' + email + '&password=' + pass);
  }
  sendLogin(acceso: Array<any>) {
    this.subject.next(acceso);
  }
  getLogin(): Observable<any> {

    return this.subject.asObservable();
  }
  clearLogin() {
    this.subject.next();
  }

}
