package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.HouseApplicationDao;
import pojo.HouseApplication;

@Service
public class HouseApplicationService {
	@Autowired
	private HouseApplicationDao houseApplicationDao;
	/**
	 * 找到所有房屋用途下拉选项框
	 */
	public List<HouseApplication> findAllHouseAppSelection(){
		 return houseApplicationDao.findAllHouseAppSelection();
	} 
}
