package pojo;

/**
 * 房屋装修表
 * @author admin
 *
 */
public class HouseAdornment {

	//装修ID
	private int adornment_Id;
	//装修类型	包括（1、精装修2、豪华装修3、普通装修4、毛坯）
	private String adornment_type;
	
	
	public int getAdornment_Id() {
		return adornment_Id;
	}
	public void setAdornment_Id(int adornment_Id) {
		this.adornment_Id = adornment_Id;
	}
	public String getAdornment_type() {
		return adornment_type;
	}
	public void setAdornment_type(String adornment_type) {
		this.adornment_type = adornment_type;
	}
	
	
	
	
	
}
