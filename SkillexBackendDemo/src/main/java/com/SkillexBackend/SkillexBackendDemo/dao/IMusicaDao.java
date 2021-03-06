package com.SkillexBackend.SkillexBackendDemo.dao;

import java.util.List;

import com.SkillexBackend.SkillexBackendDemo.vo.AlbumVO;
import com.SkillexBackend.SkillexBackendDemo.vo.Solicitudes;

public interface IMusicaDao {
	public Object crearAlbum(AlbumVO album);
	public List<AlbumVO> listarAlbum();
	public Object eliminarAlbum(Integer id);
	public AlbumVO actualizarAlbum(AlbumVO album);
	public Object solicitarCancion(String mesa, Integer idUsuario, Integer idCancion);
	public Object procesarCancion(Boolean estado, Integer idSolicitud);
	public List<Solicitudes> listarCancionesSolicitadas();
}
