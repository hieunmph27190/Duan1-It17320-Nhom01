package utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;

public class JpaUtil {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	
	public static EntityManagerFactory getEntityManagerFactory() {
		if (entityManagerFactory==null||entityManagerFactory.isOpen()==false) {
			JpaUtil.entityManagerFactory=Persistence.createEntityManagerFactory("Duan1base");
		}
		return entityManagerFactory;
	}
	public static EntityManager getEntityManager()  {
		if (entityManager==null||entityManager.isOpen()==false) {
			JpaUtil.entityManager=JpaUtil.getEntityManagerFactory().createEntityManager();
		}
		return entityManager;
	}
	public static Session getSession() {
		return getEntityManager().unwrap(Session.class);
	}
	
}
