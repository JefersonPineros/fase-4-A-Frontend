import { Injectable } from '@angular/core';
import { Observable,Subject} from 'rxjs';
import { ProductosModel } from '../Models/admin/productosModel';
import { Pedido } from '../Models/model-pedido';
@Injectable({
  providedIn: 'root'
})
export class PedidosCarritoService {

  private subject = new Subject<any>();
  private subjectClear = new Subject<any>();
  sendProducto(producto: Array<ProductosModel>){
    this.subject.next(producto);
  }
  getProduct(){
    return this.subject.asObservable();
  }
  sendClear(limpiar: boolean){
    this.subjectClear.next(limpiar);
  }
  clearList(){
    return this.subjectClear.asObservable();
  }
}
