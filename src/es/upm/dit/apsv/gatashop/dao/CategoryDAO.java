package es.upm.dit.apsv.gatashop.dao;

import java.util.List;

import es.upm.dit.apsv.gatashop.model.Category;

public interface CategoryDAO {

	public Category create (Category category) throws Exception;
	public Category read (String categoryID) throws Exception;
	public Category update (Category category) throws Exception;
	public Category delete (Category category) throws Exception;

	public List<Category> readAll();
	public List<Category> readAllByProduct(String productId);
}
