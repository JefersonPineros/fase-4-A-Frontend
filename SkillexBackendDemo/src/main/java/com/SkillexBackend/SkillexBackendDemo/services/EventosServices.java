/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SkillexBackend.SkillexBackendDemo.services;

import com.SkillexBackend.SkillexBackendDemo.dao.EventosDao;
import com.SkillexBackend.SkillexBackendDemo.vo.EventosVO;

import net.sf.jasperreports.engine.JRException;

import java.io.FileNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@RequestMapping("/api/eventos")

public class EventosServices {
     
    @Autowired
    private EventosDao eventosDao;
    
    @GetMapping("/")
    public ResponseEntity<?> readAll() {
        List<EventosVO> list = eventosDao.mostrar_eventos();
        if (list.size() > 0) {
            return ResponseEntity.ok(list);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping("/actualizar/")
    public ResponseEntity<?> updateEvento(@RequestBody EventosVO evento){
        Object respuesta = eventosDao.updateEvento(evento);
        if(respuesta != null){
            return ResponseEntity.ok(respuesta);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping
    public ResponseEntity<?> create(@RequestBody EventosVO evento) {
        Object resp = eventosDao.save(evento);
        if(resp != null){
            return ResponseEntity.ok(resp);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id){
        if(id != null){
            Object resp = eventosDao.deleteById(id);
            return ResponseEntity.ok(resp);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/getEvento/{id}")
    public ResponseEntity<?> getEvento(@PathVariable Integer id){
    	try {
			EventosVO evento = eventosDao.getEvent(id);
			if (evento != null) {
				return ResponseEntity.ok(evento);				
			} else {
				return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.NOT_FOUND);				
			}
		} catch (Exception e) {
			return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.BAD_REQUEST);
		}
    }
    @GetMapping("/getEvento")
    public ResponseEntity<?> getEvento(){
    	try {
			EventosVO evento = eventosDao.getLastEvent();
			if (evento != null) {
				return ResponseEntity.ok(evento);				
			} else {
				return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.NOT_FOUND);				
			}
		} catch (Exception e) {
			return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.BAD_REQUEST);
		}
    }
    @GetMapping("/reporte/{format}")
    public ResponseEntity<?> exportReport(@PathVariable String format) throws FileNotFoundException, JRException{
    	try {
			Object respuesta= eventosDao.reporte("pdf");
			return (ResponseEntity<?>) ResponseEntity.ok(respuesta);
		} catch (UnknownError e) {
			System.out.println(e);
			return (ResponseEntity<?>) ResponseEntity.notFound();
		}
    }
}
