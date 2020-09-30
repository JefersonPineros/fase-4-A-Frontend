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
@Table(name = "pedidos", catalog = "skillexbd", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pedidos.findAll", query = "SELECT p FROM Pedidos p")
    , @NamedQuery(name = "Pedidos.findByIdPedidos", query = "SELECT p FROM Pedidos p WHERE p.idPedidos = :idPedidos")
    , @NamedQuery(name = "Pedidos.findByEstadoPedido", query = "SELECT p FROM Pedidos p WHERE p.estadoPedido = :estadoPedido")
    , @NamedQuery(name = "Pedidos.findByMesa", query = "SELECT p FROM Pedidos p WHERE p.mesa = :mesa")
    , @NamedQuery(name = "Pedidos.findByNumeroPedido", query = "SELECT p FROM Pedidos p WHERE p.numeroPedido = :numeroPedido")})
public class Pedidos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPedidos")
    private Integer idPedidos;
    @Basic(optional = false)
    @Column(name = "estadoPedido")
    private String estadoPedido;
    @Basic(optional = false)
    @Column(name = "mesa")
    private int mesa;
    @Basic(optional = false)
    @Column(name = "numeroPedido")
    private long numeroPedido;
    @JoinColumn(name = "estado_pedido_ID", referencedColumnName = "id_Estado_pedido")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EstadoPedido estadopedidoID;
    @JoinColumn(name = "detallePedido_iddetallePedido", referencedColumnName = "iddetallePedido")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Detallepedido detallePedidoiddetallePedido;
    @JoinColumn(name = "Usuario_idUsuarios", referencedColumnName = "idUsuarios")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario usuarioidUsuarios;

    public Pedidos() {
    }

    public Pedidos(Integer idPedidos) {
        this.idPedidos = idPedidos;
    }

    public Pedidos(Integer idPedidos, String estadoPedido, int mesa, long numeroPedido) {
        this.idPedidos = idPedidos;
        this.estadoPedido = estadoPedido;
        this.mesa = mesa;
        this.numeroPedido = numeroPedido;
    }

    public Integer getIdPedidos() {
        return idPedidos;
    }

    public void setIdPedidos(Integer idPedidos) {
        this.idPedidos = idPedidos;
    }

    public String getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(String estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    public int getMesa() {
        return mesa;
    }

    public void setMesa(int mesa) {
        this.mesa = mesa;
    }

    public long getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(long numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public EstadoPedido getEstadopedidoID() {
        return estadopedidoID;
    }

    public void setEstadopedidoID(EstadoPedido estadopedidoID) {
        this.estadopedidoID = estadopedidoID;
    }

    public Detallepedido getDetallePedidoiddetallePedido() {
        return detallePedidoiddetallePedido;
    }

    public void setDetallePedidoiddetallePedido(Detallepedido detallePedidoiddetallePedido) {
        this.detallePedidoiddetallePedido = detallePedidoiddetallePedido;
    }

    public Usuario getUsuarioidUsuarios() {
        return usuarioidUsuarios;
    }

    public void setUsuarioidUsuarios(Usuario usuarioidUsuarios) {
        this.usuarioidUsuarios = usuarioidUsuarios;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPedidos != null ? idPedidos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedidos)) {
            return false;
        }
        Pedidos other = (Pedidos) object;
        if ((this.idPedidos == null && other.idPedidos != null) || (this.idPedidos != null && !this.idPedidos.equals(other.idPedidos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.SkillexBackend.SkillexBackendDemo.models.Pedidos[ idPedidos=" + idPedidos + " ]";
    }
    
}
