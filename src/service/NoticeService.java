package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.NoticeDao;
import pojo.Notice;

@Service
public class NoticeService {
	@Autowired
	private NoticeDao noticeDao;
	/**
	 * 查询最新的公告
	 * @return
	 */
	public Notice findNewNotice(){
		return noticeDao.findNewNotice();
	}
	/**
	 * 添加新公告
	 * @param notice_title
	 * @param notice_content
	 * @param saffId
	 */
	public void addNotice(String notice_title,String notice_content,int saffId){
		noticeDao.addNotice(notice_title, notice_content, saffId);
	}
}
