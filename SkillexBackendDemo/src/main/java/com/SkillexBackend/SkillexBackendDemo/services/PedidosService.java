/*
  * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SkillexBackend.SkillexBackendDemo.services;

import com.SkillexBackend.SkillexBackendDemo.dao.PedidosDao;
import com.SkillexBackend.SkillexBackendDemo.vo.PedidosVO;
import com.SkillexBackend.SkillexBackendDemo.vo.RespuestaOperaciones;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jefer
 */
@RestController
@RequestMapping("/api/pedidos")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT,RequestMethod.OPTIONS})
public class PedidosService {
    
    @Autowired
    private PedidosDao pedidosDao;
    
    @PostMapping("/")
    public ResponseEntity<?> crearPedido(@RequestBody PedidosVO pedido){
        PedidosVO crearPedido = pedido;
        try {
        	Object respuesta = pedidosDao.create(crearPedido);
            if(respuesta != null){
                return ResponseEntity.ok(respuesta);
            }else{
                return ResponseEntity.notFound().build();
            }
		} catch (Exception e) {
			return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
    @GetMapping("/listar/")
    public ResponseEntity<?> listarPedidos(){
        List<PedidosVO> pedidos = pedidosDao.getPedidos();
        try {
        	if(pedidos != null){
                return ResponseEntity.ok(pedidos);
            }else{
                return ResponseEntity.notFound().build();
            }
		} catch (Exception e) {
			return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
    @PostMapping("/procesar/")
    public ResponseEntity<?> procesarPedido(@RequestBody PedidosVO pedido) {
    	RespuestaOperaciones resp = new RespuestaOperaciones();
    	try {
			resp = (RespuestaOperaciones) pedidosDao.procesar(pedido);
			return ResponseEntity.ok(resp);
		} catch (Exception e) {
			return (ResponseEntity<?>) ResponseEntity.notFound();
		}
    }
}
