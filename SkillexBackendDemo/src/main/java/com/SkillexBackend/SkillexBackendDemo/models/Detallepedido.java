/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SkillexBackend.SkillexBackendDemo.models;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "detallepedido", catalog = "skillexbd", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detallepedido.findAll", query = "SELECT d FROM Detallepedido d")
    , @NamedQuery(name = "Detallepedido.findByIddetallePedido", query = "SELECT d FROM Detallepedido d WHERE d.iddetallePedido = :iddetallePedido")
    , @NamedQuery(name = "Detallepedido.findByValorApagar", query = "SELECT d FROM Detallepedido d WHERE d.valorApagar = :valorApagar")
    , @NamedQuery(name = "Detallepedido.findByProducto", query = "SELECT d FROM Detallepedido d WHERE d.producto = :producto")
    , @NamedQuery(name = "Detallepedido.findByCantidadProducto", query = "SELECT d FROM Detallepedido d WHERE d.cantidadProducto = :cantidadProducto")
    , @NamedQuery(name = "Detallepedido.findByFechaPedido", query = "SELECT d FROM Detallepedido d WHERE d.fechaPedido = :fechaPedido")})
public class Detallepedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddetallePedido")
    private Integer iddetallePedido;
    @Column(name = "valorApagar")
    private BigInteger valorApagar;
    @Column(name = "producto")
    private String producto;
    @Column(name = "cantidadProducto")
    private Integer cantidadProducto;
    @Column(name = "fechaPedido")
    @Temporal(TemporalType.DATE)
    private Date fechaPedido;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "detallePedidoiddetallePedido", fetch = FetchType.LAZY)
    private List<Pedidos> pedidosList;

    public Detallepedido() {
    }

    public Detallepedido(Integer iddetallePedido) {
        this.iddetallePedido = iddetallePedido;
    }

    public Integer getIddetallePedido() {
        return iddetallePedido;
    }

    public void setIddetallePedido(Integer iddetallePedido) {
        this.iddetallePedido = iddetallePedido;
    }

    public BigInteger getValorApagar() {
        return valorApagar;
    }

    public void setValorApagar(BigInteger valorApagar) {
        this.valorApagar = valorApagar;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public Integer getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(Integer cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
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
        hash += (iddetallePedido != null ? iddetallePedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detallepedido)) {
            return false;
        }
        Detallepedido other = (Detallepedido) object;
        if ((this.iddetallePedido == null && other.iddetallePedido != null) || (this.iddetallePedido != null && !this.iddetallePedido.equals(other.iddetallePedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.SkillexBackend.SkillexBackendDemo.models.Detallepedido[ iddetallePedido=" + iddetallePedido + " ]";
    }
    
}
