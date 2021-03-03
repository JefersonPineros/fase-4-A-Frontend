export class CreateAlbumModel{
    constructor(
        public nameAlbum:string,
        public autorAlbum:string,
        public generoAlbum:any,
        public imagenAlbum:string,
        public musicaAlbum:Array<any>[]

    ){

    }
}