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
@Table(name = "cancion", catalog = "skillexbd", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cancion.findAll", query = "SELECT c FROM Cancion c")
    , @NamedQuery(name = "Cancion.findByIdCancion", query = "SELECT c FROM Cancion c WHERE c.idCancion = :idCancion")
    , @NamedQuery(name = "Cancion.findByNombreCancion", query = "SELECT c FROM Cancion c WHERE c.nombreCancion = :nombreCancion")
    , @NamedQuery(name = "Cancion.findByAutor", query = "SELECT c FROM Cancion c WHERE c.autor = :autor")
    , @NamedQuery(name = "Cancion.findByDuracion", query = "SELECT c FROM Cancion c WHERE c.duracion = :duracion")})
public class Cancion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cancion")
    private Integer idCancion;
    @Column(name = "nombre_cancion")
    private String nombreCancion;
    @Column(name = "autor")
    private String autor;
    @Column(name = "duracion")
    private String duracion;
    @JoinColumn(name = "album_musical_id", referencedColumnName = "id_album_musical")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private AlbumMusical albumMusicalId;

    public Cancion() {
    }

    public Cancion(Integer idCancion) {
        this.idCancion = idCancion;
    }

    public Integer getIdCancion() {
        return idCancion;
    }

    public void setIdCancion(Integer idCancion) {
        this.idCancion = idCancion;
    }

    public String getNombreCancion() {
        return nombreCancion;
    }

    public void setNombreCancion(String nombreCancion) {
        this.nombreCancion = nombreCancion;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public AlbumMusical getAlbumMusicalId() {
        return albumMusicalId;
    }

    public void setAlbumMusicalId(AlbumMusical albumMusicalId) {
        this.albumMusicalId = albumMusicalId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCancion != null ? idCancion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cancion)) {
            return false;
        }
        Cancion other = (Cancion) object;
        if ((this.idCancion == null && other.idCancion != null) || (this.idCancion != null && !this.idCancion.equals(other.idCancion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.SkillexBackend.SkillexBackendDemo.models.Cancion[ idCancion=" + idCancion + " ]";
    }
    
}
