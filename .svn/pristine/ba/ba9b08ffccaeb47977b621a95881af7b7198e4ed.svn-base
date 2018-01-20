package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.HouseDirectionDao;
import pojo.HouseDirection;

@Service
public class HouseDirectionService {
	@Autowired
	private HouseDirectionDao houseDirectionDao;
	
	/**
	 * 找到所有房屋朝向下拉选项框
	 */
	public List<HouseDirection> findAllHouseDirSelection(){
		return houseDirectionDao.findAllHouseDirSelection();
	}; 
	
}
