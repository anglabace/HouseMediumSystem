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
 * �ͻ���ҵ����
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
	 * ��ת�ͻ����ҳ��
	 */
	@RequestMapping("main_addClient")
	public String skipToAddPage(ModelMap map){
		//�ҵ����з�����;����ѡ���
		List<HouseApplication> houseAppSelection = houseApplicationService.findAllHouseAppSelection();
		//�ҵ����з���װ������ѡ���
		List<HouseAdornment> houseAdorSelection = houseAdornmentService.findAllAdorSelection();
		//�ҵ����з��ݳ�������ѡ���
		List<HouseDirection> houseDireSelection = houseDirectionService.findAllHouseDirSelection();
		map.put("houseAppSelection", houseAppSelection);
		map.put("houseAdorSelection", houseAdorSelection);
		map.put("houseDireSelection", houseDireSelection);
		return "main_addClient";
	}
	
	/**
	 * ��ת���ͻ��б�ҳ��
	 */
	@RequestMapping("main_clientList")
	public String skipToClientList(int staff_id,int page,ModelMap map){
		//�ҵ����з�����;����ѡ���
		List<HouseApplication> houseAppSelection = houseApplicationService.findAllHouseAppSelection();
		//�ҵ����з���װ������ѡ���
		List<HouseAdornment> houseAdorSelection = houseAdornmentService.findAllAdorSelection();
		//�ҵ����з��ݳ�������ѡ���
		List<HouseDirection> houseDireSelection = houseDirectionService.findAllHouseDirSelection();
		//����Ա��id��ѯԱ������������пͻ�����
		int clientCount = clientService.findAllClientCountByStaffId(staff_id);
		//ÿҳ���ֵ�����
		int size = PhoneMessageInterface.size;
		//������ҳ��
		int totalPage = (int)Math.ceil((float)clientCount/size);
		//���嵱ǰҳ Ĭ��Ϊ��һҳ
		int currentPage = page;
		System.err.println("������ĵ�ǰҳ��Ϊ"+currentPage);
		//ҳ���ҳ��Χ
		int minRow = (currentPage-1)*size+1;
		int maxRow =currentPage*size;
		//���ݵ�½Ա��id��ҳ��ѯԱ������������пͻ��б�
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
	 * ��ת���ͻ��б�ajax����
	 */
	@RequestMapping("main_clientList_ajax")
	public String skipToClientListAjax(int staff_id,int page,int totalPage,ModelMap map){
		//����Ա��id��ѯԱ������������пͻ�����
		int clientCount = clientService.findAllClientCountByStaffId(staff_id);
		//ÿҳ���ֵ�����
		int size = PhoneMessageInterface.size;
		//������ҳ��
		//totalPage=(int)((float)clientCount/size);
		//���嵱ǰҳ Ĭ��Ϊ��һҳ
		int currentPage = page;
		System.err.println("���������ת��ǰҳ��Ϊ"+currentPage);
		System.err.println("���������ת��ҳ��Ϊ"+totalPage);
		//ҳ���ҳ��Χ
		int minRow = (currentPage-1)*size+1;
		int maxRow =currentPage*size;
		//���ݵ�½Ա��id��ҳ��ѯԱ������������пͻ��б�
		List<Client> clientList = searchClientList(staff_id,minRow,maxRow);
		map.put("clientList", clientList);
		map.put("currentPage", currentPage);
		map.put("totalPage", totalPage);
		return "main_clientList_ajax";
	}
	
	
	/**
	 * ��ת���༭����
	 */
	@RequestMapping("main_editClient")
	public String skipToEditClient(int client_id,ModelMap map){	
		ClientRequirement clientReq = clientRequirementService.findSingleClientByClientId(client_id);
		int areaId = areaService.findAreaIdByStreetName(clientReq.getSiteRequirement());
		//�ҵ����з�����;����ѡ���
		List<HouseApplication> houseAppSelection = houseApplicationService.findAllHouseAppSelection();
		//�ҵ����з���װ������ѡ���
		List<HouseAdornment> houseAdorSelection = houseAdornmentService.findAllAdorSelection();
		//�ҵ����з��ݳ�������ѡ���
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
	 * ��ת���ͻ������б����
	 */
	@RequestMapping("main_clientTrailList")
	public String skipToClientTrailList(int staff_id,int page,ModelMap map){
		//����Ա��id��ѯ��Ա������Ŀͻ�������¼����
		int clientTrailCount = clientTrailService.findAllClientTrailCountByStaffId(staff_id);
		//ÿҳ���ֵ�����
		int size = PhoneMessageInterface.size;
		//������ҳ��
		int totalPage = (int)Math.ceil((float)clientTrailCount/size);
		//��ǰҳ
		int currentPage = page;
		//ҳ���ҳ��Χ
		int minRow = (currentPage-1)*size+1;
		int maxRow = currentPage*size;
		System.out.println(minRow+","+maxRow);
		//���ݵ�½Ա��id��ҳ��ѯԱ������������пͻ������б�
		List<ClientTrail> clientTrailList = searchClientTrailList(staff_id,minRow,maxRow);
		map.put("clientTrailList", clientTrailList);
		map.put("totalPage",totalPage);
		map.put("currentPage", currentPage);
		return "main_clientTrailList";
	}
	
	
	/**
	 * ��ת���ͻ������б�ajax����
	 */
	@RequestMapping("main_clientTrailList_ajax")
	public String skipToClientTrailListAjax(int staff_id,int page,int totalPage,ModelMap map){
		//ÿҳ���ֵ�����
		int size = PhoneMessageInterface.size;
		//���嵱ǰҳ 
		int currentPage = page;
		//ҳ���ҳ��Χ
		int minRow = (currentPage-1)*size+1;
		int maxRow =currentPage*size;
		//���ݵ�½Ա��id��ҳ��ѯԱ������������пͻ������б�
		List<ClientTrail> clientTrailList = searchClientTrailList(staff_id, minRow, maxRow);
		//searchByClientTrail(clientTrailForm, currentPage, map)
		map.put("clientTrailList", clientTrailList);
		map.put("currentPage", currentPage);
		map.put("totalPage", totalPage);
		return "main_clientTrailList_ajax";
	}
	
	/**
	 * ��ӿͻ���Ϣ
	 */
	@RequestMapping("addClientInfo")
	public String addClientInfo(Client client,ClientRequirement clientReq,ModelMap map){
		System.out.println("��������ӿͻ���Ϣ");
		//��ӿͻ��Ļ�����Ϣ
		clientService.addClientBaseInfo(client);
		System.out.println("��ӿͻ�������Ϣ�ɹ�");
		//�����ֻ��ź�������ѯ����
		Client findClient = clientService.findClientByNameAndTel(client.getClient_name(), client.getTelephone());
		System.out.println(findClient.getClient_id());
		clientReq.setClient_id(findClient.getClient_id());
		//��ӿͻ���������Ϣ
		clientService.addClientReqInfo(clientReq);
		return skipToClientList(client.getStaff_id(),1,map);
	}
	
	/**
	 * �޸Ŀͻ���Ϣ
	 */
	@RequestMapping("editClientInfo")
	public String editClientInfo (Client client,ClientRequirement clientReq,ModelMap map){
		clientService.updateClientBaseInfo(client);
		clientService.updateClientReqInfo(clientReq);
		return skipToClientList(client.getStaff_id(),1, map);
	}
	
	/**
	 * ��ѯ��½Ա�������пͻ��б�
	 */
	public List<Client> searchClientList(int staff_id,int minRow,int maxRow){
		return clientService.findAllClientByStaffId(staff_id,minRow,maxRow);
	}
	
	
	/**
	 *��ѯ��½Ա�������пͻ������б�
	 */
	public List<ClientTrail> searchClientTrailList(int staff_id,int minRow,int maxRow){
		return clientTrailService.findAllClientTrailByStaffId(staff_id,minRow,maxRow);
	}
	
	/**
	 * ���ݿͻ������ҳ��ѯ���пͻ��б�
	 */
	@RequestMapping("searchByClientReq")
	public String searchClientListByClientReq(int staff_id,ClientRequirement clientReq,int page,ModelMap map){
		//System.out.println("���ݿͻ������ѯ���пͻ��б�");
		//System.err.println(clientReq.getSiteRequirement()+"�ص�Ҫ��");
		int  clientReqCount = clientService.findAllClientCountByClientReq(staff_id, clientReq);
		//System.err.println(clientReqCount+"����");
		//ÿҳ�ĸ���
		int size = PhoneMessageInterface.size;
		//������ҳ�� 
		int totalPage = (int)Math.ceil((float)clientReqCount/size);
		System.err.println("��ҳ��"+totalPage);
		int currentPage = page;
		
		int minRow = (currentPage-1)*size+1;
		int maxRow = currentPage*size;
				
		List<Client> clientReqList = clientService.findAllClientByClientReq(staff_id,clientReq,minRow,maxRow);
		//�ҵ����з�����;����ѡ���
		List<HouseApplication> houseAppSelection = houseApplicationService.findAllHouseAppSelection();
		//�ҵ����з���װ������ѡ���
		List<HouseAdornment> houseAdorSelection = houseAdornmentService.findAllAdorSelection();
		//�ҵ����з��ݳ�������ѡ���
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
	 * ���ݿͻ�idɾ�������ͻ���¼
	 */
	@ResponseBody
	@RequestMapping("deleteClientById")
	public String deleteSingleClientByClientId(int client_id){
		clientService.deleteSingleClientByClientId(client_id);
		return "";
	}
	
	
	/**
	 * ���ݿͻ�id��ӿͻ�������¼
	 */
	@RequestMapping("addClientTrail")
	public String addClientTrailByClientId(ClientTrail clientTrail,ModelMap map){
		System.out.println("�����˿ͻ�������¼");
		clientTrailService.addClientTrail(clientTrail);
		System.err.println("��ӳɹ�");
		return skipToClientTrailList(clientTrail.getStaff_id(),1,map);
	}
	
	/**
	 * ���ݿͻ�������idɾ���ͻ�������¼
	 */
	@ResponseBody
	@RequestMapping("deleteClientTrail")
	public String deleteSingleClientTrailById(int clientTrail_id){
		clientTrailService.deleteSingleClientTrailById(clientTrail_id);
		return "";	
	}

	/**
	 * ������������������
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
	 * ͨ����id�ҽּ���
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
	 * ���ݸ���ʱ���������ͷ�ҳ���ҿͻ�������¼
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
		
		//��ø��ݸ���ʱ���������ͷ�ҳ���ҿͻ�������¼����
		int clientTrailCount = clientTrailService.findCountByClientTrail(clientTrail);
		//ÿҳ�ĸ���
		int size = PhoneMessageInterface.size;
		//������ҳ�� 
		int totalPage = (int)Math.ceil((float)clientTrailCount/size);
		//��ǰҳ
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
