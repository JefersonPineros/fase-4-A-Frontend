/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SkillexBackend.SkillexBackendDemo.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jefer
 */
@Entity
@Table(name = "usuarioevento", catalog = "skillexbd", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarioevento.findAll", query = "SELECT u FROM Usuarioevento u")
    , @NamedQuery(name = "Usuarioevento.findByIdusuarioEvento", query = "SELECT u FROM Usuarioevento u WHERE u.idusuarioEvento = :idusuarioEvento")
    , @NamedQuery(name = "Usuarioevento.findByNombreUsuarioParticipacion", query = "SELECT u FROM Usuarioevento u WHERE u.nombreUsuarioParticipacion = :nombreUsuarioParticipacion")})
public class Usuarioevento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usuario_Evento")
    private Integer idusuarioEvento;
    @Basic(optional = false)
    @Column(name = "nombre_usuario_participacion")
    private String nombreUsuarioParticipacion;

    public Usuarioevento() {
    }

    public Usuarioevento(Integer idusuarioEvento) {
        this.idusuarioEvento = idusuarioEvento;
    }

    public Usuarioevento(Integer idusuarioEvento, String nombreUsuarioParticipacion) {
        this.idusuarioEvento = idusuarioEvento;
        this.nombreUsuarioParticipacion = nombreUsuarioParticipacion;
    }

    public Integer getIdusuarioEvento() {
        return idusuarioEvento;
    }

    public void setIdusuarioEvento(Integer idusuarioEvento) {
        this.idusuarioEvento = idusuarioEvento;
    }

    public String getNombreUsuarioParticipacion() {
        return nombreUsuarioParticipacion;
    }

    public void setNombreUsuarioParticipacion(String nombreUsuarioParticipacion) {
        this.nombreUsuarioParticipacion = nombreUsuarioParticipacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idusuarioEvento != null ? idusuarioEvento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarioevento)) {
            return false;
        }
        Usuarioevento other = (Usuarioevento) object;
        if ((this.idusuarioEvento == null && other.idusuarioEvento != null) || (this.idusuarioEvento != null && !this.idusuarioEvento.equals(other.idusuarioEvento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.SkillexBackend.SkillexBackendDemo.models.Usuarioevento[ idusuarioEvento=" + idusuarioEvento + " ]";
    }
    
}
