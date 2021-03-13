package com.SkillexBackend.SkillexBackendDemo.vo;

import java.util.List;

public class AlbumVO {
	public Integer id;
	public String nombreAlbum;
	public String autorAlbum;
	public String nombreImagen;
	public String urlImagen;
	public Integer usuarioId;
	public Integer generoId;
	public List<CancionVO> canciones;
	public boolean visible;
	public Integer activo; 
	
	public AlbumVO() {
		super();
	}

	public AlbumVO(Integer id, String nombreAlbum, String autorAlbum, String nombreImagen, String urlImagen,
			Integer usuarioId, Integer generoId, List<CancionVO> canciones, boolean visible, Integer activo) {
		super();
		this.id = id;
		this.nombreAlbum = nombreAlbum;
		this.autorAlbum = autorAlbum;
		this.nombreImagen = nombreImagen;
		this.urlImagen = urlImagen;
		this.usuarioId = usuarioId;
		this.generoId = generoId;
		this.canciones = canciones;
		this.visible = visible;
		this.activo = activo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<CancionVO> getCanciones() {
		return canciones;
	}

	public void setCanciones(List<CancionVO> canciones) {
		this.canciones = canciones;
	}

	public String getNombreAlbum() {
		return nombreAlbum;
	}

	public void setNombreAlbum(String nombreAlbum) {
		this.nombreAlbum = nombreAlbum;
	}

	public String getAutorAlbum() {
		return autorAlbum;
	}

	public void setAutorAlbum(String autorAlbum) {
		this.autorAlbum = autorAlbum;
	}

	public String getNombreImagen() {
		return nombreImagen;
	}

	public void setNombreImagen(String nombreImagen) {
		this.nombreImagen = nombreImagen;
	}

	public String getUrlImagen() {
		return urlImagen;
	}

	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}


	public Integer getGeneroId() {
		return generoId;
	}

	public void setGeneroId(Integer generoId) {
		this.generoId = generoId;
	}

	public Integer getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public Integer getActivo() {
		return activo;
	}

	public void setActivo(Integer activo) {
		this.activo = activo;
	}
	
}
