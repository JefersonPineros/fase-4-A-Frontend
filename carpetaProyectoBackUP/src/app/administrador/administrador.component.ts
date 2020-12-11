import { Component, OnDestroy, OnInit } from '@angular/core';
import * as Cookie from 'js-cookie';
import { SendCorreoServiceService } from '../services/correos/send-correo-service.service';
import { IdiomaServiceService } from '../services/idioma-service.service';
import { LoginService } from '../services/login.service';
import { Subscription } from 'rxjs';
declare let alertify: any;
@Component({
  selector: 'app-administrador',
  templateUrl: './administrador.component.html',
  styleUrls: ['./administrador.component.css']
})
export class AdministradorComponent implements OnInit,  OnDestroy {

  public rutasAdmin: string;
  public idiomaSelected: string;
  public asunto: string;
  public mensaje: string;
  mensajeSuscripcion: Subscription;

  constructor( private loginState: LoginService,
               private idiomaService: IdiomaServiceService,
               private mensajesService: SendCorreoServiceService
  ) {
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
    this.mensajeSuscripcion.unsubscribe();
  }
  modulo(indice: string) {
    const indi: string = indice;
    this.rutasAdmin = indi;
  }
  enviarCorreoMasivo(asunto: string, mensaje: string): void{
    console.log(asunto);
    console.log(mensaje);
    this.mensajeSuscripcion = this.mensajesService.correoMasivo(asunto, mensaje).subscribe(
      resp => {
        if (resp.codigo === '001') {
          alertify.success('Mensaje enviado correctamente');
        } else {
          alertify.error('Se ha presentado un error');
        }
      },
      error => {
        console.log(error);
        alertify.error('Se ha presentado un error');
      }
    );
  }
}
