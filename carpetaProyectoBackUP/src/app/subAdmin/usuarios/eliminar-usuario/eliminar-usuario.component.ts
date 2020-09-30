import { Component, OnInit } from '@angular/core';
import { UpdateServiceService } from '../../../services/update-service.service'
@Component({
  selector: 'app-eliminar-usuario',
  templateUrl: './eliminar-usuario.component.html',
  styleUrls: ['./eliminar-usuario.component.css']
})
export class EliminarUsuarioComponent implements OnInit {
  //dtOptions: DataTables.Settings = {};
  public listUsuarios: Array<any>;
  public seletedUser: any;
  constructor(private updateUserService:UpdateServiceService) { 
    this.listUsuarios = [
      {
        id:"1",
        nombre:"Jeferson",
        apellidos:"Piñeros",
        cedula:"",
        correo:"japineros91@misena.edu.co",
        tipo:"1",
        passwordUs:"123456"
      },
      {
        id:"2",
        nombre:"Wainer",
        apellidos:"Gaitan",
        cedula:"",
        correo:"WainerG@misena.edu.co",
        tipo:"2",
        passwordUs:""
      },
      {
        id:"3",
        nombre:"Ruby",
        apellidos:"Romero",
        cedula:"",
        correo:"ruby_Romero@misena.edu.co",
        tipo:"1",
        passwordUs:""
      },
      {
        id:"4",
        nombre:"Ana",
        apellidos:"Sofia",
        cedula:"",
        correo:"anaVelasquez@gmail.com",
        tipo:"2",
        passwordUs:""
      }
    ];
  }

  ngOnInit(): void {
    console.log(this.listUsuarios)

  }
  actualizarTabla(index:number){
    let selected = index;
    for(let i:number = 0; i<=this.listUsuarios.length; i++){
      if(selected == i){
        this.seletedUser = this.listUsuarios[i];
        this.updateUserService.sendUser(this.seletedUser);
      }
    }
  }  
  
}
