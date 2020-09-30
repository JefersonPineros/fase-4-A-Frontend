import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-administrador',
  templateUrl: './administrador.component.html',
  styleUrls: ['./administrador.component.css']
})
export class AdministradorComponent implements OnInit {
  
  public rutasAdmin:String;

  constructor() {
      
   }

  ngOnInit(): void {
    
    this.rutasAdmin = '1'
    
  }
  ngOnDestroy(): void {
    
    
  }
  modulo(indice:String) {
    let indi:String = indice;
    this.rutasAdmin = indi;
  }

}
