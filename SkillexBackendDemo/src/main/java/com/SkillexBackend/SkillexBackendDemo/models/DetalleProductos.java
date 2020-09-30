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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "detalle_productos", catalog = "skillexbd", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleProductos.findAll", query = "SELECT d FROM DetalleProductos d")
    , @NamedQuery(name = "DetalleProductos.findByIdDetalleProductos", query = "SELECT d FROM DetalleProductos d WHERE d.idDetalleProductos = :idDetalleProductos")
    , @NamedQuery(name = "DetalleProductos.findByDescripcionProducto", query = "SELECT d FROM DetalleProductos d WHERE d.descripcionProducto = :descripcionProducto")
    , @NamedQuery(name = "DetalleProductos.findByDescripcionProductoIn", query = "SELECT d FROM DetalleProductos d WHERE d.descripcionProductoIn = :descripcionProductoIn")
    , @NamedQuery(name = "DetalleProductos.findByValorInicial", query = "SELECT d FROM DetalleProductos d WHERE d.valorInicial = :valorInicial")
    , @NamedQuery(name = "DetalleProductos.findByValorMasIva", query = "SELECT d FROM DetalleProductos d WHERE d.valorMasIva = :valorMasIva")})
public class DetalleProductos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_detalle_productos")
    private Integer idDetalleProductos;
    @Column(name = "descripcion_producto")
    private String descripcionProducto;
    @Column(name = "descripcion_producto_in")
    private String descripcionProductoIn;
    @Basic(optional = false)
    @Column(name = "valor_inicial")
    private float valorInicial;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor_mas_iva")
    private Float valorMasIva;
    @Basic(optional = false)
    @Lob
    @Column(name = "url_imagen")
    private String urlImagen;
    @JoinColumn(name = "productos_id_productos", referencedColumnName = "id_productos")
    @ManyToOne(fetch = FetchType.LAZY)
    private Productos productosIdProductos;

    public DetalleProductos() {
    }

    public DetalleProductos(Integer idDetalleProductos) {
        this.idDetalleProductos = idDetalleProductos;
    }

    public DetalleProductos(Integer idDetalleProductos, float valorInicial, String urlImagen) {
        this.idDetalleProductos = idDetalleProductos;
        this.valorInicial = valorInicial;
        this.urlImagen = urlImagen;
    }

    public Integer getIdDetalleProductos() {
        return idDetalleProductos;
    }

    public void setIdDetalleProductos(Integer idDetalleProductos) {
        this.idDetalleProductos = idDetalleProductos;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public String getDescripcionProductoIn() {
        return descripcionProductoIn;
    }

    public void setDescripcionProductoIn(String descripcionProductoIn) {
        this.descripcionProductoIn = descripcionProductoIn;
    }

    public float getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(float valorInicial) {
        this.valorInicial = valorInicial;
    }

    public Float getValorMasIva() {
        return valorMasIva;
    }

    public void setValorMasIva(Float valorMasIva) {
        this.valorMasIva = valorMasIva;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public Productos getProductosIdProductos() {
        return productosIdProductos;
    }

    public void setProductosIdProductos(Productos productosIdProductos) {
        this.productosIdProductos = productosIdProductos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleProductos != null ? idDetalleProductos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleProductos)) {
            return false;
        }
        DetalleProductos other = (DetalleProductos) object;
        if ((this.idDetalleProductos == null && other.idDetalleProductos != null) || (this.idDetalleProductos != null && !this.idDetalleProductos.equals(other.idDetalleProductos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.SkillexBackend.SkillexBackendDemo.models.DetalleProductos[ idDetalleProductos=" + idDetalleProductos + " ]";
    }
    
}
