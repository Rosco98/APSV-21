package es.upm.dit.apsv.gatashop.dao;

import java.util.List;

import es.upm.dit.apsv.gatashop.model.Shipper;

public class ShipperDAOImplementation implements ShipperDAO {

	private static ShipperDAOImplementation instance = null;
	private ShipperDAOImplementation() {}
	public static ShipperDAOImplementation getInstance() {
	   if( instance ==  null) {
	       instance = new ShipperDAOImplementation();
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
