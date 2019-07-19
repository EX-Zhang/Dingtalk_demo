import java.util.Arrays;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiCalendarCreateRequest;
import com.dingtalk.api.response.OapiCalendarCreateResponse;
import com.taobao.api.ApiException;

public class DingtalkCalender {

	private String appkey;
	private String appsecret;
	
	private DingTalkClient client;
	private OapiCalendarCreateRequest calender_request;
	private OapiCalendarCreateRequest.OpenCalendarCreateVo creatVo;
	
	public DingtalkCalender(String key,String secret) {
		// TODO Auto-generated constructor stub
		client = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/calendar/create");
		
		appkey=key;
		appsecret=secret;
	}

	public OapiCalendarCreateRequest.OpenCalendarCreateVo createVo(){
		creatVo = new OapiCalendarCreateRequest.OpenCalendarCreateVo();
		return creatVo;
	}
	
	public void sendCalender() throws ApiException {
		String token =Dingtalk.getToken(appkey, appsecret);
		calender_request = new OapiCalendarCreateRequest();
		calender_request.setCreateVo(creatVo);
		OapiCalendarCreateResponse response = client.execute(calender_request, token);
		System.out.println(token);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String key="dinge8312cdce7f26b5f35c2f4657eb6378f";
		String secret="84N_qPBXNBSQ5WxrvDyLcgfJl0TCFyuF2HC5-s-0xQd4DYvECwP_sBedxU6t0Sy2";
		
		DingtalkCalender calender=new DingtalkCalender(key,secret);
		
		OapiCalendarCreateRequest.OpenCalendarCreateVo creatVo = calender.createVo();
		
		creatVo.setSummary("≤‚ ‘");
		creatVo.setUuid("123456123456");
		creatVo.setBizId("Test123");
		creatVo.setCreatorUserid("033708361224246777");
		
		creatVo.setReceiverUserids(Arrays.asList("033708361224246777"));
		OapiCalendarCreateRequest.DatetimeVo start = new OapiCalendarCreateRequest.DatetimeVo();
		start.setUnixTimestamp(System.currentTimeMillis()-10000);
		creatVo.setStartTime(start);
		OapiCalendarCreateRequest.DatetimeVo end = new OapiCalendarCreateRequest.DatetimeVo();
		end.setUnixTimestamp(System.currentTimeMillis());
		creatVo.setEndTime(end);
		creatVo.setCalendarType("notification");
		
		OapiCalendarCreateRequest.OpenCalendarSourceVo source = new OapiCalendarCreateRequest.OpenCalendarSourceVo();
		source.setTitle("≤‚ ‘");
		source.setUrl("http://www.dingtalk.com/");
		creatVo.setSource(source);
		
		try {
			calender.sendCalender();
		} catch (ApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
