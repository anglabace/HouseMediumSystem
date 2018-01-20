package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import form.ClientTrailForm;
import pojo.Area;
import pojo.Client;
import pojo.ClientRequirement;
import pojo.ClientTrail;
import pojo.HouseAdornment;
import pojo.HouseApplication;
import pojo.HouseDirection;
import pojo.Street;
import service.AreaService;
import service.ClientRequirementService;
import service.ClientService;
import service.ClientTrailService;
import service.HouseAdornmentService;
import service.HouseApplicationService;
import service.HouseDirectionService;
import service.StreetService;
import util.PhoneMessageInterface;

/**
 * 客户的业务类
 * @author Chris
 *
 */
@Controller
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	@Autowired
	private HouseApplicationService houseApplicationService;
	@Autowired
	private HouseAdornmentService houseAdornmentService;
	@Autowired
	private HouseDirectionService houseDirectionService;
	@Autowired
	private ClientRequirementService clientRequirementService;
	@Autowired
	private  ClientTrailService clientTrailService;
	@Autowired
	private AreaService areaService;
	@Autowired
	private StreetService streetService;
	/**
	 * 跳转客户添加页面
	 */
	@RequestMapping("main_addClient")
	public String skipToAddPage(ModelMap map){
		//找到所有房屋用途下拉选项框
		List<HouseApplication> houseAppSelection = houseApplicationService.findAllHouseAppSelection();
		//找到所有房屋装饰下拉选项框
		List<HouseAdornment> houseAdorSelection = houseAdornmentService.findAllAdorSelection();
		//找到所有房屋朝向下拉选项框
		List<HouseDirection> houseDireSelection = houseDirectionService.findAllHouseDirSelection();
		map.put("houseAppSelection", houseAppSelection);
		map.put("houseAdorSelection", houseAdorSelection);
		map.put("houseDireSelection", houseDireSelection);
		return "main_addClient";
	}
	
	/**
	 * 跳转至客户列表页面
	 */
	@RequestMapping("main_clientList")
	public String skipToClientList(int staff_id,int page,ModelMap map){
		//找到所有房屋用途下拉选项框
		List<HouseApplication> houseAppSelection = houseApplicationService.findAllHouseAppSelection();
		//找到所有房屋装饰下拉选项框
		List<HouseAdornment> houseAdorSelection = houseAdornmentService.findAllAdorSelection();
		//找到所有房屋朝向下拉选项框
		List<HouseDirection> houseDireSelection = houseDirectionService.findAllHouseDirSelection();
		//根据员工id查询员工所负责的所有客户数量
		int clientCount = clientService.findAllClientCountByStaffId(staff_id);
		//每页呈现的条数
		int size = PhoneMessageInterface.size;
		//计算总页数
		int totalPage = (int)Math.ceil((float)clientCount/size);
		//定义当前页 默认为第一页
		int currentPage = page;
		System.err.println("搜索后的当前页数为"+currentPage);
		//页码分页范围
		int minRow = (currentPage-1)*size+1;
		int maxRow =currentPage*size;
		//根据登陆员工id分页查询员工所负责的所有客户列表
		List<Client> clientList = searchClientList(staff_id,minRow,maxRow);
		map.put("clientList", clientList);
		map.put("houseAppSelection", houseAppSelection);
		map.put("houseAdorSelection", houseAdorSelection);
		map.put("houseDireSelection", houseDireSelection);
		map.put("currentPage", currentPage);
		map.put("totalPage", totalPage);
		return "main_clientList";
	}
	
	/**
	 * 跳转至客户列表ajax界面
	 */
	@RequestMapping("main_clientList_ajax")
	public String skipToClientListAjax(int staff_id,int page,int totalPage,ModelMap map){
		//根据员工id查询员工所负责的所有客户数量
		int clientCount = clientService.findAllClientCountByStaffId(staff_id);
		//每页呈现的条数
		int size = PhoneMessageInterface.size;
		//计算总页数
		//totalPage=(int)((float)clientCount/size);
		//定义当前页 默认为第一页
		int currentPage = page;
		System.err.println("搜索后的跳转当前页数为"+currentPage);
		System.err.println("搜索后的跳转总页数为"+totalPage);
		//页码分页范围
		int minRow = (currentPage-1)*size+1;
		int maxRow =currentPage*size;
		//根据登陆员工id分页查询员工所负责的所有客户列表
		List<Client> clientList = searchClientList(staff_id,minRow,maxRow);
		map.put("clientList", clientList);
		map.put("currentPage", currentPage);
		map.put("totalPage", totalPage);
		return "main_clientList_ajax";
	}
	
	
	/**
	 * 跳转至编辑界面
	 */
	@RequestMapping("main_editClient")
	public String skipToEditClient(int client_id,ModelMap map){	
		ClientRequirement clientReq = clientRequirementService.findSingleClientByClientId(client_id);
		int areaId = areaService.findAreaIdByStreetName(clientReq.getSiteRequirement());
		//找到所有房屋用途下拉选项框
		List<HouseApplication> houseAppSelection = houseApplicationService.findAllHouseAppSelection();
		//找到所有房屋装饰下拉选项框
		List<HouseAdornment> houseAdorSelection = houseAdornmentService.findAllAdorSelection();
		//找到所有房屋朝向下拉选项框
		List<HouseDirection> houseDireSelection = houseDirectionService.findAllHouseDirSelection();
		map.put("houseAppSelection", houseAppSelection);
		map.put("houseAdorSelection", houseAdorSelection);
		map.put("houseDireSelection", houseDireSelection);
		map.put("clientReq", clientReq);
		map.put("areaId", areaId);
		map.put("clientId", client_id);
		return "main_editClient";
	}
	
	/**
	 * 跳转至客户跟进列表界面
	 */
	@RequestMapping("main_clientTrailList")
	public String skipToClientTrailList(int staff_id,int page,ModelMap map){
		//根据员工id查询该员工负责的客户跟进记录总数
		int clientTrailCount = clientTrailService.findAllClientTrailCountByStaffId(staff_id);
		//每页呈现的条数
		int size = PhoneMessageInterface.size;
		//计算总页数
		int totalPage = (int)Math.ceil((float)clientTrailCount/size);
		//当前页
		int currentPage = page;
		//页码分页范围
		int minRow = (currentPage-1)*size+1;
		int maxRow = currentPage*size;
		System.out.println(minRow+","+maxRow);
		//根据登陆员工id分页查询员工所负责的所有客户跟进列表
		List<ClientTrail> clientTrailList = searchClientTrailList(staff_id,minRow,maxRow);
		map.put("clientTrailList", clientTrailList);
		map.put("totalPage",totalPage);
		map.put("currentPage", currentPage);
		return "main_clientTrailList";
	}
	
	
	/**
	 * 跳转至客户跟进列表ajax界面
	 */
	@RequestMapping("main_clientTrailList_ajax")
	public String skipToClientTrailListAjax(int staff_id,int page,int totalPage,ModelMap map){
		//每页呈现的条数
		int size = PhoneMessageInterface.size;
		//定义当前页 
		int currentPage = page;
		//页码分页范围
		int minRow = (currentPage-1)*size+1;
		int maxRow =currentPage*size;
		//根据登陆员工id分页查询员工所负责的所有客户跟进列表
		List<ClientTrail> clientTrailList = searchClientTrailList(staff_id, minRow, maxRow);
		//searchByClientTrail(clientTrailForm, currentPage, map)
		map.put("clientTrailList", clientTrailList);
		map.put("currentPage", currentPage);
		map.put("totalPage", totalPage);
		return "main_clientTrailList_ajax";
	}
	
	/**
	 * 添加客户信息
	 */
	@RequestMapping("addClientInfo")
	public String addClientInfo(Client client,ClientRequirement clientReq,ModelMap map){
		System.out.println("进入了添加客户信息");
		//添加客户的基本信息
		clientService.addClientBaseInfo(client);
		System.out.println("添加客户基本信息成功");
		//根据手机号和姓名查询对象
		Client findClient = clientService.findClientByNameAndTel(client.getClient_name(), client.getTelephone());
		System.out.println(findClient.getClient_id());
		clientReq.setClient_id(findClient.getClient_id());
		//添加客户的需求信息
		clientService.addClientReqInfo(clientReq);
		return skipToClientList(client.getStaff_id(),1,map);
	}
	
	/**
	 * 修改客户信息
	 */
	@RequestMapping("editClientInfo")
	public String editClientInfo (Client client,ClientRequirement clientReq,ModelMap map){
		clientService.updateClientBaseInfo(client);
		clientService.updateClientReqInfo(clientReq);
		return skipToClientList(client.getStaff_id(),1, map);
	}
	
	/**
	 * 查询登陆员工的所有客户列表
	 */
	public List<Client> searchClientList(int staff_id,int minRow,int maxRow){
		return clientService.findAllClientByStaffId(staff_id,minRow,maxRow);
	}
	
	
	/**
	 *查询登陆员工的所有客户跟进列表
	 */
	public List<ClientTrail> searchClientTrailList(int staff_id,int minRow,int maxRow){
		return clientTrailService.findAllClientTrailByStaffId(staff_id,minRow,maxRow);
	}
	
	/**
	 * 根据客户需求分页查询所有客户列表
	 */
	@RequestMapping("searchByClientReq")
	public String searchClientListByClientReq(int staff_id,ClientRequirement clientReq,int page,ModelMap map){
		//System.out.println("根据客户需求查询所有客户列表");
		//System.err.println(clientReq.getSiteRequirement()+"地点要求");
		int  clientReqCount = clientService.findAllClientCountByClientReq(staff_id, clientReq);
		//System.err.println(clientReqCount+"！！");
		//每页的个数
		int size = PhoneMessageInterface.size;
		//计算总页数 
		int totalPage = (int)Math.ceil((float)clientReqCount/size);
		System.err.println("总页数"+totalPage);
		int currentPage = page;
		
		int minRow = (currentPage-1)*size+1;
		int maxRow = currentPage*size;
				
		List<Client> clientReqList = clientService.findAllClientByClientReq(staff_id,clientReq,minRow,maxRow);
		//找到所有房屋用途下拉选项框
		List<HouseApplication> houseAppSelection = houseApplicationService.findAllHouseAppSelection();
		//找到所有房屋装饰下拉选项框
		List<HouseAdornment> houseAdorSelection = houseAdornmentService.findAllAdorSelection();
		//找到所有房屋朝向下拉选项框
		List<HouseDirection> houseDireSelection = houseDirectionService.findAllHouseDirSelection();
		map.put("clientList", clientReqList);
		map.put("houseAppSelection", houseAppSelection);
		map.put("houseAdorSelection", houseAdorSelection);
		map.put("houseDireSelection", houseDireSelection);
		map.put("totalPage", totalPage);
		map.put("currentPage",currentPage);
		return "main_clientList";
	}
	
	/**
	 * 根据客户id删除该条客户记录
	 */
	@ResponseBody
	@RequestMapping("deleteClientById")
	public String deleteSingleClientByClientId(int client_id){
		clientService.deleteSingleClientByClientId(client_id);
		return "";
	}
	
	
	/**
	 * 根据客户id添加客户跟进记录
	 */
	@RequestMapping("addClientTrail")
	public String addClientTrailByClientId(ClientTrail clientTrail,ModelMap map){
		System.out.println("进入了客户跟进记录");
		clientTrailService.addClientTrail(clientTrail);
		System.err.println("添加成功");
		return skipToClientTrailList(clientTrail.getStaff_id(),1,map);
	}
	
	/**
	 * 根据客户跟进表id删除客户跟进记录
	 */
	@ResponseBody
	@RequestMapping("deleteClientTrail")
	public String deleteSingleClientTrailById(int clientTrail_id){
		clientTrailService.deleteSingleClientTrailById(clientTrail_id);
		return "";	
	}

	/**
	 * 根据市名字找区集合
	 */
	@ResponseBody
	@RequestMapping("findAreaListBycityName")
	public String findAreaListBycityName(String cityName){
		List<Area> areaList = areaService.findAreaListBycityName(cityName);
		JSONArray areaArray = new JSONArray();
		for(Area area:areaList){
			JSONObject obj = new JSONObject();
			obj.put("area", area);
			areaArray.add(obj);
		}
		 return areaArray.toJSONString();
	}
	
	/**
	 * 通过区id找街集合
	 */
	@ResponseBody
	@RequestMapping("findStreetListByAreaId")
	public String findStreetListByAreaId(int area_Id){
		List<Street> streetList = streetService.findStreetListByAreaId(area_Id);
		JSONArray streetArray = new JSONArray();
		for(Street street:streetList){
			JSONObject obj = new JSONObject();
			obj.put("street", street);
			streetArray.add(obj);
		}
		return streetArray.toJSONString();
	}
	
	
	/**
	 * 根据跟进时间或跟进类型分页查找客户跟进记录
	 */
	@RequestMapping("searchByClientTrail")
	public String searchByClientTrail(ClientTrailForm clientTrailForm,int page,ModelMap map){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date startDate = null;
		Date endDate = null;
		try {
			if(clientTrailForm.getStartTime() != null){
				startDate=sdf.parse(clientTrailForm.getStartTime());
			} 
			 if(clientTrailForm.getEndTime() != null){
				endDate = sdf.parse(clientTrailForm.getEndTime());
			 }
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ClientTrail clientTrail = new ClientTrail();
		clientTrail.setStartTime(startDate);
		clientTrail.setEndTime(endDate);
		clientTrail.setStaff_id(clientTrailForm.getStaff_id());
		clientTrail.setClientTrail_type(clientTrailForm.getClientTrail_type());
		
		//获得根据跟进时间或跟进类型分页查找客户跟进记录总数
		int clientTrailCount = clientTrailService.findCountByClientTrail(clientTrail);
		//每页的个数
		int size = PhoneMessageInterface.size;
		//计算总页数 
		int totalPage = (int)Math.ceil((float)clientTrailCount/size);
		//当前页
		int currentPage = page;	
		
		int minRow = (currentPage-1)*size+1;
		int maxRow = currentPage*size;
		List<ClientTrail> clientTrailList = clientTrailService.findByClientTrail(clientTrail, minRow, maxRow);
		map.put("clientTrailList", clientTrailList);
		map.put("totalPage", totalPage);
		map.put("currentPage", currentPage);
		return "main_clientTrailList";
	}
	
}
