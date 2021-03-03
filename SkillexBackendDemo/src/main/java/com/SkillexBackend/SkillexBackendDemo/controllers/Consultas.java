package com.SkillexBackend.SkillexBackendDemo.controllers;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Consultas {
	
	private EntityManagerFactory emf;
	public void consultas(String consulta) {		
		emf = Persistence.createEntityManagerFactory("com.miUnidadDePersistencia");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Query query = em.createNativeQuery(consulta);
		query.executeUpdate();
		em.getTransaction().commit();
	} 
}
