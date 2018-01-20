package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.util.WebUtils;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;

import pojo.Area;
import pojo.City;
import pojo.Staff;

import pojo.StaffForm;
import pojo.StaffHouseStatus;
import pojo.User;
import service.AreaService;
import service.CityService;
import service.StaffService;
import util.Page;
import util.PageUtil;
import util.PhoneMessageInterface;
@SessionAttributes("loginStaff")
@Controller
public class StaffController {
	@Autowired
	private StaffService staffService;
	@Autowired
	private AreaService areaService;
	@Autowired
	private CityService cityService;
	/**
	 * ��¼
	 * @param telephone
	 * @param pwd
	 * @param map
	 * @return
	 */
	
	@RequestMapping("loadIndex")
	public String loadIndex(){
		return "index";
	}
	//֣���ܣ���¼ģ��
	@RequestMapping("staff_login")
	public String login(String telephone, String pwd, ModelMap map,Boolean radio, HttpServletResponse response){
		Staff staff = staffService.findStaffByName(telephone);
		//System.err.println("radio:"+radio);
		if(staff != null){
			if(staff.getStaff_pwd().equals(pwd)){
				Cookie cookie1 =new Cookie("staffName", staff.getTelephone());
				Cookie cookie2 =new Cookie("staffPsw", staff.getStaff_pwd());
				map.put("loginStaff", staff);
				if(radio==null){ 
					cookie1.setMaxAge(0);
					cookie2.setMaxAge(0);
					response.addCookie(cookie1);
					response.addCookie(cookie2);
				}else{
					cookie1.setMaxAge(60*60*24*7);
					cookie2.setMaxAge(60*60*24*7);
					response.addCookie(cookie1);
					response.addCookie(cookie2);
				}
			}
			else{
				map.put("error", "�������!");
				return "../../index";
			}
		}
		else{
			map.put("error", " �����ڸ�Ա��!");
			return "../../index";
		}
		return "index";
	}
	
	/**
	 * ע��
	 */
	@RequestMapping("cancel")
	public String cancel(HttpSession session){
		session.invalidate();
		return "../../index";
	}
	
	/**
	 * �����һ�����
	 * @param telephone
	 * @param map
	 * @return
	 */
	//��ȡԱ������
	@ResponseBody
	@RequestMapping("getPwd")
	public String getPwd(String telephone,ModelMap map){
		JSONObject obj = new JSONObject(); 
		Staff staff = staffService.findStaffByName(telephone);
		obj.put("pwd", staff.getStaff_pwd());
		return obj.toJSONString();
	}
	//������֤��
	@ResponseBody
	@RequestMapping("sendCode")
	public String sendCode(String telephone,ModelMap map) throws ServerException, ClientException{
		System.out.println("sendCode");
		PhoneMessageInterface PhoneMessageInterface=new PhoneMessageInterface();
		String code=PhoneMessageInterface.sendMessage(telephone);
		System.out.println(code);
		JSONObject obj = new JSONObject(); 	
		obj.put("code",code );
		return obj.toJSONString();
	}
	
	/**
	 * �鿴Ա�����˻�������
	 * @param session
	 * @param map
	 * @return
	 */
	@RequestMapping("main_myInfo")
	public String findStaffInfo(HttpSession session,ModelMap map){
		System.out.println("findStaffInfo");
		//�����������
		Staff satff=(Staff)session.getAttribute("loginStaff");
		//System.out.println(satff);
		int areaId=satff.getArea_id();
		Area area=areaService.findAreaByAreaId(areaId);
		//�ҵ�����Ӧ����Id�²�����������
		City city=area.getCity();
		//System.out.println("city:"+city);
		List<Area> areaList=areaService.findAreaListBycityName(city.getCity_Name());
		map.put("areaList", areaList);
		map.put("area", area);
		//System.out.println("����:"+area.getArea_Name());
		return "main_myInfo";	
	}
	/**
	 * ���������޸�
	 * @param staffForm
	 * @param map
	 * @param session
	 * @return
	 */
	@RequestMapping("updateMyInfo")
	public String updateMyInfo(StaffForm staffForm,ModelMap map,HttpSession session){
		staffService.updateStaffByStaffId(staffForm);	
		Staff staff=staffService.findStaffById(((Staff)(session.getAttribute("loginStaff"))).getStaff_id());
		System.out.println("staffForm:"+staffForm.getArea_Id());
		int areaId=staff.getArea_id();
		Area area=areaService.findAreaByAreaId(areaId);
		City city=area.getCity();
		List<Area> areaList=areaService.findAreaListBycityName(city.getCity_Name());
		map.put("areaList", areaList);
		map.put("loginStaff", staff);
		map.put("area", area);
		return "main_myInfo";
		
	}
	
