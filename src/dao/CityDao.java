package dao;

import pojo.City;

public interface CityDao {
	/**
	 * 通过区域Id查找城市对象
	 */
	public City findCityById(int city_Id);
	/**
	 * 通过城市Id查找城市对象
	 */
	public City findCityByCityId(int city_Id);
}
