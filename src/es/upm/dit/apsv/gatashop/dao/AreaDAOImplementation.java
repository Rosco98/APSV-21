package es.upm.dit.apsv.gatashop.dao;

import java.util.List;

import org.hibernate.Session;

import es.upm.dit.apsv.gatashop.model.Area;

public class AreaDAOImplementation implements AreaDAO {

	private static AreaDAOImplementation instance = null;
	private AreaDAOImplementation() {}
	public static AreaDAOImplementation getInstance() {
	   if( instance ==  null) {
	       instance = new AreaDAOImplementation();
	   }
	   return instance;
	}
	
	
	@Override
	public Area create(Area area) throws Exception{
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.save(area);
			session.getTransaction().commit();
		} catch (Exception e) {
		} finally {
			session.close();
		}		
		return area;
	}

	@Override
	public Area read(Long id) throws Exception{
		Area a = null;
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			a = session.get(Area.class, id);
			session.getTransaction().commit();
		} catch (Exception e) {
		} finally {
			session.close();
		}		
		return a;
	}

	@Override
	public Area update(Area area) throws Exception{
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(area);
			session.getTransaction().commit();
		} catch (Exception e) {
		} finally {
			session.close();
		}		
		return area;
	}

	@Override
	public Area delete(Area area) throws Exception{
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.delete(area);
			session.getTransaction().commit();
		} catch (Exception e) {
		} finally {
			session.close();
		}		
		return area;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Area> readAll() {
		List<Area> a = null;
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			a = session.createQuery("FROM Area").getResultList();
			session.getTransaction().commit();
		} catch (Exception e) {
		} finally {
			session.close();
		}		
		return a;
	}

}
