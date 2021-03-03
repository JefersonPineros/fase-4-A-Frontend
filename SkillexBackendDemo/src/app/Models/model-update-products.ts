export class UpdateProductosModels{
    constructor(
        public id_producto:string,
        public nombre_producto:string,
        public codigo_producto:string,
        public estado_producto:string,
        public cantidad_producto:number,
        public valor_iva:number,
        public descripcion_productos:string,
        public tipo_producto: string
    ){

    }
}