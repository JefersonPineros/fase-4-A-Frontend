export class CrearUsuarioAdmin{
    constructor(
        public firstName:String,
        public lastName:String,
        public document:Number,
        public email:String,
        public typeUser:String,
        public pass:String,
        public confirmPass:String
    ){}
    getPass(){
        return this.pass;
    }
    setPass(pass2:String){
        this.pass = pass2
    }
    getPassConfirm(){
        return this.confirmPass;
    }
    setPassConfirm(pass2:String){
        this.confirmPass = pass2
    }
}