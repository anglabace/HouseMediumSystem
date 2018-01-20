package pojo;

/**
 * 房源结构表
 * @author admin
 *
 */
public class HouseBuild {
	
	//建筑结构表id
	private int houseBuild_id;
	//建筑结构类型	(1.钢混结构2.砖混结构3.砖木结构4.钢结构)
	private String build_Type;
	
	
	public int getHouseBuild_id() {
		return houseBuild_id;
	}
	public void setHouseBuild_id(int houseBuild_id) {
		this.houseBuild_id = houseBuild_id;
	}
	public String getBuild_Type() {
		return build_Type;
	}
	public void setBuild_Type(String build_Type) {
		this.build_Type = build_Type;
	}

	
	
	
}
