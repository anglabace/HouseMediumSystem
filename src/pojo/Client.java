package pojo;

import java.util.Date;
import java.util.List;

/**
 * 客户信息表
 * @author admin
 *
 */
public class Client {

	//客户id
	private int client_id;
	//客户姓名
	private String client_name;
	//电话
	private String telephone;
	//性别
	private String sex;
	//联系地址
	private String address;
	//微信
	private String wechat;
	//QQ
	private String QQ;
	//邮箱
	private String email;
	//客户状态
	private int client_status;
	//员工id 外键
	private int staff_id;
	//客户需求集合
	private List<ClientRequirement> clientReqList;
	//客户信息写入时间
	private Date client_time;
	
	public int getClient_id() {
		return client_id;
	}
	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}
	public String getClient_name() {
		return client_name;
	}
	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getWechat() {
		return wechat;
	}
	public void setWechat(String wechat) {
		this.wechat = wechat;
	}
	public String getQQ() {
		return QQ;
	}
	public void setQQ(String qQ) {
		QQ = qQ;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getClient_status() {
		return client_status;
	}
	public void setClient_status(int client_status) {
		this.client_status = client_status;
	}
	public int getStaff_id() {
		return staff_id;
	}
	public void setStaff_id(int staff_id) {
		this.staff_id = staff_id;
	}
	public List<ClientRequirement> getClientReqList() {
		return clientReqList;
	}
	public void setClientReqList(List<ClientRequirement> clientReqList) {
		this.clientReqList = clientReqList;
	}
	public Date getClient_time() {
		return client_time;
	}
	public void setClient_time(Date client_time) {
		this.client_time = client_time;
	}
}
