package dao;

import java.util.List;

import pojo.HouseApplication;

/**
 * ���ݷ��ʽӿ�
 * @author admin
 *
 */
public interface HouseApplicationDao {
	/**
	 * �ҵ����з�����;������ѡ��
	 */
	public List<HouseApplication> findAllHouseAppSelection();
}
