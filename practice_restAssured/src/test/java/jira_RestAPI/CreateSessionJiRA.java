package jira_RestAPI;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class CreateSessionJiRA {
	@Test
	public void createTicket() {
		RestAssured.baseURI = "http://localhost:8080";
		String createticketURI = "/rest/auth/1/session";
		String createIssueURI="/rest/api/2/issue";
		
		String body = "{\r\n" + "    \"username\": \"priyadeosarkar91\",\r\n"
				+ "    \"password\": \"SPriyanka@1123\"\r\n" + "}";
		
		// ******** createticket >>> Post Method ********
		String response_createTicket = given().log().all().header("Content-Type", "application/json").body(body)
							.when().post(createticketURI)
								.then().log().all().assertThat().statusCode(200).extract().body().asString();
		
		
		// ******** createIssue bug/st >>> Post Method ********
		System.out.println(response_createTicket);
		
		JsonPath jsonPath = new JsonPath(response_createTicket);
		String sessionId=jsonPath.get("session.value");
		System.out.println(sessionId);
		
		String issueBody="{\r\n" + 
				"    \"fields\": {\r\n" + 
				"       \"project\":\r\n" + 
				"       {\r\n" + 
				"          \"key\": \"PRIYAD\"\r\n" + 
				"       },\r\n" + 
				"       \"summary\": \"Priyanka create Story by automation\",\r\n" + 
				"       \"description\": \"This is my second story\",\r\n" + 
				"       \"issuetype\": {\r\n" + 
				"          \"name\": \"Story\"\r\n" + 
				"       }\r\n" + 
				"   },\r\n" + 
				"}\r\n" + 
				"";
		
		String bugBody="{\r\n" + 
				"    \"fields\": {\r\n" + 
				"       \"project\":\r\n" + 
				"       {\r\n" + 
				"          \"key\": \"PRIYAD\"\r\n" + 
				"       },\r\n" + 
				"       \"summary\": \"REST ye merry gentlemen.\",\r\n" + 
				"       \"description\": \"Creating of an issue using project keys and issue type names using the REST API\",\r\n" + 
				"       \"issuetype\": {\r\n" + 
				"          \"name\": \"Bug\"\r\n" + 
				"       }\r\n" + 
				"   }\r\n" + 
				"}";
		String response_createIssue = 
				given().log().all().body(bugBody).header("Content-Type", "application/json").header("Cookie",sessionId)
										.when().post(createIssueURI)
											.then().log().all().assertThat().statusCode(201).extract().body().asString();
		System.out.println(response_createIssue);
		

	}

}
