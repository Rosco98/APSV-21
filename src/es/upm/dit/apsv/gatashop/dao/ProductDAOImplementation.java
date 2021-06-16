package es.upm.dit.apsv.gatashop.dao;

import java.util.List;

import es.upm.dit.apsv.gatashop.model.Product;

public class ProductDAOImplementation implements ProductDAO {
	
	private static ProductDAOImplementation instance = null;
	private ProductDAOImplementation() {}
	public static ProductDAOImplementation getInstance() {
	   if( instance ==  null) {
	       instance = new ProductDAOImplementation();
	   }
	   return instance;
	}
	
	
	
	@Override
	public Product create(Product product) throws Exception{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product read(String productID) throws Exception{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product update(Product product) throws Exception{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product delete(Product product) throws Exception{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> readAllByCategory(String categoryID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> readAllBySupplier(String supplierID) {
		// TODO Auto-generated method stub
		return null;
	}

}
