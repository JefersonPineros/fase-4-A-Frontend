/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SkillexBackend.SkillexBackendDemo.dao;

import com.SkillexBackend.SkillexBackendDemo.vo.UsuarioVO;
import java.util.List;

import javax.mail.MessagingException;


/**
 *
 * @author jefer
 */
public interface UsuarioDao {
    public List<UsuarioVO> findAll();
    public UsuarioVO findById(Integer idUsuario);
    public Object save(UsuarioVO usuario);
    public Object deleteById(Integer id);
    public Integer getTipeUser(Integer UserId);
    public UsuarioVO login(String email,String pass);
    public Object recuperarContrasena(String email);
    public Object updateUser(UsuarioVO usuario);
    public void correoMasivoSend(String mensaje, String asunto) throws MessagingException;
}
