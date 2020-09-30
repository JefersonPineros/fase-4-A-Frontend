import { Injectable } from '@angular/core';
import { Observable,Subject} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UpdateServiceService {

  private subject = new Subject<any>();
  sendUser(user:any){
    this.subject.next(user);
  }
  getUser(){
    return this.subject.asObservable();
  }
}
