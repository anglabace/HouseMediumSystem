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
	 * 根据员工Id获取当月跟进客源数
	 */
	public int findCurrentClientTrailByStaffId(int staffId){
		return clientTrailDao.findCurrentClientTrailByStaffId(staffId);
	}
	
	/**
	 * 添加客户跟进记录
	 */
	public void addClientTrail(ClientTrail clientTrail){
		clientTrailDao.addClientTrail(clientTrail);
	}
	
	/**
	 * 根据员工id分页查询该员工负责的客户跟进记录
	 */
	public List<ClientTrail> findAllClientTrailByStaffId(int staff_id,int minRow,int maxRow){
		return clientTrailDao.findAllClientTrailByStaffId(staff_id,minRow,maxRow);
	};
	
	
	/**
	 * 根据员工id查询该员工负责的客户跟进记录总数
	 */
	public int findAllClientTrailCountByStaffId(int staff_id){
		return clientTrailDao.findAllClientTrailCountByStaffId(staff_id);
	}
	
	
	/**
	 * 根据客户跟进表id删除客户跟进记录
	 */
	public void deleteSingleClientTrailById(int clientTrail_id){
		clientTrailDao.deleteSingleClientTrailById(clientTrail_id);
	}
	
	
	/**
	 * 根据客户跟进时间或类型查找客户跟进记录
	 */
	public List<ClientTrail> findByClientTrail(ClientTrail clientTrail,int minRow,int maxRow){
		return clientTrailDao.findByClientTrail(clientTrail,minRow,maxRow);
	}
	
	/**
	 * 根据客户跟进时间或类型查找客户跟进记录总数
	 */
	public int findCountByClientTrail(ClientTrail clientTrail){
		return clientTrailDao.findCountByClientTrail(clientTrail);
	}
}
