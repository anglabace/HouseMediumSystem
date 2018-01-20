package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.util.WebUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import pojo.Area;
import pojo.Notice;
import pojo.Staff;
import service.AreaService;
import service.ClientService;
import service.ClientTrailService;
import service.HouseService;
import service.HouseTrailService;
import service.NoticeService;
import service.OrderFormService;

@Controller
public class LoadMainController {
	@Autowired
	private AreaService areaService;
	@Autowired
	private NoticeService noticeService;
	@Autowired
	private OrderFormService orderFormService;
	@Autowired
	private ClientService clientService;
	@Autowired
	private HouseTrailService houseTrailService;
	@Autowired
	private ClientTrailService clientTrailService;
	@Autowired
	private HouseService houseService;
	/**
	 * 返回JSON格式
	 * @return
	 */
	@ResponseBody
	@RequestMapping("loadMain")
	public String loadMain(){
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		Staff staff=(Staff)WebUtils.getSessionAttribute(request, "loginStaff");
		Area area = areaService.findAreaById(staff.getArea_id());
		JSONArray array = new JSONArray();
		//存储员工负责区域
		JSONObject obj1 = new JSONObject();
		obj1.put("areaName", area.getArea_Name());
		array.add(obj1);
		//存储公司最新公告
		Notice notice = noticeService.findNewNotice();
		JSONObject obj2 = new JSONObject();
		obj2.put("notic", notice);
		array.add(obj2);
		//存储业绩总数
		int allOrder = orderFormService.findAllOrderFormByStaffId(staff.getStaff_id());
		JSONObject obj3 = new JSONObject();
		obj3.put("allOrder", allOrder);
		array.add(obj3);
		//存储买房成交业绩总数
		int buyOrder = orderFormService.findBuyOrderFormByStaffId(staff.getStaff_id());
		JSONObject obj4 = new JSONObject();
		obj4.put("buyOrder", buyOrder);
		array.add(obj4);
		//存储租房成交业绩总数
		JSONObject obj5 = new JSONObject();
		obj5.put("lease", allOrder-buyOrder);
		array.add(obj5);
		//存储客源总数
		JSONObject obj6 = new JSONObject();
		int countClient = clientService.findAllClientCountByStaffId(staff.getStaff_id());
		obj6.put("countClient", countClient);
		array.add(obj6);
		//存储当月房源跟进数
		JSONObject obj7 = new JSONObject();
		int houseNumber= houseTrailService.findCurrentHouseTrailByStaffId(staff.getStaff_id());
		obj7.put("houseNumber", houseNumber);
		array.add(obj7);
		//存储当月客源跟进数
		JSONObject obj8 = new JSONObject();
		int clienNumber= clientTrailService.findCurrentClientTrailByStaffId(staff.getStaff_id());
		obj8.put("clienNumber", clienNumber);
		array.add(obj8);
		//存储当月新增出售房源数
		JSONObject obj9 = new JSONObject();
		int newHouse1 = houseService.findCurrentBuyHouseByStaffId(staff.getStaff_id());
		obj9.put("newHouse1", newHouse1);
		array.add(obj9);
		//存储当月新增出租房源数
		JSONObject obj10 = new JSONObject();
		int newHouse2 = houseService.findCurrentLeaseHouseByStaffId(staff.getStaff_id());
		obj10.put("newHouse2", newHouse2);
		array.add(obj10);
		return array.toString();
	}
}
