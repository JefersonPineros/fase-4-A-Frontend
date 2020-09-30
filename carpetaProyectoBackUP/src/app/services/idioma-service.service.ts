import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class IdiomaServiceService {
  private subject = new Subject<any>();
  
  sendIdioma(idioma:String){
    this.subject.next(idioma);
  }
  getIdioma(){
    return this.subject.asObservable();
  }
}
