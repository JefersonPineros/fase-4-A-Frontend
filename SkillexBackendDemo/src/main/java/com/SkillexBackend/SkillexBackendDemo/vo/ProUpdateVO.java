package com.SkillexBackend.SkillexBackendDemo.vo;

public class ProUpdateVO {
	private Integer id;
	private Integer cantidad;

	public ProUpdateVO() {
		super();
	}

	public ProUpdateVO(Integer id, Integer cantidad) {
		super();
		this.id = id;
		this.cantidad = cantidad;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

}
