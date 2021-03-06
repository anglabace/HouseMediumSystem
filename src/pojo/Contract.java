package pojo;

import java.util.Date;

/**
 * 合同信息表
 * @author admin
 *
 */
public class Contract {

	//合同id
	private int Contract_id;
	//成交价
	private float Bid;
	//合同价
	private float Contract_price;
	//合同时间
	private Date Contract_Time;
	//合同备注
	private String Contract_remark;
	//合同状态
	private int Contract_status;
	//租期
	private int lease;
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	//开始日期
	private Date Start_day;
	//合同类型
	private int Contract_type;
	//员工id
	private int Staff_id;
	//员工对象
	private Staff staff;
	//客户ID
	private int Client_id;
	//房源ID
	private int house_id;
	
	private HouseResource house;
	private Client client;
	
	
	public HouseResource getHouse() {
		return house;
	}
	public void setHouse(HouseResource house) {
		this.house = house;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public int getContract_id() {
		return Contract_id;
	}
	public void setContract_id(int contract_id) {
		Contract_id = contract_id;
	}
	public float getBid() {
		return Bid;
	}
	public void setBid(float bid) {
		Bid = bid;
	}
	public float getContract_price() {
		return Contract_price;
	}
	public void setContract_price(float contract_price) {
		Contract_price = contract_price;
	}
	public Date getContract_Time() {
		return Contract_Time;
	}
	public void setContract_Time(Date contract_Time) {
		Contract_Time = contract_Time;
	}
	public String getContract_remark() {
		return Contract_remark;
	}
	public void setContract_remark(String contract_remark) {
		Contract_remark = contract_remark;
	}
	public int getContract_status() {
		return Contract_status;
	}
	public void setContract_status(int contract_status) {
		Contract_status = contract_status;
	}
	public int getLease() {
		return lease;
	}
	public void setLease(int lease) {
		this.lease = lease;
	}
	public Date getStart_day() {
		return Start_day;
	}
	public void setStart_day(Date start_day) {
		Start_day = start_day;
	}
	public int getContract_type() {
		return Contract_type;
	}
	public void setContract_type(int contract_type) {
		Contract_type = contract_type;
	}
	public int getStaff_id() {
		return Staff_id;
	}
	public void setStaff_id(int staff_id) {
		Staff_id = staff_id;
	}
	public int getClient_id() {
		return Client_id;
	}
	public void setClient_id(int client_id) {
		Client_id = client_id;
	}
	public int getHouse_id() {
		return house_id;
	}
	public void setHouse_id(int house_id) {
		this.house_id = house_id;
	}

	
	
	
}
