package com.osd.vaadin.ws.rest;

import java.util.List;
import javax.persistence.TypedQuery;
import com.osd.vaadin.Entity.*;


public class FunctionIntegrator {
	
	public static List<User> getAllUsers(){
		
		TypedQuery<User> query = EntityManagerSingleton.getEntityManager().createQuery(allCustomersQuery, User.class);
		return query.getResultList();
		
	}
	
	// Da li klijent postoji u bazi
    public static int checkUser(String username, String pwd) {
        TypedQuery<User> query = EntityManagerSingleton.getEntityManager().createQuery(checkUserQuery, User.class);
        query.setParameter("u", username);
        query.setParameter("p", pwd);
        if (query.getResultList().size() > 0)
            return 1;
        else
            return 0;
    }

private static String checkUserQuery = "SELECT u FROM User u WHERE u.username = :u AND u.pwd = :p";
private static String allCustomersQuery = "SELECT u FROM User u";
}
