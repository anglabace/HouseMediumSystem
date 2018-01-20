package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.StreetDao;
import pojo.Street;

@Service
public class StreetService {

	@Autowired
	private StreetDao streetDao;
	
	/**
	 * 通过区id找街集合
	 */
	public List<Street> findStreetListByAreaId(int area_Id){
		//System.out.println("进入了StreetService");
		return streetDao.findStreetListByAreaId(area_Id);
	}
}
