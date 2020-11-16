import { Component, OnDestroy, OnInit } from '@angular/core';
import * as Cookie from 'js-cookie';
import { IdiomaServiceService } from '../services/idioma-service.service';
import { LoginService } from '../services/login.service';
@Component({
  selector: 'app-administrador',
  templateUrl: './administrador.component.html',
  styleUrls: ['./administrador.component.css']
})
export class AdministradorComponent implements OnInit,  OnDestroy {

  public rutasAdmin: string;
  public idiomaSelected: string;
  constructor( private loginState: LoginService, private idiomaService: IdiomaServiceService) {
    this.rutasAdmin = '1';
  }

  ngOnInit(): void {
    let uG = Cookie.get('usuario');
    let access = Cookie.get('acceso');
    let tipoAC = Cookie.get('tipo');
    if (uG !== undefined) {
      let accessConfirm;
      if (access === 'true') {
        accessConfirm = true;
      }
      let tipoParce = parseInt(tipoAC);
      this.loginState.sendLogin([{ tipo: tipoParce, acceso: accessConfirm, user: uG }]);
    }
    this.idiomaService.getIdioma().subscribe(
      idioma => {
        if (idioma != null) {
          this.idiomaSelected = idioma;
        }
      }
    )
    let getIdiomaCookye = Cookie.get('idioma');
    if (getIdiomaCookye != null) {
      if (getIdiomaCookye === 'espanol') {
        this.idiomaSelected = getIdiomaCookye;
      } else {
        this.idiomaSelected = getIdiomaCookye;
      }
    } else {
      this.idiomaSelected = 'espanol';
    }
  }
  ngOnDestroy(): void {


  }
  modulo(indice: string) {
    let indi: string = indice;
    this.rutasAdmin = indi;
  }

}
