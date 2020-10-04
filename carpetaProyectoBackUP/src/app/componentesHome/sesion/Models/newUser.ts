export class NewUser {
    constructor(
        public idUsuarios: number,
        public nombreUsuario: string,
        public apellidoUsuario: string,
        public emailUsuario: string,
        public passwordUsuario: string,
        public tienda: string,
        public creacionUsuario: Date,
        public fechaLogin: string,
        public turnosLaborales: string,
        public cedulaCiudadania: string,
        public tipoUsuario: number,
        public inventarioIdInventario: number
    ) {

    }
}