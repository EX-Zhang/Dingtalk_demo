import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiMessageCorpconversationAsyncsendV2Request;
import com.dingtalk.api.response.OapiMessageCorpconversationAsyncsendV2Response;
import com.taobao.api.ApiException;

public class DingtalkWorkMsg {

	private String appkey;
	private String appsecret;
	
	private DingTalkClient client;
	private OapiMessageCorpconversationAsyncsendV2Request msg_request;
	
	public DingtalkWorkMsg(String key,String secret) {
		// TODO Auto-generated constructor stub
		client=new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/message/corpconversation/asyncsend_v2");
		
		appkey=key;
		appsecret=secret;
	}
	
	public void setUserid(String Userid,Long Agentid) {
		
		msg_request = new OapiMessageCorpconversationAsyncsendV2Request();
		
		msg_request.setAgentId(Agentid);
		msg_request.setUseridList(Userid);
		msg_request.setToAllUser(false);
	}

	public void sendTextMsg(String msg) {
		OapiMessageCorpconversationAsyncsendV2Request.Msg request_msg = new OapiMessageCorpconversationAsyncsendV2Request.Msg();
		request_msg.setMsgtype("text");
		request_msg.setText(new OapiMessageCorpconversationAsyncsendV2Request.Text());
		request_msg.getText().setContent(msg);
		msg_request.setMsg(request_msg);
		msg_request.setHttpMethod("POST");
	}
	
	public void sendMsg() throws ApiException {
		String token =Dingtalk.getToken(appkey, appsecret);
		
		client.execute(msg_request,token);
		
		System.out.println(token);
	}
	
	
	public static void main(String[] argv) {
		String key="dinge8312cdce7f26b5f35c2f4657eb6378f";
		String secret="84N_qPBXNBSQ5WxrvDyLcgfJl0TCFyuF2HC5-s-0xQd4DYvECwP_sBedxU6t0Sy2";
		DingtalkWorkMsg msg=new DingtalkWorkMsg(key,secret);
		
		msg.setUserid("033708361224246777", (long) 181945360);
		
		msg.sendTextMsg("≤‚ ‘");
		
		
		
		try {
			msg.sendMsg();
		} catch (ApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
