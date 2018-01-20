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
	//通过区域Id返回区域对象
	public Area findAreaById(int area_Id){
		return areaDao.findAreaById(area_Id);
	}
	
	/**
	 * 通过市名字找区集合
	 */
	public List<Area> findAreaListBycityName(String cityName){
		return areaDao.findAreaListBycityName(cityName);
	};
	
	/**
	 * 通过街道名字找区id
	 */
	public int findAreaIdByStreetName(String streetName){
		return areaDao.findAreaIdByStreetName(streetName);
	}
	public Area findAreaByAreaId(int area_Id){
		return areaDao.findAreaByAreaId(area_Id);
	}
}
