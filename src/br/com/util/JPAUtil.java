package br.com.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JPAUtil {
	/*Serve para receber a conexão, responsável por abrir a 
	 * conexão e efetuar a transação com o bd
	*/
	private static final String PERSISTENCE_UNIT = "bdcarro";
	private static ThreadLocal<EntityManager> threadEntityManager = new ThreadLocal<EntityManager>();
	private static EntityManagerFactory entityManagerFactory;
	
	private JPAUtil() {
		
	}
	
	public static EntityManager getEntityManager() {
		if(entityManagerFactory == null) {
			entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
		}
		EntityManager entityManager = threadEntityManager.get();
		
		if(entityManager == null||!entityManager.isOpen()) {
			entityManager=entityManagerFactory.createEntityManager();
			JPAUtil.threadEntityManager.set(entityManager);
		}
		return entityManager;
	}
	
	public static void closeEntityManager() {
		EntityManager em = threadEntityManager.get();
		if(em!=null) {
			EntityTransaction transaction = em.getTransaction();
			if(transaction.isActive()) {
				transaction.commit();
			}
			em.close();
			threadEntityManager.set(null);
		}
	}
	
	public static void closeEntityManagerFactory() {
		closeEntityManager();
		entityManagerFactory.close();
	}

}
