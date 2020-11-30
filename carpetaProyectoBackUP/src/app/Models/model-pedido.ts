import { NewUser } from '../componentesHome/sesion/Models/newUser';
import {ProductosModel} from './admin/productosModel';

export class Pedido{
  public idPedidos?: number;
  public estadoPedidos?: string;
  public mesa?: number;
  public idDetallePedido?: number;
  public idUsuario?: number;
  public idEstadoPedido?: number;
  public valorApagar?: number;
  public fechaPedido?: Date;
  public usuario?: NewUser;
  public producto?: Array<ProductosModel>;

}
