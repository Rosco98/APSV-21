package es.upm.dit.apsv.gatashop.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import es.upm.dit.apsv.gatashop.model.Category;
import es.upm.dit.apsv.gatashop.model.Product;
import es.upm.dit.apsv.gatashop.model.Supplier;

public class ProductDAOImplementation implements ProductDAO {
	
	private static ProductDAOImplementation instance = null;
	private ProductDAOImplementation() {}
	public static ProductDAOImplementation getInstance() {
	   if( instance ==  null) {
	       instance = new ProductDAOImplementation();
	   }
	   return instance;
	}
	
	
	
	@Override
	public Product create(Product product) throws Exception{
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.save(product);
			session.getTransaction().commit();
		} catch (Exception e) {
		} finally {
			session.close();
		}		
		return product;
	}

	@Override
	public Product read(Long id) throws Exception{
		Product p = null;
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			p = session.get(Product.class, id);
			session.getTransaction().commit();
		} catch (Exception e) {
		} finally {
			session.close();
		}		
		return p;
	}

	@Override
	public Product update(Product product) throws Exception{
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(product);
			session.getTransaction().commit();
		} catch (Exception e) {
		} finally {
			session.close();
		}		
		return product;
	}

	@Override
	public Product delete(Product product) throws Exception{
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.delete(product);
			session.getTransaction().commit();
		} catch (Exception e) {
		} finally {
			session.close();
		}		
		return product;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> readAll() throws Exception{
		List<Product> p = null;
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			p = session.createQuery("FROM Product").getResultList();
			session.getTransaction().commit();
		} catch (Exception e) {
		} finally {
			session.close();
		}		
		return p;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> readAllByCategory(Category category) {
		List<Product> products = null;
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Query q = session.createQuery("SELECT p "
				+ "FROM Product p, Category c "
				+ "WHERE c.ID=\"" + category.getId() + ";");
		
		products = q.getResultList();
		session.getTransaction().commit();
		session.close();
		return products;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> readAllBySupplier(Supplier supplier) {
		List<Product> products = null;
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Query q = session.createQuery("SELECT p "
				+ "FROM Product p, Supplier s "
				+ "WHERE s.id=\"" + supplier.getId() + ";");
		
		products = q.getResultList();
		session.getTransaction().commit();
		session.close();
		return products;
	}

}
