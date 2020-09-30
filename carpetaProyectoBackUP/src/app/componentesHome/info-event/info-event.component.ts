import { Component, OnInit } from '@angular/core';
import { IdiomaServiceService } from '../../services/idioma-service.service'
import * as Cookie from 'js-cookie';
@Component({
  selector: 'app-info-event',
  templateUrl: './info-event.component.html',
  styleUrls: ['./info-event.component.css']
})
export class InfoEventComponent implements OnInit {
  public idiomaSelected: String;
  constructor(private IdiomaService:IdiomaServiceService) {
    this.IdiomaService.getIdioma().subscribe(
      idioma => {
        if(idioma != null){
          this.idiomaSelected = idioma;
        }
      }
    )
   }

  ngOnInit(): void {
    let getIdiomaCookye = Cookie.get('idioma')
     if(getIdiomaCookye != null){
      if(getIdiomaCookye == "espanol"){
        this.idiomaSelected = getIdiomaCookye
      }else{
        this.idiomaSelected = getIdiomaCookye
      }
     }else{
      this.idiomaSelected = "espanol";
     }
  }

}
