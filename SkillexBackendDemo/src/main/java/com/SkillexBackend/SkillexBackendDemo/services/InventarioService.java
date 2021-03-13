/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SkillexBackend.SkillexBackendDemo.services;

import com.SkillexBackend.SkillexBackendDemo.dao.InventarioDao;
import com.SkillexBackend.SkillexBackendDemo.models.Inventario;
import com.SkillexBackend.SkillexBackendDemo.vo.InventarioVO;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jefer
 */
@RestController
@RequestMapping("/api/Inventario")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT,RequestMethod.OPTIONS})
public class InventarioService {
   @Autowired
   private InventarioDao InDaO;
   
   @GetMapping("/{id}")
   public ResponseEntity<?> GetInventario(@PathVariable Integer id){
       Optional<Inventario> oInventario = InDaO.findById(id);
        if(!oInventario.isPresent()){
            return ResponseEntity.notFound().build();
        }
        Inventario inventario = oInventario.get();
        
        //inventario.setUsuarioList(inventario.getUsuarioList());
        //inventario.setProductosList(inventario.getProductosList());
        
        InventarioVO inventarioVo = new InventarioVO(inventario.getIdInventario(),inventario.getNombreEmpresa(),inventario.getTotalProductos());
        return ResponseEntity.ok(inventarioVo);
   }
   
}
