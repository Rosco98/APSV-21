package es.upm.dit.apsv.gatashop.dao;

import java.util.List;

import es.upm.dit.apsv.gatashop.model.Client;
import es.upm.dit.apsv.gatashop.model.Order;
import es.upm.dit.apsv.gatashop.model.Shipper;

public interface OrderDAO {

	public Order create (Order order) throws Exception;
	public Order read (Long id) throws Exception;
	public Order update (Order order) throws Exception;
	public Order delete (Order order) throws Exception;

	public List<Order> readAll();
	public List<Order> readAllByClient(Client client);
	public List<Order> readAllByShipper(Shipper shipper);
}
