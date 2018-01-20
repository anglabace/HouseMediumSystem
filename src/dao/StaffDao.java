package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pojo.Staff;
import pojo.StaffForm;
import pojo.StaffHouseStatus;

/**
 * 员工dao类
 * @author admin 郑世杰
 *
 */
public interface StaffDao {
	
	//通过员工手机号码查找用户[用于登陆]
	public Staff findStaffByName(String telephone);
	//通过员工ID查找员工[用于查看个人基本资料]
	public Staff findStaffById(int staffId);
	//根据员工修改员工信息
	public void updateStaffByStaffId(StaffForm staffForm);
	// 根据员工Id修改员工密码
	public void updateStaffPwd(Staff staff);
	//根据员工Id修改员头像
	public void updateStaffHead(Staff staff);
	/**
	 * 分页查找员工信息
	 */
	public List<Staff> findAnotherStaffByPage(int staff_id,int min,int max);
	/**
	 * 查找其他员工数量
	 * @param staff_id
	 * @return
	 */
	public int findAnotherStaffCount(@Param("id")int staff_id);	
	/**
	 * 查询所有员工
	 * @return
	 */
	public List<Staff> findAllStaff();
	/**
	 * 经理查询员工信息或者可以根据名字查询员工新信息
	 */
	public  List<StaffHouseStatus> findAllStaffOrOneStaff(@Param("staff_name")String staff_name,@Param("min")int min,@Param("max")int max);
	
	/**
	 * 升级版 经理查询员工信息
	 */
	public List<StaffHouseStatus> findAllStaffOrOneStaffUp(@Param("staff_name")String staff_name,@Param("min")int min,@Param("max")int max);
	/**
	 * 新增员工
	 */
	public void addStaff(Staff staff);

	/**
	 * 查询员工的所有数量
	 */
	public Integer findAllStaffNum(@Param("staff_name")String staff_name);

	/**
	 * 查询员工数量
	 */
	public int staffCount();
	/**
	 * 分页查询所有员工
	 * @return
	 */
	public List<Staff> findAllStaffByPage(int min,int max);

}
