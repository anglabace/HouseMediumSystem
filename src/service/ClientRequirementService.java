package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ClientRequirementDao;
import pojo.ClientRequirement;
@Service
public class ClientRequirementService {
	@Autowired
	private ClientRequirementDao clientRequirementDao;
	/**
	 * ���ݿͻ�Id��ѯ�����ͻ�����������
	 */
	public ClientRequirement findSingleClientByClientId(int client_id){
		//System.out.println("������SingleService");
		return clientRequirementDao.findSingleClientByClientId(client_id);
	}
}
