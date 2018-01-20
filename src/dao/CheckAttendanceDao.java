package dao;

import java.util.List;

import pojo.CheckAttendance;

public interface CheckAttendanceDao {

	/**
	 * 添加一条考勤记录
	 */
	public void addAttendance(int staff_id);
	
	/**
	 * 查询员工本月考勤记录
	 */
	public List<CheckAttendance> findAttendances(int staff_id,int min,int max);
	
	/**
	 * 根据员工Id查询该员工当月打卡次数
	 */
	public int findCountCheckByStaffId(int staffId);
	/**
	 * 查询员工当天考勤次数
	 */
	public int findCountCheckToday(int staffId);
}
