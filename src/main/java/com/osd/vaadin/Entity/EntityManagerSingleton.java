package com.osd.vaadin.Entity;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public class EntityManagerSingleton {

	public static EntityManager getEntityManager() {
		if (em == null) {
			try {
				em = Persistence.createEntityManagerFactory("loginapp").createEntityManager();
			} catch (PersistenceException e) {
				/*
				 * TO DO - napraviti error response
				 */ 
				throw new WebApplicationException(e.getMessage(),Response.Status.SERVICE_UNAVAILABLE);

			}

		}
		return em;
	}

	private static EntityManager em = null;
}