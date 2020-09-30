/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SkillexBackend.SkillexBackendDemo.implement;

import com.SkillexBackend.SkillexBackendDemo.dao.UsuarioDao;
import com.SkillexBackend.SkillexBackendDemo.models.Usuario;
import com.SkillexBackend.SkillexBackendDemo.repository.UsuarioRepository;
import com.SkillexBackend.SkillexBackendDemo.vo.RespuestaOperaciones;
import com.SkillexBackend.SkillexBackendDemo.vo.UsuarioVO;
import static com.jayway.jsonpath.internal.function.ParamType.JSON;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jefer
 */
@Service
public class UsuarioDaoImpl implements UsuarioDao {

    private EntityManagerFactory emf;

    @Autowired
    private UsuarioRepository usuarioRepo;

    @Override
    public Iterable<Usuario> findAll() {
        return usuarioRepo.findAll();
    }

    @Override
    public Optional<Usuario> findById(Integer idUsuario) {
        return usuarioRepo.findById(idUsuario);
    }

    @Override
    public Object save(UsuarioVO usuario) {
        UsuarioVO user = usuario;
        EntityManagerFactory emf;
        emf = Persistence.createEntityManagerFactory("com.miUnidadDePersistencia");
        RespuestaOperaciones resp = new RespuestaOperaciones();
        try {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            String verificar = "select * from usuario where emailUsuario = :email";
            Query query = em.createNativeQuery(verificar);
            query.setParameter("email", user.getEmailUsuario());
            List<Object[]> listValidar = (List<Object[]>) query.getResultList();
            em.close();
            if (listValidar.size() > 0) {
                resp.setCodigo("003");
                resp.setRespuesta("Este usuario ya existe");
                return resp;
            } else {
                
                try {
                    EntityManager emt = emf.createEntityManager();
                    emt.getTransaction().begin();
                    String sql = "Insert into usuario(nombreUsuario,apellidoUsuario,emailUsuario,passwordUsuario,tienda,creacion_usuario,fecha_login,turnos_laborales,cedula_ciudadania,tipoUsuario_idTipoUsuario,inventario_idInventario)"
                            + "Values(:nombreUsuario,:apellidoUsuario,:emailUsuario,:passwordUsuario,:tienda,:creacion_usuario,:fecha_login,:turnos_laborales,:cedula_ciudadania,:tipoUsuario_idTipoUsuario,:inventario_idInventario)";
                    Query query2 = emt.createNativeQuery(sql);
                    query2.setParameter("nombreUsuario", user.getNombreUsuario());
                    query2.setParameter("apellidoUsuario", user.getApellidoUsuario());
                    query2.setParameter("emailUsuario", user.getEmailUsuario());
                    query2.setParameter("passwordUsuario", user.getPasswordUsuario());
                    query2.setParameter("tienda", user.getTienda());
                    query2.setParameter("creacion_usuario", user.getCreacionUsuario());
                    query2.setParameter("fecha_login", user.getFechaLogin());
                    query2.setParameter("turnos_laborales", user.getTurnosLaborales());
                    query2.setParameter("cedula_ciudadania", user.getCedulaCiudadania());
                    query2.setParameter("tipoUsuario_idTipoUsuario", user.getTipoUsuario());
                    query2.setParameter("inventario_idInventario", user.getInventarioIdInventario());

                    query2.executeUpdate();
                    emt.getTransaction().commit();
                    //resp = {"r","OK"};

                    resp.setCodigo("001");
                    resp.setRespuesta("OK");
                    return resp;
                } catch (Exception e) {
                    System.err.println(e.toString());
                    resp.setCodigo("002");
                    resp.setRespuesta("Error al crear un usuario");
                    return resp;
                }
            }

        } catch (Exception e) {
            System.out.println(e.toString());
            resp.setCodigo("002");
            resp.setRespuesta("Error al crear un usuario");
            return resp;
        }

    }

    @Override
    public void deleteById(Integer id) {
        usuarioRepo.deleteById(id);
    }

    @Override
    public Integer getTipeUser(Integer UserId) {
        EntityManagerFactory emf;
        emf = Persistence.createEntityManagerFactory("com.miUnidadDePersistencia");
        Integer tipoUsuario = UserId;
        Integer resultTipo = 0;
        try {
            EntityManager em = emf.createEntityManager();
            String sql = "select tipoUsuario_idTipoUsuario from usuario where idUsuarios = :idUsuario";
            Query query = em.createNativeQuery(sql);
            query.setParameter("idUsuario", tipoUsuario);
            resultTipo = (Integer) query.getSingleResult();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return resultTipo;
    }

    @Override
    public UsuarioVO login(String email, String pass) {
        emf = Persistence.createEntityManagerFactory("com.miUnidadDePersistencia");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        UsuarioVO userReponse = new UsuarioVO();
        if (email == null || pass == null) {
            return null;
        } else {
            try {
                String sql = "select * from usuario where emailUsuario = :email and passwordUsuario = :pass limit 1";
                Query query = em.createNativeQuery(sql);
                query.setParameter("email", email);
                query.setParameter("pass", pass);

                //System.out.println(query.getParameterValue([]));
                //us = (Usuario) query.getSingleResult();
                //Map<String,Object> user2 = (Map<String,Object>) query.getSingleResult();
                //Object result = (Object) query.getSingleResult();
                /*
                Para desserializar el resultaddo de la consulta es necesario convertir el objeto en una lista y despues en un iterador
                para poder dar tratamiento a los datos y construir el objeto a devolver.
                 */
                List<Object[]> res = query.getResultList();
                if (res.size() > 0) {
                    Iterator it = res.iterator();
                    while (it.hasNext()) {
                        Object[] line = (Object[]) it.next();
                        Integer id = (Integer) line[0];
                        String nombre = (String) line[1];
                        String apellido = (String) line[2];
                        String email2 = (String) line[3];
                        String pass3 = (String) line[4];
                        String tienda = (String) line[5];
                        Date fecha = (Date) line[6];
                        String fechaLogin = (String) line[7];
                        String turnos = (String) line[8];
                        String cedula = (String) line[9];
                        Integer tipo = (Integer) line[10];
                        Integer inv = (Integer) line[11];

                        userReponse = new UsuarioVO(id, nombre, apellido, email2, pass3, tienda, fecha, fechaLogin, turnos, cedula, tipo, inv);

                    }
                } else {
                    userReponse = null;
                }

            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
        return userReponse;
    }

    private static class ObjectImpl extends Object {

        public ObjectImpl() {
        }
    }

}
