/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SkillexBackend.SkillexBackendDemo.implement;

import com.SkillexBackend.SkillexBackendDemo.dao.UsuarioDao;
import com.SkillexBackend.SkillexBackendDemo.models.Usuario;
import com.SkillexBackend.SkillexBackendDemo.repository.UsuarioRepository;
import com.SkillexBackend.SkillexBackendDemo.utilidades.Email;
import com.SkillexBackend.SkillexBackendDemo.vo.RespuestaOperaciones;
import com.SkillexBackend.SkillexBackendDemo.vo.UsuarioVO;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import static com.jayway.jsonpath.internal.function.ParamType.JSON;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

import javax.mail.MessagingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;


/**
 *
 * @author jefer
 */
@Service
public class UsuarioDaoImpl implements UsuarioDao {

    private EntityManagerFactory emf;
    
    @Autowired
    private Email email;
    
    @Autowired
    private UsuarioRepository usuarioRepo;

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
    public Object deleteById(Integer id) {
        emf = Persistence.createEntityManagerFactory("com.miUnidadDePersistencia");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        RespuestaOperaciones resp = new RespuestaOperaciones();
        try {
            String sql = "delete From usuario where idUsuarios = :id";
            Query query = em.createNativeQuery(sql);
            query.setParameter("id", id);
            query.executeUpdate();
            em.getTransaction().commit();
            resp.setCodigo("001");
            resp.setRespuesta("OK");
            return resp;
        } catch (Exception e) {
            System.out.println(e.toString());
            resp.setCodigo("002");
            resp.setRespuesta("Error al eliminar el usuario");
            return resp;
        }
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
                        
                        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
                        Date fechaL = new Date(System.currentTimeMillis());                       
                        String fechaLogin = formato.format(fechaL).toString();
                        
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

    @Override
    public List<UsuarioVO> findAll() {
        emf = Persistence.createEntityManagerFactory("com.miUnidadDePersistencia");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        UsuarioVO userReponse = new UsuarioVO();
        List<UsuarioVO> listResponse = new ArrayList<UsuarioVO>();
        try {
            String sql = "Select * from usuario";
            Query query = em.createNativeQuery(sql);
            List<Object> res = query.getResultList();
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
                    listResponse.add(userReponse);
                    userReponse = new UsuarioVO();
                }
                return listResponse;
            } else {
                userReponse = null;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            return null;
        }
        return null;
    }

    @Override
    public void correoMasivoSend(String mensaje , String asunto) throws MessagingException {
    	List<UsuarioVO> listaUsuarios = this.findAll();
    	for (UsuarioVO item: listaUsuarios) {
    		String nombres = item.getNombreUsuario();
    		String apellidos = item.getApellidoUsuario();
    		String correoUs = item.getEmailUsuario();
    		
    		this.email.correoMasivo("skillex.gaes@gmail.com",correoUs, asunto, nombres, apellidos,mensaje);
    	}
    }
    @Override
    public UsuarioVO findById(Integer idUsuario) {

        return null;
    }

    @Override
    public RespuestaOperaciones updateUser(UsuarioVO usuario) {
        emf = Persistence.createEntityManagerFactory("com.miUnidadDePersistencia");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        UsuarioVO user = usuario;
        RespuestaOperaciones resp = new RespuestaOperaciones();
        try {
            if (user.getIdUsuarios() != null) {
                String sql = "update usuario "
                        + "set nombreUsuario = :nombre,"
                        + "apellidoUsuario = :apellido,"
                        + "passwordUsuario = :pass,"
                        + "tienda = :tienda,"
                        + "turnos_laborales = :turnos,"
                        + "cedula_ciudadania = :documento "
                        + "where idUsuarios = :id";
                Query query = em.createNativeQuery(sql);
                query.setParameter("nombre", user.getNombreUsuario());
                query.setParameter("apellido", user.getApellidoUsuario());
                query.setParameter("pass", user.getPasswordUsuario());
                query.setParameter("tienda", user.getTienda());
                query.setParameter("turnos", user.getTurnosLaborales());
                query.setParameter("documento", user.getCedulaCiudadania());
                query.setParameter("id", user.getIdUsuarios());

                query.executeUpdate();
                em.getTransaction().commit();
                em.close();

                resp.setCodigo("001");
                resp.setRespuesta("OK");
                return resp;
            } else {
                resp.setCodigo("003");
                resp.setRespuesta("El id usuario esta vacio ");
                return resp;
            }

        } catch (Exception e) {
            System.out.println(e.toString());
            resp.setCodigo("002");
            resp.setRespuesta("Se presento un problema al actualizar el usuario");
            return resp;
        }
    }

    @Override

