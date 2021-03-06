package com.SkillexBackend.SkillexBackendDemo.vo;

public class CancionVO {
	public Integer id;
	public String nombreCancion;
	public String duracion;

	public CancionVO() {
		super();
	}

	public CancionVO(Integer id, String nombreCancion, String duracion) {
		super();
		this.id = id;
		this.nombreCancion = nombreCancion;
		this.duracion = duracion;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

}
