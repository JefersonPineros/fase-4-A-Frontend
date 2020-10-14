/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SkillexBackend.SkillexBackendDemo.services;

import com.SkillexBackend.SkillexBackendDemo.dao.PedidosDao;
import com.SkillexBackend.SkillexBackendDemo.vo.PedidosVO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jefer
 */
@RestController
@RequestMapping("/api/pedidos")
public class PedidosService {
    
    @Autowired
    private PedidosDao pedidosDao;
    
    @PostMapping("/")
    public ResponseEntity<?> crearPedido(@RequestBody PedidosVO pedido){
        PedidosVO crearPedido = pedido;
        Object respuesta = pedidosDao.create(crearPedido);
        if(respuesta != null){
            return ResponseEntity.ok(respuesta);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/listar/")
    public ResponseEntity listarPedidos(){
        List<PedidosVO> pedidos = pedidosDao.getPedidos();
        if(pedidos != null){
            return ResponseEntity.ok(pedidos);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
