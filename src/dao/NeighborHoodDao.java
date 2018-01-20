package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.testng.annotations.Parameters;

import pojo.NeighborHood;

public interface NeighborHoodDao {
	/**
	 * 查询所哟小区【楼盘列表】
	 */
	public List<NeighborHood> findAllNeighborHood(@Param("neighborHood_Name")String neighborHood_Name,@Param("min")int start,@Param("max")int end);
	/**
	 * 查询小区的数量
	 */
	public Integer findAllNeighborHoodNum(@Param("neighborHood_Name")String neighborHood_Name);
}
