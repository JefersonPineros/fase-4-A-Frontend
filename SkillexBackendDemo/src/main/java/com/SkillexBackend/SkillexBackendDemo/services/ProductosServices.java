/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SkillexBackend.SkillexBackendDemo.services;

import com.SkillexBackend.SkillexBackendDemo.dao.ProductosDao;
import com.SkillexBackend.SkillexBackendDemo.models.Inventario;
import com.SkillexBackend.SkillexBackendDemo.models.Productos;
import com.SkillexBackend.SkillexBackendDemo.vo.InventarioVO;
import com.SkillexBackend.SkillexBackendDemo.vo.ProductosCrearVO;
import com.SkillexBackend.SkillexBackendDemo.vo.ProductosVO;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jefer
 */
@RestController
@RequestMapping("/api/productos")
public class ProductosServices {

    @Autowired
    private ProductosDao productosDao;

    // crear nuevo producto
    @PostMapping
    public ResponseEntity<?> create(@RequestBody ProductosCrearVO producto) {
        Object resp = productosDao.save(producto);
        if(resp != null){
            return ResponseEntity.ok(resp);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    //Read productos
    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable Integer id) {
        
        try {
            Optional<Productos> oProducto = productosDao.findById(id);
            
            Productos productos = oProducto.get();
            ProductosVO inventarioVo = new ProductosVO(
                    productos.getIdProductos(),
                    productos.getNombreProducto(),
                    productos.getNombreProductoIn(),
                    productos.getCodigoProducto(),
                    productos.getEstadoProducto(),
                    productos.getCantidadProducto(),
                    productos.getFechaIngreso(),
                    null,
                    0,
                    0,
                    "",
                    "",
                    "",
                    null,
                    "",
                    null,
                    "",
                    ""
            );
            return ResponseEntity.ok(inventarioVo);
            
        } catch (Exception e) {
            System.out.println(e.toString());
            return ResponseEntity.notFound().build();
        }
        
    }
    // Listar todos los productos
    @GetMapping()
    public ResponseEntity<?> readAll() {
        List<ProductosVO> list = productosDao.mostrar_productos();
        if (list.size() > 0) {
            return ResponseEntity.ok(list);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/actualizar/")
    public ResponseEntity<?> updateProducto(@RequestBody ProductosVO producto){
        Object respuesta = productosDao.updateProducto(producto);
        if(respuesta != null){
            return ResponseEntity.ok(respuesta);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
