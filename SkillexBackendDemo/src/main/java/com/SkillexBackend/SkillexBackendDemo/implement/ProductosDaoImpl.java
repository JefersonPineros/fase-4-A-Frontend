/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SkillexBackend.SkillexBackendDemo.implement;

import com.SkillexBackend.SkillexBackendDemo.controllers.Controllers;
import com.SkillexBackend.SkillexBackendDemo.dao.ProductosDao;
import com.SkillexBackend.SkillexBackendDemo.models.Productos;
import com.SkillexBackend.SkillexBackendDemo.repository.ProductosRepository;
import com.SkillexBackend.SkillexBackendDemo.vo.ProductosCrearVO;
import com.SkillexBackend.SkillexBackendDemo.vo.ProductosVO;
import com.SkillexBackend.SkillexBackendDemo.vo.RespuestaOperaciones;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jefer
 */
@Service
public class ProductosDaoImpl implements ProductosDao {
    private String upload_imagen = ".//src//main//resource//imagenes//";
    private EntityManagerFactory emf;
    @Autowired
    private ProductosRepository productosRespository;
    Controllers imagenCreate = new Controllers();
    @Override
    @Transactional(readOnly = true)
    //SERVICIO LISTAR PRODUCTOS
    public List<ProductosVO> mostrar_productos() {
        
        ProductosVO pro = new ProductosVO();
        List<ProductosVO> responseProductos = new ArrayList<ProductosVO>();

        // emf = Persistence.createEntityManagerFactory("com.miUnidadDePersistencia");
        emf = Persistence.createEntityManagerFactory("com.miUnidadDePersistencia");

        try {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            String sql = "SELECT p.id_productos,"
                    + "p.nombre_producto,"
                    + "p.nombre_producto_in,"
                    + "p.codigo_producto,"
                    + "p.estado_producto,"
                    + "p.cantidad_producto,"
                    + "p.fecha_ingreso,"
                    + "dp.id_detalle_productos,"
                    + "dp.valor_inicial,"
                    + "dp.valor_mas_iva,"
                    + "dp.descripcion_producto,"
                    + "dp.descripcion_producto_in,"
                    + "dp.url_imagen,"
                    + "cp.id_categoria_producto,"
                    + "cp.tipo_categoria "
                    + "FROM productos p "
                    + "JOIN detalle_productos dp ON p.id_productos = dp.productos_id_productos "
                    + "JOIN categoria_producto cp on p.categoria_producto_id_categoria_producto = cp.id_categoria_producto ";

            Query query = em.createNativeQuery(sql);
            List<Object[]> listOb = query.getResultList();

            if (listOb.size() > 0) {

                Iterator it = listOb.iterator();
                while (it.hasNext()) {
                    Object[] line = (Object[]) it.next();
                    Integer id_productos = (Integer) line[0];
                    String nombre_producto = (String) line[1];
                    String nombre_producto_in = (String) line[2];
                    String codigo_producto = (String) line[3];
                    String estado_producto = (String) line[4];
                    Integer cantidad_producto = (Integer) line[5];
                    Date fecha_ingreso = (Date) line[6];
                    Integer id_detalle_productos = (Integer) line[7];
                    Integer valor_inicial = (Integer) line[8];
                    Integer valor_mas_iva = (Integer) line[9];
                    String descripcion_producto = (String) line[10];
                    String descripcion_producto_in = (String) line[11];
                    String url_imagen = (String) line[12];
                    Integer id_categoria_producto = (Integer) line[13];
                    String tipo_categoria = (String) line[14];

                    pro = new ProductosVO(id_productos, nombre_producto, nombre_producto_in, codigo_producto, estado_producto, cantidad_producto, fecha_ingreso, id_detalle_productos, valor_inicial, valor_mas_iva, descripcion_producto, descripcion_producto_in, url_imagen, id_categoria_producto, tipo_categoria, null, "", "");
                    responseProductos.add(pro);
                    pro = new ProductosVO();
                }
                return responseProductos;
            } else {
                return responseProductos;
            }

        } catch (Exception e) {
            System.out.println(e.toString());
            return responseProductos;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Productos> findAll(Pageable pageable) {
        return productosRespository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    //BUSCAR PRODUCTO POR ID
    public Optional<Productos> findById(Integer id) {

        return productosRespository.findById(id);
    }

    @Override
    @Transactional
    //SERVICIO CREAR PRODUCTOS
    public Object save(ProductosCrearVO producto) {
        Integer id_Productos = 0;
        emf = Persistence.createEntityManagerFactory("com.miUnidadDePersistencia");
        RespuestaOperaciones resp = new RespuestaOperaciones();
        
        producto.setUrl_imagen(this.imagenCreate.convertirImagen(producto.getUrl_imagen(), producto.getDescripcion_producto_in()));
        
        EntityManager emd = emf.createEntityManager();
        emd.getTransaction().begin();
        
        String sql2 = "select id_Productos, codigo_producto  from productos where codigo_producto = :codigo";
        Query queryConsulta = emd.createNativeQuery(sql2);
        queryConsulta.setParameter("codigo", producto.getCodigoProducto());
        List<Object[]> listP = queryConsulta.getResultList();
        Iterator it = listP.iterator();
        while (it.hasNext()) {
            Object[] line = (Object[]) it.next();
            id_Productos = (Integer) line[0];
            String ft = (String) line[1];
        }

        if (id_Productos == 0) {
            try {
                EntityManager emt = emf.createEntityManager();
                emt.getTransaction().begin();
                String sql = "insert into productos(nombre_producto,nombre_producto_in,codigo_producto,estado_producto,cantidad_producto,fecha_ingreso,inventario_id_inventario,categoria_producto_id_categoria_producto)"
                        + "values(:nombre_producto, :nombre_producto_in, :codigo_producto, :estado_producto, :cantidad_producto, :fecha_ingreso, :inventario_id_inventario, :categoria_producto_id_categoria_producto)";
                Query query = emt.createNativeQuery(sql);
                query.setParameter("nombre_producto", producto.getNombreProducto());
                query.setParameter("nombre_producto_in", producto.getNombreProductoIn());
                query.setParameter("codigo_producto", producto.getCodigoProducto());
                query.setParameter("estado_producto", producto.getEstadoProducto());
                query.setParameter("cantidad_producto", producto.getCantidadProducto());
                query.setParameter("fecha_ingreso", producto.getFechaIngreso());
                query.setParameter("inventario_id_inventario", producto.getInventario_id_inventario());
                query.setParameter("categoria_producto_id_categoria_producto", producto.getCategoria_producto_id_categoria_producto());

                query.executeUpdate();
                emt.getTransaction().commit();

                // buscar producto Creado
                EntityManager emD2 = emf.createEntityManager();
                emD2.getTransaction().begin();

                String sql4 = "select id_Productos, codigo_producto from productos where codigo_producto = :codigo";
                Query query3 = emD2.createNativeQuery(sql4);
                query3.setParameter("codigo", producto.getCodigoProducto());
                List<Object[]> listP1 = query3.getResultList();
                Iterator it2 = listP1.iterator();
                while (it2.hasNext()) {
                    Object[] line = (Object[]) it2.next();
                    id_Productos = (Integer) line[0];
                    String ft = (String) line[1];

                }
                EntityManager emD1 = emf.createEntityManager();
                emD1.getTransaction().begin();
                String sql3 = "insert into detalle_productos(descripcion_producto,descripcion_producto_in,valor_inicial,valor_mas_iva,productos_id_productos,url_imagen)"
                        + "values(:descripcion_producto, :descripcion_producto_in, :valor_inicial, :valor_mas_iva, :productos_id_productos, :url_imagen)";
                Query query2 = emD1.createNativeQuery(sql3);
                query2.setParameter("descripcion_producto", producto.getDescripcion_producto());
                query2.setParameter("descripcion_producto_in", producto.getDescripcion_producto_in());
                query2.setParameter("valor_inicial", producto.getValor_inicial());
                double valorIva = producto.getValor_inicial() + (producto.getValor_inicial() * 0.16);
                query2.setParameter("valor_mas_iva",(float) valorIva);
                query2.setParameter("productos_id_productos", id_Productos);
                query2.setParameter("url_imagen", producto.getUrl_imagen());

                query2.executeUpdate();
                emD1.getTransaction().commit();
                emD1.close();

                resp.setCodigo("001");
                resp.setRespuesta("Producto creado");
                return resp;
            } catch (Exception e) {
                System.err.println(e.toString());
                resp.setCodigo("002");
                resp.setRespuesta("Error al crear un producto");
                return resp;
            }
        } else {
            resp.setCodigo("003");
            resp.setRespuesta("Error, el código del producto ya existe");
            return resp;
        }

    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        productosRespository.deleteById(id);
    }

    public void ProductoDAO() {
        emf = Persistence.createEntityManagerFactory("com.SkillexBackend_SkillexBackendDemo_jar_0.0.1-SNAPSHOTPU");
    }

    @Override
    public Object updateProducto(ProductosVO producto) {
        ProductosVO proUp = producto;
        RespuestaOperaciones resp = new RespuestaOperaciones();
        if (proUp.getIdProductos() != null) {
            emf = Persistence.createEntityManagerFactory("com.miUnidadDePersistencia");
            EntityManager emd = emf.createEntityManager();
            emd.getTransaction().begin();
            try {
                //Update a productos
                String sql = "update productos "
                        + "set nombre_producto = :nombre, "
                        + "cantidad_producto = :cantidad, "
                        + "categoria_producto_id_categoria_producto = :categoria "
                        + "where id_productos = :idPro";
                Query query = emd.createNativeQuery(sql);
                
                query.setParameter("nombre", proUp.getNombreProducto());
                query.setParameter("cantidad", proUp.getCantidadProducto());
                query.setParameter("categoria", proUp.getId_categoria_producto());
                query.setParameter("idPro", proUp.getIdProductos());
                query.executeUpdate();
                emd.getTransaction().commit();
                
                //Update a detalles de productos
            EntityManager emd2 = emf.createEntityManager();
            emd2.getTransaction().begin();

                String sql2 = "Update detalle_productos "
                        + "set descripcion_producto = :descripcion, "
                        + "valor_inicial = :valorInicial, "
                        + "valor_mas_iva = :valorIva, "
                        + "url_imagen = :url "
                        + "where productos_id_productos = :proId";
                Query query2 = emd2.createNativeQuery(sql2);
                query2.setParameter("descripcion", proUp.getDescripcion_producto());
                query2.setParameter("valorInicial", proUp.getValor_inicial());
                double valIva = proUp.getValor_inicial() + (proUp.getValor_inicial() * 0.16);
                
                query2.setParameter("valorIva", (Integer) Math.round((float) valIva));
                query2.setParameter("url", proUp.getUrl_imagen());
                query2.setParameter("proId",proUp.getIdProductos());
                
                query2.executeUpdate();
                emd2.getTransaction().commit();
                emd2.close();
                
                resp.setCodigo("001");
                resp.setRespuesta("Producto actualizado");
                return resp;
            } catch (Exception e) {
                System.out.println(e.toString());
                return null;
            }

        } else {
            return null;
        }
    }
}
