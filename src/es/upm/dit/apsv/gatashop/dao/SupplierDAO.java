package es.upm.dit.apsv.gatashop.dao;

import java.util.List;

import es.upm.dit.apsv.gatashop.model.Supplier;

public interface SupplierDAO {

	public Supplier create (Supplier supplier) throws Exception;
	public Supplier read (String supplierID) throws Exception;
	public Supplier update (Supplier supplier) throws Exception;
	public Supplier delete (Supplier supplier) throws Exception;

	public List<Supplier> readAll();
}
