package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.HouseAdornmentDao;
import pojo.HouseAdornment;

@Service
public class HouseAdornmentService {
	@Autowired
	private HouseAdornmentDao houseAdornmentDao;
	/**
	 * 找到所有房屋装饰下拉框选项
	 */
	public List<HouseAdornment> findAllAdorSelection(){
		return houseAdornmentDao.findAllAdorSelection();
	}
}
