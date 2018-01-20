package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import pojo.Area;
import pojo.City;
import pojo.NeighborHood;
import pojo.Street;
import pojo.Villege;
import service.NeighborhoodService;

/**
 * 小区【楼盘】
 * @author 郑世杰
 *
 */
@Controller
public class NeighborHoodController {
	@Autowired
	private NeighborhoodService neighborhoodService;
	/**
	 * 显示所有小区【楼盘名称】
	 * @param neighborHood_Name
	 * @param street_Id
	 * @param area_id
	 * @param map
	 * @return
	 */
	@RequestMapping("showAllNeighborList")
	public String showAllNeighborList(Integer pageNo,String neighborHood_Name,Integer street_Id,Integer area_id ,ModelMap map){
		System.out.println("页面加载ajax");
		if(pageNo==null){
			pageNo=1;
		}
		if(neighborHood_Name==null){
			neighborHood_Name="";
		}
		int start=(pageNo-1)*1+1;
		int end=pageNo*1;
		int totolNum=neighborhoodService.findAllNeighborHoodNum("%"+neighborHood_Name+"%");
		int pageNum;
		if(street_Id==null&&area_id==null){
			List<Villege> villegeList=new ArrayList<>();
			List<NeighborHood> listNeighborHood=neighborhoodService.findAllNeighborhood("%"+neighborHood_Name+"%",start,end);
			pageNum=(int)(Math.ceil((float)totolNum/1));
			for(NeighborHood t:listNeighborHood){
				Villege villege=new Villege();
				villege.setNeighborHood(t);	
				villege.setStreet(t.getStreet());
				villege.setArea(t.getStreet().getArea());
				System.out.println("字符串");
				System.out.println(t.getStreet().getArea().getCity().getCity_Name());
				villege.setCity(t.getStreet().getArea().getCity());
				villegeList.add(villege);
			}
			map.put("neighborHood_Name", neighborHood_Name);
			map.put("villegeList", villegeList);
			map.put("totolNum", totolNum);
			map.put("pageNum", pageNum);
			map.put("pageNo", pageNo);
		}
		return "showAllNeighborList";
	}
	/**
	 * 查看所有小区列表
	 * @return
	 */
	@RequestMapping("main_showAllNeighborList")
	public String main_showAllNeighborList(){
		System.out.println("进入到员工列表");
		return "main_showAllNeighborList";
	}
	
}
