package pojo;

/**
 * 房屋用途表
 * @author admin
 *
 */
public class HouseApplication {
	
	//房屋用途ID
	private int application_id;
	//用途类型	包括（1、自建房 2、写字楼 3、仓库 4、商铺 5、住宅 6、别墅）
	private String application_type;
	
	
	

	public int getApplication_id() {
		return application_id;
	}
	public void setApplication_id(int application_id) {
		this.application_id = application_id;
	}
	public String getApplication_type() {
		return application_type;
	}
	public void setApplication_type(String application_type) {
		this.application_type = application_type;
	}

		
	
	
}
