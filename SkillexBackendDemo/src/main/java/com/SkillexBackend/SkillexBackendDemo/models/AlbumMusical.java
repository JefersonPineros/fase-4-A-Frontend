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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "album_musical", catalog = "skillexbd", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AlbumMusical.findAll", query = "SELECT a FROM AlbumMusical a")
    , @NamedQuery(name = "AlbumMusical.findByIdAlbumMusical", query = "SELECT a FROM AlbumMusical a WHERE a.idAlbumMusical = :idAlbumMusical")
    , @NamedQuery(name = "AlbumMusical.findByNombreAlbum", query = "SELECT a FROM AlbumMusical a WHERE a.nombreAlbum = :nombreAlbum")
    , @NamedQuery(name = "AlbumMusical.findByAutorAlbum", query = "SELECT a FROM AlbumMusical a WHERE a.autorAlbum = :autorAlbum")})
public class AlbumMusical implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_album_musical")
    private Integer idAlbumMusical;
    @Column(name = "nombre_album")
    private String nombreAlbum;
    @Column(name = "autor_album")
    private String autorAlbum;
    @JoinColumn(name = "Usuario_idUsuarios", referencedColumnName = "idUsuarios")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario usuarioidUsuarios;
    @JoinColumn(name = "genero_id_genero", referencedColumnName = "id_genero")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Genero generoIdGenero;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "albumMusicalId", fetch = FetchType.LAZY)
    private List<Cancion> cancionList;
    @Column(name = "nombre_imagen")
    private String nombreImagen;
    @Column(name = "url_imagen")
    private String urlImagen;
    
    public AlbumMusical() {
    }
    
    public AlbumMusical(Integer idAlbumMusical, String nombreAlbum, String autorAlbum, String nombreImagen,
			String urlImagen) {
		this.idAlbumMusical = idAlbumMusical;
		this.nombreAlbum = nombreAlbum;
		this.autorAlbum = autorAlbum;
		this.nombreImagen = nombreImagen;
		this.urlImagen = urlImagen;
	}

	public AlbumMusical(Integer idAlbumMusical) {
        this.idAlbumMusical = idAlbumMusical;
    }

    public Integer getIdAlbumMusical() {
        return idAlbumMusical;
    }

    public void setIdAlbumMusical(Integer idAlbumMusical) {
        this.idAlbumMusical = idAlbumMusical;
    }

    public String getNombreAlbum() {
        return nombreAlbum;
    }

    public void setNombreAlbum(String nombreAlbum) {
        this.nombreAlbum = nombreAlbum;
    }

    public String getAutorAlbum() {
        return autorAlbum;
    }

    public void setAutorAlbum(String autorAlbum) {
        this.autorAlbum = autorAlbum;
    }

    public Usuario getUsuarioidUsuarios() {
        return usuarioidUsuarios;
    }

    public void setUsuarioidUsuarios(Usuario usuarioidUsuarios) {
        this.usuarioidUsuarios = usuarioidUsuarios;
    }

    public Genero getGeneroIdGenero() {
        return generoIdGenero;
    }

    public void setGeneroIdGenero(Genero generoIdGenero) {
        this.generoIdGenero = generoIdGenero;
    }

    	
    public String getNombreImagen() {
		return nombreImagen;
	}

	public void setNombreImagen(String nombreImagen) {
		this.nombreImagen = nombreImagen;
	}

	public String getUrlImagen() {
		return urlImagen;
	}

	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}

	@XmlTransient
    public List<Cancion> getCancionList() {
        return cancionList;
    }

    public void setCancionList(List<Cancion> cancionList) {
        this.cancionList = cancionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAlbumMusical != null ? idAlbumMusical.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlbumMusical)) {
            return false;
        }
        AlbumMusical other = (AlbumMusical) object;
        if ((this.idAlbumMusical == null && other.idAlbumMusical != null) || (this.idAlbumMusical != null && !this.idAlbumMusical.equals(other.idAlbumMusical))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.SkillexBackend.SkillexBackendDemo.models.AlbumMusical[ idAlbumMusical=" + idAlbumMusical + " ]";
    }
    
}
