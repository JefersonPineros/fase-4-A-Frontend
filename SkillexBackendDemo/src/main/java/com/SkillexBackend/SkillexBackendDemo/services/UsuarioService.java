/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SkillexBackend.SkillexBackendDemo.services;

import com.SkillexBackend.SkillexBackendDemo.dao.UsuarioDao;
import com.SkillexBackend.SkillexBackendDemo.vo.RespuestaOperaciones;
import com.SkillexBackend.SkillexBackendDemo.vo.UsuarioVO;

import net.sf.jasperreports.engine.JRException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author jefer
 */
@RestController
@RequestScope
//@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT,RequestMethod.OPTIONS})
@RequestMapping("/api/usuario")
public class UsuarioService {
    
    @Autowired
    private UsuarioDao UsDao;
    
    @GetMapping("/access/email={email}&password={password}")
    public ResponseEntity<?> login(@PathVariable String email,@PathVariable String password){
        UsuarioVO oUsuario = UsDao.login(email, password);
        try {
        	if(oUsuario == null){
                return ResponseEntity.notFound().build(); 
            }else{
                return ResponseEntity.ok(oUsuario);
            }
		} catch (Exception e) {
			return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
		}
        
    }
    @PostMapping("/crear/")
    public ResponseEntity<?> crearUsuario(@RequestBody UsuarioVO usuario){
        UsuarioVO crearUser = usuario;
        Object respuesta = UsDao.save(crearUser);
        try {
        	if(respuesta != null){
                return ResponseEntity.ok(respuesta);
            }else{
                return ResponseEntity.notFound().build();
            }
		} catch (Exception e) {
			return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
    @GetMapping("/")
    public ResponseEntity<?> getAllUser(){
        List<UsuarioVO> listUsuario = UsDao.findAll();
        try {
        	if(listUsuario != null){
                return ResponseEntity.ok(listUsuario);
            } else {
                return null;
            }
		} catch (Exception e) {
			return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id){
    	try {
    		if(id != null){
                Object resp = UsDao.deleteById(id);
                return ResponseEntity.ok(resp);
            }else{
                return ResponseEntity.notFound().build();
            }
		} catch (Exception e) {
			return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
		}
        
    }
    @PostMapping("/actualizar")
    public ResponseEntity<?> updateUser(@RequestBody UsuarioVO usuario){
    	try {
    		if(usuario != null){
                RespuestaOperaciones resp = (RespuestaOperaciones) UsDao.updateUser(usuario);
                return ResponseEntity.ok(resp);
            }else{
                return ResponseEntity.notFound().build();
            }
		} catch (Exception e) {
			return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
		}       
    }
    @GetMapping("/recuperar/email={email}")
    public ResponseEntity<?> recuperarPassword(@PathVariable String email) {
    	try {
    		RespuestaOperaciones resp = (RespuestaOperaciones) UsDao.recuperarContrasena(email);
        	return ResponseEntity.ok(resp);
		} catch (Exception e) {
			return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
		}
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
    @GetMapping("/reporte/{formato}")
    public ResponseEntity<?> exportReport(@PathVariable String formato) throws FileNotFoundException, JRException{
    	try {
			Object respuesta= UsDao.reporte("pdf");
			return (ResponseEntity<?>) ResponseEntity.ok(respuesta);
		} catch (UnknownError e) {
			System.out.println(e);
			return (ResponseEntity<?>) ResponseEntity.notFound();
		}
    }
    
    @GetMapping("/fechalogin/id={id}")
    public  ResponseEntity<?> setFechaIngreso(@PathVariable Integer id) {
    	try {
    		RespuestaOperaciones resp = (RespuestaOperaciones) UsDao.actualizarLogin(id);
        	return ResponseEntity.ok(resp);
		} catch (Exception e) {
			return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    		
    }
    
    @PostMapping(value ="/cargueMasivo", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> cargueM(@RequestParam(name= "file") MultipartFile file) throws IOException {
    	try {
    		Path rutaArchivo = UsDao.upload(file);
    		RespuestaOperaciones resp = (RespuestaOperaciones) UsDao.cargueMasivo(rutaArchivo);
    		return ResponseEntity.ok(resp);
		} catch (UnknownError e) {
			// TODO: handle exception
			return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    	
    }
    
}
