package es.upm.dit.apsv.gatashop.dao;

import java.util.List;

import es.upm.dit.apsv.gatashop.model.Client;

public class ClientDAOImplementation implements ClientDAO {

	private static ClientDAOImplementation instance = null;
	private ClientDAOImplementation() {}
	public static ClientDAOImplementation getInstance() {
	   if( instance ==  null) {
	       instance = new ClientDAOImplementation();
	   }
	   return instance;
	}
	
	@Override
	public Client create(Client client) throws Exception{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client read(String categoryID) throws Exception{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client update(Client client) throws Exception{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client delete(Client client) throws Exception{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Client> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client readByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client readByUser(String user) {
		// TODO Auto-generated method stub
		return null;
	}

}
