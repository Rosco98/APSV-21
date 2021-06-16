package es.upm.dit.apsv.gatashop.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import es.upm.dit.apsv.gatashop.model.Category;


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
	public Category read(String categoryID) throws Exception{
		Category c = null;
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			c = session.get(Category.class, categoryID);
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
			c = (List<Category>)(session.createQuery("from Category").list());
			session.getTransaction().commit();
		} catch (Exception e) {
		} finally {
			session.close();
		}		
		return c;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> readAllByProduct(String productID) {
		List<Category> categories = null;
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Query q = session.createQuery("SELECT Categories.CategoryID "
				+ "FROM Categories, Products "
				+ "WHERE Products.ProductID=\"" + productID + "\" "
						+ "AND Products.CategoryID=Categories.CategoryID);");
		
		categories = q.getResultList();
		session.getTransaction().commit();
		session.close();
		return categories;
	}

}
