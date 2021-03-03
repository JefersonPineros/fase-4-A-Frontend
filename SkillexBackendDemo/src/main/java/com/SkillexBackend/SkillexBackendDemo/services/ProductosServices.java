/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SkillexBackend.SkillexBackendDemo.services;

import com.SkillexBackend.SkillexBackendDemo.dao.ProductosDao;
import com.SkillexBackend.SkillexBackendDemo.models.Inventario;
import com.SkillexBackend.SkillexBackendDemo.models.Productos;
import com.SkillexBackend.SkillexBackendDemo.vo.InventarioVO;
import com.SkillexBackend.SkillexBackendDemo.vo.ProductosCrearVO;
import com.SkillexBackend.SkillexBackendDemo.vo.ProductosVO;
import com.SkillexBackend.SkillexBackendDemo.vo.RespuestaOperaciones;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
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
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author jefer
 */
@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT,RequestMethod.OPTIONS})
public class ProductosServices {

	@Autowired
	private ProductosDao productosDao;

	// crear nuevo producto
	@PostMapping
	public ResponseEntity<?> create(@RequestBody ProductosCrearVO producto) {
        Object resp = productosDao.save(producto);
        if(resp != null){
            return ResponseEntity.ok(resp);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

	// Read productos
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable Integer id) {

		try {
			Optional<Productos> oProducto = productosDao.findById(id);

			Productos productos = oProducto.get();
			ProductosVO inventarioVo = new ProductosVO(productos.getIdProductos(), productos.getNombreProducto(),
					productos.getNombreProductoIn(), productos.getCodigoProducto(), productos.getEstadoProducto(),
					productos.getCantidadProducto(), productos.getFechaIngreso(), null, 0, 0, "", "", "", "", null, "",
					null, "", "");
			return ResponseEntity.ok(inventarioVo);

		} catch (Exception e) {
			System.out.println(e.toString());
			return ResponseEntity.notFound().build();
		}

	}

	// Listar todos los productos
	@GetMapping()
	public ResponseEntity<?> readAll() {
		List<ProductosVO> list = productosDao.mostrar_productos();
		if (list.size() > 0) {
			return ResponseEntity.ok(list);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping("/actualizar/")
	public ResponseEntity<?> updateProducto(@RequestBody ProductosVO producto) {
		Object respuesta = productosDao.updateProducto(producto);
		if (respuesta != null) {
			return ResponseEntity.ok(respuesta);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/reporte/{formato}")
	public ResponseEntity<?> exportReport(@PathVariable String formato) throws FileNotFoundException, JRException {
		try {
			Object respuesta = productosDao.reporte("pdf");
			return (ResponseEntity<?>) ResponseEntity.ok(respuesta);
		} catch (UnknownError e) {
			System.out.println(e);
			return (ResponseEntity<?>) ResponseEntity.notFound();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminarProducto(@PathVariable Integer id) {
		try {
			Object respuesta = productosDao.deleteById(id);
			return ResponseEntity.ok(respuesta);
		} catch (Exception e) {
			return (ResponseEntity<?>) ResponseEntity.notFound();
		}

	}
}
