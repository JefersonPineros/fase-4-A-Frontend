SELECT p.id_productos,
p.nombre_producto,
p.nombre_producto_in,
p.codigo_producto,
p.estado_producto,
p.cantidad_producto,
p.fecha_ingreso,
dp.id_detalle_productos,
dp.valor_inicial,
dp.valor_mas_iva,
dp.descripcion_producto,
dp.descripcion_producto_in,
dp.url_imagen,
cp.id_categoria_producto,
cp.tipo_categoria,
pr.id_proveedor,
pr.contacto,
pr.nombre_proveedor
FROM skillexbd.productos p
JOIN detalle_productos dp ON p.id_productos = dp.productos_id_productos
JOIN categoria_producto cp on p.categoria_producto_id_categoria_producto = cp.id_categoria_producto
join proveedor_has_productos php on p.id_productos = php.productos_id_productos
join proveedor pr on php.proveedor_id_proveedor = pr.id_proveedor;