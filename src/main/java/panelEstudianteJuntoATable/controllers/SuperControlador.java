package panelEstudianteJuntoATable.controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import panelEstudianteJuntoATable.model.Entidad;


public class SuperControlador {
	private EntityManager em = null;
	private String nombreTabla = "";
	private Class tipoEntidad;
	
	
	
	
	
	public SuperControlador(String nombreTabla, Class tipoEntidad) {
		this.nombreTabla = nombreTabla;
		this.tipoEntidad = tipoEntidad;
	}

	/**
	 * 
	 * @return
	 */
	public EntityManager getEntityManager() {
		if (em == null) {
			em = Persistence.createEntityManagerFactory("CentroEducativo").createEntityManager();
		}
		return em;

	}
	
	@SuppressWarnings("unchecked")
	public List<? extends Entidad> findAll () {
		return (List<Entidad>) getEntityManager().createNativeQuery("SELECT * FROM " + this.nombreTabla, this.tipoEntidad).getResultList();
	}

	public void actualizacion(Entidad e) {
		EntityManager em = getEntityManager();

		em.getTransaction().begin();
		em.merge(e);
		em.getTransaction().commit();
	}
	
	public void insercion(Entidad e) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
	}
}