	/**
	 * �鿴�����޸Ľ���
	 * @return
	 */
	@RequestMapping("main_updatePwd")
	public String showUpdatePwd(){	
		//System.out.println("�����޸Ľ���");
		return "main_updatePwd";	
	}
	/**
	 * �޸�Ա������
	 * @return
	 */
	@RequestMapping("updateStaffPwd")
	public String updateStaffPwd(Staff staff,HttpSession session){
		//System.out.println("�����޸�Ա����controller��ҵ�����");
		Staff sessionStaff=(Staff)(session).getAttribute("loginStaff");
		sessionStaff.setStaff_pwd(staff.getStaff_pwd());
		session.setAttribute("loginStaff", sessionStaff);
		staffService.updateStaffPwd(sessionStaff);
		return "main_updatePwd";	
	}
	/**
	 * �ϴ�ͷ��
	 */
	@RequestMapping("upLoadPic")
	public String upLoadPic(@RequestParam("file") CommonsMultipartFile file,  
            HttpServletRequest request, ModelMap model,HttpSession session){
		 // ���ԭʼ�ļ���  
        String fileName = file.getOriginalFilename();  
        System.out.println("ԭʼ�ļ���:" + fileName);  
        //����Ա��ͷ��
        Staff staff=(Staff)(session).getAttribute("loginStaff");
        staff.setHead(fileName);
        staffService.updateStaffHead(staff);
        session.setAttribute("loginStaff", staff);
        // ���ļ���  
        String newFileName = fileName;  
        // �����Ŀ��·��  
        ServletContext sc = request.getSession().getServletContext();  
        // �ϴ�λ��  
        String path = sc.getRealPath("/images/head") + "/"; // �趨�ļ������Ŀ¼  
        File f = new File(path);  
        if (!f.exists())  
            f.mkdirs();  
        if (!file.isEmpty()) {  
            try {  
                FileOutputStream fos = new FileOutputStream(path + newFileName);  
                InputStream in = file.getInputStream();  
                int b = 0;  
                while ((b = in.read()) != -1) {  
                    fos.write(b);  
                }  
                fos.close();  
                in.close();  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        }  
       // System.out.println("�ϴ�ͼƬ��:" + path + newFileName);  
        // �����ļ���ַ������JSPҳ�����  
        model.addAttribute("fileUrl", "images/head/"+ newFileName);  
        //System.out.println("�ϴ�ͼƬ��:" +path + newFileName);
        return "main_updateHead";  	
	}
	/**
	 * �鿴ͷ����Ϣ
	 */
	@RequestMapping("main_updateHead")
	public String findStaffHead(ModelMap model,HttpSession session){
		//System.out.println("���뵽ͷ�����");
		//ͨ��sessions��ȡͷ������
		Staff staff=(Staff)(session).getAttribute("loginStaff");
		String FileName=staff.getHead(); 
		 // �����ļ���ַ������JSPҳ�����  
        model.addAttribute("fileUrl", "images/head/"+ FileName);
        return "main_updateHead";  	
		 
	}
	/**
	 * ��ҳ��ʾͨѶ¼
	 * @param req
	 * @param map
	 * @param pageNum
	 * @return
	 */

	@RequestMapping("contacts")
	public String contact(HttpServletRequest req,ModelMap map,Integer pageNum){
		HttpSession session = req.getSession();
		Staff staff = (Staff)session.getAttribute("loginStaff");
		int count = staffService.findAnotherStaffCount(staff.getStaff_id());
		Page page = PageUtil.Page(pageNum, count);
		
		List<Staff> list = staffService.findAnotherStaffsByPage(staff.getStaff_id(),page.getMin(), page.getMax());
		
		map.put("start", page.getStart());
		map.put("end", page.getEnd());
		map.put("staffList", list);
		map.put("totalPage",page.getTotalPage());
		map.put("count",count);
		map.put("pageNum", page.getPageNum());
		return "contacts";
	}
	/**
	 * ������ѯԱ����,���Ը���Ա������,Ҳ����û������
	 * 
	 */
	@RequestMapping("searchStaffList")
	public String searchStaffList(String staff_name,ModelMap map,Integer pageNo){
		System.out.println("searchStaffList");
		//ע�⣺û������������Ϊ�գ��в���������������Ϊ�յ��ַ������������ݾ�set����ȥ��
		if(pageNo==null){
			pageNo=1;
		}
		if(staff_name==null){
			staff_name="";
		}
		//ÿҳ�ĳߴ�
		int size = 1;
		//System.out.println("����Ŀ��"+totalNum);
		//����Ŀ��
		int totalNum=staffService.findAllStaffNum("%"+staff_name+"%");
		//System.out.println("��ҳ����"+pageNum);
		//��ǰҳ�ĵ�һ����¼
		int start=(pageNo-1)*1+1;
				//��ǰҳ�����һ����¼
		int end=pageNo*size;
		List<StaffHouseStatus> list=staffService.findAllStaffOrOneStaffUp("%"+staff_name+"%",start,end);
		
		//��ҳ��
		int pageNum=(int)Math.ceil((float)totalNum/1);
		System.err.println("��ҳ����"+pageNum);
		map.put("staffList", list);
		map.put("pageNum", pageNum);
		map.put("pageNo", pageNo);
		map.put("staff_name", staff_name);
		return "StaffOneOrAllList";
	}
	/**
	 * ����鿴Ա���б�
	 */
	@RequestMapping("main_showStaffList")
	public String showStaffList(){
		System.out.println("main_showStaffList");
		return "main_showStaffList";
	}
	/**
	 * ����Ա��
	 *
	 */
	@RequestMapping("addStaff")
	public String addStaff(Staff staff){
		System.out.println("��������Ա��");
		staffService.addStaff(staff);
		return showStaffList();
	}
}