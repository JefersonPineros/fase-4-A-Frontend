import { Component, OnInit, Output, EventEmitter,Input } from '@angular/core';
import { PedidosCarritoService } from '../../services/pedidos-carrito.service'
import { newArray } from '@angular/compiler/src/util';
import Swal from 'sweetalert2';
import { IdiomaServiceService } from '../../services/idioma-service.service';
import * as Cookie from 'js-cookie';
import { ThrowStmt } from '@angular/compiler';
@Component({
  selector: 'app-carrito-compras',
  templateUrl: './carrito-compras.component.html',
  styleUrls: ['./carrito-compras.component.css']
})
export class CarritoComprasComponent implements OnInit {
  public pedidos: Array<any>;
  public idiomaSelected: any;
  public limpiar: boolean = false;
  @Output() emitClearList = new EventEmitter();
  constructor(private getPedido: PedidosCarritoService, private idiomaService: IdiomaServiceService) {
    this.pedidos = new Array()
  }

  ngOnInit(): void {
    this.getPedido.getProduct().subscribe(
      product => {
        if (product != "") {
          this.pedidos = product
          console.log(this.pedidos)
        }
      }
    )
    this.idiomaService.getIdioma().subscribe(
      idioma => {
        this.idiomaSelected = idioma;
      }
    )
    let getIdiomaCookie = Cookie.get('idioma');
    if(getIdiomaCookie != null){
      if(getIdiomaCookie == "espanol"){
        this.idiomaSelected = getIdiomaCookie;
      }else{
        this.idiomaSelected = getIdiomaCookie;
      }
    }else{
      this.idiomaSelected = "espanol"
    }
  }
  enviarPedido() {
    let getUsuarioCookie = Cookie.get('usuario');
    if(getUsuarioCookie != null){
      const Toast = Swal.mixin({
        toast: true,
        position: 'top-end',
        showConfirmButton: false,
        timer: 3000,
        timerProgressBar: true,
        onOpen: (toast) => {
          toast.addEventListener('mouseenter', Swal.stopTimer);
          toast.addEventListener('mouseleave', Swal.resumeTimer);
        }
      })
  
      Toast.fire({
        icon: 'success',
        title: 'Pedido enviado'
      })
      this.pedidos = [];
      this.getPedido.sendClear(true);
    }else{
      Swal.fire({
        icon: 'error',
        title: 'No ha iniciado sesion..',
        text: 'Por favor inicie sesion o cree una cuenta.',
        onClose:() =>{
          location.reload();
        } 
      })
      this.getPedido.sendClear(true);
    }
  }


}
