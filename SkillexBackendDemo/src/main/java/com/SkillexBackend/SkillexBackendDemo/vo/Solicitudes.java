package com.SkillexBackend.SkillexBackendDemo.vo;

public class Solicitudes {
	
	private Integer idSolicitud;
	private String mesa;
	private Boolean estado;
	private Integer idCancion;
	private String nombreCancion;
	private String duracion;
	private Integer idUsuario;
	private String nombreUsuario;
	
	public Solicitudes() {
		super();
	}

	public Solicitudes(Integer idSolicitud, String mesa, Boolean estado, Integer idCancion, String nombreCancion,
			String duracion, Integer idUsuario, String nombreUsuario) {
		super();
		this.idSolicitud = idSolicitud;
		this.mesa = mesa;
		this.estado = estado;
		this.idCancion = idCancion;
		this.nombreCancion = nombreCancion;
		this.duracion = duracion;
		this.idUsuario = idUsuario;
		this.nombreUsuario = nombreUsuario;
	}

	public Integer getIdSolicitud() {
		return idSolicitud;
	}

	public void setIdSolicitud(Integer idSolicitud) {
		this.idSolicitud = idSolicitud;
	}

	public String getMesa() {
		return mesa;
	}

	public void setMesa(String mesa) {
		this.mesa = mesa;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Integer getIdCancion() {
		return idCancion;
	}

	public void setIdCancion(Integer idCancion) {
		this.idCancion = idCancion;
	}

	public String getNombreCancion() {
		return nombreCancion;
	}

	public void setNombreCancion(String nombreCancion) {
		this.nombreCancion = nombreCancion;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	
}
