package it.beije.hiketracker.dbconnection;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


@Component
public class JpaEntityManager {
	
	private static EntityManagerFactory emfactory = null;

	private JpaEntityManager() {}
	
	@Bean(name = "entityManagerFactory")	
	public static synchronized EntityManagerFactory getInstance() {
		try {
			if (emfactory == null) {
				emfactory = Persistence.createEntityManagerFactory("hiketracker");
			}
			return emfactory;
		} catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
