package pojo;

import java.util.List;

/**
 * ֣���ܣ�С����¥�̶���
 * @author admin
 *
 */
public class Villege {
	//С������
	private List<NeighborHood> listNeighborHood;
	//�ֵ����
	private List<Street> listStreet;
	//������
	private List<Area> listArea;
	//���м���
	private List<City> listCity;
	//С��
	private NeighborHood neighborHood;
	//�ֵ�
	private Street street;
	//����
	private Area area;
	//����
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
