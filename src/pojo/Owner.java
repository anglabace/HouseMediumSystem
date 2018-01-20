package pojo;

/**
 * 业主信息表
 * @author admin
 *
 */
public class Owner {

	//业主信息表Id
	private int owner_id;
	//业主姓名
	private String owner_name;
	//联系电话
	private String telephone;
	//接受价格
	private float accept_price;
	//身份证号
	private String iD_number;
	//备注信息
	private String remark;
	
	
	public int getOwner_id() {
		return owner_id;
	}
	public void setOwner_id(int owner_id) {
		this.owner_id = owner_id;
	}
	public String getOwner_name() {
		return owner_name;
	}
	public void setOwner_name(String owner_name) {
		this.owner_name = owner_name;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public float getAccept_price() {
		return accept_price;
	}
	public void setAccept_price(float accept_price) {
		this.accept_price = accept_price;
	}
	public String getiD_number() {
		return iD_number;
	}
	public void setiD_number(String iD_number) {
		this.iD_number = iD_number;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	
	
}
