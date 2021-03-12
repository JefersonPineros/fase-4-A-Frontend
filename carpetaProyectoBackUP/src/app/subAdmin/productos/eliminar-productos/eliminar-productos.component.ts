import { Component, OnInit, OnDestroy } from '@angular/core';
import { UpdateProductosService } from '../../../services/update-productos.service';
import { ProductosService } from '../../../services/admin/productos.service';
import { ProductosModel } from 'src/app/Models/admin/productosModel';
import { ReporteProductosService } from '../../../services/reportes/reporte-productos.service';
import Swal from 'sweetalert2';
import { Subscription } from 'rxjs';
import { descargarPDF } from 'src/app/Controller/descargaPDF-controller';
import { NgxSpinnerService } from 'ngx-spinner';
@Component({
  selector: 'app-eliminar-productos',
  templateUrl: './eliminar-productos.component.html',
  styleUrls: ['./eliminar-productos.component.css']
})
export class EliminarProductosComponent extends descargarPDF implements OnInit, OnDestroy {
  public listaProductos: Array<ProductosModel>;
  public actPro: ProductosModel;
  cantidadPro = false;
  suscripcionProductos: Subscription;
  suscripcionActualizarP: Subscription;
  suscripcionReportes: Subscription;

  constructor(
    private updateProductos: UpdateProductosService,
    private productosService: ProductosService,
    private reportesServices: ReporteProductosService,
    private spinner: NgxSpinnerService) {
    super();
    this.listaProductos = new Array<ProductosModel>();
  }
  ngOnDestroy(): void {
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
    this.spinner.show();
    this.suscripcionProductos = this.productosService.eliminarProducto(item).subscribe(
      resp => {
        this.spinner.hide();
        Swal.fire({
          icon: 'success',
          title: 'Transacción exitosa',
          text: 'Se ha eliminado el producto correctamente',
          onClose: () => {

          }
        });
      },
      error => {
        this.spinner.hide();
        console.log(error);
      }
    );
  }
  setColor(cantidad: string): boolean {
    // tslint:disable-next-line: radix
    if (parseInt(cantidad) < 10) {
      console.log(parseInt(cantidad));
      this.cantidadPro = true;
      return this.cantidadPro;
    } else {
      return this.cantidadPro;
    }
  }
  reporte(): void {
    this.spinner.show();
    this.suscripcionReportes = this.reportesServices.reporteProducto('pdf').subscribe(
      resp => {
        this.spinner.hide();
        this.descargar(resp);
        Swal.fire({
          icon: 'success',
          title: 'Descarga exitosa',
          text: 'Se ha descargado correctamente el reporte',
          onClose: () => {
            location.reload();
          }
        });
      },
      error => {
        this.spinner.hide();
        Swal.fire({
          icon: 'error',
          title: 'Oops...',
          text: 'No se pudo descargar el pdf',
          footer: 'Se ha presentado un problema al descargar el reporte'
        });
      }
    );
  }
}
