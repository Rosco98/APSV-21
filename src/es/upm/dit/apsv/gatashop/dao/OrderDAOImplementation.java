package es.upm.dit.apsv.gatashop.dao;

import java.util.List;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order read(String orderID) throws Exception{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order update(Order order) throws Exception{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order delete(Order order) throws Exception{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> readAllByClient(String clientID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> readAllByShipper(String shipperID) {
		// TODO Auto-generated method stub
		return null;
	}

}
