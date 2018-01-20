package service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.NeighborHoodDao;
import pojo.NeighborHood;

/**
 * С����¥�̷���㡿
 * @author admin
 *
 */
@Service
public class NeighborhoodService {
	@Autowired
	private NeighborHoodDao neighborHoodDao;
	/**
	 * ��������С���б�
	 * 
	 */
	public List<NeighborHood> findAllNeighborhood(String neighborHood_Name,int start,int end){
		return neighborHoodDao.findAllNeighborHood(neighborHood_Name,start,end);
	}
	public Integer findAllNeighborHoodNum(String neighborHood_Name){
		return neighborHoodDao.findAllNeighborHoodNum(neighborHood_Name);
	}
}