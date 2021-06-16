package es.upm.dit.apsv.gatashop.dao;

import java.util.List;

import es.upm.dit.apsv.gatashop.model.OrderDetail;

public interface OrderDetailDAO {

	public OrderDetail create (OrderDetail orderDetail) throws Exception;
	public OrderDetail read (String orderDetailID) throws Exception;
	public OrderDetail update (OrderDetail orderDetail) throws Exception;
	public OrderDetail delete (OrderDetail orderDetail) throws Exception;

	public List<OrderDetail> readAll();
	public List<OrderDetail> readAllByOrder(String orderID);
	public List<OrderDetail> readAllByProduct(String productID);
}
