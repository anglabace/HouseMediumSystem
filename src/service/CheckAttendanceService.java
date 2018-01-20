package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.CheckAttendanceDao;
import pojo.CheckAttendance;

@Service
public class CheckAttendanceService {
	@Autowired
	private CheckAttendanceDao checkAttendanceDao;
	
	/**
	 * 新增考勤信息
	 * @param checkAttendance
	 */
	public void addAttendance(int staff_id){
		checkAttendanceDao.addAttendance(staff_id);
	}
	/**
	 * 查询本月考勤
	 */
	public List<CheckAttendance> findAttendances(int staff_id,int min,int max){
		return checkAttendanceDao.findAttendances(staff_id,min,max);
	}
	/**
	 * 根据员工Id查询该员工当月打卡次数
	 */
	public int findCountCheckByStaffId(int staffId){
		return checkAttendanceDao.findCountCheckByStaffId(staffId);
	}
	/**
	 * 查询员工当天考勤次数
	 */
	public int findCountCheckToday(int staffId){
		return checkAttendanceDao.findCountCheckToday(staffId);
	}
}
