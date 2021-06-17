package es.upm.dit.apsv.gatashop.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import es.upm.dit.apsv.gatashop.model.OrderDetail;

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
	public OrderDetail read(String orderDetailID) throws Exception{
		OrderDetail o = null;
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			o = session.get(OrderDetail.class, orderDetailID);
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
			o = (List<OrderDetail>)(session.createQuery("from OrderDetails").list());
			session.getTransaction().commit();
		} catch (Exception e) {
		} finally {
			session.close();
		}		
		return o;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrderDetail> readAllByOrder(String orderID) {
		List<OrderDetail> orderDetails = null;
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Query q = session.createQuery("SELECT o "
				+ "FROM Orders o, OrderDetails oD "
				+ "WHERE o.orderID=\"" + orderID + "\" "
						+ "AND o.orderID=oD.orderID);");
		
		orderDetails = q.getResultList();
		session.getTransaction().commit();
		session.close();
		return orderDetails;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrderDetail> readAllByProduct(String productID) {
		List<OrderDetail> orderDetails = null;
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Query q = session.createQuery("SELECT oD "
				+ "FROM Products p, OrderDetails oD "
				+ "WHERE p.productID=\"" + productID + "\" "
						+ "AND p.productID=oD.productID);");
		
		orderDetails = q.getResultList();
		session.getTransaction().commit();
		session.close();
		return orderDetails;
	}

}
