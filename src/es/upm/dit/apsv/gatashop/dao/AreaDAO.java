package es.upm.dit.apsv.gatashop.dao;

import java.util.List;

import es.upm.dit.apsv.gatashop.model.Area;

public interface AreaDAO {

	public Area create (Area area) throws Exception;
	public Area read (Long id) throws Exception;
	public Area update (Area area) throws Exception;
	public Area delete (Area area) throws Exception;

	public List<Area> readAll();
}
