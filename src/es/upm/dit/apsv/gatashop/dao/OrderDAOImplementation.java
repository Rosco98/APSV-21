package es.upm.dit.apsv.gatashop.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import es.upm.dit.apsv.gatashop.model.Client;
import es.upm.dit.apsv.gatashop.model.Order;
import es.upm.dit.apsv.gatashop.model.Shipper;

public class OrderDAOImplementation implements OrderDAO {

	private static OrderDAOImplementation instance = null;
	private OrderDAOImplementation() {}
	public static OrderDAOImplementation getInstance() {
	   if( instance ==  null) {
	       instance = new OrderDAOImplementation();
	   }
	   return instance;
	}
	
	
	@Override
	public Order create(Order order) throws Exception{
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.save(order);
			session.getTransaction().commit();
		} catch (Exception e) {
		} finally {
			session.close();
		}		
		return order;
	}

	@Override
	public Order read(Long id) throws Exception{
		Order o = null;
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			o = session.get(Order.class, id);
			session.getTransaction().commit();
		} catch (Exception e) {
		} finally {
			session.close();
		}		
		return o;
	}

	@Override
	public Order update(Order order) throws Exception{
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(order);
			session.getTransaction().commit();
		} catch (Exception e) {
		} finally {
			session.close();
		}		
		return order;
	}

	@Override
	public Order delete(Order order) throws Exception{
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.delete(order);
			session.getTransaction().commit();
		} catch (Exception e) {
		} finally {
			session.close();
		}		
		return order;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> readAll() {
		List<Order> o = null;
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			o = session.createQuery("from Order").getResultList();
			session.getTransaction().commit();
		} catch (Exception e) {
		} finally {
			session.close();
		}		
		return o;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> readAllByClient(Client client) {
		List<Order> orders = null;
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Query q = session.createQuery("SELECT o "
				+ "FROM Order o, Client c "
				+ "WHERE o.orders=" + client.getId() + ";");
		
		orders = q.getResultList();
		session.getTransaction().commit();
		session.close();
		return orders;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> readAllByShipper(Shipper shipper) {
		List<Order> orders = null;
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Query q = session.createQuery("SELECT o "
				+ "FROM Order o, Client c "
				+ "WHERE o.orders=" + shipper.getId() + ";");
		
		orders = q.getResultList();
		session.getTransaction().commit();
		session.close();
		return orders;
	}

}
