export class ProductosModel {
    constructor(
        public idProductos: number,
        public nombreProducto: string,
        public nombreProductoIn: string,
        public codigoProducto: string,
        public estadoProducto: string,
        public cantidadProducto: string,
        public fechaIngreso: Date,
        public id_detalle_productos: number,
        public valor_inicial: number,
        public valor_mas_iva: number,
        public descripcion_producto: string,
        public descripcion_producto_in: string,
        public url_imagen: string,
        public id_categoria_producto: number,
        public tipo_categoria: string,
        public id_proveedor: number,
        public contacto: string,
        public nombre_proveedor: string
    ) {

    }
}