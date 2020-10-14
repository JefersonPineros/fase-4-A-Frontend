/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SkillexBackend.SkillexBackendDemo.implement.metodos;

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
public class MetodosAuxiliares {

    public MetodosAuxiliares() {
    }
    private EntityManagerFactory emf;

    public Integer contsultarUltimoID(String tabla,String valor1,String valor2) {
        Integer idPedido = null;
        Integer mesa = null;
        emf = Persistence.createEntityManagerFactory("com.miUnidadDePersistencia");
        
        if(emf.isOpen()){
            System.out.println("Persistencia abierta");
        }
        EntityManager auxiliar = emf.createEntityManager();
        //auxiliar.getTransaction().begin();
        try {
            String sql = "Select :dato1, :dato2 from :tabla order by :dato1 desc limit 1";
            Query query = auxiliar.createNativeQuery(sql);
            query.setParameter("dato1", valor1);
            query.setParameter("dato2", valor2);
            query.setParameter("tabla", tabla);
            
            List<Object[]> lista = query.getResultList();
            Iterator it = lista.iterator();
            while (it.hasNext()) {
                Object[] line = (Object[]) it.next();
                idPedido = (Integer) line[0];
                mesa = (Integer) line[1];
            }
            return idPedido;
        } catch (Exception e) {
            System.out.println(e.toString());
            return null;
        }
    }
}
