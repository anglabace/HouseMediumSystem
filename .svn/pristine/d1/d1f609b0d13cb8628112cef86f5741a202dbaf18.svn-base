package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.OwnerDao;
import pojo.Owner;
@Service
public class OwnerService {
	@Autowired
	private OwnerDao ownerDao;
	
	/**
	 * 根据业主id查询对象
	 */
	public Owner findOwnerById(int owner_id){
		return ownerDao.findOwnerById(owner_id); 
	}
}
