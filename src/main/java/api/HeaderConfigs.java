package api;

import java.util.HashMap;
import java.util.Map;

import common.Constants;
import static common.Utilities.*;

public class HeaderConfigs extends BaseApi{
	public static Map<String, Object> BASE_HEADER(){
		Map<String, Object> headers = new HashMap<String, Object>();
		headers.put("Authorization", "Bearer " + Constants.token);
		return headers;
	}
	public static Map<String, Object> POST_HEADER(){
		Map<String, Object> headers = new HashMap<String, Object>();
		headers.put("Content-Type", "application/json");
		headers.put("X-Request-Id", randomNumber());
		headers.put("Authorization", "Bearer " + Constants.token);
		return headers;
	}

	
}
