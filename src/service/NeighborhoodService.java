package service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.NeighborHoodDao;
import pojo.NeighborHood;

/**
 * 小区【楼盘服务层】
 * @author admin
 *
 */
@Service
public class NeighborhoodService {
	@Autowired
	private NeighborHoodDao neighborHoodDao;
	/**
	 * 查找所有小区列表
	 * 
	 */
	public List<NeighborHood> findAllNeighborhood(String neighborHood_Name,int start,int end){
		return neighborHoodDao.findAllNeighborHood(neighborHood_Name,start,end);
	}
	public Integer findAllNeighborHoodNum(String neighborHood_Name){
		return neighborHoodDao.findAllNeighborHoodNum(neighborHood_Name);
	}
}
