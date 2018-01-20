package pojo;

import java.util.Date;
import java.util.List;

/**
 * 包含房源状态的信息Staff类
 * @author admin
 *
 */
public class StaffHouseStatus {
	private int staff_id;
	private int rentting;//出租的集合
	private List<HouseResource> renttingList;
	private int outtime;
	private int saling;//出售的集合
	private List<HouseResource> salingList;
	private int completed;
	private String staff_name;
	private String telephone;
	private Date hire_date; 
	public List<HouseResource> getRenttingList() {
		return renttingList;
	}
	public void setRenttingList(List<HouseResource> renttingList) {
		this.renttingList = renttingList;
	}
	public List<HouseResource> getSalingList() {
		return salingList;
	}
	public void setSalingList(List<HouseResource> salingList) {
		this.salingList = salingList;
	}
	public int getStaff_id() {
		return staff_id;
	}
	public void setStaff_id(int staff_id) {
		this.staff_id = staff_id;
	}
	public int getRentting() {
		return rentting;
	}
	public void setRentting(int rentting) {
		this.rentting = rentting;
	}
	public int getOuttime() {
		return outtime;
	}
	public void setOuttime(int outtime) {
		this.outtime = outtime;
	}
	public int getSaling() {
		return saling;
	}
	public void setSaling(int saling) {
		this.saling = saling;
	}
	public int getCompleted() {
		return completed;
	}
	public void setCompleted(int completed) {
		this.completed = completed;
	}
	public String getStaff_name() {
		return staff_name;
	}
	public void setStaff_name(String staff_name) {
		this.staff_name = staff_name;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public Date getHire_date() {
		return hire_date;
	}
	public void setHire_date(Date hire_date) {
		this.hire_date = hire_date;
	}
}
