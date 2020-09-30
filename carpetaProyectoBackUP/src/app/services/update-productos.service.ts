import { Injectable } from '@angular/core';
import { Observable, Subject} from 'rxjs';
import { ProductosModel } from '../Models/admin/productosModel';
import { CreateProduct } from '../Models/model-create-productos';
import { UpdateProductosModels } from '../Models/model-update-products';

@Injectable({
  providedIn: 'root'
})
export class UpdateProductosService {

  private suscription = new Subject<any>();
  sendProduct(product: ProductosModel){
    this.suscription.next(product);
  }
  getProduct(){
    return this.suscription.asObservable();
  }
}
