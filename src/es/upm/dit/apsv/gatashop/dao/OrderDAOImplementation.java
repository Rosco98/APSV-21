package es.upm.dit.apsv.gatashop.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import es.upm.dit.apsv.gatashop.model.Order;

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
	public Order read(String orderID) throws Exception{
		Order o = null;
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			o = session.get(Order.class, orderID);
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
			o = (List<Order>)(session.createQuery("from Orders").list());
			session.getTransaction().commit();
		} catch (Exception e) {
		} finally {
			session.close();
		}		
		return o;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> readAllByClient(String clientID) {
		List<Order> orders = null;
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Query q = session.createQuery("SELECT o "
				+ "FROM Orders o, Clients c "
				+ "WHERE c.clientID=\"" + clientID + "\" "
						+ "AND o.clientID=c.clientID);");
		
		orders = q.getResultList();
		session.getTransaction().commit();
		session.close();
		return orders;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> readAllByShipper(String shipperID) {
		List<Order> orders = null;
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Query q = session.createQuery("SELECT o "
				+ "FROM Orders o, Shippers s "
				+ "WHERE s.shipperID=\"" + shipperID + "\" "
						+ "AND o.shipperID=s.shipperID);");
		
		orders = q.getResultList();
		session.getTransaction().commit();
		session.close();
		return orders;
	}

}
