package es.upm.dit.apsv.gatashop.dao;

import java.util.List;

import es.upm.dit.apsv.gatashop.model.Order;
import es.upm.dit.apsv.gatashop.model.OrderDetail;
import es.upm.dit.apsv.gatashop.model.Product;

public interface OrderDetailDAO {

	public OrderDetail create (OrderDetail orderDetail) throws Exception;
	public OrderDetail read (Long id) throws Exception;
	public OrderDetail update (OrderDetail orderDetail) throws Exception;
	public OrderDetail delete (OrderDetail orderDetail) throws Exception;

	public List<OrderDetail> readAll();
	public List<OrderDetail> readAllByOrder(Order order);
	public List<OrderDetail> readAllByProduct(Product product);
}
