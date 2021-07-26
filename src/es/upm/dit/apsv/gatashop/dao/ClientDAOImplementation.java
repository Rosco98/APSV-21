package es.upm.dit.apsv.gatashop.dao;

import java.util.List;

import org.hibernate.Session;

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
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.save(client);
			session.getTransaction().commit();
		} catch (Exception e) {
		} finally {
			session.close();
		}		
		return client;
	}

	@Override
	public Client read(Long id) throws Exception{
		Client c = null;
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			c = session.get(Client.class, id);
			session.getTransaction().commit();
		} catch (Exception e) {
		} finally {
			session.close();
		}		
		return c;
	}

	@Override
	public Client update(Client client) throws Exception{
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(client);
			session.getTransaction().commit();
		} catch (Exception e) {
		} finally {
			session.close();
		}		
		return client;
	}

	@Override
	public Client delete(Client client) throws Exception{
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.delete(client);
			session.getTransaction().commit();
		} catch (Exception e) {
		} finally {
			session.close();
		}		
		return client;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Client> readAll() {
		List<Client> c = null;
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			c = session.createQuery("FROM Client").getResultList();
			session.getTransaction().commit();
		} catch (Exception e) {
		} finally {
			session.close();
		}		
		return c;
	}

	@Override	//Puede haber mas de un cliente con el mismo correo
	public Client readByEmail(String email) {
		for (Client c : this.readAll()) 
			if (email.equals(c.getEmail()))
				return c;
		return null;
	}

	@Override	//Puede haber mas de un cliente con el mismo user
	public Client readByUser(String user) {
		for (Client c : this.readAll()) 
			if (user.equals(c.getUser()))
				return c;
		return null;
	}
	
	@Override
	public Client login(String email, String password) throws Exception {
		Client c = null;
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			c = (Client) session.createQuery("FROM Client c WHERE c.EMAIL=\'" + email
					+ "\' c.PASSWORD=\'" + password + "\';").getSingleResult();
			session.getTransaction().commit();
		} catch (Exception e) {
		} finally {
			session.close();
		}		
		return c;
	}

}
