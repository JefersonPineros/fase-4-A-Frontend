import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { RespuestasServices } from '../../../Models/respuestasServices';
import { Pedido } from 'src/app/Models/model-pedido';
@Injectable({
  providedIn: 'root'
})
export class PedidosServicesService {

  constructor(private httpClient: HttpClient) { }
  createPedido(pedido: Pedido): Observable<RespuestasServices> {
    return this.httpClient.post<RespuestasServices>('/api/pedidos/', pedido);
  }
  listarPedidos(): Observable<Pedido[]>{
    return this.httpClient.get<Pedido[]>('/api/pedidos/listar/');
  }
  procesarPedido(pedidoP: Pedido): Observable<RespuestasServices> {
    return this.httpClient.post<RespuestasServices>('/api/pedidos/procesar/', pedidoP);
  }
}
