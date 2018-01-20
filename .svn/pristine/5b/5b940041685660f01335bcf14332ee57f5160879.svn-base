package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.*;
import pojo.*;
/**
 * Service层负责对DAO层进行调用
 * @author admin
 *
 */
@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	
	public User findUserByName(String userName){
		return userDao.findUserByName(userName);
	}
}
