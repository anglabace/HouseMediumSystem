package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.testng.annotations.Parameters;

import pojo.NeighborHood;

public interface NeighborHoodDao {
	/**
	 * ��ѯ��ӴС����¥���б���
	 */
	public List<NeighborHood> findAllNeighborHood(@Param("neighborHood_Name")String neighborHood_Name,@Param("min")int start,@Param("max")int end);
	/**
	 * ��ѯС��������
	 */
	public Integer findAllNeighborHoodNum(@Param("neighborHood_Name")String neighborHood_Name);
}