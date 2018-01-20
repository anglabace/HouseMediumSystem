package dao;

import pojo.Notice;

public interface NoticeDao {
	/**
	 * 查询最新的公告
	 */ 
	public Notice findNewNotice();
	
	/**
	 * 插入新的公告
	 * @param notice_title
	 * @param notice_content
	 * @param saffId
	 */
	public void addNotice(String notice_title,String notice_content,int saffId);
}
