import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileInputStream;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

public class TestJiraAPIs {

	//End-point related to Create sessions, Create Issues 
	String createSessionURI = "/rest/auth/1/session";
	String createIssueURI = "/rest/api/2/issue";
//	String createAttachemntURI="/rest/api/2/issue/%s/attachments";
	
	//create attachment URI with id
	String createAttachemntURI="/rest/api/2/issue/{id}/attachments";
	
	
	@Test
	public void createSession() {

		//Creating Object for SessionFilter
		SessionFilter sessionFilter = new SessionFilter();

		//BaseURL
		RestAssured.baseURI = "http://localhost:8080";

		// Create Session >> JIRA API
		given().log().all()
		.contentType(ContentType.JSON)
		.body(PayloadJira.getSessionPayload())
		.filter(sessionFilter)
		.when().post(createSessionURI)
		.then().log().all()
		.assertThat().statusCode(200)
		.extract().body().asString();

		// Create Issue - Create Bug >> JIRA API
		given().log().all()
		.contentType(ContentType.JSON)
		.body(PayloadJira.getCreateBugPayload())
		.filter(sessionFilter)
		.when().post(createIssueURI)
		.then().log().all()
		.assertThat().statusCode(201)
		.extract().body().asString();

		// Create Issue - Create Story >> JIRA API
		String responseCreateStory=given().log().all()
		.contentType(ContentType.JSON)
		.body(PayloadJira.getCreateStoryPayload())
		.filter(sessionFilter)
		.when().post(createIssueURI)
		.then().log().all()
		.assertThat().statusCode(201)
		.extract().body().asString();
		
		
		JsonPath jsonPath = new JsonPath(responseCreateStory);
		String getStorykey=jsonPath.get("key");
		System.out.println(getStorykey);
		String createAttachemntURI1=String.format(createAttachemntURI,getStorykey);
		System.out.println(createAttachemntURI);
		
		File fileObject=new File("src\\test\\resources\\TestDoc.txt");
		
		//Create Attachment >> JIRA API
//		given().log().all()
//		.header("contentType","multipart/form-data")
//		.header("X-Atlassian-Token","nocheck")
//		.multiPart("file",fileObject)
//		.filter(sessionFilter)
//		.when().post(createAttachemntURI1)
//		.then().log().all()
//		.assertThat().statusCode(200)
//		.extract().body().asString();
		
		
		//Create Attachment with path parameter>> JIRA API
		given().log().all()
		.pathParam("id",getStorykey)
		.header("contentType","multipart/form-data")
		.header("X-Atlassian-Token","nocheck")
		.multiPart("file",fileObject)
		.filter(sessionFilter)
		.when().post(createAttachemntURI)
		.then().log().all()
		.assertThat().statusCode(200)
		.extract().body().asString();
		

	}

}
