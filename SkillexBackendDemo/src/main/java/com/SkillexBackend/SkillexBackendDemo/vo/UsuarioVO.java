/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SkillexBackend.SkillexBackendDemo.vo;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author jefer
 */
public class UsuarioVO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer idUsuarios;
    private String nombreUsuario;
    private String apellidoUsuario;
    private String emailUsuario;
    private String passwordUsuario;
    private String tienda;
    private Date creacionUsuario;
    private String fechaLogin;
    private String turnosLaborales;
    private String cedulaCiudadania;
    private Integer tipoUsuario;
    private Integer inventarioIdInventario;

    public UsuarioVO(Integer idUsuarios, String nombreUsuario, String apellidoUsuario, String emailUsuario, String passwordUsuario, String tienda,Date creacionUsuario, String fechaLogin, String turnosLaborales, String cedulaCiudadania,Integer tipoUsuario,Integer inventarioIdInventario) {
        this.idUsuarios = idUsuarios;
        this.nombreUsuario = nombreUsuario;
        this.apellidoUsuario = apellidoUsuario;
        this.emailUsuario = emailUsuario;
        this.passwordUsuario = passwordUsuario;
        this.tienda = tienda;
        this.fechaLogin = fechaLogin;
        this.turnosLaborales = turnosLaborales;
        this.cedulaCiudadania = cedulaCiudadania;
        this.tipoUsuario = tipoUsuario;
        this.inventarioIdInventario = inventarioIdInventario;
        this.creacionUsuario = creacionUsuario;
    }

    public UsuarioVO() {
    }


    public Integer getIdUsuarios() {
        return idUsuarios;
    }

    public void setIdUsuarios(Integer idUsuarios) {
        this.idUsuarios = idUsuarios;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getPasswordUsuario() {
        return passwordUsuario;
    }

    public void setPasswordUsuario(String passwordUsuario) {
        this.passwordUsuario = passwordUsuario;
    }

    public String getTienda() {
        return tienda;
    }

    public void setTienda(String tienda) {
        this.tienda = tienda;
    }

    public String getFechaLogin() {
        return fechaLogin;
    }

    public void setFechaLogin(String fechaLogin) {
        this.fechaLogin = fechaLogin;
    }

    public String getTurnosLaborales() {
        return turnosLaborales;
    }

    public void setTurnosLaborales(String turnosLaborales) {
        this.turnosLaborales = turnosLaborales;
    }

    public String getCedulaCiudadania() {
        return cedulaCiudadania;
    }

    public void setCedulaCiudadania(String cedulaCiudadania) {
        this.cedulaCiudadania = cedulaCiudadania;
    }

    public Integer getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(Integer tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public Integer getInventarioIdInventario() {
        return inventarioIdInventario;
    }

    public void setInventarioIdInventario(Integer inventarioIdInventario) {
        this.inventarioIdInventario = inventarioIdInventario;
    }

    public Date getCreacionUsuario() {
        return creacionUsuario;
    }

    public void setCreacionUsuario(Date creacionUsuario) {
        this.creacionUsuario = creacionUsuario;
    }
}
