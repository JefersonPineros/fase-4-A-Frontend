export class Evento {

  constructor(
    public idEventos?: number,
    public nombre_evento?: string,
    public autor_evento?: string,
    public usuario_idUsuarios?: number,
    public detalle_evento_id_detalle_evento?: number,
    public fecha_evento?: Date,
    public id_detalle_evento?: number,
    public tipo_evento?: string,
    public servicio_ofrecido?: string,
    public nombre_imagen?: string,
    public imagen_evento?: string
  ) { }
}
