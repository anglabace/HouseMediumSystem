package dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import pojo.Contract;

public interface ContractDao {
	/**
	 * 新增出售合同
	 */
	public void addSellContract(Contract contract);
	/**
	 * 新增出租合同
	 */
	public void addRentContract(Contract contract);
	/**
	 * 查看出售合同
	 */
	public List<Contract> findSellContractById(int staff_id);
	/**
	 * 查看出租合同
	 */
	public List<Contract> findRentContractById(int staff_id);

	/**
	 * 查看所有合同或者满足指定类型的合同
	 * @param Contract_type 合同类型
	 * @param Contract_id 单号
	 * @param Contract_Time 合同时间
	 * @param min 开始行索引
	 * @param max 结束行索引
	 * @return
	 */
	public List<Contract> findAllContract(@Param("Contract_type")int Contract_type,@Param("Contract_id")int Contract_id,@Param("Contract_Time")String Contract_Time,@Param("min")int min,@Param("max")int max);
	/**
	 * 查出指定条件或者没有条件的条目数
	 * @param Contract_type
	 * @param Contract_id
	 * @param Contract_Time
	 * @return
	 */
	public Integer findNumAllContract(@Param("Contract_type")int Contract_type,@Param("Contract_id")int Contract_id,@Param("Contract_Time")String Contract_Time);

	/**
	 * 根据合同id查看合同
	 */
	public Contract findContractByConId(int contract_id);
	
	/**
	 * 修改合同状态啊,通过合同Id
	 */
	public void updateContractStatusById(int contract_status,int contract_id);

}
