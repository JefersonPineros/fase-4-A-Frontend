import { Component, OnInit, OnDestroy } from '@angular/core';
import { NgForm, FormGroup, FormControl } from '@angular/forms';
import { NewUser } from 'src/app/componentesHome/sesion/Models/newUser';
import { UserModel } from 'src/app/Models/userModel';
import { UsuarioService } from 'src/app/services/admin/usuario.service';
import { RespuestasServices } from '../../../Models/respuestasServices';
import Swal from 'sweetalert2';
import * as Cookie from 'js-cookie';
import { IdiomaServiceService } from 'src/app/services/idioma-service.service';
import { Subscription } from 'rxjs';

interface HtmlInputEvent extends Event {
  target: HTMLInputElement & EventTarget;
}
@Component({
  selector: 'app-crear-usuario',
  templateUrl: './crear-usuario.component.html',
  styleUrls: ['./crear-usuario.component.css']
})
export class CrearUsuarioComponent implements OnInit, OnDestroy {
  public tipo: any[];
  public pass1: string;
  public pass2: string;
  public crearUsuarioAdmin: UserModel;
  public crearUser: NewUser;
  public confirmacion: boolean;
  public error: string[];
  public responseS: RespuestasServices;
  public idiomaSelected: string;
  public archivo = 'Seleccione un archivo';
  public archivoSelecionado: File;
  suscripcionUsuario: Subscription;

  constructor( private userService: UsuarioService, private idiomaService: IdiomaServiceService ) {
    this.crearUsuarioAdmin = new UserModel();
    this.tipo = [
      { id: 1, tipo: 'Administrador' },
      { id: 2, tipo: 'Cliente' },
      { id: 3, tipo: 'Bartender' }
    ];
    this.error = ['Correcto', 'Ingrese una contraseña valida', 'Las contraseñas no coinciden'];
  }
  ngOnDestroy(): void {
    // this.suscripcionUsuario.unsubscribe();
  }

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
  onSubmit() {
    const fechaCreacion = new Date(Date.now());
    this.crearUsuarioAdmin.creacionUsuario = fechaCreacion;
    this.crearUsuarioAdmin.inventario = 1;
    if (this.crearUsuarioAdmin.tipoUsuario === 2){
      this.crearUsuarioAdmin.tienda = '';
      this.crearUsuarioAdmin.turnosLaborales = '';
    }
    this.crearUser = new NewUser(
      null,
      this.crearUsuarioAdmin.nombreUsuario,
      this.crearUsuarioAdmin.apellidoUsuario,
      this.crearUsuarioAdmin.emailUsuario,
      this.crearUsuarioAdmin.passwordUsuario,
      this.crearUsuarioAdmin.tienda,
      this.crearUsuarioAdmin.creacionUsuario,
      this.crearUsuarioAdmin.fechaLogin,
      this.crearUsuarioAdmin.turnosLaborales,
      this.crearUsuarioAdmin.cedulaCiudadania,
      this.crearUsuarioAdmin.tipoUsuario,
      this.crearUsuarioAdmin.inventario
      );
    this.suscripcionUsuario = this.userService.crearUsuario(this.crearUser).subscribe(
      resp => {
        this.responseS = resp;
        if (this.responseS.codigo === '001'){
          Swal.fire({
            icon: 'success',
            title: 'Usuario almacenado correctamente',
            text: 'Ninguna novedad al crear el usuario ',
            onClose: () => {
              location.reload();
            }
          });
        } else {
          Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Error al crear el usuario',
            footer: 'El correo ya existe o se presento algún error.'
          });
        }
      }
    );
    console.log(this.crearUsuarioAdmin);
  }
  uploadFile(event: HtmlInputEvent): void {
    this.archivoSelecionado =  event.target.files[0];
    if (this.archivoSelecionado.type === 'application/vnd.ms-excel') {
      this.archivo = this.archivoSelecionado.name;
      Swal.fire({
        title: 'Creación masiva de usuario!',
        text: '¿Desea continuar con esta acción?',
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Confirmar'
      }).then((result) => {
        if (result.isConfirmed) {
          this.userService.cargueMasivo(this.archivoSelecionado).subscribe(
            resp => {
              if (resp.codigo === '001') {
                Swal.fire(
                  'Exito!',
                  'Usuarios creados exitosamente',
                  'success'
                );
              }
            },
            err => {
              console.log(err);
              Swal.fire({
                icon: 'error',
                title: 'Se ha presentado un error',
                text: 'No se pudo realizar la creación de los usuarios',
                onClose: () => {
                }
              });
            }
          );
        }
      });
    } else {
      Swal.fire({
        icon: 'error',
        title: 'Se ha presentado un error',
        text: 'No se pudo realizar la creación de los usuarios',
        onClose: () => {
        }
      });
    }
  }
}
