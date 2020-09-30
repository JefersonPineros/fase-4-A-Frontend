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
@Table(name = "estado_pedido", catalog = "skillexbd", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoPedido.findAll", query = "SELECT e FROM EstadoPedido e")
    , @NamedQuery(name = "EstadoPedido.findByIdEstadopedido", query = "SELECT e FROM EstadoPedido e WHERE e.idEstadopedido = :idEstadopedido")
    , @NamedQuery(name = "EstadoPedido.findByStateid", query = "SELECT e FROM EstadoPedido e WHERE e.stateid = :stateid")
    , @NamedQuery(name = "EstadoPedido.findByDescripcion", query = "SELECT e FROM EstadoPedido e WHERE e.descripcion = :descripcion")})
public class EstadoPedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Estado_pedido")
    private Integer idEstadopedido;
    @Column(name = "State_id")
    private Integer stateid;
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estadopedidoID", fetch = FetchType.LAZY)
    private List<Pedidos> pedidosList;

    public EstadoPedido() {
    }

    public EstadoPedido(Integer idEstadopedido) {
        this.idEstadopedido = idEstadopedido;
    }

    public Integer getIdEstadopedido() {
        return idEstadopedido;
    }

    public void setIdEstadopedido(Integer idEstadopedido) {
        this.idEstadopedido = idEstadopedido;
    }

    public Integer getStateid() {
        return stateid;
    }

    public void setStateid(Integer stateid) {
        this.stateid = stateid;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Pedidos> getPedidosList() {
        return pedidosList;
    }

    public void setPedidosList(List<Pedidos> pedidosList) {
        this.pedidosList = pedidosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadopedido != null ? idEstadopedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoPedido)) {
            return false;
        }
        EstadoPedido other = (EstadoPedido) object;
        if ((this.idEstadopedido == null && other.idEstadopedido != null) || (this.idEstadopedido != null && !this.idEstadopedido.equals(other.idEstadopedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.SkillexBackend.SkillexBackendDemo.models.EstadoPedido[ idEstadopedido=" + idEstadopedido + " ]";
    }
    
}
