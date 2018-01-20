package dao;

import java.util.List;

import pojo.Area;

public interface AreaDao {
	/**
	 * 通过区域Id返回区域对象
	 */
	public Area findAreaById(int area_Id);
	
	/**
	 * 通过市名字找区集合
	 */
	public List<Area> findAreaListBycityName(String cityName);

	
	
	/**
	 * 通过街道名字找区id
	 */
	public int findAreaIdByStreetName(String streetName);

	public Area findAreaByAreaId(int area_Id);

}
