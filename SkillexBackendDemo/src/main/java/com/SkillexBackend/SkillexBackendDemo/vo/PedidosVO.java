/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SkillexBackend.SkillexBackendDemo.vo;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author jefer
 */
public class PedidosVO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    public Integer idPedidos;
    public String estadoPedidos;
    public String mesa;
    public Integer idDetallePedido;
    public Integer idUsuario;
    public Integer idEstadoPedido;
    public Integer valorApagar;
    public Date fechaPedido;
    public UsuarioVO usuario;
    public List<ProductosVO> producto;

    public PedidosVO() {
    }

    public PedidosVO(Integer idPedidos, String estadoPedidos, String mesa, Integer idDetallePedido, Integer idUsuario, Integer idEstadoPedido, Integer valorApagar, Date fechaPedido, UsuarioVO usuario, List<ProductosVO> producto) {
        this.idPedidos = idPedidos;
        this.estadoPedidos = estadoPedidos;
        this.mesa = mesa;
        this.idDetallePedido = idDetallePedido;
        this.idUsuario = idUsuario;
        this.idEstadoPedido = idEstadoPedido;
        this.valorApagar = valorApagar;
        this.fechaPedido = fechaPedido;
        this.usuario = usuario;
        this.producto = producto;
    }

    public Integer getIdPedidos() {
        return idPedidos;
    }

    public void setIdPedidos(Integer idPedidos) {
        this.idPedidos = idPedidos;
    }

    public String getEstadoPedidos() {
        return estadoPedidos;
    }

    public void setEstadoPedidos(String estadoPedidos) {
        this.estadoPedidos = estadoPedidos;
    }

    public String getMesa() {
        return mesa;
    }

    public void setMesa(String mesa) {
        this.mesa = mesa;
    }

    public Integer getIdDetallePedido() {
        return idDetallePedido;
    }

    public void setIdDetallePedido(Integer idDetallePedido) {
        this.idDetallePedido = idDetallePedido;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdEstadoPedido() {
        return idEstadoPedido;
    }

    public void setIdEstadoPedido(Integer idEstadoPedido) {
        this.idEstadoPedido = idEstadoPedido;
    }

    public Integer getValorApagar() {
        return valorApagar;
    }

    public void setValorApagar(Integer valorApagar) {
        this.valorApagar = valorApagar;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public UsuarioVO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioVO usuario) {
        this.usuario = usuario;
    }

    public List<ProductosVO> getProducto() {
        return producto;
    }

    public void setProducto(List<ProductosVO> producto) {
        this.producto = producto;
    }
    
}
