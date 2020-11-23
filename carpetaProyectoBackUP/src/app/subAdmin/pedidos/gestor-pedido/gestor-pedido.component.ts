import { Component, OnDestroy, OnInit, } from '@angular/core';
import { Pedido } from 'src/app/Models/model-pedido';
import { PedidosServicesService } from 'src/app/services/admin/pedidos/pedidos-services.service';

@Component({
  selector: 'app-gestor-pedido',
  templateUrl: './gestor-pedido.component.html',
  styleUrls: ['./gestor-pedido.component.css']
})
export class GestorPedidoComponent implements OnInit, OnDestroy {

  public listadoPedidos: Array<Pedido>;
  public componenteActivo: boolean;
  public pedidoAProcesar: Pedido;
  constructor(private listarPedidos: PedidosServicesService) {
    this.pedidoAProcesar = new Pedido();
   }

  ngOnInit(): void {
    this.componenteActivo = true;
    this.updatePedidos();
  }

  timer() {
    setTimeout(() => { this.updatePedidos(); }, 10000);
  }

  updatePedidos() {
    this.listarPedidos.listarPedidos().subscribe(
      resp => {
        this.listadoPedidos = resp;
        console.log(this.listadoPedidos);
      },
      error => {
        console.log(error);
      }
    );
    if (this.componenteActivo) {
      this.timer();
    }
  }
  ngOnDestroy(): void {
    this.componenteActivo = false;
    console.log(this.componenteActivo);
  }
  procesarPedido(id: number): void{
    for (let pedido of this.listadoPedidos) {
      if (id === pedido.idPedidos){
        this.pedidoAProcesar = pedido;
        console.log(this.pedidoAProcesar.usuario.nombreUsuario);
      }
    }
  }
}
