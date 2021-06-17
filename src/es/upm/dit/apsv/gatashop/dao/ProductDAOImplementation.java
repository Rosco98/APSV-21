package es.upm.dit.apsv.gatashop.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import es.upm.dit.apsv.gatashop.model.Product;

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
	public Product read(String productID) throws Exception{
		Product p = null;
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			p = session.get(Product.class, productID);
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
	public List<Product> readAll() {
		List<Product> p = null;
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			p = (List<Product>)(session.createQuery("from Products").list());
			session.getTransaction().commit();
		} catch (Exception e) {
		} finally {
			session.close();
		}		
		return p;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> readAllByCategory(String categoryID) {
		List<Product> products = null;
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Query q = session.createQuery("SELECT p "
				+ "FROM Products p, Categories c "
				+ "WHERE c.categoryID=\"" + categoryID + "\" "
						+ "AND c.categoryID=p.categoryID);");
		
		products = q.getResultList();
		session.getTransaction().commit();
		session.close();
		return products;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> readAllBySupplier(String supplierID) {
		List<Product> products = null;
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Query q = session.createQuery("SELECT p "
				+ "FROM Products p, Suppliers s "
				+ "WHERE Suppliers.supplierID=\"" + supplierID + "\" "
						+ "AND Supplier.supplierID=Products.supplierID);");
		
		products = q.getResultList();
		session.getTransaction().commit();
		session.close();
		return products;
	}

}
