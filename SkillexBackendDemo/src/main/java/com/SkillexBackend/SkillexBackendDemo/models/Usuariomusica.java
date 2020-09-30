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
@Table(name = "usuariomusica", catalog = "skillexbd", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuariomusica.findAll", query = "SELECT u FROM Usuariomusica u")
    , @NamedQuery(name = "Usuariomusica.findByIdusuarioMusica", query = "SELECT u FROM Usuariomusica u WHERE u.idusuarioMusica = :idusuarioMusica")
    , @NamedQuery(name = "Usuariomusica.findByMesaCancion", query = "SELECT u FROM Usuariomusica u WHERE u.mesaCancion = :mesaCancion")})
public class Usuariomusica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idusuarioMusica")
    private Integer idusuarioMusica;
    @Column(name = "mesa_cancion")
    private String mesaCancion;

    public Usuariomusica() {
    }

    public Usuariomusica(Integer idusuarioMusica) {
        this.idusuarioMusica = idusuarioMusica;
    }

    public Integer getIdusuarioMusica() {
        return idusuarioMusica;
    }

    public void setIdusuarioMusica(Integer idusuarioMusica) {
        this.idusuarioMusica = idusuarioMusica;
    }

    public String getMesaCancion() {
        return mesaCancion;
    }

    public void setMesaCancion(String mesaCancion) {
        this.mesaCancion = mesaCancion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idusuarioMusica != null ? idusuarioMusica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuariomusica)) {
            return false;
        }
        Usuariomusica other = (Usuariomusica) object;
        if ((this.idusuarioMusica == null && other.idusuarioMusica != null) || (this.idusuarioMusica != null && !this.idusuarioMusica.equals(other.idusuarioMusica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.SkillexBackend.SkillexBackendDemo.models.Usuariomusica[ idusuarioMusica=" + idusuarioMusica + " ]";
    }
    
}
