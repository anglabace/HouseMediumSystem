package dao;

import pojo.City;

public interface CityDao {
	/**
	 * ͨ������Id���ҳ��ж���
	 */
	public City findCityById(int city_Id);
	/**
	 * ͨ������Id���ҳ��ж���
	 */
	public City findCityByCityId(int city_Id);
}
