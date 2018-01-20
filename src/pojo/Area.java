package pojo;

import java.util.List;

/**
 * 区域表
 * @author admin
 *
 */
public class Area {

	//主键
	private int area_Id;
	//区域名称
	private String area_Name;
	//市表（外键）
	private int city_id;
	//城市对象
	private City city;
	//街道列表
	private List<Street> streetList;
	
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	
	public List<Street> getStreetList() {
		return streetList;
	}
	public void setStreetList(List<Street> streetList) {
		this.streetList = streetList;
	}
	public int getArea_Id() {
		return area_Id;
	}
	public void setArea_Id(int area_Id) {
		this.area_Id = area_Id;
	}
	public String getArea_Name() {
		return area_Name;
	}
	public void setArea_Name(String area_Name) {
		this.area_Name = area_Name;
	}
	public int getCity_id() {
		return city_id;
	}
	public void setCity_id(int city_id) {
		this.city_id = city_id;
	}
	
	
	
	
}
