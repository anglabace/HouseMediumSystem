package pojo;

import java.util.List;

/**
 * �ֵ���
 * @author admin
 *
 */
public class Street {
	//����
	private int street_Id;
	//�ֵ�����
	private String street_Name;
	//����������
	private int area_id;
	//�������
	private Area area;
	public Area getArea() {
		return area;
	}
	public void setArea(Area area) {
		this.area = area;
	}
	//С���б�
	private List<NeighborHood> neighborhoodList;
	public int getStreet_Id() {
		return street_Id;
	}
	public List<NeighborHood> getNeighborhoodList() {
		return neighborhoodList;
	}
	public void setNeighborhoodList(List<NeighborHood> neighborhoodList) {
		this.neighborhoodList = neighborhoodList;
	}
	public void setStreet_Id(int street_Id) {
		this.street_Id = street_Id;
	}
	public String getStreet_Name() {
		return street_Name;
	}
	public void setStreet_Name(String street_Name) {
		this.street_Name = street_Name;
	}
	public int getArea_id() {
		return area_id;
	}
	public void setArea_id(int area_id) {
		this.area_id = area_id;
	}
	
	
	
	
	
	
}
