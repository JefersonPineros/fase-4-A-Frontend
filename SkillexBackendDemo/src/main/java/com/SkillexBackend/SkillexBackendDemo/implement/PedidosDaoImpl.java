/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SkillexBackend.SkillexBackendDemo.implement;

import com.SkillexBackend.SkillexBackendDemo.dao.PedidosDao;
import com.SkillexBackend.SkillexBackendDemo.vo.ListarPedidosVO;
import com.SkillexBackend.SkillexBackendDemo.vo.PedidosVO;
import com.SkillexBackend.SkillexBackendDemo.vo.ProductosVO;
import com.SkillexBackend.SkillexBackendDemo.vo.RespuestaOperaciones;
import com.SkillexBackend.SkillexBackendDemo.vo.UsuarioVO;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.springframework.stereotype.Service;

/**
 *
 * @author jefer
 */
@Service
public class PedidosDaoImpl implements PedidosDao {

    private EntityManagerFactory emf;

    @Override
    public Object create(PedidosVO pedido) {
        List<ProductosVO> proPedido = new ArrayList<ProductosVO>();
        proPedido = pedido.getProducto();

        Integer idDetalle = null;
        Integer idPedido = null;
        String mesa = "";

        RespuestaOperaciones resp = new RespuestaOperaciones();
        emf = Persistence.createEntityManagerFactory("com.miUnidadDePersistencia");
        try {
            //Primer insert

            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            String sql = "Insert into detallepedido(valorApagar,fecha_pedido) values(:valor , :fecha) ";
            Query query = em.createNativeQuery(sql);
            query.setParameter("valor", pedido.getValorApagar());
            query.setParameter("fecha", pedido.getFechaPedido());
            query.executeUpdate();
            em.getTransaction().commit();
            em.close();

            //Integer lastDetalle = metodos.contsultarUltimoID("detallepedido", "iddetallePedido", "valorApagar");
            //Consultar ultimo Id
            EntityManager auxiliar = emf.createEntityManager();
            auxiliar.getTransaction().begin();
            String sql5 = "Select iddetallePedido, valorApagar from detallepedido order by iddetallePedido desc limit 1";
            Query query5 = auxiliar.createNativeQuery(sql5);

            List<Object[]> lista = query5.getResultList();
            Iterator it = lista.iterator();
            while (it.hasNext()) {
                Object[] line = (Object[]) it.next();
                idDetalle = (Integer) line[0];
                mesa = (String) line[1];
            }
            auxiliar.close();
            //Segundo Insert
            EntityManager em2 = emf.createEntityManager();
            em2.getTransaction().begin();

            String sql2 = "Insert into pedidos(estadoPedido,mesa, numeroPedido, detallePedido_iddetallePedido, Usuario_idUsuarios, estado_pedido_ID) values(:estadoPedido,:mesa,:numeroPedido , :detallePedido_iddetallePedido, :Usuario_idUsuarios, :estado_pedido_ID)";
            Query query2 = em2.createNativeQuery(sql2);
            query2.setParameter("mesa", pedido.getMesa());
            query2.setParameter("detallePedido_iddetallePedido", idDetalle);
            query2.setParameter("Usuario_idUsuarios", pedido.getIdUsuario());
            query2.setParameter("estado_pedido_ID", pedido.getIdEstadoPedido());
            query2.setParameter("estadoPedido", pedido.getEstadoPedidos());
            query2.setParameter("numeroPedido", "2");
            query2.executeUpdate();
            em2.getTransaction().commit();
            em2.close();
            // Consultar pedido 

            EntityManager auxiliar2 = emf.createEntityManager();
            auxiliar2.getTransaction().begin();

            String sql6 = "Select idPedidos, mesa from pedidos order by idPedidos desc limit 1";
            Query query6 = auxiliar2.createNativeQuery(sql6);

            List<Object[]> lista2 = query6.getResultList();
            Iterator it2 = lista2.iterator();
            while (it2.hasNext()) {
                Object[] line = (Object[]) it2.next();
                idPedido = (Integer) line[0];
                mesa = (String) line[1];
            }
            auxiliar2.close();
            //Tercer insert
            //Integer lastPedido = (Integer) metodos.contsultarUltimoID("pedidos", "idPedidos", "mesa");

            EntityManager em3 = emf.createEntityManager();
            em3.getTransaction().begin();
            String sql3 = "Insert into pedidos_has_pedidos values(:usuario,:pedido)";
            Query query3 = em3.createNativeQuery(sql3);
            query3.setParameter("pedido", idPedido);
            query3.setParameter("usuario", pedido.getIdUsuario());
            query3.executeUpdate();
            em3.getTransaction().commit();
            em3.close();
            //Cuarto insert 

            for (ProductosVO pro : proPedido) {
                EntityManager em4 = emf.createEntityManager();
                em4.getTransaction().begin();
                String sql4 = "Insert into pedidos_has_productos values(:pedido,:producto,:cantidad)";
                Query query4 = em4.createNativeQuery(sql4);
                query4.setParameter("pedido", idPedido);
                query4.setParameter("producto", pro.getIdProductos());
                query4.setParameter("cantidad", pro.getCantidadProducto());
                query4.executeUpdate();
                em4.getTransaction().commit();
                em4.close();
            }
            resp.setCodigo("001");
            resp.setRespuesta("OK");
            return resp;
        } catch (Exception e) {
            System.out.println(e.toString());
            resp.setCodigo("002");
            resp.setRespuesta("No se pudo realizar el pedido");
            return resp;
        }
    }

