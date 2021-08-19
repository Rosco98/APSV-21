package es.upm.dit.apsv.gatashop.dao;

import java.util.List;

import es.upm.dit.apsv.gatashop.model.Category;
import es.upm.dit.apsv.gatashop.model.Product;
import es.upm.dit.apsv.gatashop.model.Supplier;

public interface ProductDAO {

	public Product create (Product product) throws Exception;
	public Product read (Long id) throws Exception;
	public Product update (Product product) throws Exception;
	public Product delete (Product product) throws Exception;

	public List<Product> readAll();
	public List<Product> readAvailables();
	public List<Product> readAllByCategory(Category category);
	public List<Product> readAllBySupplier(Supplier supplier);
}
