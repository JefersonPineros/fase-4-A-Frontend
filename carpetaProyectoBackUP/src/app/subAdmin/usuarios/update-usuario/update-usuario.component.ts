import { Component, OnInit, OnDestroy } from '@angular/core';
import { UpdateServiceService } from '../../../services/update-service.service';
import { UsuarioService } from 'src/app/services/admin/usuario.service';
import { NewUser } from 'src/app/componentesHome/sesion/Models/newUser';
import Swal from 'sweetalert2';
import { RespuestasServices } from 'src/app/Models/respuestasServices';
import { IdiomaServiceService } from 'src/app/services/idioma-service.service';
import * as Cookie from 'js-cookie';
import { Subscription } from 'rxjs';
@Component({
  selector: 'app-update-usuario',
  templateUrl: './update-usuario.component.html',
  styleUrls: ['./update-usuario.component.css']
})
export class UpdateUsuarioComponent implements OnInit, OnDestroy {
  public usuarioUpdate: NewUser;
  public selected: boolean;
  public userType: Array<any>;
  public responseS: RespuestasServices;
  public idiomaSelected: string;
  suscripcionUsuario: Subscription;
  SuscripcionActualizar: Subscription;
  constructor(
    private updateUserService: UpdateServiceService,
    private userServices: UsuarioService,
    private idiomaService: IdiomaServiceService) {
    this.selected = false;
    this.userType = [
      { id: '1', tipo: 'Administrador' },
      { id: '2', tipo: 'Bartender' }
    ];
  }
  ngOnDestroy(): void {
    this.suscripcionUsuario.unsubscribe();
    this.SuscripcionActualizar.unsubscribe();
  }

  ngOnInit(): void {
    this.SuscripcionActualizar = this.updateUserService.getUser().subscribe(
      usuario => {
        if (usuario !== '') {
          this.usuarioUpdate = usuario;
          this.selected = true;
        }
      }
    );

    let uG = Cookie.get('usuario');
    let access = Cookie.get('acceso');
    let tipoAC = Cookie.get('tipo');
    if (uG !== undefined) {
      let accessConfirm;
      if (access === 'true') {
        accessConfirm = true;
      }
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
  onSubmit() {
    this.suscripcionUsuario = this.userServices.updateUsuario(this.usuarioUpdate).subscribe(
      resp => {
        this.responseS = resp;
        if (this.responseS.codigo === '001') {
          Swal.fire({
            position: 'top-end',
            icon: 'success',
            title: 'Actualización realizada satisfact',
            showConfirmButton: false,
            timer: 1500
          });
        } else {
          Swal.fire({
            position: 'top-end',
            icon: 'error',
            title: 'No se pudo realizar la actualización',
            showConfirmButton: false,
            timer: 1500
          });
        }
      }
    );
  }

}
