package es.upm.dit.apsv.gatashop.dao;

import java.util.List;
import es.upm.dit.apsv.gatashop.model.Order;

public interface OrderDAO {

	public Order create (Order order) throws Exception;
	public Order read (String orderID) throws Exception;
	public Order update (Order order) throws Exception;
	public Order delete (Order order) throws Exception;

	public List<Order> readAll();
	public List<Order> readAllByClient(String clientID);
	public List<Order> readAllByShipper(String shipperID);
}
