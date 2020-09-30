/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SkillexBackend.SkillexBackendDemo.vo;

import java.io.Serializable;

/**
 *
 * @author jefer
 */
public class InventarioVO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer idInventario;
    private String nombreEmpresa;
    private String totalProductos;

    public InventarioVO() {
    }

    public InventarioVO(Integer idInventario, String nombreEmpresa, String totalProductos) {
        this.idInventario = idInventario;
        this.nombreEmpresa = nombreEmpresa;
        this.totalProductos = totalProductos;
    }

    public Integer getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(Integer idInventario) {
        this.idInventario = idInventario;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getTotalProductos() {
        return totalProductos;
    }

    public void setTotalProductos(String totalProductos) {
        this.totalProductos = totalProductos;
    }
    
}
