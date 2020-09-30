/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SkillexBackend.SkillexBackendDemo.dao;

import com.SkillexBackend.SkillexBackendDemo.models.Inventario;
import com.SkillexBackend.SkillexBackendDemo.models.Usuario;
import com.SkillexBackend.SkillexBackendDemo.vo.UsuarioVO;
import java.util.Optional;
import org.json.JSONObject;


/**
 *
 * @author jefer
 */
public interface UsuarioDao {
    public Iterable<Usuario> findAll();
    public Optional<Usuario> findById(Integer idUsuario);
    public Object save(UsuarioVO usuario);
    public void deleteById(Integer id);
    public Integer getTipeUser(Integer UserId);
    public UsuarioVO login(String email,String pass);
}
