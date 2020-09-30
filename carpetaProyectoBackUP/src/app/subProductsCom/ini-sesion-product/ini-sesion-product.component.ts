import { Component, OnInit } from '@angular/core';
import { Form } from '@angular/forms';
import { LoginController } from '../../Controller/login.controller';
import { Sesion } from '../../componentesHome/sesion/Models/sesion';
import * as Cookie from 'js-cookie';
import { LoginService } from '../../services/login.service';
import { UserModel } from 'src/app/Models/userModel';
import Swal from 'sweetalert2';
declare let alertify: any;

@Component({
  selector: 'app-ini-sesion-product',
  templateUrl: './ini-sesion-product.component.html',
  styleUrls: ['./ini-sesion-product.component.css']
})
export class IniSesionProductComponent extends LoginController implements OnInit {

  public userEmail: string;
  public userPass: string;
  public init: Array<any>;
  public sesion = new Sesion();
  public accesoUser: Array<any>;
  public validacion: boolean;
  public loginController: LoginController;
  public userLogin: UserModel;
  constructor(private loginState: LoginService) {
    super();
    this.userEmail = '';
    this.userPass = '';
  }

  ngOnInit(): void {
  }
  validationLogin(values: Array<any>): boolean {
    let acceso: Array<any> = values
    if (acceso[0].acceso = true) {
      return true;
    } else {
      return false;
    }
  }
  async onSubmit() {
    this.loginState.solicitarAcceso(this.sesion.getEmail(), this.sesion.getPass()).subscribe(
      (res) => {
        this.userLogin = res;
        this.controlAcceso();
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
  controlAcceso(): void{
    this.accesoUser = this.comprobarUser(this.userLogin);
    this.validacion = this.validationLogin(this.accesoUser);
    this.loginState.sendLogin(this.accesoUser);
    if (this.validacion) {
      let user: any;
      let tipoAc: any;
      let access: any;
      this.accesoUser.forEach((item) => {
        user = item.user;
        access = item.acceso;
        tipoAc = item.tipo;
      });
      // guardar cookies
      //localStorage.setItem()
      Cookie.set('acceso', access);
      Cookie.set('usuario', user);
      Cookie.set('tipo', tipoAc);
    }
  }

}
