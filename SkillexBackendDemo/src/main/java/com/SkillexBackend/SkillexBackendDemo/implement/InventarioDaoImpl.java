/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SkillexBackend.SkillexBackendDemo.implement;

import com.SkillexBackend.SkillexBackendDemo.dao.InventarioDao;
import com.SkillexBackend.SkillexBackendDemo.models.Inventario;
import com.SkillexBackend.SkillexBackendDemo.repository.InventarioRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author jefer
 */
@Service
public class InventarioDaoImpl implements InventarioDao {
    
    @Autowired
    private InventarioRepository inventarioRepo;
    @Override
    public Iterable<Inventario> findAll() {
        return inventarioRepo.findAll();
    }

    @Override
    public Page<Inventario> findAll(Pageable pageable) {
        return inventarioRepo.findAll(pageable);
    }


    @Override
    public Inventario save(Inventario inventario) {
        return inventarioRepo.save(inventario);
    }

    @Override
    public void deleteById(Integer id) {
        inventarioRepo.deleteById(id);
    }

    @Override
    public Optional<Inventario> findById(Integer idInventario) {
        return inventarioRepo.findById(idInventario);
    }

    


    
    
}
