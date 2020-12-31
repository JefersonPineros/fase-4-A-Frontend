SELECT 
p.idPedidos,
p.estadoPedido,
p.mesa,
dp.iddetallePedido,
dp.valorApagar,
dp.producto,
dp.cantidadProducto,
dp.fecha_pedido,
ep.id_Estado_pedido,
ep.State_id,
ep.descripcion,
php.cantidad_producto_pedido,
pr.id_productos,
pr.nombre_producto,
pr.codigo_producto,
pr.estado_producto,
pr.cantidad_producto,
pr.fecha_ingreso,
dpr.id_detalle_productos,
dpr.valor_inicial,
dpr.valor_mas_iva,
dpr.descripcion_producto,
dpr.url_imagen,
u.idUsuarios,
u.nombreUsuario,
u.apellidoUsuario,
u.emailUsuario,
u.passwordUsuario,
u.tienda,
u.creacion_usuario,
u.fecha_login,
u.turnos_laborales,
u.cedula_ciudadania
FROM skillexbd.pedidos p
JOIN detallepedido dp ON p.detallePedido_iddetallePedido = dp.iddetallePedido
JOIN estado_pedido ep ON p.estado_pedido_ID = ep.id_Estado_pedido
JOIN pedidos_has_productos php ON p.idPedidos = php.pedidos_idPedidos
join productos pr ON pr.id_productos = php.productos_id_productos
join detalle_productos dpr ON dpr.productos_id_productos = pr.id_productos
JOIN pedidos_has_pedidos phu ON  p.idPedidos = phu.Pedidos_idPedidos 
JOIN usuario u ON u.idUsuarios = phu.Pedidos_idUsuarios
WHERE ep.id_Estado_pedido NOT LIKE 4 and ep.id_Estado_pedido NOT LIKE 1 ;