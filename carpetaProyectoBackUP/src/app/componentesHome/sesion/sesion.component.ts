import { Component, OnInit } from '@angular/core';
import { FormsModule, NgForm, FormGroup } from '@angular/forms';
import { Sesion } from './Models/sesion';
import { NewUser } from './Models/newUser';
import { LoginService } from '../../services/login.service';
import { LoginController } from '../../Controller/login.controller';
import * as Cookie from 'js-cookie';
import Swal from 'sweetalert2';
import { IdiomaServiceService } from '../../services/idioma-service.service';
import { UserModel } from 'src/app/Models/userModel';
import { UsuarioService } from '../../services/admin/usuario.service';
import { from } from 'rxjs';
import { RespuestasServices } from 'src/app/Models/respuestasServices';
import { Location } from '@angular/common';
declare let alertify: any;
@Component({
  selector: 'app-sesion',
  templateUrl: './sesion.component.html',
  styleUrls: ['./sesion.component.css']
})
export class SesionComponent extends LoginController implements OnInit {
  public sesion: Sesion;
  public newUser: NewUser;
  public validacion: boolean;
  private typeValidation: any[];
  public idiomaSelected: string;
  public formSesion: FormGroup;
  public userLogin: UserModel;
  public respuestaSer: RespuestasServices;
  constructor(
    private loginState: LoginService,
    private idiomaService: IdiomaServiceService,
    private usuarioService: UsuarioService,
    private location: Location
    ) {
    super();
    this.sesion = new Sesion();
    this.newUser = new NewUser(null, '', '', '', '', '', null, '', '', '', null, null);
  }

  ngOnInit(): void {

    // validacion de cookies guardadas
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
    // if(this.validacion){
    //   this.loginState.sendLogin(this.typeValidation);
    // }else{
    //   this.loginState.sendLogin(this.typeValidation);
    // }
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
  validationLogin(values: Array<any>): boolean {
    let acceso: Array<any> = values;
    if (acceso[0].acceso = true) {
      return true;
    } else {
      return false;
    }
  }

  onSubmit() {
    this.loginState.solicitarAcceso(this.sesion.getEmail(), this.sesion.getPass()).subscribe(
      (res) => {
        this.userLogin = res;
        if (this.userLogin.tipoUsuario === 1 || this.userLogin.tipoUsuario === 3){
          this.location.replaceState('/admin');
          window.location.reload();
        }
        this.comprobarAcceso();
      },
      (error) => {
        this.userLogin = null;
        console.log(error);

        Swal.fire({
          icon: 'error',
          title: 'Acceso no permitido',
          text: 'Su usuario o contraseña, son erroneos.',
        });
      }
    );
  }
  comprobarAcceso() {
    this.typeValidation = this.comprobarUser(this.userLogin);
    this.validacion = this.validationLogin(this.typeValidation);
    // validacion y actualización del estado
    this.loginState.sendLogin(this.typeValidation);
    if (this.validacion) {
      let user;
      let tipoAc;
      let access;
      this.typeValidation.forEach((item) => {
        user = item.user;
        access = item.acceso;
        tipoAc = item.tipo;
      });
      Cookie.set('acceso', access);
      Cookie.set('usuario', user);
      Cookie.set('tipo', tipoAc);
      alertify.success('Bienvenido');
    }
  }

  newUserSubmit() {
    this.newUser.inventarioIdInventario = 1;
    let fecha = new Date(Date.now());
    this.newUser.creacionUsuario = fecha;
    this.newUser.tipoUsuario =  2;
    this.usuarioService.crearUsuario(this.newUser).subscribe(
      resp => {
        this.respuestaSer = resp;
        if (this.respuestaSer.codigo === '001'){
          Swal.fire({
            icon: 'success',
            title: 'Usuario almacenado correctamente',
            text: '¡Muchas gracias!, ahora inicia sesion. ',
            onClose: () => {
              location.reload();
            }
          });
        }else{
          Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Error al crear el usuario',
            footer: 'El correo ya existe o se presento algún error.'
          });
        }
      }
    );
    console.log(this.newUser);
  }


}