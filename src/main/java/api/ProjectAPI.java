package api;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.response.Response;
import org.json.simple.JSONObject;

public class ProjectAPI extends BaseApi {
	private final String baseEndpoint = "https://api.todoist.com/rest/v1/projects";
	public String createProject(String projectName) throws Exception {
				
		JSONObject request = new JSONObject();
		request.put("name", projectName);
		Response response = given()
			.headers(HeaderConfigs.POST_HEADER())
			.body(request.toJSONString())
		.when()
			.post(baseEndpoint)
		.then()
			.statusCode(200)
			.body("name",equalToIgnoringCase(projectName))
			.extract()
			.response();
		return response.jsonPath().getString("id");
	}
	public void deleteProject(String projectId){
		given()
				.headers(HeaderConfigs.BASE_HEADER())
		.when()
				.delete(baseEndpoint+"/"+projectId)
		.then()
				.statusCode(204);
	}

}
