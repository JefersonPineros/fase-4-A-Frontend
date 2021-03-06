select 
	sm.idusuarioMusica, 
	sm.mesa_cancion, 
    sm.estado,
    cn.id_cancion,
    cn.nombre_cancion,
    cn.duracion,
    us.idUsuarios,
    us.nombreUsuario
from usuariomusica sm
JOIN usuariomusica_has_usuario smh ON smh.usuarioMusica_idusuarioMusica = sm.idusuarioMusica
JOIN usuario us ON us.idUsuarios = smh.Usuario_idUsuarios
JOIN cancion_has_usuariomusica chu ON chu.usuarioMusica_idusuarioMusica = sm.idusuarioMusica
JOIN cancion cn ON cn.id_cancion = chu.cancion_id_cancion 
Where sm.estado = 0