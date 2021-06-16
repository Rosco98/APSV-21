package es.upm.dit.apsv.gatashop.dao;

import java.util.List;

import es.upm.dit.apsv.gatashop.model.Shipper;

public class SupplierDAOImplementation implements ShipperDAO {

	private static SupplierDAOImplementation instance = null;
	private SupplierDAOImplementation() {}
	public static SupplierDAOImplementation getInstance() {
	   if( instance ==  null) {
	       instance = new SupplierDAOImplementation();
	   }
	   return instance;
	}
	
	
	@Override
	public Shipper create(Shipper shipper) throws Exception{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Shipper read(String shipperID) throws Exception{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Shipper update(Shipper shipper) throws Exception{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Shipper delete(Shipper shipper) throws Exception{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Shipper> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
