package pojo;

import java.util.Date;

/**
 * ������¼��
 * @author admin
 *
 */
public class OrderForm {

	//������¼��ID
	private int orderForm_id;
	//��ͬid
	private int contract_id;
	//��������ʱ��
	private Date orderForm_time;
	//����״̬
	private int orderForm_status;

	
	public int getOrderForm_id() {
		return orderForm_id;
	}
	public void setOrderForm_id(int orderForm_id) {
		this.orderForm_id = orderForm_id;
	}
	public int getContract_id() {
		return contract_id;
	}
	public void setContract_id(int contract_id) {
		this.contract_id = contract_id;
	}
	public Date getOrderForm_time() {
		return orderForm_time;
	}
	public void setOrderForm_time(Date orderForm_time) {
		this.orderForm_time = orderForm_time;
	}
	public int getOrderForm_status() {
		return orderForm_status;
	}
	public void setOrderForm_status(int orderForm_status) {
		this.orderForm_status = orderForm_status;
	}
	
}
