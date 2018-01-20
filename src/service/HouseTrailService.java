package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.HouseTrailDao;
import pojo.HouseTrail;

@Service
public class HouseTrailService {
	@Autowired
	private HouseTrailDao houseTrailDao;
	
	/**
	 * ����Ա��Id��ȡ���¸�����Դ��
	 */
	public int findCurrentHouseTrailByStaffId(int staffId){
		return houseTrailDao.findCurrentHouseTrailByStaffId(staffId);
	}
	/**
	 * ����Ա��Id��ȡԱ�������ĳ��۷�Դ��������
	 */
	public int findSellHouseTrailCountByStaffId(int staffId){
		return houseTrailDao.findSellHouseTrailCountByStaffId(staffId);
	}
	/**
	 * ��ҳ��ȡԱ�������ĳ��۷�Դ������¼
	 */
	public List<HouseTrail> findSellHouseTrail(int staffId,int min,int max){
		return houseTrailDao.findSellHouseTrail(staffId, min, max);
	}
	/**
	 * ����Ա��Id��ȡԱ�������ĳ��ⷿԴ��������
	 */
	public int findLeaseHouseTrailCountByStaffId(int staffId){
		return houseTrailDao.findLeaseHouseTrailCountByStaffId(staffId);
	}
	
	/**
	 * ��ҳ��ȡԱ�������ĳ��ⷿԴ������¼
	 */
	public List<HouseTrail> findLeaseHouseTrail(int staffId,int min,int max){
		return houseTrailDao.findLeaseHouseTrail(staffId, min, max);
	}
	/**
	 * ���ݷ�Դid��ӷ�Դ������Ϣ
	 */
	public void addHouseTrail(){
		houseTrailDao.addHouseTrail();
	}
}
