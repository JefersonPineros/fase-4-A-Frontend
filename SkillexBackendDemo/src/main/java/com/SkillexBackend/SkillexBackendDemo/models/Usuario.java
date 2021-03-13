/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SkillexBackend.SkillexBackendDemo.models;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jefer
 */
@Entity
@Table(name = "usuario", catalog = "skillexbd", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByIdUsuarios", query = "SELECT u FROM Usuario u WHERE u.idUsuarios = :idUsuarios")
    , @NamedQuery(name = "Usuario.findByNombreUsuario", query = "SELECT u FROM Usuario u WHERE u.nombreUsuario = :nombreUsuario")
    , @NamedQuery(name = "Usuario.findByApellidoUsuario", query = "SELECT u FROM Usuario u WHERE u.apellidoUsuario = :apellidoUsuario")
    , @NamedQuery(name = "Usuario.findByEmailUsuario", query = "SELECT u FROM Usuario u WHERE u.emailUsuario = :emailUsuario")
    , @NamedQuery(name = "Usuario.findByPasswordUsuario", query = "SELECT u FROM Usuario u WHERE u.passwordUsuario = :passwordUsuario")
    , @NamedQuery(name = "Usuario.findByTienda", query = "SELECT u FROM Usuario u WHERE u.tienda = :tienda")
    , @NamedQuery(name = "Usuario.findByCreacionUsuario", query = "SELECT u FROM Usuario u WHERE u.creacionUsuario = :creacionUsuario")
    , @NamedQuery(name = "Usuario.findByFechaLogin", query = "SELECT u FROM Usuario u WHERE u.fechaLogin = :fechaLogin")
    , @NamedQuery(name = "Usuario.findByTurnosLaborales", query = "SELECT u FROM Usuario u WHERE u.turnosLaborales = :turnosLaborales")
    , @NamedQuery(name = "Usuario.findByCedulaCiudadania", query = "SELECT u FROM Usuario u WHERE u.cedulaCiudadania = :cedulaCiudadania")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idUsuarios")
    private Integer idUsuarios;
    @Basic(optional = false)
    @Column(name = "nombreUsuario")
    private String nombreUsuario;
    @Basic(optional = false)
    @Column(name = "apellidoUsuario")
    private String apellidoUsuario;
    @Basic(optional = false)
    @Column(name = "emailUsuario")
    private String emailUsuario;
    @Basic(optional = false)
    @Column(name = "passwordUsuario")
    private String passwordUsuario;
    @Basic(optional = false)
    @Column(name = "tienda")
    private String tienda;
    @Column(name = "creacion_usuario")
    @Temporal(TemporalType.DATE)
    private Date creacionUsuario;
    @Column(name = "fecha_login")
    private String fechaLogin;
    @Column(name = "turnos_laborales")
    private String turnosLaborales;
    @Column(name = "cedula_ciudadania")
    private String cedulaCiudadania;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioidUsuarios", fetch = FetchType.LAZY)
    private List<Eventos> eventosList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioidUsuarios", fetch = FetchType.LAZY)
    private List<Pedidos> pedidosList;
    
    @JoinColumn(name = "tipoUsuario_idTipoUsuario", referencedColumnName = "idTipoUsuario")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Tipousuario tipoUsuarioidTipoUsuario;
    
    @JoinColumn(name = "inventario_idInventario", referencedColumnName = "id_inventario")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Inventario inventarioidInventario;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioidUsuarios", fetch = FetchType.LAZY)
    private List<AlbumMusical> albumMusicalList;

    public Usuario() {
    }

    public Usuario(Integer idUsuarios) {
        this.idUsuarios = idUsuarios;
    }

    public Usuario(Integer idUsuarios, String nombreUsuario, String apellidoUsuario, String emailUsuario, String passwordUsuario, String tienda) {
        this.idUsuarios = idUsuarios;
        this.nombreUsuario = nombreUsuario;
        this.apellidoUsuario = apellidoUsuario;
        this.emailUsuario = emailUsuario;
        this.passwordUsuario = passwordUsuario;
        this.tienda = tienda;
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

    public Date getCreacionUsuario() {
        return creacionUsuario;
    }

    public void setCreacionUsuario(Date creacionUsuario) {
        this.creacionUsuario = creacionUsuario;
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

    @XmlTransient
    public List<Eventos> getEventosList() {
        return eventosList;
    }

    public void setEventosList(List<Eventos> eventosList) {
        this.eventosList = eventosList;
    }

    @XmlTransient
    public List<Pedidos> getPedidosList() {
        return pedidosList;
    }

    public void setPedidosList(List<Pedidos> pedidosList) {
        this.pedidosList = pedidosList;
    }

    public Tipousuario getTipoUsuarioidTipoUsuario() {
        return tipoUsuarioidTipoUsuario;
    }

    public void setTipoUsuarioidTipoUsuario(Tipousuario tipoUsuarioidTipoUsuario) {
        this.tipoUsuarioidTipoUsuario = tipoUsuarioidTipoUsuario;
    }

    public Inventario getInventarioidInventario() {
        return inventarioidInventario;
    }

    public void setInventarioidInventario(Inventario inventarioidInventario) {
        this.inventarioidInventario = inventarioidInventario;
    }

    @XmlTransient
    public List<AlbumMusical> getAlbumMusicalList() {
        return albumMusicalList;
    }

    public void setAlbumMusicalList(List<AlbumMusical> albumMusicalList) {
        this.albumMusicalList = albumMusicalList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuarios != null ? idUsuarios.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idUsuarios == null && other.idUsuarios != null) || (this.idUsuarios != null && !this.idUsuarios.equals(other.idUsuarios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.SkillexBackend.SkillexBackendDemo.models.Usuario[ idUsuarios=" + idUsuarios + " ]";
    }
    
}
