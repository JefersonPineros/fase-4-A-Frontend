/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SkillexBackend.SkillexBackendDemo.repository;

import com.SkillexBackend.SkillexBackendDemo.models.Eventos;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author LABORATORIO 2
 */
public interface EventosRepository extends JpaRepository<Eventos, Integer>{
    
}
