/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SkillexBackend.SkillexBackendDemo.dao;

import com.SkillexBackend.SkillexBackendDemo.models.Productos;
import com.SkillexBackend.SkillexBackendDemo.vo.ProductosCrearVO;
import com.SkillexBackend.SkillexBackendDemo.vo.ProductosVO;

import net.sf.jasperreports.engine.JRException;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author jefer
 */
public interface ProductosDao {
    
    public List<ProductosVO> mostrar_productos();
    public Page<Productos> findAll(Pageable pageable);
    public Optional<Productos> findById(Integer idProductos);
    public Object save(ProductosCrearVO producto);
    public Object deleteById(Integer id);
    public Object updateProducto(ProductosVO producto);
    public Object reporte(String type) throws FileNotFoundException, JRException;
}
