/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SkillexBackend.SkillexBackendDemo.vo;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author jefer
 */
public class EventosVO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer idEventos;
    private String nombre_evento;
    private String autor_evento;
    private Integer usuario_idUsuarios;
    private Integer detalle_evento_id_detalle_evento;
    private Integer id_detalle_evento;
    private String tipo_evento;
    private String servicio_ofrecido;
    private Timestamp fecha_evento;
    private String nombre_imagen;
    private String imagen_evento;

    public EventosVO(
        Integer idEventos, 
        String nombre_evento, 
        String autor_evento, 
        Integer usuario_idUsuarios, 
        Integer detalle_evento_id_detalle_evento, 
        Integer id_detalle_evento, 
        String tipo_evento, 
        String servicio_ofrecido,
        Timestamp fecha_evento,
        String nombre_imagen,
        String imagen_evento) 
    {
        this.idEventos = idEventos;
        this.nombre_evento = nombre_evento;
        this.autor_evento = autor_evento;
        this.usuario_idUsuarios = usuario_idUsuarios;
        this.detalle_evento_id_detalle_evento = detalle_evento_id_detalle_evento;
        this.id_detalle_evento = id_detalle_evento;
        this.tipo_evento = tipo_evento;
        this.servicio_ofrecido = servicio_ofrecido;
        this.fecha_evento = fecha_evento;
        this.nombre_imagen = nombre_imagen;
        this.imagen_evento = imagen_evento;
    }

   
    public EventosVO() {
    }
    
    public EventosVO (Integer idEventos, Integer id_detalle_evento){
    
        this.idEventos = idEventos;
        this.id_detalle_evento = id_detalle_evento; 
    }
    
    public EventosVO(Integer idEventos, String nombre_evento, String autor_evento, Integer usuario_idUsuarios, Integer detalle_evento_id_detalle_evento, Integer id_detalle_evento, String tipo_evento, String servicio_ofrecido, String imagen_evento, Object object, String string, String string0) {
    }

    public Integer getIdEventos() {
        return idEventos;
    }

    public void setIdEventos(Integer idEventos) {
        this.idEventos = idEventos;
    }

    public String getNombre_evento() {
        return nombre_evento;
    }

    public void setNombre_evento(String nombre_evento) {
        this.nombre_evento = nombre_evento;
    }

    public String getAutor_evento() {
        return autor_evento;
    }

    public void setAutor_evento(String autor_evento) {
        this.autor_evento = autor_evento;
    }

    public Integer getUsuario_idUsuarios() {
        return usuario_idUsuarios;
    }

    public void setUsuario_idUsuarios(Integer Usuario_idUsuarios) {
        this.usuario_idUsuarios = Usuario_idUsuarios;
    }

    public Integer getDetalle_evento_id_detalle_evento() {
        return detalle_evento_id_detalle_evento;
    }

    public void setDetalle_evento_id_detalle_evento(Integer detalle_evento_id_detalle_evento) {
        this.detalle_evento_id_detalle_evento = detalle_evento_id_detalle_evento;
    }

    public Integer getId_detalle_evento() {
        return id_detalle_evento;
    }

    public void setId_detalle_evento(Integer id_detalle_evento) {
        this.id_detalle_evento = id_detalle_evento;
    }

    public String getTipo_evento() {
        return tipo_evento;
    }

    public void setTipo_evento(String tipo_evento) {
        this.tipo_evento = tipo_evento;
    }

    public String getServicio_ofrecido() {
        return servicio_ofrecido;
    }

    public void setServicio_ofrecido(String servicio_ofrecido) {
        this.servicio_ofrecido = servicio_ofrecido;
    }
    
    public Timestamp getFecha_evento() {
		return fecha_evento;
	}


	public void setFecha_evento(Timestamp fecha_evento) {
		this.fecha_evento = fecha_evento;
	}


	public String getImagen_evento() {
        return imagen_evento;
    }

    public void setImagen_evento(String imagen_evento) {
        this.imagen_evento = imagen_evento;
    }


	public String getNombre_imagen() {
		return nombre_imagen;
	}


	public void setNombre_imagen(String nombre_imagen) {
		this.nombre_imagen = nombre_imagen;
	}
}
