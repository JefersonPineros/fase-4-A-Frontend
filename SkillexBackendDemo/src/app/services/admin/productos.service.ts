import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CreateProduct } from 'src/app/Models/model-create-productos';
import { RespuestasServices } from 'src/app/Models/respuestasServices';
import { ProductosModel } from '../../Models/admin/productosModel';
import { environment } from '../../../environments/environment';
@Injectable({
  providedIn: 'root'
})
export class ProductosService {

  constructor(private httpCliente: HttpClient) { }
  getProductos(): Observable<ProductosModel[]> {
    return this.httpCliente.get<ProductosModel[]>('/api/productos');
  }
  crearProducto(producto: CreateProduct): Observable<any> {

    return this.httpCliente.post<any>(environment.apiBaseUrl + '/api/productos', producto);
  }
  actualizarProoducto(producto: ProductosModel): Observable<any> {
    return this.httpCliente.post(environment.apiBaseUrl + '/api/productos/actualizar/', producto);
  }
  eliminarProducto(id: number): Observable<RespuestasServices> {
    return this.httpCliente.delete<RespuestasServices>(environment.apiBaseUrl + '/api/productos/' + id);
  }
}
