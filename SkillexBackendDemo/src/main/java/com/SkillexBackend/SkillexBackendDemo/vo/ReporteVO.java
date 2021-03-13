package com.SkillexBackend.SkillexBackendDemo.vo;

public class ReporteVO {
	private String archivoBase64;
	private String nombreArchivo;
	
	public ReporteVO() {
		super();
	}
	
	public ReporteVO(String archivoBase64, String nombreArchivo) {
		super();
		this.archivoBase64 = archivoBase64;
		this.nombreArchivo = nombreArchivo;
	}
	
	public String getArchiboBase64() {
		return archivoBase64;
	}
	public void setArchivoBase64(String archivoBase64) {
		this.archivoBase64 = archivoBase64;
	}
	public String getNombreArchivo() {
		return nombreArchivo;
	}
	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}
	
	
}
