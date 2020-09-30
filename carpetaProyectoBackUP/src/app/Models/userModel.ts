export class UserModel {
    public idUsuario: number;
    public nombreUsuario: string;
    public apellidoUsuario: string;
    public emailUsuario: string;
    public passwordUsuario: string;
    public tienda: string;
    public creacionUsuario: Date;
    public fechaLogin: string;
    public turnosLaborales: string;
    public cedulaCiudadania: string;
    public tipoUsuario: number;
    public inventario: number;
    constructor(
        idUsuario: number,
        nombreUsuario: string,
        apellidosUsuario: string,
        emailUsuario: string,
        passwordUsuario: string,
        tienda: string,
        creacionUsuario: Date,
        fechaLogin: string,
        turnosLaborales: string,
        cedulaCiudadania: string,
        tipoUsuario: number,
        inventario: number
    ) {
        this.idUsuario =  idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.apellidoUsuario = apellidosUsuario;
        this.emailUsuario = emailUsuario;
        this.passwordUsuario = passwordUsuario;
        this.tienda = tienda;
        this.creacionUsuario = creacionUsuario;
        this.fechaLogin = fechaLogin;
        this.turnosLaborales = turnosLaborales;
        this.cedulaCiudadania = cedulaCiudadania;
        this.tipoUsuario = tipoUsuario;
        this.inventario = inventario;
    }
    getIdUsuario(){
        return this.idUsuario;
    }
    setIdUsuario(idUsuario: number){
        this.idUsuario = idUsuario;
    }
    getNombreUsuario(){
        return this.nombreUsuario;
    }
    setNombreUsuario(nombreUsuario: string){
        this.nombreUsuario = nombreUsuario;
    }
    getApellidoUsuario(){
        return this.apellidoUsuario;
    }
    setApellidoUsuario(apellidoUsuario: string){
        this.apellidoUsuario = apellidoUsuario;
    }
    getEmailUsuario(){
        return this.emailUsuario;
    }
    setEmailUsuario(emailUsuario: string){
        this.emailUsuario = emailUsuario;
    }
    getPassWord(){
        return this.passwordUsuario;
    }
    setPassWord(pass: string){
        this.passwordUsuario = pass;
    }
    getTienda(){
        return this.tienda;
    }
    setTienda(tienda: string){
        this.tienda = tienda;
    }
    getCreacionUsuario(){
        return this.creacionUsuario;
    }
    setCreacionUsuario(creacion: Date){
        this.creacionUsuario = creacion;
    }
    getFechaLogin(){
        return this.fechaLogin;
    }
    setFechaLogin(fechaLogin: string){
        this.fechaLogin = fechaLogin;
    }
    getTurnosLaborales(){
        return this.turnosLaborales;
    }
    setTurnosLaborales(turnos: string){
        this.turnosLaborales = turnos;
    }
    getCedulaCiudadania(){
        return this.cedulaCiudadania;
    }
    setCedulaCiudadania(cedula: string){
        this.cedulaCiudadania = cedula;
    }
    getTipoUsuario(){
        return this.tipoUsuario;
    }
    setTipoUsuario(tipoUsuario: number){
        this.tipoUsuario = tipoUsuario;
    }
    getInventario(){
        return this.inventario;
    }
    setInventario(inventario: number){
        this.inventario = inventario;
    }
}