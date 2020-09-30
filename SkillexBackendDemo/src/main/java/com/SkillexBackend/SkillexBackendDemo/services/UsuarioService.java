/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SkillexBackend.SkillexBackendDemo.services;

import com.SkillexBackend.SkillexBackendDemo.dao.UsuarioDao;
import com.SkillexBackend.SkillexBackendDemo.vo.UsuarioVO;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/api/usuario")
public class UsuarioService {
    
    @Autowired
    private UsuarioDao UsDao;
    
    @GetMapping("/access/email={email}&password={password}")
    public ResponseEntity<?> login(@PathVariable String email,@PathVariable String password){
        UsuarioVO oUsuario = UsDao.login(email, password);
        if(oUsuario == null){
            return ResponseEntity.notFound().build(); 
        }else{
            return ResponseEntity.ok(oUsuario);
        }
    }
    @PostMapping("/crear/")
    public ResponseEntity<?> crearUsuario(@RequestBody UsuarioVO usuario){
        UsuarioVO crearUser = usuario;
        Object respuesta = UsDao.save(crearUser);
        if(respuesta != null){
            return ResponseEntity.ok(respuesta);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
