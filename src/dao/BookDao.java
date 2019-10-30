package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import Model.Books;

public class BookDao {

	private EntityManagerFactory entityManagerFactory;

	public void create(Books s) {

		entityManagerFactory = HibernateOGMUtil.getEntityManagerFactory();

		EntityManager em = entityManagerFactory.createEntityManager();

		em.getTransaction().begin();

		em.persist(s);

		em.getTransaction().commit();
	}

	public List<Books> findAll() {
		entityManagerFactory = HibernateOGMUtil.getEntityManagerFactory();

		EntityManager em = entityManagerFactory.createEntityManager();

		List<Books> books = em.createQuery("select s from Books s", Books.class).getResultList();

		return books;
	}

	public Books find(int id) {
		entityManagerFactory = HibernateOGMUtil.getEntityManagerFactory();

		EntityManager em = entityManagerFactory.createEntityManager();
		
		Books s = em.find(Books.class, id);
		
		return s;
	}
	
	public List<Books> find(String str) {
		entityManagerFactory = HibernateOGMUtil.getEntityManagerFactory();

		EntityManager em = entityManagerFactory.createEntityManager();
		
		List<Books> books = em.createQuery("select s from Books s where s.title= :name or s.author= :name", Books.class).setParameter("name", str).getResultList();
		
		return books;
	}
	public void update(Books s) {
		entityManagerFactory = HibernateOGMUtil.getEntityManagerFactory();

		EntityManager em = entityManagerFactory.createEntityManager();
		
		em.getTransaction().begin();
		
		em.merge(s);
		
		em.getTransaction().commit();
		
	}
	
	public void delete(Books s) {
		entityManagerFactory = HibernateOGMUtil.getEntityManagerFactory();

		EntityManager em = entityManagerFactory.createEntityManager();
		
		em.getTransaction().begin();
		
		em.remove(s);
		
		em.getTransaction().commit();
	}
}
