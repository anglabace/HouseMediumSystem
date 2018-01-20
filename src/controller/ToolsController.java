package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import pojo.CheckAttendance;
import pojo.HouseResource;
import pojo.Staff;
import pojo.StaffHouseStatus;
import service.CheckAttendanceService;
import service.HouseService;
import service.StaffService;
import util.Page;
import util.PageUtil;

/**
 * 实用工具业务类
 * @author admin
 *
 */
@Controller
public class ToolsController {
	@Autowired
	private CheckAttendanceService checkAttendanceService;
	@Autowired
	private HouseService houseService;
	@Autowired
	private StaffService staffService;
	/**
	 * 跳转电子考勤页面 显示本月考勤
	 */
	@RequestMapping("checkAttendance")
	public String findAttendances(HttpServletRequest req,ModelMap map,Integer pageNum){
		HttpSession session = req.getSession();
		Staff staff = (Staff)session.getAttribute("loginStaff");
		int count = checkAttendanceService.findCountCheckByStaffId(staff.getStaff_id());
		Page page = PageUtil.Page(pageNum, count);
		System.out.println(page.getStart()+","+count);
		List list = checkAttendanceService.findAttendances(staff.getStaff_id(),page.getMin(), page.getMax());
		map.put("attendanceList", list);
		map.put("start", page.getStart());
		map.put("end", page.getEnd());
		map.put("totalPage",page.getTotalPage());
		map.put("count",count);
		map.put("pageNum", page.getPageNum());
		return "checkAttendance";
	}
	
	/**
	 * 新增考勤记录
	 */
	@RequestMapping("addAttendance")
	public String addAttendance(int staff_id,HttpServletRequest req,ModelMap map,Integer pageNum){
		HttpSession session = req.getSession();
		Staff staff = (Staff)session.getAttribute("loginStaff");
		int count = checkAttendanceService.findCountCheckByStaffId(staff.getStaff_id());
		int count1 = checkAttendanceService.findCountCheckToday(staff.getStaff_id());
		Page page = PageUtil.Page(pageNum, count);
		System.out.println(page);
		List list = checkAttendanceService.findAttendances(staff.getStaff_id(),page.getMin(), page.getMax());
		System.out.println(count);
		if(count1 == 0){
			checkAttendanceService.addAttendance(staff_id);
		}
		map.put("attendanceList", list);
		map.put("start", page.getStart());
		map.put("end", page.getEnd());
		map.put("totalPage",page.getTotalPage());
		map.put("count",count);
		map.put("pageNum", page.getPageNum());
		return "checkAttendance";
	}
	/**
	 * 跳转业务员转移房源界面 显示业务员有关房源信息
	 */
	@RequestMapping("staffTransformHouse")
	public String findHouseResourceInfos(HttpServletRequest req,ModelMap map,Integer pageNum){
		HttpSession session = req.getSession();
		Staff staff = (Staff)session.getAttribute("loginStaff");
		int count = houseService.findHouseResourceCount(staff.getStaff_id());
		Page page = PageUtil.Page(pageNum, count);
		List list = houseService.findHouseResourceInfos(staff.getStaff_id(),page.getMin(), page.getMax());
		System.out.println(list.size());
		map.put("houseResourceList", list);
		map.put("start", page.getStart());
		map.put("end", page.getEnd());
		map.put("totalPage",page.getTotalPage());
		map.put("count",count);
		map.put("pageNum", page.getPageNum());
		return "staffTransformHouse";
		
	}

	/**
	 * 跳转选择员工id界面 显示所有员工信息
	 */
	@RequestMapping("selectStaffId")
	public String findAllStaff(ModelMap map,Integer pageNum){
		int count = staffService.staffCount();
		Page page = PageUtil.Page(pageNum, count);
		List<Staff> list = staffService.findAllStaffByPage(page.getMin(), page.getMax());
		
		map.put("staffList", list);
		map.put("start", page.getStart());
		map.put("end", page.getEnd());
		map.put("totalPage",page.getTotalPage());
		map.put("count",count);
		map.put("pageNum", page.getPageNum());
		return "selectStaffId";
	}
	/**
	 * 修改房源负责业务员
	 */
	@RequestMapping("updateStaffIdInHouseResource")
	public String updateStaffIdInHouseResource(HttpServletRequest req){
		System.out.println(1);
		HttpSession session = req.getSession();
		int staffId1 = Integer.parseInt(req.getParameter("staffId1"));
		System.out.println(staffId1);
		Staff staff = (Staff)session.getAttribute("loginStaff");
		houseService.updateStaffIdInHouseResource(staffId1,staff.getStaff_id());
		return "success";
	}

	/**
	 * 跳转至房贷计算器页面
	 */
	@RequestMapping("main_housingLoanCal")
	public String skipToHousingLoanCal(){
		return "main_housingLoanCal";
	}

}
