package dao;

import java.util.List;

import pojo.HouseTrail;

public interface HouseTrailDao {

	/**
	 * 根据员工Id获取当月跟进房源数
	 */
	public int findCurrentHouseTrailByStaffId(int staffId);
	
	/**
	 * 根据员工Id获取员工跟进的出售房源跟进条数
	 */
	public int findSellHouseTrailCountByStaffId(int staffId);
	/**
	 * 分页获取员工跟进的出售房源跟进记录
	 */
	public List<HouseTrail> findSellHouseTrail(int staffId,int min,int max);
	/**
	 * 根据员工Id获取员工跟进的出租房源跟进条数
	 */
	public int findLeaseHouseTrailCountByStaffId(int staffId);
	
	/**
	 * 分页获取员工跟进的出租房源跟进记录
	 */
	public List<HouseTrail> findLeaseHouseTrail(int staffId,int min,int max);
	/**
	 * 根据房源id添加房源跟进信息
	 */
	public void addHouseTrail();
}
