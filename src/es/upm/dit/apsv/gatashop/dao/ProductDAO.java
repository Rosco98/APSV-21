package es.upm.dit.apsv.gatashop.dao;

import java.util.List;

import es.upm.dit.apsv.gatashop.model.Product;

public interface ProductDAO {

	public Product create (Product product) throws Exception;
	public Product read (String productID) throws Exception;
	public Product update (Product product) throws Exception;
	public Product delete (Product product) throws Exception;

	public List<Product> readAll();
	public List<Product> readAllByCategory(String categoryID);
	public List<Product> readAllBySupplier(String supplierID);
}
