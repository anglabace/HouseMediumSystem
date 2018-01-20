package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pojo.ClientTrail;

public interface ClientTrailDao {
	/**
	 * 根据员工Id获取当月跟进客源数
	 */
	public int findCurrentClientTrailByStaffId(int staffId);
	
	/**
	 * 添加客户跟进记录
	 */
	public void addClientTrail(ClientTrail clientTrail);

	/**
	 * 根据员工id分页查询该员工负责的客户跟进记录
	 */
	public List<ClientTrail> findAllClientTrailByStaffId(int staff_id,int minRow,int maxRow);

	
	/**
	 * 根据员工id查询该员工负责的客户跟进记录总数
	 */
	public int findAllClientTrailCountByStaffId(int staff_id);
	
	/**
	 * 根据客户跟进表的id删除客户跟进记录
	 */
	public void deleteSingleClientTrailById(int clientTrail_id);
	
	/**
	 * 根据客户跟进时间或类型查找客户跟进记录
	 */
	public List<ClientTrail> findByClientTrail(@Param("clientTrail")ClientTrail clientTrail,int minRow,int maxRow);
	
	
	/**
	 * 根据客户跟进时间或类型查找客户跟进记录总数
	 */
	public int findCountByClientTrail(@Param("clientTrail")ClientTrail clientTrail);
}

