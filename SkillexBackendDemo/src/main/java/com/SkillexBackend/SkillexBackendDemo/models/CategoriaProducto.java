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
@Table(name = "categoria_producto", catalog = "skillexbd", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CategoriaProducto.findAll", query = "SELECT c FROM CategoriaProducto c")
    , @NamedQuery(name = "CategoriaProducto.findByIdCategoriaProducto", query = "SELECT c FROM CategoriaProducto c WHERE c.idCategoriaProducto = :idCategoriaProducto")
    , @NamedQuery(name = "CategoriaProducto.findByTipoCategoria", query = "SELECT c FROM CategoriaProducto c WHERE c.tipoCategoria = :tipoCategoria")})
public class CategoriaProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_categoria_producto")
    private Integer idCategoriaProducto;
    @Column(name = "tipo_categoria")
    private String tipoCategoria;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoriaProductoIdCategoriaProducto", fetch = FetchType.LAZY)
    private List<Productos> productosList;

    public CategoriaProducto() {
    }

    public CategoriaProducto(Integer idCategoriaProducto) {
        this.idCategoriaProducto = idCategoriaProducto;
    }

    public Integer getIdCategoriaProducto() {
        return idCategoriaProducto;
    }

    public void setIdCategoriaProducto(Integer idCategoriaProducto) {
        this.idCategoriaProducto = idCategoriaProducto;
    }

    public String getTipoCategoria() {
        return tipoCategoria;
    }

    public void setTipoCategoria(String tipoCategoria) {
        this.tipoCategoria = tipoCategoria;
    }

    @XmlTransient
    public List<Productos> getProductosList() {
        return productosList;
    }

    public void setProductosList(List<Productos> productosList) {
        this.productosList = productosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCategoriaProducto != null ? idCategoriaProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CategoriaProducto)) {
            return false;
        }
        CategoriaProducto other = (CategoriaProducto) object;
        if ((this.idCategoriaProducto == null && other.idCategoriaProducto != null) || (this.idCategoriaProducto != null && !this.idCategoriaProducto.equals(other.idCategoriaProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.SkillexBackend.SkillexBackendDemo.models.CategoriaProducto[ idCategoriaProducto=" + idCategoriaProducto + " ]";
    }
    
}
