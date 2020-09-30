import { Component, OnInit } from '@angular/core';
import { NgForm, FormGroup, FormControl } from '@angular/forms';
import { ProductosService } from 'src/app/services/admin/productos.service';
import { CreateProduct } from '../../../Models/model-create-productos';

@Component({
  selector: 'app-crear-productos',
  templateUrl: './crear-productos.component.html',
  styleUrls: ['./crear-productos.component.css']
})
export class CrearProductosComponent implements OnInit {
  public createProduct: CreateProduct;
  public tipoProduct: any[];
  constructor(private productosService: ProductosService) {
    this.createProduct = new CreateProduct(null, '', '', '', '', null, null, null, null, null, null, null, '', '', '');
    this.tipoProduct = [
      { id: '1', tipo: 'Cerveza' },
      { id: '2', tipo: 'Aguardiente' },
      { id: '3', tipo: 'Aperitivos' },
      { id: '4', tipo: 'Whysky' },
      { id: '5', tipo: 'Cocteles' }
    ];
  }

  ngOnInit(): void {

  }
  onSubmit() {
    this.createProduct.estadoProducto = 'Activo';
    let fechaIngreso: Date = new Date(Date.now());
    this.createProduct.fechaIngreso = fechaIngreso;
    this.createProduct.inventario_id_inventario = 1;
    this.productosService.crearProducto(this.createProduct).subscribe(
      resp => {
        console.log(resp);
      }
    );
    console.log(this.createProduct);
  }
}
