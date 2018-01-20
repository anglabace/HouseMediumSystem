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
 * Service层负责对DAO层调用
 * @author Chris
 *
 */
@Service
public class ClientService {
	@Autowired
	private ClientDao clientDao;
	/**
	 * 新增客户基本信息
	 * @param client
	 */
	public void addClientBaseInfo(Client client){
		clientDao.addClientBaseInfo(client);
	}

	/**
	 * 更新客户基本信息
	 */
	public void updateClientBaseInfo(Client client){
		clientDao.updateClientBaseInfo(client);
	}
	
	/**
	 * 新增客户需求信息
	 */
	public void addClientReqInfo(ClientRequirement clientReq){
		clientDao.addClientReqInfo(clientReq);
	}
	
	/**
	 * 更新客户需求信息
	 */
	public void updateClientReqInfo(ClientRequirement clientReq){
		clientDao.updateClientReqInfo(clientReq);
	}
	
	
	
	/**
	 * 根据客户姓名和手机号查询客户对象
	 */
	public Client findClientByNameAndTel(String client_name,String telephone){
		return clientDao.findClientByNameAndTel(client_name, telephone);
	}
	
	/**
	 * 根据员工id查询所负责的所有客户对象
	 */
	public List<Client> findAllClientByStaffId(int staff_id,int minRow,int maxRow){
		return clientDao.findAllClientByStaffId(staff_id,minRow,maxRow);
	}
	
	

	/**
	 * 根据员工id查询所负责的所有客户数量
	 */
	public int findAllClientCountByStaffId(int staffId){
		return clientDao.findAllClientCountByStaffId(staffId);
	}

	
	/**
	 * 根据客户需求查询其负责的所有客户列表
	 * @param staff_id
	 * @param cReq
	 * @return
	 */
	public List<Client> findAllClientByClientReq(int staff_id,ClientRequirement cReq,int minRow,int maxRow){
		return clientDao.findAllClientByClientReq(staff_id,cReq,minRow,maxRow);
	}
	
	/**
	 * 根据客户需求查询其负责的所有客户列表总数
	 */
	public int findAllClientCountByClientReq(int staff_id,@Param("cReq") ClientRequirement cReq){
		return clientDao.findAllClientCountByClientReq(staff_id, cReq);
	};
	
	/**
	 * 根据员工Id查询该员工半年来的新增客源数
	 */
	public int findSemesterCountClientByStaffId(int staffId){
		return clientDao.findSemesterCountClientByStaffId(staffId);
	}
	/**
	 * 根据客户id删除该条客户记录
	 */
	public void deleteSingleClientByClientId(int client_id){
		 clientDao.deleteSingleClientByClientId(client_id);
	};
	/**
	 * 根据客户id查找用户信息
	 */
	public Client findClientById(int clientId){
		return clientDao.findClientById(clientId);
	}
	
	/**
	 *  根据员工id查询负责的求购类型客户 
	 */
	public List<Client> findSellClientByStaffId(int clientId){
		return clientDao.findSellClientByStaffId(clientId);
	}
	/**
	 *  根据员工id查询负责的求租类型客户 
	 */
	public List<Client> findRentClientByStaffId(int clientId){
		return clientDao.findRentClientByStaffId(clientId);
	}
	/**
	 * 根据客户id修改客户状态
	 */
	public void updateClientStatus(int clientId,int status){
		clientDao.updateClientStatus(clientId,status);
	}
}
