import { Component, OnInit, Output } from '@angular/core';
import { LoginService } from '../services/login.service';
import * as Cookie from 'js-cookie';
import { IdiomaServiceService } from '../../app/services/idioma-service.service';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  private sucripcion: any;
  private accessObject: Array<any>;
  public accesoValidado: boolean;
  public idiomaSelected: string;
  public idEvento: number;
  constructor(private loginService: LoginService, private idiomaServices: IdiomaServiceService) {
    this.sucripcion = this.loginService.getLogin().subscribe(
      validacion => {
        this.accessObject = validacion;
        this.accesoValidado = this.accessObject[0].acceso;
      });
  }

  ngOnInit(): void {
    this.idiomaServices.getIdioma().subscribe(
      idioma => {
        if (idioma != null) {
          this.idiomaSelected = idioma;
        }
      }
    );
    let getIdiomaCookye: string = Cookie.get('idioma');
    if (getIdiomaCookye !== null) {
      if (getIdiomaCookye === 'espanol') {
        this.idiomaSelected = getIdiomaCookye;
      } else {
        this.idiomaSelected = getIdiomaCookye;
      }
    } else {
      this.idiomaSelected = 'espanol';
    }
    let accessCookie: string = Cookie.get('acceso');
    if (accessCookie !== undefined) {
      if (accessCookie === 'true') {
        this.accesoValidado = true;
      } else {
        this.accesoValidado = false;
      }
    } else {
      this.accesoValidado = false;
    }

  }
  pasarIdInfoEvent(evento: number): void {
    this.idEvento = evento;
  }

}
