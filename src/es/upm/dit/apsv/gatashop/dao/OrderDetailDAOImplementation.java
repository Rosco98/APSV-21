package es.upm.dit.apsv.gatashop.dao;

import java.util.List;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderDetail read(String orderDetailID) throws Exception{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderDetail update(OrderDetail orderDetail) throws Exception{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderDetail delete(OrderDetail orderDetail) throws Exception{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderDetail> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderDetail> readAllByOrder(String orderID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderDetail> readAllByProduct(String productID) {
		// TODO Auto-generated method stub
		return null;
	}

}
