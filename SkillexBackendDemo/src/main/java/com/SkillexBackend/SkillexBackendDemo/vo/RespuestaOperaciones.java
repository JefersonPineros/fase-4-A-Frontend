/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SkillexBackend.SkillexBackendDemo.vo;

/**
 *
 * @author jefer
 */
public class RespuestaOperaciones {
    public String codigo;
    public String respuesta;

    public RespuestaOperaciones(String codigo, String respuesta) {
        this.codigo = codigo;
        this.respuesta = respuesta;
    }
    
    public RespuestaOperaciones(){
    
    }
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
    
}
