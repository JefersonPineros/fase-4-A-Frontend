/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SkillexBackend.SkillexBackendDemo.services;

import com.SkillexBackend.SkillexBackendDemo.dao.UsuarioDao;
import com.SkillexBackend.SkillexBackendDemo.vo.RespuestaOperaciones;
import com.SkillexBackend.SkillexBackendDemo.vo.UsuarioVO;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.DeleteMapping;
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
//@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT,RequestMethod.OPTIONS})
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
    @GetMapping("/")
    public ResponseEntity<?> getAllUser(){
        List<UsuarioVO> listUsuario = UsDao.findAll();
        if(listUsuario != null){
            return ResponseEntity.ok(listUsuario);
        } else {
            return null;
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id){
        if(id != null){
            Object resp = UsDao.deleteById(id);
            return ResponseEntity.ok(resp);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/actualizar")
    public ResponseEntity<?> updateUser(@RequestBody UsuarioVO usuario){
        if(usuario != null){
            RespuestaOperaciones resp = (RespuestaOperaciones) UsDao.updateUser(usuario);
            return ResponseEntity.ok(resp);
        }else{
            return ResponseEntity.notFound().build();
        }       
    }
    @GetMapping("/recuperar/email={email}")
    public ResponseEntity<?> recuperarPassword(@PathVariable String email) {
    	RespuestaOperaciones resp = (RespuestaOperaciones) UsDao.recuperarContrasena(email);
    	return ResponseEntity.ok(resp);
    }
    @GetMapping("/correoMasivo/asunto={asunto}&mensaje={mensaje}")
    public ResponseEntity<?> correoMasivoEnviar(@PathVariable String asunto, @PathVariable String mensaje) throws MessagingException {
    	RespuestaOperaciones resp = new RespuestaOperaciones();
    	try {
    		this.UsDao.correoMasivoSend(mensaje, asunto);
    		resp.setCodigo("001");
    		resp.setRespuesta("Correo enviado exitosamente");
    		return ResponseEntity.ok(resp);
		} catch (Exception e) {
			resp.setCodigo("002");
    		resp.setRespuesta("No se pudo completar la operación");
			return ResponseEntity.ok(resp);
		}
    }
    
}
