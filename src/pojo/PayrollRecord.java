package pojo;

import java.util.Date;

/**
 * н�ʼ�¼��
 * @author admin
 *
 */
public class PayrollRecord {

	//н�ʱ�Id
	private int STAFFSalary_id;
	//н�ʱ�����
	private Date SalaryDate;
	//����н��
	private float BasePay;
	//����
	private float Bounus;
	//���
	private float Commission;
	//Ա��id
	private int Staff_id;
	
	
	
	public int getSTAFFSalary_id() {
		return STAFFSalary_id;
	}
	public void setSTAFFSalary_id(int sTAFFSalary_id) {
		STAFFSalary_id = sTAFFSalary_id;
	}
	public Date getSalaryDate() {
		return SalaryDate;
	}
	public void setSalaryDate(Date salaryDate) {
		SalaryDate = salaryDate;
	}
	public float getBasePay() {
		return BasePay;
	}
	public void setBasePay(float basePay) {
		BasePay = basePay;
	}
	public float getBounus() {
		return Bounus;
	}
	public void setBounus(float bounus) {
		Bounus = bounus;
	}
	public float getCommission() {
		return Commission;
	}
	public void setCommission(float commission) {
		Commission = commission;
	}
	public int getStaff_id() {
		return Staff_id;
	}
	public void setStaff_id(int staff_id) {
		Staff_id = staff_id;
	}

	
	
	
}
