/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SkillexBackend.SkillexBackendDemo.vo;

import java.util.Date;

/**
 *
 * @author jefer
 */
public class ListarPedidosVO {

    private Integer idPedidos;
    private String estadoPedido;
    private String mesa;
    private Integer iddetallePedido;
    private Integer valorApagar;
    private String producto;
    private Integer cantidadProducto;
    private Date fecha_pedido;
    private Integer Id_Estado_pedido;
    private Integer State_id;
    private String descripcion;
    private Integer cantidad_producto_pedido;
    private Integer id_productos;
    private String nombre_producto;
    private String codigo_producto;
    private String estado_producto;
    private Integer cantidad_producto;
    private Date fecha_ingreso;
    private Integer id_detalle_productos;
    private Integer valor_inicial;
    private Integer valor_mas_iva;
    private String descripcion_producto;
    private String url_imagen;
    private Integer idUsuarios;
    private String nombreUsuario;
    private String apellidoUsuario;
    private String emailUsuario;
    private String passwordUsuario;
    private String tienda;
    private Date creacion_usuario;
    private String fecha_login;
    private String turnos_laborales;
    private String cedula_ciudadania;

    public ListarPedidosVO() {
    }

    public ListarPedidosVO(Integer idPedidos, String estadoPedido, String mesa, Integer iddetallePedido, Integer valorApagar, String producto, Integer cantidadProducto, Date fecha_pedido, Integer Id_Estado_pedido, Integer State_id, String descripcion, Integer cantidad_producto_pedido, Integer id_productos, String nombre_producto, String codigo_producto, String estado_producto, Integer cantidad_producto, Date fecha_ingreso, Integer id_detalle_productos, Integer valor_inicial, Integer valor_mas_iva, String descripcion_producto, String url_imagen, Integer idUsuarios, String nombreUsuario, String apellidoUsuario, String emailUsuario, String passwordUsuario, String tienda, Date creacion_usuario, String fecha_login, String turnos_laborales, String cedula_ciudadania) {
        this.idPedidos = idPedidos;
        this.estadoPedido = estadoPedido;
        this.mesa = mesa;
        this.iddetallePedido = iddetallePedido;
        this.valorApagar = valorApagar;
        this.producto = producto;
        this.cantidadProducto = cantidadProducto;
        this.fecha_pedido = fecha_pedido;
        this.Id_Estado_pedido = Id_Estado_pedido;
        this.State_id = State_id;
        this.descripcion = descripcion;
        this.cantidad_producto_pedido = cantidad_producto_pedido;
        this.id_productos = id_productos;
        this.nombre_producto = nombre_producto;
        this.codigo_producto = codigo_producto;
        this.estado_producto = estado_producto;
        this.cantidad_producto = cantidad_producto;
        this.fecha_ingreso = fecha_ingreso;
        this.id_detalle_productos = id_detalle_productos;
        this.valor_inicial = valor_inicial;
        this.valor_mas_iva = valor_mas_iva;
        this.descripcion_producto = descripcion_producto;
        this.url_imagen = url_imagen;
        this.idUsuarios = idUsuarios;
        this.nombreUsuario = nombreUsuario;
        this.apellidoUsuario = apellidoUsuario;
        this.emailUsuario = emailUsuario;
        this.passwordUsuario = passwordUsuario;
        this.tienda = tienda;
        this.creacion_usuario = creacion_usuario;
        this.fecha_login = fecha_login;
        this.turnos_laborales = turnos_laborales;
        this.cedula_ciudadania = cedula_ciudadania;
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

    public String getMesa() {
        return mesa;
    }

    public void setMesa(String mesa) {
        this.mesa = mesa;
    }

    public Integer getIddetallePedido() {
        return iddetallePedido;
    }

    public void setIddetallePedido(Integer iddetallePedido) {
        this.iddetallePedido = iddetallePedido;
    }

    public Integer getValorApagar() {
        return valorApagar;
    }

    public void setValorApagar(Integer valorApagar) {
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

    public Date getFecha_pedido() {
        return fecha_pedido;
    }

    public void setFecha_pedido(Date fecha_pedido) {
        this.fecha_pedido = fecha_pedido;
    }

    public Integer getId_Estado_pedido() {
        return Id_Estado_pedido;
    }

    public void setId_Estado_pedido(Integer Id_Estado_pedido) {
        this.Id_Estado_pedido = Id_Estado_pedido;
    }

    public Integer getState_id() {
        return State_id;
    }

    public void setState_id(Integer State_id) {
        this.State_id = State_id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getCantidad_producto_pedido() {
        return cantidad_producto_pedido;
    }

    public void setCantidad_producto_pedido(Integer cantidad_producto_pedido) {
        this.cantidad_producto_pedido = cantidad_producto_pedido;
    }

    public Integer getId_productos() {
        return id_productos;
    }

    public void setId_productos(Integer id_productos) {
        this.id_productos = id_productos;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public String getCodigo_producto() {
        return codigo_producto;
    }

    public void setCodigo_producto(String codigo_producto) {
        this.codigo_producto = codigo_producto;
    }

    public String getEstado_producto() {
        return estado_producto;
    }

    public void setEstado_producto(String estado_producto) {
        this.estado_producto = estado_producto;
    }

    public Integer getCantidad_producto() {
        return cantidad_producto;
    }

    public void setCantidad_producto(Integer cantidad_producto) {
        this.cantidad_producto = cantidad_producto;
    }

    public Date getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
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

    public String getUrl_imagen() {
        return url_imagen;
    }

    public void setUrl_imagen(String url_imagen) {
        this.url_imagen = url_imagen;
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

    public Date getCreacion_usuario() {
        return creacion_usuario;
    }

    public void setCreacion_usuario(Date creacion_usuario) {
        this.creacion_usuario = creacion_usuario;
    }

    public String getFecha_login() {
        return fecha_login;
    }

    public void setFecha_login(String fecha_login) {
        this.fecha_login = fecha_login;
    }

    public String getTurnos_laborales() {
        return turnos_laborales;
    }

    public void setTurnos_laborales(String turnos_laborales) {
        this.turnos_laborales = turnos_laborales;
    }

    public String getCedula_ciudadania() {
        return cedula_ciudadania;
    }

    public void setCedula_ciudadania(String cedula_ciudadania) {
        this.cedula_ciudadania = cedula_ciudadania;
    }
    
    
}
