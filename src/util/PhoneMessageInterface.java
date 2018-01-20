package util;

import javax.servlet.http.HttpServletRequest;

import org.apache.coyote.http11.Http11AprProcessor;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import com.aliyun.mns.common.http.ServiceClient.Request;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

/**
 * �ֻ����Žӿ�,ֱ�ӵ���sendMessage(String telephone)������
 * @author admin
 *
 */
public class PhoneMessageInterface {
	public static int size = 1;
	//���ô˷������Ͷ�����֤��
	public String sendMessage(String telephone) throws ServerException, ClientException{
	    // ��ʼ��client����
	    IAcsClient client = initClient();
	    // ����ģ���������
	    SendSmsRequest request = null;
	    // ���ݶ���ģ��code����ȡ��ͬ�Ķ���ģ���������
	    String templateCode  = "SMS_98440006";
	  //���������
	    int randomNum=(int)(Math.random()*100000);
	    switch(templateCode)
	    {
	        case "SMS_98440006": 
	            request = getSMS_72780019Message(telephone,randomNum);
	           // System.out.println(request.getTemplateParam());
	            break;
	    }
	    // ���Ͷ���
	    SendSmsResponse response = client.getAcsResponse(request);
	    return ""+randomNum;
	    // ��ӡ���ŵ���Ϣ
//	    System.out.println("_____________����SMS_72780019�����յ�����Ӧ��Ϣ_______________");
//	    System.out.println("�����ID:" + response.getRequestId());
//	    System.out.println("�����״̬��:" + response.getCode());
//	    System.out.println("�����״̬������:" + response.getMessage());
//	    System.out.println("����Ļ�ִID:" + response.getBizId());
	}

		/**
		 * ��ȡIAcsClient����
		 * 
		 * @return
		 * @throws ClientException
		 * @throws com.aliyuncs.exceptions.ClientException 
		 */
		private IAcsClient initClient() throws ClientException, com.aliyuncs.exceptions.ClientException {
		    System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
		    System.setProperty("sun.net.client.defaultReadTimeout", "10000");
		    // ��ʼ��ascClient��Ҫ�ļ�������
		    final String product = "Dysmsapi";// ����API��Ʒ����
		    final String domain = "dysmsapi.aliyuncs.com";// ����API��Ʒ����
		    // ��Կkey��secret
		    final String appkey = "LTAIKfomnS8ONfq9";
		    final String appSecret = "Lgwf0EDbRgzVpRQ1sUCc0bGDNHlG87";
		    // ��ʼ��ascClient,��ʱ��֧�ֶ�region
		    IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", appkey, appSecret);
		    DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
		    IAcsClient acsClient = new DefaultAcsClient(profile);
		    return acsClient;
		}
		/**
		 * ��ȡSMS_72780019����ģ���Ӧ������
		 * 
		 * @return
		 */
		private SendSmsRequest getSMS_72780019Message(String telephone,int randomNum) {
		     //��װ�������
		     SendSmsRequest request = new SendSmsRequest();
		     //����:�������ֻ��š�֧���Զ��ŷָ�����ʽ�����������ã���������Ϊ20���ֻ�����,������������ڵ������ü�ʱ�������ӳ�,��֤�����͵Ķ����Ƽ�ʹ�õ������õķ�ʽ
		     request.setPhoneNumbers(telephone);
		     //����:����ǩ��-���ڶ��ſ���̨���ҵ�
		     request.setSignName("�⽨ΰ");
		     //����:����ģ��-���ڶ��ſ���̨���ҵ�
		     request.setTemplateCode("SMS_98440006");
		     //��ѡ:ģ���еı����滻JSON��,��ģ������Ϊ"�װ���${name},������֤��Ϊ${code}"ʱ,�˴���ֵΪ
		     request.setTemplateParam("{\"name\":\"Tom\", \"code\":\""+randomNum+"\"}");
		    
		     //��ѡ:outIdΪ�ṩ��ҵ����չ�ֶ�,�����ڶ��Ż�ִ��Ϣ�н���ֵ���ظ�������
		     request.setOutId("yourOutId");
			return request;
		 }
		
}