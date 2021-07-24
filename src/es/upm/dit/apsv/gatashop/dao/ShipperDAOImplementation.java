package es.upm.dit.apsv.gatashop.dao;

import java.util.List;

import org.hibernate.Session;

import es.upm.dit.apsv.gatashop.model.Shipper;

public class ShipperDAOImplementation implements ShipperDAO {

	private static ShipperDAOImplementation instance = null;
	private ShipperDAOImplementation() {}
	public static ShipperDAOImplementation getInstance() {
	   if( instance ==  null) {
	       instance = new ShipperDAOImplementation();
	   }
	   return instance;
	}
	
	
	@Override
	public Shipper create(Shipper shipper) throws Exception{
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.save(shipper);
			session.getTransaction().commit();
		} catch (Exception e) {
		} finally {
			session.close();
		}		
		return shipper;
	}

	@Override
	public Shipper read(Long id) throws Exception{
		Shipper s = null;
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			s = session.get(Shipper.class, id);
			session.getTransaction().commit();
		} catch (Exception e) {
		} finally {
			session.close();
		}		
		return s;
	}

	@Override
	public Shipper update(Shipper shipper) throws Exception{
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(shipper);
			session.getTransaction().commit();
		} catch (Exception e) {
		} finally {
			session.close();
		}		
		return shipper;
	}

	@Override
	public Shipper delete(Shipper shipper) throws Exception{
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.delete(shipper);
			session.getTransaction().commit();
		} catch (Exception e) {
		} finally {
			session.close();
		}		
		return shipper;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Shipper> readAll() {
		List<Shipper> s = null;
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			s = session.createQuery("FROM Shipper").getResultList();
			session.getTransaction().commit();
		} catch (Exception e) {
		} finally {
			session.close();
		}		
		return s;
	}

}
