import { Component, OnInit, Output, EventEmitter, Input } from '@angular/core';
import { PedidosCarritoService } from '../../services/pedidos-carrito.service';
import Swal from 'sweetalert2';
import { IdiomaServiceService } from '../../services/idioma-service.service';
import * as Cookie from 'js-cookie';
import { Pedido } from '../../Models/model-pedido';
import { NgForm, FormGroup, FormControl } from '@angular/forms';
import { ProductosModel } from 'src/app/Models/admin/productosModel';
import { PedidosServicesService } from '../../services/admin/pedidos/pedidos-services.service';
import { RespuestasServices } from 'src/app/Models/respuestasServices';

@Component({
  selector: 'app-carrito-compras',
  templateUrl: './carrito-compras.component.html',
  styleUrls: ['./carrito-compras.component.css']
})
export class CarritoComprasComponent implements OnInit {
  public pedidosList: Array<ProductosModel>;
  public idiomaSelected: any;
  public limpiar = false;
  public createPedidos: Pedido;
  public respuesta: RespuestasServices;
  @Output() emitClearList = new EventEmitter();
  constructor(private getPedido: PedidosCarritoService,
              private idiomaService: IdiomaServiceService,
              private pedidoService: PedidosServicesService) {
    this.pedidosList = new Array<ProductosModel>();
    this.createPedidos = new Pedido();
  }

  ngOnInit(): void {
    this.getPedido.getProduct().subscribe(
      product => {
        if (product !== '') {
          this.pedidosList = product;
          this.pedidosList.forEach((item) => {item.cantidadProducto = 0});
          console.log(this.pedidosList);
        }
      }
    );
    this.idiomaService.getIdioma().subscribe(
      idioma => {
        this.idiomaSelected = idioma;
      }
    );
    let getIdiomaCookie = sessionStorage.getItem('idioma');
    if (getIdiomaCookie != null) {
      if (getIdiomaCookie === 'espanol' ) {
        this.idiomaSelected = getIdiomaCookie;
      } else {
        this.idiomaSelected = getIdiomaCookie;
      }
    } else {
      this.idiomaSelected = 'espanol';
    }
  }
  enviarPedido() {

    let getUsuarioCookie = sessionStorage.getItem('usuario');
    let getIdUser = parseInt(sessionStorage.getItem('idUsuario'));
    if (getUsuarioCookie != null) {
      try {
        this.createPedidos.idPedidos = null;
        this.createPedidos.estadoPedidos = 'Activo';
        this.createPedidos.mesa = 1;
        this.createPedidos.idDetallePedido = null;
        this.createPedidos.idUsuario = getIdUser;
        this.createPedidos.idEstadoPedido = 3;
        this.createPedidos.valorApagar = null;
        let date = new Date(Date.now());
        this.createPedidos.fechaPedido = date;
        this.createPedidos.usuario = null;
        this.createPedidos.producto = this.pedidosList;
        console.log(this.createPedidos);
        this.pedidoService.createPedido(this.createPedidos).subscribe(
          resp => {
            this.respuesta = resp;
            if (this.respuesta.codigo === '001') {
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
              });
              Toast.fire({
                icon: 'success',
                title: 'Pedido enviado'
              });
            } else {
              Swal.fire({
                icon: 'error',
                title: 'Ocurrio un error ',
                text: 'Por favor intente nuevamente',
                onClose: () => {
                  location.reload();
                }
              });
            }
          },
          error => {
            Swal.fire({
              icon: 'error',
              title: 'Ocurrio un error ',
              text: 'Por favor intente nuevamente',
              onClose: () => {
                location.reload();
              }
            });
          }
        );
      } catch (error) {
        Swal.fire({
          icon: 'error',
          title: 'Ocurrio un error ',
          text: 'Por favor intente nuevamente',
          onClose: () => {
            location.reload();
          }
        });
      }
      this.pedidosList = [];
      this.getPedido.sendClear(true);
    } else {
      Swal.fire({
        icon: 'error',
        title: 'No ha iniciado sesion..',
        text: 'Por favor inicie sesion o cree una cuenta.',
        onClose: () => {
          location.reload();
        }
      });
      this.getPedido.sendClear(true);
    }
  }
}
