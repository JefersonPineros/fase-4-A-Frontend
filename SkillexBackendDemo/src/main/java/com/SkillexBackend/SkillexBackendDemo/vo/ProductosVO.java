/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SkillexBackend.SkillexBackendDemo.vo;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Date;

/**
 *
 * @author jefer
 */
public class ProductosVO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer idProductos;
    private String nombreProducto;
    private String nombreProductoIn;
    private String codigoProducto;
    private String estadoProducto;
    private Integer cantidadProducto;
    private Date fechaIngreso;
    private Integer id_detalle_productos;
    private Integer valor_inicial;
    private Integer valor_mas_iva;
    private String descripcion_producto;
    private String descripcion_producto_in;
    private String url_imagen;
    private Integer id_categoria_producto;
    private String tipo_categoria;
    private Integer id_proveedor;
    private String contacto;
    private String nombre_proveedor;

    public ProductosVO(
            Integer idProductos, 
            String nombreProducto, 
            String nombreProductoIn, 
            String codigoProducto, 
            String estadoProducto, 
            Integer cantidadProducto, 
            Date fechaIngreso, 
            Integer id_detalle_productos, 
            Integer valor_inicial, 
            Integer valor_mas_iva, 
            String descripcion_producto, 
            String descripcion_producto_in, 
            String url_imagen, 
            Integer id_categoria_producto, 
            String tipo_categoria, 
            Integer id_proveedor, 
            String contacto, 
            String nombre_proveedor) {
        this.idProductos = idProductos;
        this.nombreProducto = nombreProducto;
        this.nombreProductoIn = nombreProductoIn;
        this.codigoProducto = codigoProducto;
        this.estadoProducto = estadoProducto;
        this.cantidadProducto = cantidadProducto;
        this.fechaIngreso = fechaIngreso;
        this.id_detalle_productos = id_detalle_productos;
        this.valor_inicial = valor_inicial;
        this.valor_mas_iva = valor_mas_iva;
        this.descripcion_producto = descripcion_producto;
        this.descripcion_producto_in = descripcion_producto_in;
        this.url_imagen = url_imagen;
        this.id_categoria_producto = id_categoria_producto;
        this.tipo_categoria = tipo_categoria;
        this.id_proveedor = id_proveedor;
        this.contacto = contacto;
        this.nombre_proveedor = nombre_proveedor;
    }

    public Integer getId_detalle_productos() {
        return id_detalle_productos;
    }

    public void setId_detalle_productos(Integer id_detalle_productos) {
        this.id_detalle_productos = id_detalle_productos;
    }

    public Integer getValor_inicial() {
        return valor_inicial;
    }

    public void setValor_inicial(Integer valor_inicial) {
        this.valor_inicial = valor_inicial;
    }

    public Integer getValor_mas_iva() {
        return valor_mas_iva;
    }

    public void setValor_mas_iva(Integer valor_mas_iva) {
        this.valor_mas_iva = valor_mas_iva;
    }

    public String getDescripcion_producto() {
        return descripcion_producto;
    }

    public void setDescripcion_producto(String descripcion_producto) {
        this.descripcion_producto = descripcion_producto;
    }

    public String getDescripcion_producto_in() {
        return descripcion_producto_in;
    }

    public void setDescripcion_producto_in(String descripcion_producto_in) {
        this.descripcion_producto_in = descripcion_producto_in;
    }

    public String getUrl_imagen() {
        return url_imagen;
    }

    public void setUrl_imagen(String url_imagen) {
        this.url_imagen = url_imagen;
    }

    public Integer getId_categoria_producto() {
        return id_categoria_producto;
    }

    public void setId_categoria_producto(Integer id_categoria_producto) {
        this.id_categoria_producto = id_categoria_producto;
    }

    public String getTipo_categoria() {
        return tipo_categoria;
    }

    public void setTipo_categoria(String tipo_categoria) {
        this.tipo_categoria = tipo_categoria;
    }

    public Integer getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(Integer id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getNombre_proveedor() {
        return nombre_proveedor;
    }

    public void setNombre_proveedor(String nombre_proveedor) {
        this.nombre_proveedor = nombre_proveedor;
    }
   
    
    public ProductosVO() {
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
    
    
}
