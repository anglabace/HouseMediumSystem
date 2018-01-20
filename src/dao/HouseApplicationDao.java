package dao;

import java.util.List;

import pojo.HouseApplication;

/**
 * 数据访问接口
 * @author admin
 *
 */
public interface HouseApplicationDao {
	/**
	 * 找到所有房屋用途下拉框选项
	 */
	public List<HouseApplication> findAllHouseAppSelection();
}
