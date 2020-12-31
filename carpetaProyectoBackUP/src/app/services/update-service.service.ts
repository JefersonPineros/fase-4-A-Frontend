import { Injectable } from '@angular/core';
import { Observable, Subject} from 'rxjs';
import { Evento } from '../Models/EventoModel';
import { UserModel } from '../Models/userModel';

@Injectable({
  providedIn: 'root'
})
export class UpdateServiceService {

  private subject = new Subject<any>();
  private subject2 = new Subject<any>();
  sendUser(user: UserModel){
    this.subject.next(user);
  }
  getUser(){
    return this.subject.asObservable();
  }
  sendEvent(evento: Evento) {
    this.subject2.next(evento);
  }
  getEvento() {
    return this.subject2.asObservable();
  }
}
