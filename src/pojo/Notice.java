package pojo;

import java.util.Date;

/**
 * �����
 * @author admin
 *
 */
public class Notice {
	
	//����ID
	private int notice_Id;
	//�������
	private String notice_title;
	//��������
	private String notice_content;
	//����ʱ��
	private Date notice_time;
	//Ա��id
	private int staff_id;
	public int getNotice_Id() {
		return notice_Id;
	}
	public void setNotice_Id(int notice_Id) {
		this.notice_Id = notice_Id;
	}
	public String getNotice_title() {
		return notice_title;
	}
	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}
	public String getNotice_content() {
		return notice_content;
	}
	public void setNotice_content(String notice_content) {
		this.notice_content = notice_content;
	}
	public Date getNotice_time() {
		return notice_time;
	}
	public void setNotice_time(Date notice_time) {
		this.notice_time = notice_time;
	}
	public int getStaff_id() {
		return staff_id;
	}
	public void setStaff_id(int staff_id) {
		this.staff_id = staff_id;
	}

	
	
	
}
