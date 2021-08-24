package es.upm.dit.apsv.gatashop.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import es.upm.dit.apsv.gatashop.model.Category;
import es.upm.dit.apsv.gatashop.model.Product;


public class CategoryDAOImplementation implements CategoryDAO {
	
	private static CategoryDAOImplementation instance = null;
	private CategoryDAOImplementation() {}
	public static CategoryDAOImplementation getInstance() {
	   if( instance ==  null) {
	       instance = new CategoryDAOImplementation();
	   }
	   return instance;
	}
	
	
	@Override
	public Category create(Category category) throws Exception{
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.save(category);
			session.getTransaction().commit();
		} catch (Exception e) {
		} finally {
			session.close();
		}		
		return category;
	}

	@Override
	public Category read(Long id) throws Exception{
		Category c = null;
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			c = session.get(Category.class, id);
			session.getTransaction().commit();
		} catch (Exception e) {
		} finally {
			session.close();
		}		
		return c;
	}

	@Override
	public Category update(Category category) throws Exception{
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(category);
			session.getTransaction().commit();
		} catch (Exception e) {
		} finally {
			session.close();
		}		
		return category;
	}

	@Override
	public Category delete(Category category) throws Exception{
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.delete(category);
			session.getTransaction().commit();
		} catch (Exception e) {
		} finally {
			session.close();
		}		
		return category;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> readAll() {
		List<Category> c = null;
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			c = session.createQuery("FROM Category").getResultList();
			session.getTransaction().commit();
		} catch (Exception e) {
		} finally {
			session.close();
		}		
		return c;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> readAllByProduct(Product product) {
		List<Category> categories = null;
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Query q = session.createQuery("SELECT c "
				+ "FROM Category c, Product p "
				+ "WHERE p.ID=" + product.getId() + " ;");
		
		categories = q.getResultList();
		session.getTransaction().commit();
		session.close();
		return categories;
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public HashMap<String, List<Long>> countProductsByCategory() {
		// SELECT COUNT(PRODUCTSASSOCIATED_ID), CATEGORIES_ID  FROM PRODUCTS_CATEGORIES GROUP BY CATEGORIES_ID
		HashMap<String, List<Long>> count_CategoriesID = new HashMap<String, List<Long>>();;
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		
		/*
		"SELECT c FROM Client c "
		+ "JOIN c.cart p "
		+ "WHERE p.id=\'" + product.getId() + "\'"); 
		*/
				
		Query q1 = session.createQuery("SELECT count(pAs) FROM Category cat " 
				+ "JOIN cat.productsAssociated pAs "
				+ "GROUP BY cat.id "
				+ "ORDER BY cat.id ASC");
		
		Query q2 = session.createQuery("SELECT cat.id FROM Category cat "
				+ "JOIN cat.productsAssociated pAs "
				+ "GROUP BY cat.id "
				+ "ORDER BY cat.id ASC");

		
		List<Long> count = q1.getResultList();
		List<Long> categoriesID = q2.getResultList();
		
		count_CategoriesID.put("count", count);
		count_CategoriesID.put("categoriesID", categoriesID);
		session.getTransaction().commit();
		session.close();
		return count_CategoriesID;
	}	

}
