package pojo;

/**
 * 房屋方位表
 * @author admin
 *
 */
public class HouseDirection {

	//方位ID
	private int direction_Id;
	//方向类型	（1、	南北通透2、东西向3、东4、西5、 南6、 北）
	private String direction_type;
	
	
	public int getDirection_Id() {
		return direction_Id;
	}
	public void setDirection_Id(int direction_Id) {
		this.direction_Id = direction_Id;
	}
	public String getDirection_type() {
		return direction_type;
	}
	public void setDirection_type(String direction_type) {
		this.direction_type = direction_type;
	}
	

	
	
}
