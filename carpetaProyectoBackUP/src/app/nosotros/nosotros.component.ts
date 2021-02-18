import { Component, OnInit } from '@angular/core';
import * as Cookie from 'js-cookie';
import { IdiomaServiceService } from '../services/idioma-service.service';
@Component({
  selector: 'app-nosotros',
  templateUrl: './nosotros.component.html',
  styleUrls: ['./nosotros.component.css']
})
export class NosotrosComponent implements OnInit {
  public idiomaSelected: string;
  constructor(private idiomaService: IdiomaServiceService) { }

  ngOnInit(): void {
    let uG = sessionStorage.getItem('usuario');
    let access = sessionStorage.getItem('acceso');
    let tipoAC = sessionStorage.getItem('tipo');
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

}
