import { Injectable } from '@angular/core';
import { Observable, Subject} from 'rxjs';
import { UserModel } from '../Models/userModel';

@Injectable({
  providedIn: 'root'
})
export class UpdateServiceService {

  private subject = new Subject<any>();
  sendUser(user: UserModel){
    this.subject.next(user);
  }
  getUser(){
    return this.subject.asObservable();
  }
}
