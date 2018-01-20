package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.util.WebUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import pojo.Staff;
import service.CheckAttendanceService;
import service.ClientService;
import service.HouseService;
import service.NoticeService;
import service.OrderFormService;
import service.StaffService;

@Controller
public class ManagerController {
	@Autowired
	private NoticeService noticeService;
	@Autowired
	private StaffService staffService;
	@Autowired
	private HouseService houseService;
	@Autowired
	private OrderFormService orderFormService;
	@Autowired
	private ClientService clientService;
	@Autowired
	private CheckAttendanceService checkAttendanceService;
	/**
	 * 跳转到公告页面
	 * @return
	 */
	@RequestMapping("loginNotice")
	public String loginNotice(){
		return "main_notice";
	}
	/**
	 * 添加新的公告
	 * @param notice_title
	 * @param notice_content
	 * @return
	 */
	@RequestMapping("addNotice")
	public String addNotice(String notice_title,String notice_content){
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		Staff staff=(Staff)WebUtils.getSessionAttribute(request, "loginStaff");
		//System.out.println(notice_title+","+notice_content+","+staff.getStaff_id());
		noticeService.addNotice(notice_title, notice_content, staff.getStaff_id());
		return "main_notice";
	}
	/**
	 * 跳转到业务报表页面
	 */
	@RequestMapping("viewStatement")
	public String goToStatement(ModelMap map){
		return "main_statement";
	}
	
	/**
	 * Ajax加载报表数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping("loadStatement")
	public String loadStatement(){
		JSONObject obj1 = new JSONObject();
		List<Staff> list=staffService.findAllStaff();
		JSONArray name = new JSONArray();
		JSONArray house = new JSONArray();
		JSONArray order = new JSONArray();
		JSONArray clien = new JSONArray();
		for(Staff staff : list){
			int houseNumber = houseService.findSemesterCountHouseByStaffId(staff.getStaff_id());
			int orderNumber = orderFormService.findSemesterCountOrderFormByStaffId(staff.getStaff_id());
			int clienNumber = clientService.findSemesterCountClientByStaffId(staff.getStaff_id());
			//System.out.println(staff.getStaff_name());
			clien.add(clienNumber);
			order.add(orderNumber);
			house.add(houseNumber);
			name.add(staff.getStaff_name());
		}
		obj1.put("name", name);
		obj1.put("house", house);
		obj1.put("order", order);
		obj1.put("clien", clien);
		return obj1.toString();
	}
	
	@ResponseBody
	@RequestMapping("loadAttendance")
	public String loadAttendance(){
		JSONObject obj1 = new JSONObject();
		List<Staff> list=staffService.findAllStaff();
		JSONArray name = new JSONArray();
		JSONArray check = new JSONArray();
		for(Staff staff : list){
			int checkNumber = checkAttendanceService.findCountCheckByStaffId(staff.getStaff_id());
			check.add(checkNumber);
			name.add(staff.getStaff_name());
		}
		obj1.put("name", name);
		obj1.put("check",check);
		return obj1.toString();
	}
}
