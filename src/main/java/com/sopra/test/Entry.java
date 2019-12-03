package com.sopra.test;

import javax.persistence.EntityManager;

import com.sopra.Contact;
import com.sopra.dao.Context;

public class Entry {

	public static void main(String[] args) {
		
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		
		Contact c = new Contact();
		
		em.getTransaction().commit();
		em.close();
	}

}
