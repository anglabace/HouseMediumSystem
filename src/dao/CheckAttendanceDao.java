package dao;

import java.util.List;

import pojo.CheckAttendance;

public interface CheckAttendanceDao {

	/**
	 * ���һ�����ڼ�¼
	 */
	public void addAttendance(int staff_id);
	
	/**
	 * ��ѯԱ�����¿��ڼ�¼
	 */
	public List<CheckAttendance> findAttendances(int staff_id,int min,int max);
	
	/**
	 * ����Ա��Id��ѯ��Ա�����´򿨴���
	 */
	public int findCountCheckByStaffId(int staffId);
	/**
	 * ��ѯԱ�����쿼�ڴ���
	 */
	public int findCountCheckToday(int staffId);
}
