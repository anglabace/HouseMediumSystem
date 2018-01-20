package service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.StaffDao;
import pojo.Staff;
import pojo.StaffForm;
import pojo.StaffHouseStatus;

@Service
public class StaffService {
	@Autowired
	private StaffDao staffDao;
	//��½zsj
	public Staff findStaffByName(String telephone){
		return staffDao.findStaffByName(telephone);
	}
	/**
	 * ��ѯ����Ա������
	 * @param staff_id
	 * @return
	 */

		
	public int findAnotherStaffCount(int staff_id){
		return staffDao.findAnotherStaffCount(staff_id);
		
	}

	/**
	 * ���±�Ա����Ϣ
	 */
	
	public void updateStaffByStaffId(StaffForm staffForm){
		//System.out.println("�������ϸ��½�����");
		staffDao.updateStaffByStaffId(staffForm);
	}
	/**
	 * ����Ա��ID���Ҹ�������
	 */
	public Staff findStaffById(int  staffId){
		return staffDao.findStaffById(staffId);
	}

	/**
	 * �޸�����
	 * @param staff
	 */
	public void updateStaffPwd(Staff staff){
		staffDao.updateStaffPwd(staff);
	}
	
	/**
	 * ��ҳ��ѯ
	 */
	public List<Staff> findAnotherStaffsByPage(int staff_id,int min,int max){
		return staffDao.findAnotherStaffByPage(staff_id, min, max);
	}

	/**
	 * �޸�Ա��ͷ��
	 */
	public void updateStaffHead(Staff staff){
		staffDao.updateStaffHead(staff);
	}

	/**
	 * ��ѯ����Ա��
	 */
	public List<Staff> findAllStaff(){
		return staffDao.findAllStaff();
	}
	/**
	 * �����ҳ��ѯԱ��[�г���/��������]�б�
	 */
	public List<StaffHouseStatus> findAllStaffOrOneStaff(String staff_name,int min,int max){
		return staffDao.findAllStaffOrOneStaff(staff_name, min, max);
	}
	public List<StaffHouseStatus> findAllStaffOrOneStaffUp(String staff_name,int min,int max){
		return staffDao.findAllStaffOrOneStaffUp(staff_name, min, max);
	}
	/**
	 * ���Ա��
	 */
	public void addStaff(Staff staff){
		
		staffDao.addStaff(staff);
	}
	/**
	 * ��ѯԱ������
	 */
	public int staffCount(){
		return staffDao.staffCount();
	}
	/**
	 * ��ҳ��ѯ����Ա��
	 * @return
	 */
	public List<Staff> findAllStaffByPage(int min,int max){
		return staffDao.findAllStaffByPage(min, max);
	}
	/**
	 * ��ѯԱ������
	 */
	public Integer findAllStaffNum(@Param("staff_name")String staff_name){
		return staffDao.findAllStaffNum(staff_name);
	}
}
