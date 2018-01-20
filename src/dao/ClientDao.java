package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pojo.Client;
import pojo.ClientRequirement;

/**
 * 数据访问接口
 * @author Chris
 *
 */
public interface ClientDao {
	/**
	 * 添加客户基本信息
	 */
	public void addClientBaseInfo(Client client);
	
	/**
	 * 更新客户基本信息
	 */
	public void updateClientBaseInfo(Client client);
	
	/**
	 * 添加客户需求信息
	 */
	public void addClientReqInfo(ClientRequirement clientReq);

	/**
	 * 更新客户需求信息
	 */
	public void updateClientReqInfo(ClientRequirement clientReq);
	
	
	/**
	 * 根据客户姓名和手机号查询客户对象
	 */
	public Client findClientByNameAndTel(String client_name,String telephone);
	
	/**
	 * 根据员工id查询所负责的所有客户对象
	 */
	public List<Client> findAllClientByStaffId(int staff_id,int minRow,int maxRow);
	
	/**
	 * 根据客户需求查询其负责的所有客户列表
	 */
	public List<Client> findAllClientByClientReq(int staff_id,@Param("cReq") ClientRequirement cReq,int minRow,int maxRow);

	/**
	 * 根据客户需求查询其负责的所有客户列表总数
	 */
	public int findAllClientCountByClientReq(int staff_id,@Param("cReq") ClientRequirement cReq);
	
	/**
	 * 根据客户id删除该条客户记录
	 */
	public void deleteSingleClientByClientId(int client_id);
	
	
	
	/***********wjw**************/
	
	/**
	 * 根据员工Id查询该员工半年来的新增客源数
	 */
	public int findSemesterCountClientByStaffId(int staffId);

	/**
	 * 根据员工id查找其负责的所有客户数量
	 */
	public int findAllClientCountByStaffId(int staffId);
	/**
	 * 根据客户 id查找客户信息
	 */
	public Client findClientById(int clientId);
	/**
	 *  根据员工id查询负责的求购类型客户 
	 */
	public List<Client> findSellClientByStaffId(int clientId);
	/**
	 *  根据员工id查询负责的求租类型客户 
	 */
	public List<Client> findRentClientByStaffId(int clientId);
	/**
	 * 根据客户id修改客户状态
	 */
	public void updateClientStatus(int clientId,int status);
}
