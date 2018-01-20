package pojo;

import java.util.List;

/**
 * 郑世杰：小区【楼盘对象】
 * @author admin
 *
 */
public class Villege {
	//小区集合
	private List<NeighborHood> listNeighborHood;
	//街道结合
	private List<Street> listStreet;
	//区域结合
	private List<Area> listArea;
	//城市集合
	private List<City> listCity;
	//小区
	private NeighborHood neighborHood;
	//街道
	private Street street;
	//区域
	private Area area;
	//城市
	private City city;
	public NeighborHood getNeighborHood() {
		return neighborHood;
	}
	public void setNeighborHood(NeighborHood neighborHood) {
		this.neighborHood = neighborHood;
	}
	public Street getStreet() {
		return street;
	}
	public void setStreet(Street street) {
		this.street = street;
	}
	public Area getArea() {
		return area;
	}
	public void setArea(Area area) {
		this.area = area;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public List<NeighborHood> getListNeighborHood() {
		return listNeighborHood;
	}
	public void setListNeighborHood(List<NeighborHood> listNeighborHood) {
		this.listNeighborHood = listNeighborHood;
	}
	public List<Street> getListStreet() {
		return listStreet;
	}
	public void setListStreet(List<Street> listStreet) {
		this.listStreet = listStreet;
	}
	public List<Area> getListArea() {
		return listArea;
	}
	public void setListArea(List<Area> listArea) {
		this.listArea = listArea;
	}
	public List<City> getListCity() {
		return listCity;
	}
	public void setListCity(List<City> listCity) {
		this.listCity = listCity;
	}
	
}
