package pojo;

import java.util.Date;

/**
 * ��Դ������
 * @author admin
 *
 */
public class ClientTrail {
	
	
	//�ͻ�������Id
	private int clientTrail_ID;
	//����ʱ��
	private Date clientTrail_Time;
	//��������
	private String clientTrail_content;
	//��������
	private int clientTrail_type;
	//Ա��id
	private int staff_id;
	//�ͻ�id
	private int client_id;
	//�ͻ�����
	private String client_name;
	//��ѯʹ�õĸ�����ʼʱ��
	private Date startTime;
	//��ѯʹ�õĸ�������ʱ��
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