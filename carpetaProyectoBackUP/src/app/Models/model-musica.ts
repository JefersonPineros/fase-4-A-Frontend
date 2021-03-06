import { CancionesModel } from "./model-musica-canciones";
export class AlbumesMusicaModel {
    constructor(
        public id?: number,
        public nombreAlbum?: string,
        public autorAlbum?: string,
        public nombreImagen?: string,
        public urlImagen?: string,
        public generoId?: number,
        public canciones?: Array<CancionesModel>,
        public usuarioId?: number,
        public visible?: boolean,
        public activo?: number
    ){}
}