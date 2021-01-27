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
@Table(name = "productos", catalog = "skillexbd", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productos.findAll", query = "SELECT p FROM Productos p")
    , @NamedQuery(name = "Productos.findByIdProductos", query = "SELECT p FROM Productos p WHERE p.idProductos = :idProductos")
    , @NamedQuery(name = "Productos.findByNombreProducto", query = "SELECT p FROM Productos p WHERE p.nombreProducto = :nombreProducto")
    , @NamedQuery(name = "Productos.findByNombreProductoIn", query = "SELECT p FROM Productos p WHERE p.nombreProductoIn = :nombreProductoIn")
    , @NamedQuery(name = "Productos.findByCodigoProducto", query = "SELECT p FROM Productos p WHERE p.codigoProducto = :codigoProducto")
    , @NamedQuery(name = "Productos.findByEstadoProducto", query = "SELECT p FROM Productos p WHERE p.estadoProducto = :estadoProducto")
    , @NamedQuery(name = "Productos.findByCantidadProducto", query = "SELECT p FROM Productos p WHERE p.cantidadProducto = :cantidadProducto")
    , @NamedQuery(name = "Productos.findByFechaIngreso", query = "SELECT p FROM Productos p WHERE p.fechaIngreso = :fechaIngreso")})
public class Productos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_productos")
    private Integer idProductos;
    @Column(name = "nombre_producto")
    private String nombreProducto;
    @Column(name = "nombre_producto_in")
    private String nombreProductoIn;
    @Column(name = "codigo_producto")
    private String codigoProducto;
    @Column(name = "estado_producto")
    private String estadoProducto;
    @Column(name = "cantidad_producto")
    private Integer cantidadProducto;
    @Column(name = "fecha_ingreso")
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    
    @OneToMany(mappedBy = "productosIdProductos", fetch = FetchType.LAZY)
    private List<DetalleProductos> detalleProductosList;
    
    @JoinColumn(name = "categoria_producto_id_categoria_producto", referencedColumnName = "id_categoria_producto")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private CategoriaProducto categoriaProductoIdCategoriaProducto;
    
    @JoinColumn(name = "inventario_id_inventario", referencedColumnName = "id_inventario")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Inventario inventarioIdInventario;

    public Productos() {
    }

    public Productos(Integer idProductos) {
        this.idProductos = idProductos;
    }

    public Integer getIdProductos() {
        return idProductos;
    }

    public void setIdProductos(Integer idProductos) {
        this.idProductos = idProductos;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getNombreProductoIn() {
        return nombreProductoIn;
    }

    public void setNombreProductoIn(String nombreProductoIn) {
        this.nombreProductoIn = nombreProductoIn;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getEstadoProducto() {
        return estadoProducto;
    }

    public void setEstadoProducto(String estadoProducto) {
        this.estadoProducto = estadoProducto;
    }

    public Integer getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(Integer cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    @XmlTransient
    public List<DetalleProductos> getDetalleProductosList() {
        return detalleProductosList;
    }

    public void setDetalleProductosList(List<DetalleProductos> detalleProductosList) {
        this.detalleProductosList = detalleProductosList;
    }

    public CategoriaProducto getCategoriaProductoIdCategoriaProducto() {
        return categoriaProductoIdCategoriaProducto;
    }

    public void setCategoriaProductoIdCategoriaProducto(CategoriaProducto categoriaProductoIdCategoriaProducto) {
        this.categoriaProductoIdCategoriaProducto = categoriaProductoIdCategoriaProducto;
    }

    public Inventario getInventarioIdInventario() {
        return inventarioIdInventario;
    }

    public void setInventarioIdInventario(Inventario inventarioIdInventario) {
        this.inventarioIdInventario = inventarioIdInventario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProductos != null ? idProductos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productos)) {
            return false;
        }
        Productos other = (Productos) object;
        if ((this.idProductos == null && other.idProductos != null) || (this.idProductos != null && !this.idProductos.equals(other.idProductos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.SkillexBackend.SkillexBackendDemo.models.Productos[ idProductos=" + idProductos + " ]";
    }
    
}
