import { Component, OnInit } from '@angular/core';
import { UpdateProductosService } from '../../../services/update-productos.service';
import { ProductosService } from '../../../services/admin/productos.service';
import { ProductosModel } from 'src/app/Models/admin/productosModel';
@Component({
  selector: 'app-eliminar-productos',
  templateUrl: './eliminar-productos.component.html',
  styleUrls: ['./eliminar-productos.component.css']
})
export class EliminarProductosComponent implements OnInit {
  public listaProductos: Array<ProductosModel>;
  public actPro: ProductosModel;
  cantidadPro = false;
  constructor(private updateProductos: UpdateProductosService, private productosService: ProductosService) {
    this.listaProductos = new Array<ProductosModel>();
  }

  ngOnInit(): void {
    this.productosService.getProductos().subscribe(
      rest => {
        this.listaProductos = rest;
      },
      error => {
        console.log(error);
      }
    );
  }

  actualizarProducto(item: number) {
    for (let i = 0; i <= this.listaProductos.length; i++) {
      if (i === item) {
        this.actPro = this.listaProductos[i];
        this.updateProductos.sendProduct(this.actPro);
      }
    }
  }
  eliminarProducto(item: number) {
    console.log('Eliminar producto', item);
  }
  setColor(cantidad: string): boolean {
    // tslint:disable-next-line: radix
    if ( parseInt(cantidad) < 10 ){
      console.log(parseInt(cantidad));
      this.cantidadPro = true;
      return this.cantidadPro;
    } else {
      return this.cantidadPro;
    }
  }
}