    public Object recuperarContrasena(String email) {
        emf = Persistence.createEntityManagerFactory("com.miUnidadDePersistencia");
        EntityManager em = emf.createEntityManager();
        RespuestaOperaciones resp = new RespuestaOperaciones();
        String userId;
        UsuarioVO usuarioRequest = new UsuarioVO();
        String claveNueva = "";
        try {
            String sql = "SELECT * FROM usuario WHERE emailUsuario = :email";
            Query query = em.createNativeQuery(sql);
            query.setParameter("email", email);
            List<Object[]> listOb = query.getResultList();
            if (listOb.size() > 0) {
                Iterator it = listOb.iterator();
                while (it.hasNext()) {
                    Object[] line = (Object[]) it.next();
                    usuarioRequest.setIdUsuarios((Integer) line[0]);
                    usuarioRequest.setNombreUsuario((String) line[1]);
                    usuarioRequest.setApellidoUsuario((String) line[2]);
                    usuarioRequest.setEmailUsuario((String) line[3]);
                    usuarioRequest.setPasswordUsuario((String) line[4]);
                    usuarioRequest.setTienda((String) line[5]);
                    Date fecha = (Date) line[6];
                    usuarioRequest.setCreacionUsuario(fecha);
                    usuarioRequest.setFechaLogin((String) line[7]);
                    usuarioRequest.setTurnosLaborales((String) line[8]);
                    usuarioRequest.setCedulaCiudadania((String) line[9]);
                    usuarioRequest.setTipoUsuario((Integer) line[10]);
                    usuarioRequest.setInventarioIdInventario((Integer) line[11]);
                }
                em.close();
                String claveAleatoria = "";
                int max = 10; 
                int min = 1; 
                int range = max - min + 1; 
                for (int i = 0; i <= 10 ; i ++){
                     claveAleatoria = claveAleatoria + String.valueOf((int)(Math.random()* range) + min);
                }
                
                EntityManager em2 = emf.createEntityManager();
                em2.getTransaction().begin();
                String q2 = "UPDATE usuario SET passwordUsuario = :password WHERE emailUsuario = :email";
                Query query2 = em2.createNativeQuery(q2);
                query2.setParameter("email", usuarioRequest.getEmailUsuario());
                query2.setParameter("password", claveAleatoria);
                query2.executeUpdate();
                em2.getTransaction().commit();
                em2.close();
                             
                this.email.enviarContrasena("skillex.gaes@gmail.com",usuarioRequest.getEmailUsuario(), "Recuperación de contraseña", claveAleatoria,usuarioRequest.getNombreUsuario(),usuarioRequest.getApellidoUsuario() );
                
                resp.setCodigo("001");
            	resp.setRespuesta("Correo enviado exitosamente");
                return resp;
            } else {
            	resp.setCodigo("002");
            	resp.setRespuesta("El correo no existe");
                return resp;
            }
        } catch (Exception e) {
        	resp.setCodigo("003");
        	resp.setRespuesta("Se presento un error al enviar el correo");
            return resp;
        }
    }

	@Override
	public Object actualizarLogin(Integer id) {
		emf = Persistence.createEntityManagerFactory("com.miUnidadDePersistencia");
		RespuestaOperaciones resp = new RespuestaOperaciones();
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date fechaL = new Date(System.currentTimeMillis());                       
        String fechaLogin = formato.format(fechaL).toString();
		
		EntityManager em2 = emf.createEntityManager();
        em2.getTransaction().begin();
        try {
			String sqp2 = "UPDATE usuario SET fecha_login = :fechaLogin WHERE idUsuarios = :idUsuario";
			Query q2 = em2.createNativeQuery(sqp2);
			q2.setParameter("fechaLogin", fechaLogin);
			q2.setParameter("idUsuario", id);
			q2.executeUpdate();
			em2.getTransaction().commit();
			em2.close();
			
			resp.setCodigo("001");
			resp.setRespuesta("Ok");
			return resp;
		} catch (Exception e) {
			System.out.println(e.toString());
			resp.setCodigo("002");
			resp.setRespuesta("Error al actualizar el login");
			return resp;
		}
	}
	@Override
	public Object reporte(String format) throws FileNotFoundException, JRException {
		List<UsuarioVO> lista = this.findAll();
    	String path = "C://Users//jefer//Downloads";
    	File file = ResourceUtils.getFile("classpath:reportes/listaUsuarios.jrxml");
    	JasperReport jasper = JasperCompileManager.compileReport(file.getAbsolutePath());
    	JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(lista);
    	
    	Map<String, Object> parameters = new HashMap<String, Object>();
    	parameters.put("gain java", "Knowledge");
    	
    	JasperPrint jasperPrint = JasperFillManager.fillReport(jasper,parameters, ds);
    	
    	if(format.equalsIgnoreCase("html")) {
    		JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "//listaUsuarios.html");
    	}
    	if(format.equalsIgnoreCase("pdf")) {
    		JasperExportManager.exportReportToPdfFile(jasperPrint, path + "//listaUsuarios.pdf" );
    	}
		return null;
	}
}
