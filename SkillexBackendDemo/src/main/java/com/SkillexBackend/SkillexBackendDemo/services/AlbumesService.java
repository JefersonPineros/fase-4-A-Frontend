package com.SkillexBackend.SkillexBackendDemo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import com.SkillexBackend.SkillexBackendDemo.dao.IMusicaDao;
import com.SkillexBackend.SkillexBackendDemo.vo.AlbumVO;
import com.SkillexBackend.SkillexBackendDemo.vo.Solicitudes;

import net.bytebuddy.asm.Advice.Return;

@RestController
@RequestMapping("/api/albumes")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT,
		RequestMethod.OPTIONS })
public class AlbumesService {

	@Autowired
	private IMusicaDao musicaDao;

	@GetMapping
	public ResponseEntity<?> listarAlbumes() {
		List<AlbumVO> listaAlbum = musicaDao.listarAlbum();
		if (!listaAlbum.isEmpty()) {
			return new ResponseEntity<List<AlbumVO>>(listaAlbum, HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
		}
	}

	@PostMapping
	public ResponseEntity<?> crearAlbum(@RequestBody AlbumVO album) {
		Object resp = this.musicaDao.crearAlbum(album);
		if (resp != null) {
			return new ResponseEntity<Object>(resp, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminarAlbum(@PathVariable Integer id) {
		Object resp = this.musicaDao.eliminarAlbum(id);
		if (resp != null) {
			return new ResponseEntity<Object>(resp, HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
		}
	}

	@GetMapping("/solicitar/mesa={mesa}&idCancion={idCancion}&idUsuario={idUsuario}")
	public ResponseEntity<?> solicitarCancion(@PathVariable String mesa, @PathVariable Integer idCancion,
			@PathVariable Integer idUsuario) {
		Object resp = this.musicaDao.solicitarCancion(mesa, idUsuario, idCancion);
		if (resp != null) {
			return new ResponseEntity<Object>(resp,HttpStatus.OK); 
		} else {
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST); 
		}
	}
	
	@GetMapping("/actualizarSolicitud/estado={estado}&solicitud={idSolicitud}")
	public ResponseEntity<?> actualizarSolicitud(@PathVariable Boolean estado, @PathVariable Integer idSolicitud) {
		Object resp = this.musicaDao.procesarCancion(estado, idSolicitud);
		if (resp != null) {
			return new ResponseEntity<Object>(resp, HttpStatus.OK);
		} else { 
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/listarcancioncessolicitadas")
	public ResponseEntity<?> listarCancionesSolicitadas() {
		List<Solicitudes> lista = this.musicaDao.listarCancionesSolicitadas();
		if (!lista.isEmpty()) {
			return new ResponseEntity<List<Solicitudes>>(lista, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Solicitudes>>( HttpStatus.BAD_REQUEST);
		}
	}
}