    @Override
    public List<PedidosVO> getPedidos() {
        emf = Persistence.createEntityManagerFactory("com.miUnidadDePersistencia");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        List<ListarPedidosVO> LPVO = new ArrayList<ListarPedidosVO>();
        ListarPedidosVO almacenarPedidos = new ListarPedidosVO();
        List<PedidosVO> listadoPedidos = new ArrayList<PedidosVO>();
        PedidosVO pedido = new PedidosVO();
        UsuarioVO usuario = new UsuarioVO();
        List<ProductosVO> listaProductos = new ArrayList<ProductosVO>();
        ProductosVO productos = new ProductosVO();
        try {
            String sql = "SELECT "
                    + "p.idPedidos,"
                    + "p.estadoPedido,"
                    + "p.mesa,"
                    + "dp.iddetallePedido,"
                    + "dp.valorApagar,"
                    + "dp.producto,"
                    + "dp.cantidadProducto,"
                    + "dp.fecha_pedido,"
                    + "ep.id_Estado_pedido,"
                    + "ep.State_id,"
                    + "ep.descripcion,"
                    + "php.cantidad_producto_pedido,"
                    + "pr.id_productos,"
                    + "pr.nombre_producto,"
                    + "pr.codigo_producto,"
                    + "pr.estado_producto,"
                    + "pr.cantidad_producto,"
                    + "pr.fecha_ingreso,"
                    + "dpr.id_detalle_productos,"
                    + "dpr.valor_inicial,"
                    + "dpr.valor_mas_iva,"
                    + "dpr.descripcion_producto,"
                    + "dpr.nombre_imagen,"
                    + "dpr.url_imagen,"
                    + "u.idUsuarios,"
                    + "u.nombreUsuario,"
                    + "u.apellidoUsuario,"
                    + "u.emailUsuario,"
                    + "u.passwordUsuario,"
                    + "u.tienda,"
                    + "u.creacion_usuario,"
                    + "u.fecha_login,"
                    + "u.turnos_laborales,"
                    + "u.cedula_ciudadania "
                    + "FROM skillexbd.pedidos p "
                    + "JOIN detallepedido dp ON p.detallePedido_iddetallePedido = dp.iddetallePedido "
                    + "JOIN estado_pedido ep ON p.estado_pedido_ID = ep.id_Estado_pedido "
                    + "JOIN pedidos_has_productos php ON p.idPedidos = php.pedidos_idPedidos "
                    + "join productos pr ON pr.id_productos = php.productos_id_productos "
                    + "join detalle_productos dpr ON dpr.productos_id_productos = pr.id_productos "
                    + "JOIN pedidos_has_pedidos phu ON  p.idPedidos = phu.Pedidos_idPedidos "
                    + "JOIN usuario u ON u.idUsuarios = phu.Pedidos_idUsuarios ORDER by dp.fecha_pedido desc;";
            Query query = em.createNativeQuery(sql);

            List<Object[]> lista = query.getResultList();
            Iterator it = lista.iterator();
            while (it.hasNext()) {
                Object[] line = (Object[]) it.next();
                Integer idPedidos = (Integer) line[0];
                String estadoPedido = (String) line[1];
                String mesa = (String) line[2];
                Integer iddetallePedido = (Integer) line[3];
                Integer valorApagar = (Integer) line[4];
                String producto = (String) line[5];
                Integer cantidadProducto = (Integer) line[6];
                Date fecha_pedido = (Date) line[7];
                Integer Id_Estado_pedido = (Integer) line[8];
                Integer State_id = (Integer) line[9];
                String descripcion = (String) line[10];
                Integer cantidad_producto_pedido = (Integer) line[11];
                Integer id_productos = (Integer) line[12];
                String nombre_producto = (String) line[13];
                String codigo_producto = (String) line[14];
                String estado_producto = (String) line[15];
                Integer cantidad_producto = (Integer) line[16];
                Date fecha_ingreso = (Date) line[17];
                Integer id_detalle_productos = (Integer) line[18];
                Integer valor_inicial = (Integer) line[19];
                Integer valor_mas_iva = (Integer) line[20];
                String descripcion_producto = (String) line[21];
                String nombre_imagen = (String) line[22];
                String url_imagen = (String) line[23];
                Integer idUsuarios = (Integer) line[24];
                String nombreUsuario = (String) line[25];
                String apellidoUsuario = (String) line[26];
                String emailUsuario = (String) line[27];
                String passwordUsuario = (String) line[28];
                String tienda = (String) line[29];
                Date creacion_usuario = (Date) line[30];
                String fecha_login = (String) line[31];
                String turnos_laborales = (String) line[32];
                String cedula_ciudadania = (String) line[33];

                almacenarPedidos = new ListarPedidosVO(idPedidos, estadoPedido, mesa, iddetallePedido, valorApagar, producto, cantidadProducto, fecha_pedido, Id_Estado_pedido, State_id, descripcion, cantidad_producto_pedido, id_productos, nombre_producto, codigo_producto, estado_producto, cantidad_producto, fecha_ingreso, id_detalle_productos, valor_inicial, valor_mas_iva, descripcion_producto, nombre_imagen, url_imagen, idUsuarios, nombreUsuario, apellidoUsuario, emailUsuario, passwordUsuario, tienda, creacion_usuario, fecha_login, turnos_laborales, cedula_ciudadania);
                LPVO.add(almacenarPedidos);
            }
            if (LPVO.size() > 0) {
                for (ListarPedidosVO itemTraidos : LPVO) {
                    if (listadoPedidos.size() > 0) {
                        Integer idPedido = null;
                        for (PedidosVO itemP : listadoPedidos) {
                            if (itemP.getIdPedidos() == itemTraidos.getIdPedidos()) {
                                idPedido = itemTraidos.getIdPedidos();
                            }
                        }
                        if (idPedido != null) {
                            for (PedidosVO itemP : listadoPedidos) {
                                if (itemP.getIdPedidos() == idPedido) {
                                    productos = new ProductosVO(itemTraidos.getId_productos(), itemTraidos.getNombre_producto(), "", itemTraidos.getCodigo_producto(), itemTraidos.getEstado_producto(), itemTraidos.getCantidad_producto_pedido(), itemTraidos.getFecha_ingreso(), itemTraidos.getId_detalle_productos(), itemTraidos.getValor_inicial(), itemTraidos.getValor_mas_iva(), itemTraidos.getDescripcion_producto(), "", itemTraidos.getNombre_imagen(), itemTraidos.getUrl_imagen(), null, "", null, "", "");
                                    List<ProductosVO> agregar = itemP.getProducto();
                                    agregar.add(productos);
                                    itemP.setProducto(agregar);
                                    productos = new ProductosVO();
                                    agregar = new ArrayList<ProductosVO>();
                                }
                            }
                        } else {
                            pedido = new PedidosVO(itemTraidos.getIdPedidos(), itemTraidos.getEstadoPedido(), itemTraidos.getMesa(), itemTraidos.getIddetallePedido(), itemTraidos.getIdUsuarios(), itemTraidos.getId_Estado_pedido(), itemTraidos.getValorApagar(), itemTraidos.getFecha_pedido(), null, null);
                            usuario = new UsuarioVO(itemTraidos.getIdUsuarios(), itemTraidos.getNombreUsuario(), itemTraidos.getApellidoUsuario(), itemTraidos.getEmailUsuario(), "", itemTraidos.getTienda(), itemTraidos.getCreacion_usuario(), itemTraidos.getFecha_login(), itemTraidos.getTurnos_laborales(), itemTraidos.getCedula_ciudadania(), null, null);
                            pedido.setUsuario(usuario);
                            productos = new ProductosVO(itemTraidos.getId_productos(), itemTraidos.getNombre_producto(), "", itemTraidos.getCodigo_producto(), itemTraidos.getEstado_producto(), itemTraidos.getCantidad_producto_pedido(), itemTraidos.getFecha_ingreso(), itemTraidos.getId_detalle_productos(), itemTraidos.getValor_inicial(), itemTraidos.getValor_mas_iva(), itemTraidos.getDescripcion_producto(), "", itemTraidos.getNombre_imagen(), itemTraidos.getUrl_imagen(), null, "", null, "", "");
                            listaProductos.add(productos);
                            pedido.setProducto(listaProductos);
                            listadoPedidos.add(pedido);
                            productos = new ProductosVO();
                            usuario = new UsuarioVO();
                            listaProductos = new ArrayList<ProductosVO>();
                        }
                    } else {
                        pedido = new PedidosVO(itemTraidos.getIdPedidos(), itemTraidos.getEstadoPedido(), itemTraidos.getMesa(), itemTraidos.getIddetallePedido(), itemTraidos.getIdUsuarios(), itemTraidos.getId_Estado_pedido(), itemTraidos.getValorApagar(), itemTraidos.getFecha_pedido(), null, null);
                        usuario = new UsuarioVO(itemTraidos.getIdUsuarios(), itemTraidos.getNombreUsuario(), itemTraidos.getApellidoUsuario(), itemTraidos.getEmailUsuario(), "", itemTraidos.getTienda(), itemTraidos.getCreacion_usuario(), itemTraidos.getFecha_login(), itemTraidos.getTurnos_laborales(), itemTraidos.getCedula_ciudadania(), null, null);
                        pedido.setUsuario(usuario);
                        productos = new ProductosVO(itemTraidos.getId_productos(), itemTraidos.getNombre_producto(), "", itemTraidos.getCodigo_producto(), itemTraidos.getEstado_producto(), itemTraidos.getCantidad_producto_pedido(), itemTraidos.getFecha_ingreso(), itemTraidos.getId_detalle_productos(), itemTraidos.getValor_inicial(), itemTraidos.getValor_mas_iva(), itemTraidos.getDescripcion_producto(), "", itemTraidos.getNombre_imagen(), itemTraidos.getUrl_imagen(), null, "", null, "", "");
                        listaProductos.add(productos);
                        pedido.setProducto(listaProductos);
                        listadoPedidos.add(pedido);
                        listaProductos = new ArrayList<ProductosVO>();
                        productos = new ProductosVO();
                    }
                }
                return listadoPedidos;
            } else {
                return null;
            }

        } catch (Exception e) {
            System.out.println(e.toString());
            return null;
        }
    }

    @Override
    public PedidosVO getPedido(Integer idPedido) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object procesar(Integer idEstado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
