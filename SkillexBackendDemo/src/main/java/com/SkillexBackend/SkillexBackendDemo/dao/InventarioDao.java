/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SkillexBackend.SkillexBackendDemo.dao;


import com.SkillexBackend.SkillexBackendDemo.models.Inventario;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author jefer
 */
public interface InventarioDao {
    public Iterable<Inventario> findAll();
    public Page<Inventario> findAll(Pageable pageable);
    public Optional<Inventario> findById(Integer idInventario);
    public Inventario save(Inventario Inventario);
    public void deleteById(Integer id);
}
