package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pojo.ClientTrail;

public interface ClientTrailDao {
	/**
	 * ����Ա��Id��ȡ���¸�����Դ��
	 */
	public int findCurrentClientTrailByStaffId(int staffId);
	
	/**
	 * ��ӿͻ�������¼
	 */
	public void addClientTrail(ClientTrail clientTrail);

	/**
	 * ����Ա��id��ҳ��ѯ��Ա������Ŀͻ�������¼
	 */
	public List<ClientTrail> findAllClientTrailByStaffId(int staff_id,int minRow,int maxRow);

	
	/**
	 * ����Ա��id��ѯ��Ա������Ŀͻ�������¼����
	 */
	public int findAllClientTrailCountByStaffId(int staff_id);
	
	/**
	 * ���ݿͻ��������idɾ���ͻ�������¼
	 */
	public void deleteSingleClientTrailById(int clientTrail_id);
	
	/**
	 * ���ݿͻ�����ʱ������Ͳ��ҿͻ�������¼
	 */
	public List<ClientTrail> findByClientTrail(@Param("clientTrail")ClientTrail clientTrail,int minRow,int maxRow);
	
	
	/**
	 * ���ݿͻ�����ʱ������Ͳ��ҿͻ�������¼����
	 */
	public int findCountByClientTrail(@Param("clientTrail")ClientTrail clientTrail);
}

