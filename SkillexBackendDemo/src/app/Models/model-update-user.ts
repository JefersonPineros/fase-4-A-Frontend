export class UpdateUserModel {
    constructor(
        public iduser:number,
        public firstName:String,
        public lastName:String,
        public document:Number,
        public email:String,
        public typeUser:String,
        public pass:String,
    ){}

}