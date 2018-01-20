package dao;

import pojo.OrderForm;

public interface OrderFormDao {

	/**
	 * 查询个人业务总数
	 */
	public int findAllOrderFormByStaffId(int staffId);
	/**
	 * 查询个人卖房总数
	 */
	public int findBuyOrderFormByStaffId(int staffId);
	/**
	 * 根据员工Id查询该员工半年来的业务总数
	 */
	public int findSemesterCountOrderFormByStaffId(int staffId);
	/**
	 * 新增订单数据
	 */
	public void addOrderForm(OrderForm orderForm);
}
