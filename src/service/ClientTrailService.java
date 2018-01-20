package service;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.ClientTrailDao;
import pojo.ClientTrail;

@Service
public class ClientTrailService {
	@Autowired
	private ClientTrailDao clientTrailDao;
	
	/**
	 * ����Ա��Id��ȡ���¸�����Դ��
	 */
	public int findCurrentClientTrailByStaffId(int staffId){
		return clientTrailDao.findCurrentClientTrailByStaffId(staffId);
	}
	
	/**
	 * ��ӿͻ�������¼
	 */
	public void addClientTrail(ClientTrail clientTrail){
		clientTrailDao.addClientTrail(clientTrail);
	}
	
	/**
	 * ����Ա��id��ҳ��ѯ��Ա������Ŀͻ�������¼
	 */
	public List<ClientTrail> findAllClientTrailByStaffId(int staff_id,int minRow,int maxRow){
		return clientTrailDao.findAllClientTrailByStaffId(staff_id,minRow,maxRow);
	};
	
	
	/**
	 * ����Ա��id��ѯ��Ա������Ŀͻ�������¼����
	 */
	public int findAllClientTrailCountByStaffId(int staff_id){
		return clientTrailDao.findAllClientTrailCountByStaffId(staff_id);
	}
	
	
	/**
	 * ���ݿͻ�������idɾ���ͻ�������¼
	 */
	public void deleteSingleClientTrailById(int clientTrail_id){
		clientTrailDao.deleteSingleClientTrailById(clientTrail_id);
	}
	
	
	/**
	 * ���ݿͻ�����ʱ������Ͳ��ҿͻ�������¼
	 */
	public List<ClientTrail> findByClientTrail(ClientTrail clientTrail,int minRow,int maxRow){
		return clientTrailDao.findByClientTrail(clientTrail,minRow,maxRow);
	}
	
	/**
	 * ���ݿͻ�����ʱ������Ͳ��ҿͻ�������¼����
	 */
	public int findCountByClientTrail(ClientTrail clientTrail){
		return clientTrailDao.findCountByClientTrail(clientTrail);
	}
}
