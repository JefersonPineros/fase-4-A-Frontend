import { Component, OnInit } from '@angular/core';
import { PedidosCarritoService } from '../services/pedidos-carrito.service';
import Swal from 'sweetalert2';
import { IdiomaServiceService } from '../services/idioma-service.service';
import * as Cookie from 'js-cookie';
import { CarritoComprasComponent } from '../subProductsCom/carrito-compras/carrito-compras.component';
import { ProductosService } from '../services/admin/productos.service';
import { ProductosModel } from '../Models/admin/productosModel';
@Component({
  selector: 'app-productos',
  templateUrl: './productos.component.html',
  styleUrls: ['./productos.component.css'],
  providers: [CarritoComprasComponent]
})
export class ProductosComponent implements OnInit {
  public countPedidos: string;
  public listaProductosIN: Array<ProductosModel>;
  public listaProductosESP: Array<ProductosModel>;
  public ProduuctosSeleccionados: Array<ProductosModel>;
  public idiomaSelected: string;
  public listarProduct: Array<ProductosModel>;
  public buscarProducto: string;
  constructor(private sendProductoServices: PedidosCarritoService,
              private idiomaService: IdiomaServiceService,
              private productosServices: ProductosService) {
    this.ProduuctosSeleccionados = new Array();
    this.countPedidos = '0';
    this.listarProduct = new Array<ProductosModel>();
    /**
     * Inyeccion de servicio de consulta de productos
     */
    this.productosServices.getProductos().subscribe(
      resp => {
        this.listarProduct = resp;
        this.listaProductosESP = this.listarProduct;
        this.listaProductosIN = this.listarProduct;
      },
      error => {
          console.log(error);
          console.log('Error al cargar los productos');
      }
    );
    this.sendProductoServices.clearList().subscribe(
      limpiar => {
        if (limpiar) {
          this.ProduuctosSeleccionados = [];
          this.countPedidos = '0';
        }
      }
    );
  }
  ngOnInit(): void {
    this.idiomaService.getIdioma().subscribe(
      idioma => {
        let idm = idioma;
        this.idiomaSelected = idm;
      }
    );
    let getIdiomaCookie = Cookie.get('idioma');
    if (getIdiomaCookie != null) {
      if (getIdiomaCookie === 'espanol') {
        this.idiomaSelected = getIdiomaCookie;
      } else {
        this.idiomaSelected = getIdiomaCookie;
      }
    } else {
      this.idiomaSelected = 'espanol';
    }
  }

  agregarProducto(idPro: number) {
    let idPr: number = idPro;
    let contador: number = parseInt(this.countPedidos);

    if (this.ProduuctosSeleccionados.length > 0) {
      if (this.ProduuctosSeleccionados.find(x => x.idProductos === idPr)) {
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
          icon: 'error',
          title: 'Producto ya seleccionado'

        });
      } else {
        for (let x = 0; x < this.listaProductosESP.length; x++) {
          if (this.listaProductosESP[x].idProductos === idPr) {
            contador = contador + 1;
            this.countPedidos = contador.toString();
            this.ProduuctosSeleccionados.push(this.listaProductosESP[x]);
            console.log(this.ProduuctosSeleccionados);
          }
        }
      }
    } else {
      for ( let i = 0; i < this.listaProductosESP.length; i++ ) {
        if (this.listaProductosESP[i].idProductos === idPr) {
          contador = contador + 1;
          this.countPedidos = contador.toString();
          this.ProduuctosSeleccionados.push(this.listaProductosESP[i]);
        }
      }
    }
  }
  sendProductos() {
    this.sendProductoServices.sendProducto(this.ProduuctosSeleccionados);
  }
  filtrarBebida(tipo?: string): void {
    if (tipo === undefined) {
      this.listaProductosESP = this.listarProduct;
    } else {
      this.listaProductosESP = this.listarProduct.filter(tipoP => tipoP.tipo_categoria === tipo);
    }
  }
  buscarProductos(): void {
    this.listaProductosESP = this.listarProduct.filter(
      item => {
        return item.nombreProducto.toLowerCase().indexOf(this.buscarProducto.toLowerCase()) > -1;
      }
    );
  }
}
