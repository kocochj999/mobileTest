package api;

import static io.restassured.RestAssured.given;

import java.util.List;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;

public class TaskAPI extends BaseApi {
	public final String baseEndpoint = "https://api.todoist.com/rest/v1/tasks";

	public Response getAllTasks() {
		RestAssured.defaultParser = Parser.JSON;
		return 
				given().headers(HeaderConfigs.BASE_HEADER()).
				when().get(baseEndpoint).
				then().
				statusCode(200).
				contentType(ContentType.JSON).extract().response();
	}
	public String getTaskId(String taskName){
		String id ="";
		Response res = getAllTasks();
		List<Map<String,Object>> list = res.jsonPath().getList("$");
		for(Map<String,Object> map:list){
			if(map.get("content").equals(taskName)){
				id = String.valueOf(map.get("id"));
			}
		}
		return id;
	}
	
	public void verifyTaskIsCreated(String taskName) {
		given().headers(HeaderConfigs.BASE_HEADER()).
		when().get(baseEndpoint).
		then().
		statusCode(200).
		body("content", hasItems(taskName));
	}
	
	public void reopenTask(String taskID) throws Exception {
		given().headers(HeaderConfigs.BASE_HEADER()).when()
				.post(baseEndpoint + "/" + taskID + "/reopen").then().statusCode(204);
	}
}
