import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.request.OapiGettokenRequest;
import com.dingtalk.api.response.OapiGettokenResponse;
import com.taobao.api.ApiException;

public class Dingtalk{
	
	public Dingtalk() {
		// TODO Auto-generated constructor stub

	}
	
	protected static String getToken(String key,String secret) {
		DefaultDingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/gettoken");
		OapiGettokenRequest get_token_request  = new OapiGettokenRequest();;
		
		get_token_request.setAppkey(key);
		get_token_request.setAppsecret(secret);
		get_token_request.setHttpMethod("GET");
		
		OapiGettokenResponse get_token_response = null;
		try {
			get_token_response = client.execute(get_token_request);
		} catch (ApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		get_token_response.getAccessToken();
		return get_token_response.getAccessToken();
	}

	
	
}
