package dao;

import pojo.ClientRequirement;

public interface ClientRequirementDao {
	
	
	/**
	 * ���ݿͻ�Id��ѯ�����ͻ���������
	 */
	public ClientRequirement findSingleClientByClientId(int client_id);
	
}
