import { Component, OnDestroy, OnInit } from '@angular/core';
import * as Cookie from 'js-cookie';
import { SendCorreoServiceService } from '../services/correos/send-correo-service.service';
import { IdiomaServiceService } from '../services/idioma-service.service';
import { LoginService } from '../services/login.service';
import { Subscription } from 'rxjs';
import { ActivatedRoute, Router } from '@angular/router';
import { RouterLink } from '@angular/router';
import { Location } from '@angular/common';
import { NgxSpinnerService } from 'ngx-spinner';
declare let alertify: any;
declare var $: any;
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
  public tipoUser: number;
  mensajeSuscripcion: Subscription;

  constructor( private loginState: LoginService,
               private idiomaService: IdiomaServiceService,
               private mensajesService: SendCorreoServiceService,
               private route: ActivatedRoute,
               private location: Location,
               private spinner: NgxSpinnerService
  ) {
    if (this.tipoUser === 1) {
      this.rutasAdmin = '1';
    } else  {
      this.rutasAdmin = '2';
    }
    $('.collapse').collapse()
  }

  ngOnInit(): void {
    let uG = sessionStorage.getItem('usuario');
    let access = sessionStorage.getItem('acceso');
    let tipoAC = sessionStorage.getItem('tipo');
    this.tipoUser = Number.parseInt(tipoAC);
    if (uG !== undefined) {
      let accessConfirm;
      if (access === 'true') {
        if (this.tipoUser === 1 || this.tipoUser === 2) {
          accessConfirm = true;
        } else {
          this.location.replaceState('/home');
          window.location.reload();
        }
      } else {
        this.location.replaceState('/home');
        window.location.reload();
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
    let getIdiomaCookye = sessionStorage.getItem('idioma');
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
    // this.mensajeSuscripcion.unsubscribe();
  }
  modulo(indice: string) {
    const indi: string = indice;
    this.rutasAdmin = indi;
  }
  enviarCorreoMasivo(asunto: string, mensaje: string): void{
    this.spinner.show();
    this.mensajeSuscripcion = this.mensajesService.correoMasivo(asunto, mensaje).subscribe(
      resp => {
        this.spinner.hide();
        if (resp.codigo === '001') {
          alertify.success('Mensaje enviado correctamente');
        } else {
          alertify.error('Se ha presentado un error');
        }
      },
      error => {
        this.spinner.hide();
        console.log(error);
        alertify.error('Se ha presentado un error');
      }
    );
  }
}
