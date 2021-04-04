import { Component, OnDestroy, OnInit } from '@angular/core';
import { Pedido } from 'src/app/Models/model-pedido';
import { PedidosServicesService } from 'src/app/services/admin/pedidos/pedidos-services.service';
declare let alertify: any;
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-gestor-pedido',
  templateUrl: './gestor-pedido.component.html',
  styleUrls: ['./gestor-pedido.component.css']
})
export class GestorPedidoComponent implements OnInit, OnDestroy {

  public listadoPedidos: Array<Pedido>;
  public componenteActivo: boolean;
  public pedidoAProcesar: Pedido;
  public totalPedido: number;
  suscripcionPedidos: Subscription;

  constructor(private listarPedidos: PedidosServicesService) {
    this.pedidoAProcesar = new Pedido();
    this.listadoPedidos = new Array<Pedido>();
    this.updatePedidos();
    this.componenteActivo = true;
  }

  ngOnInit(): void {
  }

  timer() {
    setTimeout(() => { this.updatePedidos(); }, 10000);
  }

  updatePedidos() {
    this.suscripcionPedidos = this.listarPedidos.listarPedidos().subscribe(
      resp => {
        if (resp.length > 0) {
          this.listadoPedidos = resp;
        } else {
          this.listadoPedidos = [];
        }
        if (this.componenteActivo) {
          this.timer();
        }
      },
      error => {
        this.listadoPedidos = [];
        if (this.componenteActivo) {
          this.timer();
        }
        alertify.error('Se ha presentado un error');
      }
    );
  }

  ngOnDestroy(): void {
    this.componenteActivo = false;
  }

  procesarPedido(id: number): void{
    let porTipo: number;
    this.totalPedido = 0;
    for (let pedido of this.listadoPedidos) {
      if (id === pedido.idPedidos){
        this.pedidoAProcesar = pedido;
        for (let prod of pedido.producto){
          porTipo = prod.valor_mas_iva * prod.cantidadProducto;
          this.totalPedido = porTipo + this.totalPedido;
          this.pedidoAProcesar.valorApagar = this.totalPedido;
        }
      }
    }
  }
  aceptarPedido(estado: number) {
    this.pedidoAProcesar.idEstadoPedido = estado;
    console.log(this.pedidoAProcesar);
    this.suscripcionPedidos = this.listarPedidos.procesarPedido(this.pedidoAProcesar).subscribe(
      resp => {
        alertify.success('Solicitud exitosa');
      },
      error => {
        alertify.error('Se ha presentado un error');
      }
    );
  }
}
