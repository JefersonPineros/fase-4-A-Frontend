/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SkillexBackend.SkillexBackendDemo.models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jefer
 */
@Entity
@Table(name = "detalle_evento", catalog = "skillexbd", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleEvento.findAll", query = "SELECT d FROM DetalleEvento d")
    , @NamedQuery(name = "DetalleEvento.findByIdDetalleEvento", query = "SELECT d FROM DetalleEvento d WHERE d.idDetalleEvento = :idDetalleEvento")
    , @NamedQuery(name = "DetalleEvento.findByTipoEvento", query = "SELECT d FROM DetalleEvento d WHERE d.tipoEvento = :tipoEvento")
    , @NamedQuery(name = "DetalleEvento.findByServicioOfrecido", query = "SELECT d FROM DetalleEvento d WHERE d.servicioOfrecido = :servicioOfrecido")
    , @NamedQuery(name = "DetalleEvento.findByImagenEvento", query = "SELECT d FROM DetalleEvento d WHERE d.imagenEvento = :imagenEvento")})
public class DetalleEvento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_detalle_evento")
    private Integer idDetalleEvento;
    @Basic(optional = false)
    @Column(name = "tipo_evento")
    private String tipoEvento;
    @Basic(optional = false)
    @Column(name = "servicio_ofrecido")
    private String servicioOfrecido;
    @Basic(optional = false)
    @Column(name = "nombre_imagen")
    private String nombreImagen;
    @Column(name = "imagen_evento")
    private String imagenEvento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "detalleEventoIdDetalleEvento", fetch = FetchType.LAZY)
    private List<Eventos> eventosList;

    public DetalleEvento() {
    }

    public DetalleEvento(Integer idDetalleEvento) {
        this.idDetalleEvento = idDetalleEvento;
    }

    public DetalleEvento(Integer idDetalleEvento, String tipoEvento, String servicioOfrecido, String nombreImagen,
			String imagenEvento) {
		this.idDetalleEvento = idDetalleEvento;
		this.tipoEvento = tipoEvento;
		this.servicioOfrecido = servicioOfrecido;
		this.nombreImagen = nombreImagen;
		this.imagenEvento = imagenEvento;
	}

	public Integer getIdDetalleEvento() {
        return idDetalleEvento;
    }

    public void setIdDetalleEvento(Integer idDetalleEvento) {
        this.idDetalleEvento = idDetalleEvento;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public String getServicioOfrecido() {
        return servicioOfrecido;
    }

    public void setServicioOfrecido(String servicioOfrecido) {
        this.servicioOfrecido = servicioOfrecido;
    }

    public String getImagenEvento() {
        return imagenEvento;
    }

    public void setImagenEvento(String imagenEvento) {
        this.imagenEvento = imagenEvento;
    }
    

    public String getNombreImagen() {
		return nombreImagen;
	}

	public void setNombreImagen(String nombreImagen) {
		this.nombreImagen = nombreImagen;
	}

	@XmlTransient
    public List<Eventos> getEventosList() {
        return eventosList;
    }

    public void setEventosList(List<Eventos> eventosList) {
        this.eventosList = eventosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleEvento != null ? idDetalleEvento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleEvento)) {
            return false;
        }
        DetalleEvento other = (DetalleEvento) object;
        if ((this.idDetalleEvento == null && other.idDetalleEvento != null) || (this.idDetalleEvento != null && !this.idDetalleEvento.equals(other.idDetalleEvento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.SkillexBackend.SkillexBackendDemo.models.DetalleEvento[ idDetalleEvento=" + idDetalleEvento + " ]";
    }
    
}
