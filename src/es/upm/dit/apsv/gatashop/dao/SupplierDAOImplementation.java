package es.upm.dit.apsv.gatashop.dao;

import java.util.List;

import org.hibernate.Session;

import es.upm.dit.apsv.gatashop.model.Client;
import es.upm.dit.apsv.gatashop.model.Supplier;

public class SupplierDAOImplementation implements SupplierDAO {

	private static SupplierDAOImplementation instance = null;
	private SupplierDAOImplementation() {}
	public static SupplierDAOImplementation getInstance() {
	   if( instance ==  null) {
	       instance = new SupplierDAOImplementation();
	   }
	   return instance;
	}
	
	
	@Override
	public Supplier create(Supplier supplier) throws Exception{
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.save(supplier);
			session.getTransaction().commit();
		} catch (Exception e) {
		} finally {
			session.close();
		}		
		return supplier;
	}

	@Override
	public Supplier read(Long id) throws Exception{
		Supplier s = null;
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			s = session.get(Supplier.class, id);
			session.getTransaction().commit();
		} catch (Exception e) {
		} finally {
			session.close();
		}		
		return s;
	}

	@Override
	public Supplier update(Supplier supplier) throws Exception{
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(supplier);
			session.getTransaction().commit();
		} catch (Exception e) {
		} finally {
			session.close();
		}		
		return supplier;
	}

	@Override
	public Supplier delete(Supplier supplier) throws Exception{
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.delete(supplier);
			session.getTransaction().commit();
		} catch (Exception e) {
		} finally {
			session.close();
		}		
		return supplier;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Supplier> readAll() {
		List<Supplier> s = null;
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			s = session.createQuery("FROM Supplier").getResultList();
			session.getTransaction().commit();
		} catch (Exception e) {
		} finally {
			session.close();
		}		
		return s;
	}
	@Override
	public Supplier login(String email, String password) throws Exception {
		Supplier s = null;
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			s = (Supplier) session.createQuery("FROM Supplier s WHERE s.EMAIL=\'" + email
					+ "\' s.PASSWORD=\'" + password + "\';").getSingleResult();
			session.getTransaction().commit();
		} catch (Exception e) {
		} finally {
			session.close();
		}		
		return s;
	}

}
