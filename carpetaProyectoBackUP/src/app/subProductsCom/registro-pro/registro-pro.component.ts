import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';
import { NewUser } from '../../componentesHome/sesion/Models/newUser';
import { IdiomaServiceService } from '../../services/idioma-service.service';
import * as Cookie from 'js-cookie';
@Component({
  selector: 'app-registro-pro',
  templateUrl: './registro-pro.component.html',
  styleUrls: ['./registro-pro.component.css']
})
export class RegistroProComponent implements OnInit {
  public newUser: NewUser;
  public idiomaSelected: string;
  constructor(private loginState: LoginService, private idiomaService: IdiomaServiceService) {
    this.newUser = new NewUser(null, '', '', '', '', '', null, '', '', '', null, null);
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
    console.log(getIdiomaCookye);
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
  newUserSubmit() {
  }
}
