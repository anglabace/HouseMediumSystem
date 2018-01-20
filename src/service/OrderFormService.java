package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.OrderFormDao;

@Service
public class OrderFormService {
	@Autowired
	private OrderFormDao orderFormDao;
	
	/**
	 * ��ѯ����ҵ������
	 * @return
	 */
	public int findAllOrderFormByStaffId(int staffId){
		return orderFormDao.findAllOrderFormByStaffId(staffId);
	}
	/**
	 * ��ѯ������������
	 */
	public int findBuyOrderFormByStaffId(int staffId){
		return orderFormDao.findBuyOrderFormByStaffId(staffId);
	}
	/**
	 * ����Ա��Id��ѯ��Ա����������ҵ������
	 */
	public int findSemesterCountOrderFormByStaffId(int staffId){
		return orderFormDao.findSemesterCountOrderFormByStaffId(staffId);
	}
	
}