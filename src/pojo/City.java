package pojo;

import java.util.List;

/**
 * �б�
 * @author admin
 *
 */
public class City {
	//����s
	private int city_Id;
	//�ֵ�����
	private String city_Name;
	//ʡ�������������
	private int province_id;
	//�����б�
	private List<Area> areaList;
	public List<Area> getAreaList() {
		return areaList;
	}
	public void setAreaList(List<Area> areaList) {
		this.areaList = areaList;
	}
	public int getCity_Id() {
		return city_Id;
	}
	public void setCity_Id(int city_Id) {
		this.city_Id = city_Id;
	}
	public String getCity_Name() {
		return city_Name;
	}
	public void setCity_Name(String city_Name) {
		this.city_Name = city_Name;
	}
	public int getProvince_id() {
		return province_id;
	}
	public void setProvince_id(int province_id) {
		this.province_id = province_id;
	}
}