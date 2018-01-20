package service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ClientDao;
import pojo.Client;
import pojo.ClientRequirement;
import pojo.HouseApplication;

/**
 * Service�㸺���DAO�����
 * @author Chris
 *
 */
@Service
public class ClientService {
	@Autowired
	private ClientDao clientDao;
	/**
	 * �����ͻ�������Ϣ
	 * @param client
	 */
	public void addClientBaseInfo(Client client){
		clientDao.addClientBaseInfo(client);
	}

	/**
	 * ���¿ͻ�������Ϣ
	 */
	public void updateClientBaseInfo(Client client){
		clientDao.updateClientBaseInfo(client);
	}
	
	/**
	 * �����ͻ�������Ϣ
	 */
	public void addClientReqInfo(ClientRequirement clientReq){
		clientDao.addClientReqInfo(clientReq);
	}
	
	/**
	 * ���¿ͻ�������Ϣ
	 */
	public void updateClientReqInfo(ClientRequirement clientReq){
		clientDao.updateClientReqInfo(clientReq);
	}
	
	
	
	/**
	 * ���ݿͻ��������ֻ��Ų�ѯ�ͻ�����
	 */
	public Client findClientByNameAndTel(String client_name,String telephone){
		return clientDao.findClientByNameAndTel(client_name, telephone);
	}
	
	/**
	 * ����Ա��id��ѯ����������пͻ�����
	 */
	public List<Client> findAllClientByStaffId(int staff_id,int minRow,int maxRow){
		return clientDao.findAllClientByStaffId(staff_id,minRow,maxRow);
	}
	
	

	/**
	 * ����Ա��id��ѯ����������пͻ�����
	 */
	public int findAllClientCountByStaffId(int staffId){
		return clientDao.findAllClientCountByStaffId(staffId);
	}

	
	/**
	 * ���ݿͻ������ѯ�为������пͻ��б�
	 * @param staff_id
	 * @param cReq
	 * @return
	 */
	public List<Client> findAllClientByClientReq(int staff_id,ClientRequirement cReq,int minRow,int maxRow){
		return clientDao.findAllClientByClientReq(staff_id,cReq,minRow,maxRow);
	}
	
	/**
	 * ���ݿͻ������ѯ�为������пͻ��б�����
	 */
	public int findAllClientCountByClientReq(int staff_id,@Param("cReq") ClientRequirement cReq){
		return clientDao.findAllClientCountByClientReq(staff_id, cReq);
	};
	
	/**
	 * ����Ա��Id��ѯ��Ա����������������Դ��
	 */
	public int findSemesterCountClientByStaffId(int staffId){
		return clientDao.findSemesterCountClientByStaffId(staffId);
	}
	/**
	 * ���ݿͻ�idɾ�������ͻ���¼
	 */
	public void deleteSingleClientByClientId(int client_id){
		 clientDao.deleteSingleClientByClientId(client_id);
	};
	/**
	 * ���ݿͻ�id�����û���Ϣ
	 */
	public Client findClientById(int clientId){
		return clientDao.findClientById(clientId);
	}
	
	/**
	 *  ����Ա��id��ѯ����������Ϳͻ� 
	 */
	public List<Client> findSellClientByStaffId(int clientId){
		return clientDao.findSellClientByStaffId(clientId);
	}
	/**
	 *  ����Ա��id��ѯ������������Ϳͻ� 
	 */
	public List<Client> findRentClientByStaffId(int clientId){
		return clientDao.findRentClientByStaffId(clientId);
	}
	/**
	 * ���ݿͻ�id�޸Ŀͻ�״̬
	 */
	public void updateClientStatus(int clientId,int status){
		clientDao.updateClientStatus(clientId,status);
	}
}
