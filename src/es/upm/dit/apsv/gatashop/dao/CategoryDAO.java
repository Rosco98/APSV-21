package es.upm.dit.apsv.gatashop.dao;

import java.util.List;

import es.upm.dit.apsv.gatashop.model.Category;
import es.upm.dit.apsv.gatashop.model.Product;

public interface CategoryDAO {

	public Category create (Category category) throws Exception;
	public Category read (Long id) throws Exception;
	public Category update (Category category) throws Exception;
	public Category delete (Category category) throws Exception;

	public List<Category> readAll();
	public List<Category> readAllByProduct(Product product);
}
