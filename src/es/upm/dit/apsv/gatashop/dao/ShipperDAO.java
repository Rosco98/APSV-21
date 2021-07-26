package es.upm.dit.apsv.gatashop.dao;

import java.util.List;

import es.upm.dit.apsv.gatashop.model.Shipper;

public interface ShipperDAO {

	public Shipper create (Shipper shipper) throws Exception;
	public Shipper read (Long id) throws Exception;
	public Shipper update (Shipper shipper) throws Exception;
	public Shipper delete (Shipper shipper) throws Exception;

	public List<Shipper> readAll();
	public Shipper login(String email, String password) throws Exception;

}
