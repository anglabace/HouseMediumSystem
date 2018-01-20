package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.OrderFormDao;

@Service
public class OrderFormService {
	@Autowired
	private OrderFormDao orderFormDao;
	
	/**
	 * 查询个人业务总数
	 * @return
	 */
	public int findAllOrderFormByStaffId(int staffId){
		return orderFormDao.findAllOrderFormByStaffId(staffId);
	}
	/**
	 * 查询个人卖房总数
	 */
	public int findBuyOrderFormByStaffId(int staffId){
		return orderFormDao.findBuyOrderFormByStaffId(staffId);
	}
	/**
	 * 根据员工Id查询该员工半年来的业务总数
	 */
	public int findSemesterCountOrderFormByStaffId(int staffId){
		return orderFormDao.findSemesterCountOrderFormByStaffId(staffId);
	}
	
}
