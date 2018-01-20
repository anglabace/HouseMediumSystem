package service;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.*;
import pojo.*;

@Service
public class HouseService {
	@Autowired
	private HouseResourceDao houseResourceDao;
	/**
	 * 新增出售房
	 * @param h
	 */
	public void addHouse(HouseResource h){
		houseResourceDao.addHouse(h);
	}
	/**
	 * 根据员工Id查询当月新增出售房
	 */
	public int findCurrentBuyHouseByStaffId(int staffId){
		return houseResourceDao.findCurrentBuyHouseByStaffId(staffId);
	}
	/**
	 * 根据员工Id查询当月新增出租房
	 */
	public int findCurrentLeaseHouseByStaffId(int staffId){
		return houseResourceDao.findCurrentLeaseHouseByStaffId(staffId);
	}
	/**
	 * 根据员工Id查询该员工半年来的新增房源数
	 */
	public int findSemesterCountHouseByStaffId(int staffId){
		return houseResourceDao.findSemesterCountHouseByStaffId(staffId);
	}
	/**
	 * 根据员工id查询房源信息
	 */
	public List<HouseResource> findHouseResourceInfos(int staffId,int min,int max){
		return houseResourceDao.findHouseResourceInfos(staffId,min,max);
	}
	/**
	 * 根据员工Id查询出售房源信息
	 */
	public List<HouseResource> findSellHouseResourceInfos(int staffId,int min,int max){
		return houseResourceDao.findSellHouseResourceInfos(staffId,min, max);
	}
	/**
	 * 根据员工Id查询出售房源总数
	 */
	public int findSellCountHouseResource(int staffId){
		return houseResourceDao.findSellCountHouseResource(staffId);
	}
	/**
	 * 根据员工Id查询出租房源信息
	 */
	public List<HouseResource> findLeaseHouseResourceInfos(int staffId,int min,int max){
		return houseResourceDao.findLeaseHouseResourceInfos(staffId,min, max);
	}
	/**
	 * 根据员工Id查询出租房源总数
	 */
	public int findLeaseCountHouseResource(int staffId){
		return houseResourceDao.findLeaseCountHouseResource(staffId);
	}
	/**
	 * 根据房源Id删除房源
	 */
	public void deleteHouseResource(int houseResource_id){
		houseResourceDao.deleteHouseResource(houseResource_id);
	}
	/**
	 * 根据房源id查找房源
	 */
	public HouseResource findHouseByHouseId(int houseId){
		return houseResourceDao.findHouseByHouseId(houseId);
	}

	/**
	 * 修改房源的员工id
	 */
	public void updateStaffIdInHouseResource(int staffId1,int staffId2){
		houseResourceDao.updateStaffIdInHouseResource(staffId1,staffId2);
	}
	/**
	 * 查找出售的房源列表
	 */
	public List<HouseResource> findSellHouse(int staff_id){
		return houseResourceDao.findSellHouse(staff_id);
	}
	/**
	 * 查找出租的房源列表
	 */
	public List<HouseResource> findRentHouse(int staff_id){
		return houseResourceDao.findRentHouse(staff_id);
	}
	/**
	 * 修改房源状态
	 */
	public void updateHouseStatus(int houseId,int status){
		houseResourceDao.updateHouseStatus(houseId, status);
	}

	/**
	 * 增加出租房源信息
	 */
	public void addRentHouseResource( int houseresource_id,String floor_,String ceil_,String doorplate,int room,int hall,int toilet,int balcony,int kitchen,int tier,int total_tiers,double total_price,double build_areas,double inside_areas,Date publishTime,String houseResource_title,String houseResource_describe,int heatingcondition,int application_id,int adornment_id,int direction_id,int houseAttribute_id,int owner_id,int neighborhood_id,String houseconfigure,double rent,int type,int status,int staff_id){
		houseResourceDao.addRentHouseResource(houseresource_id, floor_, ceil_, doorplate, room, hall, toilet, balcony, kitchen, tier, total_tiers, total_price, build_areas, inside_areas, publishTime, houseResource_title, houseResource_describe, heatingcondition, application_id, adornment_id, direction_id, houseAttribute_id, owner_id, neighborhood_id, houseconfigure, rent, type, status, staff_id);
	}
	
	/**
	 * 根据客户需求快速匹配房源
	 */
	public List<HouseResource> findHouseRsesourceByClientReq(int staff_id,int application_id,float minPrice,float maxPrice,String siteRequirement,@Param("flag")int flag){
		return houseResourceDao.findHouseRsesourceByClientReq(staff_id, application_id, minPrice, maxPrice, siteRequirement, flag);
	}
	/**
	 * 根据员工id查询房源总数
	 */
	public int findHouseResourceCount(int staffId){
		return houseResourceDao.findHouseResourceCount(staffId);
	}
	
}
