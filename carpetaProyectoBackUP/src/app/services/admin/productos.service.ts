import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { from, Observable } from 'rxjs';
import { CreateProduct } from 'src/app/Models/model-create-productos';
import { ProductosModel } from '../../Models/admin/productosModel';

@Injectable({
  providedIn: 'root'
})
export class ProductosService {

  constructor(private httpCliente: HttpClient) { }
  getProductos(): Observable<ProductosModel[]> {
    return this.httpCliente.get<ProductosModel[]>('/api/productos');
  }
  crearProducto(producto: CreateProduct): Observable<any> {
    return this.httpCliente.post<any>('/api/productos', producto);
  }
  actualizarProoducto(producto: ProductosModel): Observable<any>{
    return this.httpCliente.post('/api/productos/actualizar/', producto);
  }
}