DROP procedure spStateOrder;
delimiter $$
CREATE procedure spStateOrder(IN idPedido int,IN stateOrder int,OUT endState text)
begin
	Declare idPedidoV int;
    Declare stateOrderV int;
    Declare Actualstate int;
    Declare endStateF text;
    SET idPedidoV = idPedido;
    SET stateOrderV = stateOrder;
	IF idPedidoV > 0
    THEN
		UPDATE pedidos SET estado_pedido_ID =  stateOrderV WHERE idPedidos = idPedidoV;
        UPDATE pedidos SET estadoPedido = (SELECT ep.descripcion from estado_pedido ep where ep.id_Estado_pedido = stateOrderV ) where idPedidos = idPedidoV;
		SET endStateF = (
							Select 
								ep.descripcion
                            from estado_pedido ep
							join pedidos p ON p.estado_pedido_ID = ep.id_Estado_pedido
                            where p.idPedidos = idPedidoV
						);
		SET endState = endStateF;
    END IF;
END;
$$ 
CALL spStateOrder(2,1,@texto);
SELECT @texto