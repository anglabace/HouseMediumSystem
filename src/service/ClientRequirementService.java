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
	 * 根据客户Id查询单个客户对象及其需求
	 */
	public ClientRequirement findSingleClientByClientId(int client_id){
		//System.out.println("进入了SingleService");
		return clientRequirementDao.findSingleClientByClientId(client_id);
	}
}
