package com.SkillexBackend.SkillexBackendDemo.implement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.SkillexBackend.SkillexBackendDemo.controllers.Controllers;
import com.SkillexBackend.SkillexBackendDemo.dao.IMusicaDao;
import com.SkillexBackend.SkillexBackendDemo.vo.AlbumVO;
import com.SkillexBackend.SkillexBackendDemo.vo.CancionVO;
import com.SkillexBackend.SkillexBackendDemo.vo.RespuestaOperaciones;
import com.SkillexBackend.SkillexBackendDemo.vo.Solicitudes;

@Service
public class MusicaDaoImpl implements IMusicaDao {
	private EntityManagerFactory emf;
	RespuestaOperaciones respuestas = new RespuestaOperaciones();

	Controllers imagenCreate = new Controllers();

	@Override
	public Object crearAlbum(AlbumVO album) {

		Integer idAlbum = null;
		emf = Persistence.createEntityManagerFactory("com.miUnidadDePersistencia");
		album.setUrlImagen(this.imagenCreate.convertirImagen(album.getUrlImagen(), album.getNombreImagen(), 3));
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		try {
			String sql = "insert into album_musical(nombre_album,autor_album,Usuario_idUsuarios,genero_id_genero,nombre_imagen,url_imagen, activo) "
					+ "values (:nombreAl,:autorAL,:usuario,:genero,:nombreIm,:urlImagen,0)";
			Query query = em.createNativeQuery(sql);
			query.setParameter("nombreAl", album.getNombreAlbum());
			query.setParameter("autorAL", album.getAutorAlbum());
			query.setParameter("usuario", album.getUsuarioId());
			query.setParameter("genero", album.getGeneroId());
			query.setParameter("nombreIm", album.getNombreImagen());
			query.setParameter("urlImagen", album.getUrlImagen());

			query.executeUpdate();
			em.getTransaction().commit();

			EntityManager em2 = emf.createEntityManager();
			em2.getTransaction().begin();
			String sql2 = "Select id_album_musical, autor_album  from album_musical where nombre_album = :nombre order by id_album_musical desc limit 1";
			Query query2 = em2.createNativeQuery(sql2);
			query2.setParameter("nombre", album.getNombreAlbum());

			List<Object[]> listId = query2.getResultList();

			if (!listId.isEmpty()) {
				Iterator it = listId.iterator();

				while (it.hasNext()) {
					Object[] line = (Object[]) it.next();
					idAlbum = (Integer) line[0];
				}
			}
			if (!album.canciones.isEmpty()) {
				if (idAlbum != null || idAlbum != 0) {
					String sql3 = "insert into cancion(nombre_cancion,duracion,album_musical_id) values";

					CancionVO[] item = album.canciones.toArray(new CancionVO[0]);
					for (int i = 0; i < album.canciones.size(); i++) {

						if (i == (album.canciones.size() - 1)) {
							sql3 = sql3 + "(" + (char) 34 + item[i].getNombreCancion() + (char) 34 + "," + (char) 34
									+ item[i].getDuracion() + (char) 34 + "," + idAlbum + ")";
						} else {
							sql3 = sql3 + " (" + (char) 34 + item[i].getNombreCancion() + (char) 34 + "," + (char) 34
									+ item[i].getDuracion() + (char) 34 + "," + idAlbum + "),";
						}
					}
					System.out.println(sql3);

					EntityManager em3 = emf.createEntityManager();
					em3.getTransaction().begin();

					Query query3 = em3.createNativeQuery(sql3);
					query3.executeUpdate();
					em3.getTransaction().commit();
				}

			}

			this.respuestas = new RespuestaOperaciones();
			this.respuestas.setCodigo("001");
			this.respuestas.setRespuesta("Album creado correctamente");
			return this.respuestas;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<AlbumVO> listarAlbum() {

		AlbumVO albumes = new AlbumVO();
		CancionVO cancion = new CancionVO();
		List<AlbumVO> listaAl = new ArrayList<AlbumVO>();

		emf = Persistence.createEntityManagerFactory("com.miUnidadDePersistencia");

		try {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();

			String sql = "select * from album_musical where activo = 0";
			Query query = em.createNativeQuery(sql);

			List<Object> listaAlbumes = query.getResultList();

			if (listaAlbumes.size() > 0) {
				Iterator it = listaAlbumes.iterator();
				while (it.hasNext()) {
					Object[] line = (Object[]) it.next();
					albumes.setId((Integer) line[0]);
					albumes.setNombreAlbum((String) line[1]);
					albumes.setAutorAlbum((String) line[2]);
					albumes.setUsuarioId((Integer) line[3]);
					albumes.setGeneroId((Integer) line[4]);
					albumes.setNombreImagen((String) line[5]);
					albumes.setUrlImagen((String) line[6]);
					albumes.setActivo((Integer) line[7]);

					EntityManager em2 = emf.createEntityManager();
					em2.getTransaction().begin();

					String sql2 = "select * from cancion where cancion.album_musical_id = :idAlbum";
					Query query2 = em2.createNativeQuery(sql2);
					query2.setParameter("idAlbum", albumes.getId());

					List<Object> listaCanciones = query2.getResultList();
					if (listaCanciones.size() > 0) {
						albumes.canciones = new ArrayList<CancionVO>();

						Iterator it2 = listaCanciones.iterator();
						while (it2.hasNext()) {
							Object[] line2 = (Object[]) it2.next();

							cancion.setId((Integer) line2[0]);
							cancion.setNombreCancion((String) line2[1]);
							cancion.setDuracion((String) line2[3]);

							albumes.canciones.add(cancion);
							cancion = new CancionVO();
						}
					}
					listaAl.add(albumes);
					albumes = new AlbumVO();
				}
				return listaAl;
			} else {
				return null;
			}
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public Object eliminarAlbum(Integer id) {
		// TODO Auto-generated method stub
		emf = Persistence.createEntityManagerFactory("com.miUnidadDePersistencia");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		try {
			String sql = "UPDATE album_musical SET activo = 1 WHERE id_album_musical = :id";
			Query query = em.createNativeQuery(sql);
			query.setParameter("id", id);
			query.executeUpdate();
			em.getTransaction().commit();

			this.respuestas = new RespuestaOperaciones();
			this.respuestas.setCodigo("001");
			this.respuestas.setRespuesta("Album eliminado correctamente");
			return this.respuestas;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public AlbumVO actualizarAlbum(AlbumVO album) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object solicitarCancion(String mesa, Integer idUsuario, Integer idCancion) {
		emf = Persistence.createEntityManagerFactory("com.miUnidadDePersistencia");
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Integer idSolicitudFinal = null;
		try {
			String sql = "Insert into usuariomusica(mesa_cancion, estado) values (:mesa,:estado)";
			Query query = em.createNativeQuery(sql);
			query.setParameter("mesa", mesa);
			query.setParameter("estado", 0);
			
			query.executeUpdate();
			em.getTransaction().commit();
			
			EntityManager em2 = emf.createEntityManager();
			em2.getTransaction().begin();
			
			String sql2 = "Select idusuarioMusica, mesa_cancion from usuariomusica order by idusuarioMusica desc limit 1";
			Query query2 = em2.createNativeQuery(sql2);
			
			List<Object[]> idSolicitud = query2.getResultList();
			if (!idSolicitud.isEmpty()) {
				Iterator it = idSolicitud.iterator();
				
				while (it.hasNext()) {
					Object[] line = (Object[]) it.next();
					idSolicitudFinal = (Integer) line[0];
				}
			}
			if (idSolicitudFinal != null || idSolicitudFinal > 0) {
				if (idUsuario > 0 && idCancion > 0) {
					EntityManager em3 = emf.createEntityManager();
					em3.getTransaction().begin();
					
					String sql3 = "Insert into cancion_has_usuariomusica Values (:idCancion, :idUsuarioMusica)";
					Query query3 = em3.createNativeQuery(sql3);
					query3.setParameter("idCancion", idCancion);
					query3.setParameter("idUsuarioMusica", idSolicitudFinal);
					
					query3.executeUpdate();
					em3.getTransaction().commit();
					
					EntityManager em4 = emf.createEntityManager();
					em4.getTransaction().begin();
					
					String sql4 = "insert into usuariomusica_has_usuario values(:idUsuarioMusica, :idUsuario)";
					Query query4 = em4.createNativeQuery(sql4);
					query4.setParameter("idUsuario", idUsuario);
					query4.setParameter("idUsuarioMusica", idSolicitudFinal);
					query4.executeUpdate();
					em4.getTransaction().commit();
					
					this.respuestas = new RespuestaOperaciones();
					this.respuestas.setCodigo("001");
					this.respuestas.setRespuesta("Solicitud exitosa");
					
					return this.respuestas;
				}else {
					return null;
				}
			}
			return null;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	@Override
	public Object procesarCancion(Boolean estado, Integer solicitud) {
		emf = Persistence.createEntityManagerFactory("com.miUnidadDePersistencia");
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		try {
			String sql = "UPDATE usuariomusica SET estado = :estado where idusuarioMusica = :idSolicitud";
			Query query = em.createNativeQuery(sql);
			
			if (estado) {
				query.setParameter("estado", 1);
				query.setParameter("idSolicitud", solicitud);
			}
			query.executeUpdate();
			em.getTransaction().commit();
			
			this.respuestas = new RespuestaOperaciones();
			this.respuestas.setCodigo("001");
			this.respuestas.setRespuesta("Estado actualizado correctamente");
			
			return this.respuestas;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Solicitudes> listarCancionesSolicitadas() {
		emf = Persistence.createEntityManagerFactory("com.miUnidadDePersistencia");
		Solicitudes solicitud = new Solicitudes();
		List<Solicitudes> listaSol = new ArrayList<Solicitudes>();
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		try {
			String sql = "select "
					+ "	sm.idusuarioMusica, "
					+ "	sm.mesa_cancion, "
					+ "    sm.estado, "
					+ "    cn.id_cancion, "
					+ "    cn.nombre_cancion, "
					+ "    cn.duracion, "
					+ "    us.idUsuarios, "
					+ "    us.nombreUsuario "
					+ "    from usuariomusica sm  "
					+ "JOIN usuariomusica_has_usuario smh ON sm.idusuarioMusica = smh.usuarioMusica_idusuarioMusica "
					+ "JOIN usuario us ON smh.Usuario_idUsuarios = us.idUsuarios "
					+ "JOIN cancion_has_usuariomusica chu ON chu.usuarioMusica_idusuarioMusica = sm.idusuarioMusica "
					+ "JOIN cancion cn ON cn.id_cancion = chu.cancion_id_cancion "
					+ "Where sm.estado = 0";
			Query query = em.createNativeQuery(sql);
			
			List<Object[]> listaSolicitudes = query.getResultList();
			
			if (!listaSolicitudes.isEmpty()) {
				Iterator it = listaSolicitudes.iterator();
				while (it.hasNext()) {
					Object[] line = (Object[]) it.next();
					solicitud.setIdSolicitud((Integer) line[0]);
					solicitud.setMesa((String) line[1]);
					if ((Integer) line[2] == 0) {						
						solicitud.setEstado(false);
					} else {
						solicitud.setEstado(true);
					}
					solicitud.setIdCancion((Integer) line[3]);
					solicitud.setNombreCancion((String) line[4]);
					solicitud.setDuracion((String) line[5]);
					solicitud.setIdUsuario((Integer) line[6]);
					solicitud.setNombreUsuario((String) line[7]);
					
					listaSol.add(solicitud);
					
					solicitud = new Solicitudes();
				}
			}
			return listaSol;
		} catch (Exception e) {
			return null;
		}
	}

}
