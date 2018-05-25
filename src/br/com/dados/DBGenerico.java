package br.com.dados;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.util.JPAUtil;

public class DBGenerico {

	private static DBGenerico instance;
	private EntityManager entityManager;
	
	private DBGenerico() {
		entityManager = JPAUtil.getEntityManager();
	}
	
	public static DBGenerico getInstance() {
		if (instance == null)
			instance = new DBGenerico();
		return instance;
	}
	
	public boolean insert(Object obj) {
		
		boolean retorno = false;
		
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(obj);
			entityManager.getTransaction().commit();
			retorno = true;
		}catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
		return retorno;
	}
	
	public boolean update (Object obj) {
		
		boolean retorno = false;
		
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(obj);
			entityManager.getTransaction().commit();
			retorno = true;
		}catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
		return retorno;
	}
	
	public boolean delete(Object obj) {
		
		boolean retorno = false;
		
		try {
			entityManager.getTransaction().begin();
			entityManager.remove(obj);
			entityManager.getTransaction().commit();
			retorno = true;
		}catch(Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
		return retorno;
	}
	
	@SuppressWarnings("unchecked")
	public List<Object> select(String q){
		entityManager.getTransaction().begin();
		Query query = entityManager.createNamedQuery(q);
		entityManager.getTransaction().commit();
		return query.getResultList();
	}
	
	public <T> Object select (int id, Class<T> c1) {
		
		try {
			entityManager.getTransaction().begin();
			Object obj = entityManager.find(c1,id);
			entityManager.getTransaction().commit();
			return obj;
		}catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
		return null;
	}
	
	public List<Object> selectTo (String q, Object valor){
		
		try {
			Query query = entityManager.createNamedQuery(q);
			query.setParameter("valor", valor);
			return query.getResultList();
		}catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
		return null;
	}
}
