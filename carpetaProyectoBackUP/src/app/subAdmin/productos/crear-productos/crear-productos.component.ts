import { Component, OnInit, OnDestroy } from '@angular/core';
import { NgForm, FormGroup, FormControl, NgModel } from '@angular/forms';
import { ProductosService } from 'src/app/services/admin/productos.service';
import { CreateProduct } from '../../../Models/model-create-productos';
import { FileUploader } from 'ng2-file-upload';
import { event } from 'jquery';
import Swal from 'sweetalert2';
import { Subscription } from 'rxjs';

interface HtmlInputEvent extends Event {
  target: HTMLInputElement & EventTarget;
}
@Component({
  selector: 'app-crear-productos',
  templateUrl: './crear-productos.component.html',
  styleUrls: ['./crear-productos.component.css']
})
export class CrearProductosComponent implements OnInit, OnDestroy {
  public createProduct: CreateProduct;
  public tipoProduct: any[];
  public nameImg = 'No ha seleccionado una imagen';
  public selectedFile: File;
  public imagen: File;
  suscripcionProductos: Subscription;

  constructor(private productosService: ProductosService) {
    this.createProduct = new CreateProduct(null, '', '', '', '', null, null, null, null, null, null, null, '', '', '', '');
    this.tipoProduct = [
      { id: '1', tipo: 'Cerveza' },
      { id: '2', tipo: 'Aguardiente' },
      { id: '3', tipo: 'Aperitivos' },
      { id: '4', tipo: 'Whysky' },
      { id: '5', tipo: 'Cocteles' }
    ];
  }
  ngOnDestroy(): void {
    // this.suscripcionProductos.unsubscribe();
  }

  ngOnInit(): void {
  }
  onSubmit() {
    this.createProduct.estadoProducto = 'Activo';
    const fechaIngreso: Date = new Date(Date.now());
    this.createProduct.fechaIngreso = fechaIngreso;
    this.createProduct.inventario_id_inventario = 1;
    this.suscripcionProductos = this.productosService.crearProducto(this.createProduct).subscribe(
      resp => {
        Swal.fire({
          position: 'top-end',
          icon: 'success',
          title: 'Proceso exitoso',
          text: 'Se ha creado el usuario correctamente',
          showConfirmButton: false,
          timer: 1500
        });
      },
      error => {
        Swal.fire({
          position: 'top-end',
          icon: 'error',
          title: 'Se presento un error',
          text: 'No se pudo realizar la creación del usuario, intente nueva mente.',
          showConfirmButton: false,
          timer: 1500
        });
      }
    );
    console.log(this.createProduct);
  }
  uploadFile(event: HtmlInputEvent): void {
    this.imagen = event.target.files[0];
    if (
      this.imagen.type === 'image/jpeg' ||
      this.imagen.type === 'image/png' ||
      this.imagen.type === 'image/jpg'
    ) {
      if (event.target.files && event.target.files[0]) {
        this.selectedFile = event.target.files[0];
        this.nameImg = this.selectedFile.name;
        const reader = new FileReader();
        reader.readAsDataURL(this.selectedFile);
        reader.onload = (): void => {
          const base64String: string = (reader.result as string).match(/.+;base64,(.+)/)[1];
          this.createProduct.url_imagen = 'data:' + this.selectedFile.type + ';base64,' + base64String;
          console.log(this.nameImg);
          this.createProduct.nombre_imagen = this.nameImg;
        };
      }
    } else {
      Swal.fire({
        icon: 'error',
        title: 'Se ha presentado un error',
        text: 'El formato del archivo no es el correcto (jpeg, png o png) ',
        onClose: () => {
          this.nameImg = "Seleccione una imagen";
        }
      });
    }
  }
}
