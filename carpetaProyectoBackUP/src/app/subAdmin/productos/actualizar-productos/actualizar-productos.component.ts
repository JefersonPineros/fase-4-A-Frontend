import { Component, OnInit } from '@angular/core';
import { UpdateProductosService } from '../../../services/update-productos.service';
import { UpdateProductosModels } from '../../../Models/model-update-products';
import { ProductosModel } from 'src/app/Models/admin/productosModel';
import { ProductosService } from 'src/app/services/admin/productos.service';
import { NgxSpinnerService } from 'ngx-spinner';
@Component({
  selector: 'app-actualizar-productos',
  templateUrl: './actualizar-productos.component.html',
  styleUrls: ['./actualizar-productos.component.css']
})
export class ActualizarProductosComponent implements OnInit {
  public productoAc: ProductosModel;
  public updateProductosModel: UpdateProductosModels;
  public x: number;
  public selected = false;
  public tipoProducto: Array<any>;
  public tipoCat: number;
  constructor(
    private updateProducto: UpdateProductosService,
    private productosService: ProductosService,
    private spinner: NgxSpinnerService) { }

  ngOnInit(): void {
    this.updateProducto.getProduct().subscribe(
      producto => {
        console.log(producto);
        if (producto !== '') {
          this.productoAc = producto;
          this.tipoCat = this.productoAc.id_categoria_producto + 1;
          console.log(this.tipoCat);
          this.selected = true;
        }
      },
      error => {
        console.log(error);
      }
    );
    this.tipoProducto = [
      { id: '1', tipo: 'Cerveza' },
      { id: '2', tipo: 'Aguardiente' },
      { id: '3', tipo: 'Aperitivos' },
      { id: '4', tipo: 'Whysky' },
      { id: '5', tipo: 'Cocteles' }
    ];
  }
  actualizarProducto() {
    this.spinner.show();
    this.productosService.actualizarProoducto(this.productoAc).subscribe(
      resp => {
        this.spinner.hide();
        console.log(resp);
      },
      error => {
        this.spinner.hide();
        console.log(error);
      }
    );
    console.log(this.productoAc);
  }

}
