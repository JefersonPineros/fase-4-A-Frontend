/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SkillexBackend.SkillexBackendDemo.dao;

import com.SkillexBackend.SkillexBackendDemo.vo.PedidosVO;
import java.util.List;

/**
 *
 * @author jefer
 */
public interface PedidosDao {
    public Object create(PedidosVO pedido);
    public List<PedidosVO> getPedidos();
    public PedidosVO getPedido(Integer idPedido);
    public Object procesar(Integer idEstado);
}
