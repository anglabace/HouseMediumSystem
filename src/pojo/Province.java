package pojo;

import java.util.List;

/**
 * ʡ��
 * @author admin
 *
 */
public class Province {
	//����
	private int province_Id;
	//ʡ����
	private String province_Name;
	//�����б�
	private List<City> cityList;
	public List<City> getCityList() {
		return cityList;
	}
	public void setCityList(List<City> cityList) {
		this.cityList = cityList;
	}
	public int getProvince_Id() {
		return province_Id;
	}
	public void setProvince_Id(int province_Id) {
		this.province_Id = province_Id;
	}
	public String getProvince_Name() {
		return province_Name;
	}
	public void setProvince_Name(String province_Name) {
		this.province_Name = province_Name;
	}


	
	
}
