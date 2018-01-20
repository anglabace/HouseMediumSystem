package service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ContractDao;
import dao.HouseResourceDao;
import dao.OrderFormDao;
import pojo.Contract;
import pojo.OrderForm;
@Service
public class ContractService {
	@Autowired
	private ContractDao contractDao;
	@Autowired
	private HouseResourceDao houseResourceDao;
	@Autowired 
	private OrderFormDao orderFormDao;
	/**
	 * 新增出售合同
	 */
	public void addSellContract(Contract contract){
		contractDao.addSellContract(contract);
	}
	/**
	 * 新增租赁合同
	 */
	public void addRentContract(Contract contract){
		contractDao.addRentContract(contract);
	}
	/**
	 * 查看出售合同
	 */
	public List<Contract> findSellContractById(int staff_id){
		return contractDao.findSellContractById(staff_id);
	}
	/**
	 * 查看租赁合同
	 */
	public List<Contract> findRentContractById(int staff_id){
		return contractDao.findRentContractById(staff_id);
	}

	/**
	 * 查找素有合同或者满足指定条件的合同
	 */
	public List<Contract> findAllContract(int Contract_type,int Contract_id,String Contract_Time,int min,int max){
		return contractDao.findAllContract(Contract_type, Contract_id, Contract_Time,min,max);
	}
	/**
	 * 查找素有合同或者满足指定条件的合同的数目
	 */
	public Integer findNumAllContract(int Contract_type,int Contract_id,String Contract_Time){
		return contractDao.findNumAllContract(Contract_type, Contract_id, Contract_Time);
	}

	/**
	 * 根据合同id查看合同
	 */
	public Contract findContractByConId(int contract_id){
		return contractDao.findContractByConId(contract_id);
	}
	/**
	 * 修改合同状态啊,通过合同Id
	 */
	public void updateContractStatusById(int contract_status,int contract_id){
		//改变房源状态
		contractDao.updateContractStatusById(contract_status, contract_id);
		//改变房源状态
			//先通过合同Id找到房源Id
			int id=contractDao.findContractByConId(contract_id).getHouse_id();
			//再通过房源Id修改房源状态
				//3未通过【下架】2
				if(contract_status==3){
					houseResourceDao.updateHouseStatus(id, 2);
				}			
				//2通过【已成家】4
				if(contract_status==2){
					houseResourceDao.updateHouseStatus(id, 4);
				}
		//生成订单记录
		OrderForm o=new OrderForm();
		o.setContract_id(contract_id);
		orderFormDao.addOrderForm(o);	
	}
}
