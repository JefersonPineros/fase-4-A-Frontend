import { Component, OnInit } from '@angular/core';
import { UpdateServiceService } from '../../../services/update-service.service';
import {NgForm, FormsModule } from '@angular/forms';
import { UpdateUserModel } from '../../../Models/model-update-user';
@Component({
  selector: 'app-update-usuario',
  templateUrl: './update-usuario.component.html',
  styleUrls: ['./update-usuario.component.css']
})
export class UpdateUsuarioComponent implements OnInit {
  public usuarioUpdate: any;
  public selected: boolean;
  public updateUserMode: UpdateUserModel;
  public userType: Array<any>
  constructor(private updateUserService:UpdateServiceService) {
      this.selected = false;
      this.updateUserMode = new UpdateUserModel(null,"","",null,"","","");  
      this.userType = [
        {id:"1",tipo:'Administrador'},
        {id:"2",tipo:'Bartender'}
      ];
   }

  ngOnInit(): void {
    this.updateUserService.getUser().subscribe(
      usuario => {
        if(usuario != '' ){
          this.usuarioUpdate = usuario
          this.updateUserMode.iduser = this.usuarioUpdate.id;
          this.updateUserMode.firstName = this.usuarioUpdate.nombre;
          this.updateUserMode.lastName = this.usuarioUpdate.apellidos;
          this.updateUserMode.document = this.usuarioUpdate.cedula;
          this.updateUserMode.email = this.usuarioUpdate.correo;
          this.updateUserMode.pass = this.usuarioUpdate.passwordUs;
          this.selected = true;
        }
      }
    );
  }
  onSubmit(){
    console.log(this.updateUserMode);
  }

}
