package util;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;

import pojo.Staff;

public class PageUtil {
	public static int size = 5;
	public static Page Page(Integer pageNum,int count){
		int pageNum1 = 1;
		int totalPage = 0;
		int min = 1;
		int max = 0;
		int start = 0;
		int end = 0;
		
		if(pageNum != null){
			pageNum1 = pageNum;
		}
		
		if(count%size == 0){
			totalPage = count/size;
		}else{
			totalPage = count/size + 1;
		}
		
		min = 1+(pageNum1-1)*size;
		max = pageNum1*size;
		
		start = pageNum1 - 2;
		end = pageNum1 + 2;
		
		if(start<1){
			start = 1;
			if(end < totalPage){
				end = start + 4;
			}
		}
		if(end > totalPage){
			start = totalPage - 4;
			end = totalPage;
		}
		if(totalPage < 5){
			end = totalPage;
			start = 1;
		}
		Page page = new Page();
		
		page.setPageNum(pageNum1);
		page.setStart(start);
		page.setEnd(end);
		page.setMin(min);
		page.setMax(max);
		page.setTotalPage(totalPage);
		return page;
	}
}
