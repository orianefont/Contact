package com.sopra.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Context {
	
	private Logger LOGGER = LogManager.getLogger(Context.class.getName());
	private static Logger LOGGERs = LogManager.getLogger(Context.class.getName());
	
	private static Context instance;
	private EntityManagerFactory emf;

	private Context () {
		LOGGER.debug("Creation d'un persistance context : contact");
		emf = Persistence.createEntityManagerFactory("contact");
	}

	public static Context getInstance() {
		if (instance == null) {
			instance = new Context();
		}
		LOGGERs.debug("Récupéraiton singleton");
		return instance;
	}

	public EntityManagerFactory getEmf() {
		return emf;
	}


}

