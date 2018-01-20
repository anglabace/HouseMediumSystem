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
	 * �������۷�
	 * @param h
	 */
	public void addHouse(HouseResource h){
		houseResourceDao.addHouse(h);
	}
	/**
	 * ����Ա��Id��ѯ�����������۷�
	 */
	public int findCurrentBuyHouseByStaffId(int staffId){
		return houseResourceDao.findCurrentBuyHouseByStaffId(staffId);
	}
	/**
	 * ����Ա��Id��ѯ�����������ⷿ
	 */
	public int findCurrentLeaseHouseByStaffId(int staffId){
		return houseResourceDao.findCurrentLeaseHouseByStaffId(staffId);
	}
	/**
	 * ����Ա��Id��ѯ��Ա����������������Դ��
	 */
	public int findSemesterCountHouseByStaffId(int staffId){
		return houseResourceDao.findSemesterCountHouseByStaffId(staffId);
	}
	/**
	 * ����Ա��id��ѯ��Դ��Ϣ
	 */
	public List<HouseResource> findHouseResourceInfos(int staffId,int min,int max){
		return houseResourceDao.findHouseResourceInfos(staffId,min,max);
	}
	/**
	 * ����Ա��Id��ѯ���۷�Դ��Ϣ
	 */
	public List<HouseResource> findSellHouseResourceInfos(int staffId,int min,int max){
		return houseResourceDao.findSellHouseResourceInfos(staffId,min, max);
	}
	/**
	 * ����Ա��Id��ѯ���۷�Դ����
	 */
	public int findSellCountHouseResource(int staffId){
		return houseResourceDao.findSellCountHouseResource(staffId);
	}
	/**
	 * ����Ա��Id��ѯ���ⷿԴ��Ϣ
	 */
	public List<HouseResource> findLeaseHouseResourceInfos(int staffId,int min,int max){
		return houseResourceDao.findLeaseHouseResourceInfos(staffId,min, max);
	}
	/**
	 * ����Ա��Id��ѯ���ⷿԴ����
	 */
	public int findLeaseCountHouseResource(int staffId){
		return houseResourceDao.findLeaseCountHouseResource(staffId);
	}
	/**
	 * ���ݷ�ԴIdɾ����Դ
	 */
	public void deleteHouseResource(int houseResource_id){
		houseResourceDao.deleteHouseResource(houseResource_id);
	}
	/**
	 * ���ݷ�Դid���ҷ�Դ
	 */
	public HouseResource findHouseByHouseId(int houseId){
		return houseResourceDao.findHouseByHouseId(houseId);
	}

	/**
	 * �޸ķ�Դ��Ա��id
	 */
	public void updateStaffIdInHouseResource(int staffId1,int staffId2){
		houseResourceDao.updateStaffIdInHouseResource(staffId1,staffId2);
	}
	/**
	 * ���ҳ��۵ķ�Դ�б�
	 */
	public List<HouseResource> findSellHouse(int staff_id){
		return houseResourceDao.findSellHouse(staff_id);
	}
	/**
	 * ���ҳ���ķ�Դ�б�
	 */
	public List<HouseResource> findRentHouse(int staff_id){
		return houseResourceDao.findRentHouse(staff_id);
	}
	/**
	 * �޸ķ�Դ״̬
	 */
	public void updateHouseStatus(int houseId,int status){
		houseResourceDao.updateHouseStatus(houseId, status);
	}

	/**
	 * ���ӳ��ⷿԴ��Ϣ
	 */
	public void addRentHouseResource( int houseresource_id,String floor_,String ceil_,String doorplate,int room,int hall,int toilet,int balcony,int kitchen,int tier,int total_tiers,double total_price,double build_areas,double inside_areas,Date publishTime,String houseResource_title,String houseResource_describe,int heatingcondition,int application_id,int adornment_id,int direction_id,int houseAttribute_id,int owner_id,int neighborhood_id,String houseconfigure,double rent,int type,int status,int staff_id){
		houseResourceDao.addRentHouseResource(houseresource_id, floor_, ceil_, doorplate, room, hall, toilet, balcony, kitchen, tier, total_tiers, total_price, build_areas, inside_areas, publishTime, houseResource_title, houseResource_describe, heatingcondition, application_id, adornment_id, direction_id, houseAttribute_id, owner_id, neighborhood_id, houseconfigure, rent, type, status, staff_id);
	}
	
	/**
	 * ���ݿͻ��������ƥ�䷿Դ
	 */
	public List<HouseResource> findHouseRsesourceByClientReq(int staff_id,int application_id,float minPrice,float maxPrice,String siteRequirement,@Param("flag")int flag){
		return houseResourceDao.findHouseRsesourceByClientReq(staff_id, application_id, minPrice, maxPrice, siteRequirement, flag);
	}
	/**
	 * ����Ա��id��ѯ��Դ����
	 */
	public int findHouseResourceCount(int staffId){
		return houseResourceDao.findHouseResourceCount(staffId);
	}
	
}