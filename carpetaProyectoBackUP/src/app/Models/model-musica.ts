import { CancionesModel } from "./model-musica-canciones";
export class AlbumesMusicaModel {
    constructor(
        public id?: number,
        public nombreAlbum?: string,
        public autorAlbum?: string,
        public nombreImagen?: string,
        public urlImagen?: string,
        public UsuarioId?: number,
        public generoId?: number,
        public canciones?: Array<CancionesModel>,
        public usuarioId?: number
    ){}
}