package dao;

import java.util.List;

import pojo.Street;

public interface StreetDao {
	
	/**
	 * ͨ����id�ҽּ���
	 */
	public List<Street> findStreetListByAreaId(int area_Id);
	/**
	 * ͨ���ֵ�Id���ҽֵ�
	 */
	public Street findStreetById(int StreetId);
}