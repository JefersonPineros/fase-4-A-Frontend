import { Component, OnInit, OnDestroy } from '@angular/core';
import { UserModel } from 'src/app/Models/userModel';
import { UsuarioService } from 'src/app/services/admin/usuario.service';
import { UpdateServiceService } from '../../../services/update-service.service';
import * as Cookie from 'js-cookie';
import Swal from 'sweetalert2';
import { RespuestasServices } from 'src/app/Models/respuestasServices';
import { IdiomaServiceService } from 'src/app/services/idioma-service.service';
import { ReporteProductosService } from '../../../services/reportes/reporte-productos.service';
import { Subscription } from 'rxjs';
import { descargarPDF } from '../../../Controller/descargaPDF-controller';
@Component({
  selector: 'app-eliminar-usuario',
  templateUrl: './eliminar-usuario.component.html',
  styleUrls: ['./eliminar-usuario.component.css']
})
export class EliminarUsuarioComponent extends descargarPDF implements OnInit, OnDestroy{
  public listUsuarios: Array<UserModel>;
  public seletedUser: any;
  public responseS: RespuestasServices;
  public idiomaSelected: string;
  suscriptionUsuario: Subscription;
  suscriptionResporte: Subscription;
  constructor(
    private updateUserService: UpdateServiceService,
    private usuarioService: UsuarioService,
    private idiomaService: IdiomaServiceService,
    private reporteService: ReporteProductosService) {
    super();
    this.listUsuarios = new Array<UserModel>();
  }
  ngOnInit(): void {
    this.suscriptionUsuario = this.usuarioService.listarUsuario().subscribe(
      res => {
        this.listUsuarios = res;
      },
      error => {
        console.log(error);
      }
    );

    let uG = sessionStorage.getItem('usuario');
    let access = sessionStorage.getItem('acceso');
    let tipoAC = sessionStorage.getItem('tipo');
    if (uG !== undefined) {
      let accessConfirm;
      if (access === 'true') {
        accessConfirm = true;
      }
      let tipoParce = parseInt(tipoAC);
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
  ngOnDestroy() {
    // this.suscriptionUsuario.unsubscribe();
    // this.suscriptionResporte.unsubscribe();
  }
  actualizarTabla(index: number) {
    const selected = index;
    for (let i = 0; i <= this.listUsuarios.length; i++) {
      if (selected === i) {
        this.seletedUser = this.listUsuarios[i];
        this.updateUserService.sendUser(this.seletedUser);
      }
    }
  }
  eliminarUsuario(id: number): void {
    for (let i = 0; i <= this.listUsuarios.length; i++) {
      if (id === i) {
        Swal.fire({
          title: 'Eliminar usuario!',
          text: '¿Esta seguro de eliminar este usuario?',
          icon: 'warning',
          showCancelButton: true,
          confirmButtonColor: '#3085d6',
          cancelButtonColor: '#d33',
          confirmButtonText: 'Confirmar'
        }).then((result) => {
          if (result.isConfirmed) {
            console.log(this.listUsuarios[i].idUsuarios);
            this.usuarioService.eliminarUsuario(this.listUsuarios[i].idUsuarios).subscribe(
              resp => {
                this.responseS = resp;
                if (this.responseS.codigo === '001') {
                  console.log(this.responseS);
                } else {
                  Swal.fire({
                    position: 'top-end',
                    icon: 'error',
                    title: 'No se pudo eliminar el usuario',
                    showConfirmButton: false,
                    timer: 3000
                  });
                }
              }
            );
            Swal.fire(
              'Deleted!',
              'Usuario eliminado correctamente',
              'success'
            );
          }
        });
      }
    }
  }
  reporte(): void {
    this.suscriptionResporte = this.reporteService.reporteUsuarios('pdf').subscribe(
      resp => {
        this.descargar(resp);

        Swal.fire({
          icon: 'success',
          title: 'Se ha descargado el documento',
          text: 'Verifique en descargas',
          onClose: () => {

          }
        });
      },
      error => {
        Swal.fire({
          icon: 'error',
          title: 'Se ha presentado un error',
          text: 'No se pudo descargar el documento, intente nueva mente',
          onClose: () => {
          }
        });
      }
    );
  }

}
