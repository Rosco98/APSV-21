package es.upm.dit.apsv.gatashop.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import es.upm.dit.apsv.gatashop.model.Order;
import es.upm.dit.apsv.gatashop.model.OrderDetail;
import es.upm.dit.apsv.gatashop.model.Product;

public class OrderDetailDAOImplementation implements OrderDetailDAO {

	private static OrderDetailDAOImplementation instance = null;
	private OrderDetailDAOImplementation() {}
	public static OrderDetailDAOImplementation getInstance() {
	   if( instance ==  null) {
	       instance = new OrderDetailDAOImplementation();
	   }
	   return instance;
	}
	
	
	@Override
	public OrderDetail create(OrderDetail orderDetail) throws Exception{
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.save(orderDetail);
			session.getTransaction().commit();
		} catch (Exception e) {
		} finally {
			session.close();
		}		
		return orderDetail;
	}

	@Override
	public OrderDetail read(Long id) throws Exception{
		OrderDetail o = null;
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			o = session.get(OrderDetail.class, id);
			session.getTransaction().commit();
		} catch (Exception e) {
		} finally {
			session.close();
		}		
		return o;
	}

	@Override
	public OrderDetail update(OrderDetail orderDetail) throws Exception{
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(orderDetail);
			session.getTransaction().commit();
		} catch (Exception e) {
		} finally {
			session.close();
		}		
		return orderDetail;
	}

	@Override
	public OrderDetail delete(OrderDetail orderDetail) throws Exception{
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.delete(orderDetail);
			session.getTransaction().commit();
		} catch (Exception e) {
		} finally {
			session.close();
		}		
		return orderDetail;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrderDetail> readAll() {
		List<OrderDetail> o = null;
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			o = session.createQuery("FROM OrderDetail "
					+ "ORDER BY order_id").getResultList();
			session.getTransaction().commit();
		} catch (Exception e) {
		} finally {
			session.close();
		}		
		return o;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrderDetail> readAllByOrder(Order order) {
		List<OrderDetail> orderDetails = null;
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Query q = session.createQuery("SELECT oD "
				+ "FROM Order o, OrderDetail oD "
				+ "WHERE o.orders=\"" + order.getId() + ";");
		
		orderDetails = q.getResultList();
		session.getTransaction().commit();
		session.close();
		return orderDetails;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrderDetail> readAllByProduct(Product product) {
		List<OrderDetail> orderDetails = null;
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Query q = session.createQuery("SELECT oD "
				+ "FROM Product p, OrderDetail oD "
				+ "WHERE p.ID=\"" + product.getId() + ";");
		
		orderDetails = q.getResultList();
		session.getTransaction().commit();
		session.close();
		return orderDetails;
	}

}
