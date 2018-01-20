package pojo;

import java.util.List;

/**
 * 省表
 * @author admin
 *
 */
public class Province {
	//主键
	private int province_Id;
	//省名称
	private String province_Name;
	//城市列表
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
