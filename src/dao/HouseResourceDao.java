package dao;



import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import pojo.*;

public interface HouseResourceDao {

	/**
	 * ���ӷ�Դ��Ϣ
	 * @param h
	 */
	public void addHouse(HouseResource h);
	/**
	 * ����Ա��Id��ѯ�����������۷�
	 */
	public int findCurrentBuyHouseByStaffId(int staffId);
	/**
	 * ����Ա��Id��ѯ�����������ⷿ
	 */
	public int findCurrentLeaseHouseByStaffId(int staffId);
	
	/**
	 * ����Ա��Id��ѯ��Ա����������������Դ��
	 */
	public int findSemesterCountHouseByStaffId(int staffId);
	/**
	 * ����Ա��id��ѯ��Դ��Ϣ
	 */
	public List<HouseResource> findHouseResourceInfos(int staffId,int min,int max);
	/**
	 * ����Ա��Id��ѯ���۷�Դ��Ϣ
	 */
	public List<HouseResource> findSellHouseResourceInfos(int staffId,int min,int max);
	/**
	 * ����Ա��Id��ѯ���۷�Դ����
	 */
	public int findSellCountHouseResource(int staffId);
	/**
	 * ����Ա��Id��ѯ���ⷿԴ��Ϣ
	 */
	public List<HouseResource> findLeaseHouseResourceInfos(int staffId,int min,int max);
	/**
	 * ����Ա��Id��ѯ���ⷿԴ����
	 */
	public int findLeaseCountHouseResource(int staffId);

	/**
	 * ���ݷ�ԴIdɾ����Դ
	 */
	public void deleteHouseResource(int houseResource_id);
	/**
	 * ���ݷ�Դid��ѯ��Դ
	 */
	public HouseResource findHouseByHouseId(int houseId);

	/**
	 * ����Ա��id���ҳ��۵ķ�Դ�б�
	 */
	public List<HouseResource> findSalingHouseResource(int staffId);
	/**
	 * ����Ա��ID���ҳ�����ķ�Դ�б�
	 */
	public List<HouseResource> findRentintHouseResource(int staffId);

	/**
	 * �޸ķ�Դ��Ա��id
	 */
	public void updateStaffIdInHouseResource(int staffId1,int staffId2);
	
	/**
	 * ���ҳ��۵ķ�Դ�б�
	 */
	public List<HouseResource> findSellHouse(int staff_id);
	/**
	 * ���ҳ���ķ�Դ�б�
	 */
	public List<HouseResource> findRentHouse(int staff_id);
	
	/**
	 * �޸ķ�Դ״̬
	 */
	public void updateHouseStatus(int houseId,int status);

	
	
	/**
	 * ���ݿͻ��������ƥ�䷿Դ
	 */
	public List<HouseResource> findHouseRsesourceByClientReq(@Param("staff_id")int staff_id,@Param("application_id")int application_id,@Param("minPrice")float minPrice,@Param("maxPrice")float maxPrice,@Param("siteRequirement")String siteRequirement,@Param("flag")int flag);

	/**
	 * ���ӳ��ⷿԴ��Ϣ
	 */
	public void addRentHouseResource( int houseresource_id,String floor_,String ceil_,String doorplate,int room,int hall,int toilet,int balcony,int kitchen,int tier,int total_tiers,double total_price,double build_areas,double inside_areas,Date publishTime,String houseResource_title,String houseResource_describe,int heatingcondition,int application_id,int adornment_id,int direction_id,int houseAttribute_id,int owner_id,int neighborhood_id,String houseconfigure,double rent,int type,int status,int staff_id);
	/**
	 * ����Ա��id��ѯ��Դ����
	 */
	public int findHouseResourceCount(int staffId);
}