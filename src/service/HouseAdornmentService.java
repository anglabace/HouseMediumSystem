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
	 * �ҵ����з���װ��������ѡ��
	 */
	public List<HouseAdornment> findAllAdorSelection(){
		return houseAdornmentDao.findAllAdorSelection();
	}
}
