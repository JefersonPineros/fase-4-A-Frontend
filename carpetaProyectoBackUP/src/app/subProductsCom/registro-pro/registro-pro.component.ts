import { Component, OnInit } from '@angular/core';
import { Form } from '@angular/forms'
import { NewUser } from '../../componentesHome/sesion/Models/newUser'

@Component({
  selector: 'app-registro-pro',
  templateUrl: './registro-pro.component.html',
  styleUrls: ['./registro-pro.component.css']
})
export class RegistroProComponent implements OnInit {
  public newUser: NewUser;
  constructor() { 
    this.newUser =new NewUser("","","","",""); 
  }

  ngOnInit(): void {
  }
  newUserSubmit(){
    console.log(this.newUser)    
  }
}
