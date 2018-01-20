package dao;

import java.util.List;

import pojo.Street;

public interface StreetDao {
	
	/**
	 * 通过区id找街集合
	 */
	public List<Street> findStreetListByAreaId(int area_Id);
	/**
	 * 通过街道Id查找街道
	 */
	public Street findStreetById(int StreetId);
}
