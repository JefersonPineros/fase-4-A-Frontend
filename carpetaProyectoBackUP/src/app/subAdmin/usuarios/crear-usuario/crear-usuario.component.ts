import { Component, OnInit } from '@angular/core';
import { NgForm, FormGroup, FormControl } from '@angular/forms';
import { CrearUsuarioAdmin } from './Model/crearUsuario'

@Component({
  selector: 'app-crear-usuario',
  templateUrl: './crear-usuario.component.html',
  styleUrls: ['./crear-usuario.component.css']
})
export class CrearUsuarioComponent implements OnInit {
  public tipo:any[];
  public pass1:String;
  public pass2: String;
  public crearUsuarioAdmin: CrearUsuarioAdmin;
  public confirmacion:Boolean;
  public error:String[];
  constructor() { 
    this.crearUsuarioAdmin = new CrearUsuarioAdmin("","",null,"","","","");
    this.tipo = [
      {id:"1",tipo:'Administrador'},
      {id:"2",tipo:'Bartender'}
    ];
    this.error= ['Correcto','Ingrese una contraseña valida','Las contraseñas no coinciden']
    this.pass1 = this.crearUsuarioAdmin.getPass();
    this.pass2 = this.crearUsuarioAdmin.getPassConfirm();
    
  }

  ngOnInit(): void {

  }
  onSubmit(){
    
    console.log(this.crearUsuarioAdmin);
    
    
  }
  
}
