package dao;
/**
 * 数据访问接口
 * @author admin
 *
 */

import pojo.*;

public interface UserDao {
	
	public User findUserByName(String name);
}
