package service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.AreaDao;
import pojo.Area;

@Service
public class AreaService {
	@Autowired
	private AreaDao areaDao;
	//ͨ������Id�����������
	public Area findAreaById(int area_Id){
		return areaDao.findAreaById(area_Id);
	}
	
	/**
	 * ͨ����������������
	 */
	public List<Area> findAreaListBycityName(String cityName){
		return areaDao.findAreaListBycityName(cityName);
	};
	
	/**
	 * ͨ���ֵ���������id
	 */
	public int findAreaIdByStreetName(String streetName){
		return areaDao.findAreaIdByStreetName(streetName);
	}
	public Area findAreaByAreaId(int area_Id){
		return areaDao.findAreaByAreaId(area_Id);
	}
}