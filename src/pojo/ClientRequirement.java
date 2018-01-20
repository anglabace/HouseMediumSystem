package pojo;

/**
 * �ͻ������
 * @author admin
 *
 */
public class ClientRequirement {

	//�ͻ������id
	private int clientRequirement_id;
	//�ͻ�����
	private int client_type;
	//��
	private int room;
	//��
	private int hall;
	//��
	private int toilet;
	//��С����
	private int min_tier;
	//������
	private int max_tier;
	//��С�۸�
	private float min_price;
	//���۸�
	private float max_price;
	//��С���
	private float min_area;
	//������
	private float max_area;
	//�ͻ���ע
	private String remark;
	//����Ҫ��
	private String siteRequirement;
	//���ʽ   (1.�̴�2.������3.��Ѻ��4.������5.����)
	private int clientPay_Type;
	//������;
	private int application_Id;
	//����װ��
	private int adornment_Id;
	//���ݷ�λ
	private int direction_Id;
	//�ͻ�id ���
	private int client_id;
	//�ͻ�״̬
	private int client_status;
	
	private Client client;
	
	
	
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public int getClient_status() {
		return client_status;
	}
	public void setClient_status(int client_status) {
		this.client_status = client_status;
	}
	public int getClientRequirement_id() {
		return clientRequirement_id;
	}
	public void setClientRequirement_id(int clientRequirement_id) {
		this.clientRequirement_id = clientRequirement_id;
	}
	public int getClient_type() {
		return client_type;
	}
	public void setClient_type(int client_type) {
		this.client_type = client_type;
	}
	public int getRoom() {
		return room;
	}
	public void setRoom(int room) {
		this.room = room;
	}
	public int getHall() {
		return hall;
	}
	public void setHall(int hall) {
		this.hall = hall;
	}
	public int getToilet() {
		return toilet;
	}
	public void setToilet(int toilet) {
		this.toilet = toilet;
	}
	
	public int getMin_tier() {
		return min_tier;
	}
	public void setMin_tier(int min_tier) {
		this.min_tier = min_tier;
	}
	public int getMax_tier() {
		return max_tier;
	}
	public void setMax_tier(int max_tier) {
		this.max_tier = max_tier;
	}
	public float getMin_price() {
		return min_price;
	}
	public void setMin_price(float min_price) {
		this.min_price = min_price;
	}
	public float getMax_price() {
		return max_price;
	}
	public void setMax_price(float max_price) {
		this.max_price = max_price;
	}
	public float getMin_area() {
		return min_area;
	}
	public void setMin_area(float min_area) {
		this.min_area = min_area;
	}
	public float getMax_area() {
		return max_area;
	}
	public void setMax_area(float max_area) {
		this.max_area = max_area;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getSiteRequirement() {
		return siteRequirement;
	}
	public void setSiteRequirement(String siteRequirement) {
		this.siteRequirement = siteRequirement;
	}
	public int getClientPay_Type() {
		return clientPay_Type;
	}
	public void setClientPay_Type(int clientPay_Type) {
		this.clientPay_Type = clientPay_Type;
	}
	public int getApplication_Id() {
		return application_Id;
	}
	public void setApplication_Id(int application_Id) {
		this.application_Id = application_Id;
	}
	public int getAdornment_Id() {
		return adornment_Id;
	}
	public void setAdornment_Id(int adornment_Id) {
		this.adornment_Id = adornment_Id;
	}
	public int getDirection_Id() {
		return direction_Id;
	}
	public void setDirection_Id(int direction_Id) {
		this.direction_Id = direction_Id;
	}
	public int getClient_id() {
		return client_id;
	}
	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}
	@Override
	public String toString() {
		return "��ϸ��Ϣ��ClientRequirement [room=" + room + ", min_tier=" + min_tier + ", max_tier="
				+ max_tier + ", min_price=" + min_price + ", max_price=" + max_price + ", min_area=" + min_area
				+ ", max_area=" + max_area + ", application_Id=" + application_Id + ", adornment_Id="
				+ adornment_Id + ", direction_Id=" + direction_Id + ",client_status="
				+ client_status + "]";
	}
	
	
}