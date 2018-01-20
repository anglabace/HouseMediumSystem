package pojo;

import java.util.Date;

/**
 * 客源跟进表
 * @author admin
 *
 */
public class ClientTrail {
	
	
	//客户跟进表Id
	private int clientTrail_ID;
	//跟进时间
	private Date clientTrail_Time;
	//跟进内容
	private String clientTrail_content;
	//跟进类型
	private int clientTrail_type;
	//员工id
	private int staff_id;
	//客户id
	private int client_id;
	//客户姓名
	private String client_name;
	//查询使用的跟进开始时间
	private Date startTime;
	//查询使用的跟进结束时间
	private Date endTime;
	
	
	
	
	
	public String getClient_name() {
		return client_name;
	}
	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public int getClientTrail_ID() {
		return clientTrail_ID;
	}
	public void setClientTrail_ID(int clientTrail_ID) {
		this.clientTrail_ID = clientTrail_ID;
	}
	public Date getClientTrail_Time() {
		return clientTrail_Time;
	}
	public void setClientTrail_Time(Date clientTrail_Time) {
		this.clientTrail_Time = clientTrail_Time;
	}
	public String getClientTrail_content() {
		return clientTrail_content;
	}
	public void setClientTrail_content(String clientTrail_content) {
		this.clientTrail_content = clientTrail_content;
	}
	
	public int getClientTrail_type() {
		return clientTrail_type;
	}
	public void setClientTrail_type(int clientTrail_type) {
		this.clientTrail_type = clientTrail_type;
	}
	public int getStaff_id() {
		return staff_id;
	}
	public void setStaff_id(int staff_id) {
		this.staff_id = staff_id;
	}
	public int getClient_id() {
		return client_id;
	}
	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}

	
	
	
}
