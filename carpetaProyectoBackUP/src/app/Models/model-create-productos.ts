export class CreateProduct{
    constructor(
        public idProductos: number,
        public nombreProducto: string,
        public nombreProductoIn: string,
        public codigoProducto: string,
        public estadoProducto: string,
        public cantidadProducto: number,
        public fechaIngreso: Date,
        public inventario_id_inventario: number,
        public categoria_producto_id_categoria_producto: number,
        public id_detalle_productos: number,
        public valor_inicial: number,
        public valor_mas_iva: number,
        public descripcion_producto: string,
        public descripcion_producto_in: string,
        public url_imagen: string
    ){

    }
}