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
	//登陆zsj
	public Staff findStaffByName(String telephone){
		return staffDao.findStaffByName(telephone);
	}
	/**
	 * 查询其他员工数量
	 * @param staff_id
	 * @return
	 */

		
	public int findAnotherStaffCount(int staff_id){
		return staffDao.findAnotherStaffCount(staff_id);
		
	}

	/**
	 * 更新本员工信息
	 */
	
	public void updateStaffByStaffId(StaffForm staffForm){
		//System.out.println("个人资料更新进来了");
		staffDao.updateStaffByStaffId(staffForm);
	}
	/**
	 * 根据员工ID查找个人资料
	 */
	public Staff findStaffById(int  staffId){
		return staffDao.findStaffById(staffId);
	}

	/**
	 * 修改密码
	 * @param staff
	 */
	public void updateStaffPwd(Staff staff){
		staffDao.updateStaffPwd(staff);
	}
	
	/**
	 * 分页查询
	 */
	public List<Staff> findAnotherStaffsByPage(int staff_id,int min,int max){
		return staffDao.findAnotherStaffByPage(staff_id, min, max);
	}

	/**
	 * 修改员工头像
	 */
	public void updateStaffHead(Staff staff){
		staffDao.updateStaffHead(staff);
	}

	/**
	 * 查询所有员工
	 */
	public List<Staff> findAllStaff(){
		return staffDao.findAllStaff();
	}
	/**
	 * 经理分页查询员工[有出售/出租数量]列表
	 */
	public List<StaffHouseStatus> findAllStaffOrOneStaff(String staff_name,int min,int max){
		return staffDao.findAllStaffOrOneStaff(staff_name, min, max);
	}
	public List<StaffHouseStatus> findAllStaffOrOneStaffUp(String staff_name,int min,int max){
		return staffDao.findAllStaffOrOneStaffUp(staff_name, min, max);
	}
	/**
	 * 添加员工
	 */
	public void addStaff(Staff staff){
		
		staffDao.addStaff(staff);
	}
	/**
	 * 查询员工数量
	 */
	public int staffCount(){
		return staffDao.staffCount();
	}
	/**
	 * 分页查询所有员工
	 * @return
	 */
	public List<Staff> findAllStaffByPage(int min,int max){
		return staffDao.findAllStaffByPage(min, max);
	}
	/**
	 * 查询员工数量
	 */
	public Integer findAllStaffNum(@Param("staff_name")String staff_name){
		return staffDao.findAllStaffNum(staff_name);
	}
}
