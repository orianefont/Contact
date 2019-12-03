package com.sopra.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sopra.Contact;
import com.sopra.dao.ContactDAO;
import com.sopra.dao.Context;

public class ContactDAOimpl implements ContactDAO {
	
	private Logger log = LogManager.getLogger(Context.class.getName());
	
	EntityManager em = Context.getInstance().getEmf().createEntityManager();

	@Override
	public List<Contact> findAll() {
			log.info("Méthode findAll");
		Query q = em.createQuery("from Contact");
		return q.getResultList();
	}

	@Override
	public Contact findByKey(Integer id) {
		log.info("Méthode findByKey");
		return em.find(Contact.class, id);		
	}

	@Override
	public Contact insert(Contact obj) {
		log.info("Méthode insert");
		try {
			em.getTransaction().begin();
			em.persist(obj);
			em.getTransaction().commit();
		} catch  (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		return obj;
	}

	@Override
	public Contact update(Contact obj) {
		log.info("Méthode update");
		Contact c = em.find(Contact.class, obj);
		try {
			em.getTransaction().begin();
			c = em.merge(obj);
			em.getTransaction().commit();
		} catch  (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		return obj;
	}

	@Override
	public void deleteByKey(Integer key) {
		log.info("Méthode deleteByKey");
		Contact c = null;
		try {
			em.getTransaction().begin();
			if (c!=null){
				em.remove(c);
			}
			em.getTransaction().commit();
		} catch  (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		
	}

}
