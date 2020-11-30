/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SkillexBackend.SkillexBackendDemo.models;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jefer
 */
@Entity
@Table(name = "eventos", catalog = "skillexbd", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Eventos.findAll", query = "SELECT e FROM Eventos e")
    , @NamedQuery(name = "Eventos.findByIdEventos", query = "SELECT e FROM Eventos e WHERE e.idEventos = :idEventos")
    , @NamedQuery(name = "Eventos.findByNombreEvento", query = "SELECT e FROM Eventos e WHERE e.nombreEvento = :nombreEvento")
    , @NamedQuery(name = "Eventos.findByAutorEvento", query = "SELECT e FROM Eventos e WHERE e.autorEvento = :autorEvento")})
public class Eventos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEventos")
    private Integer idEventos;
    @Basic(optional = false)
    @Column(name = "nombre_evento")
    private String nombreEvento;
    @Basic(optional = false)
    @Column(name = "autor_evento")
    private String autorEvento;
    @JoinColumn(name = "Usuario_idUsuarios", referencedColumnName = "idUsuarios")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario usuarioidUsuarios;
    @JoinColumn(name = "detalle_evento_id_detalle_evento", referencedColumnName = "id_detalle_evento")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private DetalleEvento detalleEventoIdDetalleEvento;
    @Basic(optional = false)
    @Column(name = "fecha_evento")
    private Date fechaEvento;
    
    public Eventos() {
    }

    public Eventos(Integer idEventos) {
        this.idEventos = idEventos;
    }

    public Eventos(Integer idEventos, String nombreEvento, String autorEvento, Date fechaEvento) {
        this.idEventos = idEventos;
        this.nombreEvento = nombreEvento;
        this.autorEvento = autorEvento;
        this.fechaEvento = fechaEvento;
    }

    public Integer getIdEventos() {
        return idEventos;
    }

    public void setIdEventos(Integer idEventos) {
        this.idEventos = idEventos;
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public String getAutorEvento() {
        return autorEvento;
    }

    public void setAutorEvento(String autorEvento) {
        this.autorEvento = autorEvento;
    }

    public Usuario getUsuarioidUsuarios() {
        return usuarioidUsuarios;
    }

    public void setUsuarioidUsuarios(Usuario usuarioidUsuarios) {
        this.usuarioidUsuarios = usuarioidUsuarios;
    }

    public DetalleEvento getDetalleEventoIdDetalleEvento() {
        return detalleEventoIdDetalleEvento;
    }

    public void setDetalleEventoIdDetalleEvento(DetalleEvento detalleEventoIdDetalleEvento) {
        this.detalleEventoIdDetalleEvento = detalleEventoIdDetalleEvento;
    }
    
    public Date getFechaEvento() {
		return fechaEvento;
	}

	public void setFechaEvento(Date fechaEvento) {
		this.fechaEvento = fechaEvento;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idEventos != null ? idEventos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Eventos)) {
            return false;
        }
        Eventos other = (Eventos) object;
        if ((this.idEventos == null && other.idEventos != null) || (this.idEventos != null && !this.idEventos.equals(other.idEventos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.SkillexBackend.SkillexBackendDemo.models.Eventos[ idEventos=" + idEventos + " ]";
    }
    
}
