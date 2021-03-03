import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { LoginService } from '../services/login.service';
import { IdiomaServiceService } from '../services/idioma-service.service';
import * as Cookie from 'js-cookie';
declare var $: any;
@Component({
  selector: 'app-barra',
  templateUrl: './barra.component.html',
  styleUrls: ['./barra.component.css']
})
export class BarraComponent implements OnInit {
  suscripcion: Subscription;
  public ingreso: boolean;
  public tipoUsuario: number;
  public usuario: string;
  private urlHome: string;
  private objAccess: Array<any>;
  public idiomaSeleccionado: string;
  constructor(private loginService: LoginService, private IdiomaService: IdiomaServiceService) {
    this.urlHome = '/home';
    this.idiomaSeleccionado = 'espanol';
  }
  ngOnInit(): void {

    const tipoCookie = sessionStorage.getItem('tipo');
    const userCookie = sessionStorage.getItem('usuario');
    const accesoCookie = sessionStorage.getItem('acceso');
    if (userCookie !== undefined) {
      if (accesoCookie === 'true') {
        this.ingreso = true;
      }
      this.tipoUsuario = parseInt(tipoCookie);
      this.usuario = userCookie;
    } else {
      this.ingreso = false;
      this.tipoUsuario = null;
      this.usuario = null;
    }

    $('a[data-toggle="tab"]').on('shown.bs.tab', (e) => {
      e.target // newly activated tab
      e.relatedTarget // previous active tab
    });
    $('#myCollapsible').collapse({
      toggle: false
    });
    this.suscripcion = this.loginService.getLogin().subscribe(
      validacion => {
        this.objAccess = validacion;
        this.ingreso = this.objAccess[0].acceso;
        this.tipoUsuario = this.objAccess[0].tipo;
        this.usuario = this.objAccess[0].user;
      }
    );
    const getIdiomaCookie = sessionStorage.getItem('idioma');
    if (getIdiomaCookie != null) {
      if (getIdiomaCookie === 'espanol') {
        this.idiomaSeleccionado = getIdiomaCookie;
      } else {
        this.idiomaSeleccionado = getIdiomaCookie;
      }
    } else {
      this.idiomaSeleccionado = 'espanol';
    }
  }
  clearSesion() {
    this.loginService.clearLogin();
    sessionStorage.removeItem('tipo');
    sessionStorage.removeItem('usuario');
    sessionStorage.removeItem('acceso');
    sessionStorage.removeItem('idUsuario');
    location.reload();
    location.replace(this.urlHome);
  }

  selectIdioma(idm: string) {
    let idm1 = idm;
    sessionStorage.setItem('idioma', idm1);
    // Cookie.set('idioma', idm1);
    this.idiomaSeleccionado = idm;
    this.IdiomaService.sendIdioma(idm1);
  }
}
