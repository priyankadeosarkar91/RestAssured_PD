package JiraAPIs;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

public class TestJIRAAPIs {

	// End-point related to Create sessions, Create Issues
	String createSessionURI = "/rest/auth/1/session";
	String createIssueURI = "/rest/api/2/issue";
	// create attachment URI with id
	String createAttachemntURI = "/rest/api/2/issue/%s/attachments";

	// Response Variables
	String createSessionResponse;
	String createIssueResponse;

	// Creating Object for SessionFilter
	SessionFilter sessionFilter = new SessionFilter();

	@Test(priority = 1)
	public void createSession() {

		// BaseURL
		PayloadJira.getbaseURI();

		// Create Session >> JIRA API
		createSessionResponse = 
				given().log().all()
				.contentType(ContentType.JSON)
				.body(PayloadJira.getSessionPayload())
				.filter(sessionFilter).when()
				.post(createSessionURI)
				.then().log()
				.all().assertThat().statusCode(200).extract().body().asString();
	}

	@Test(priority = 2)
	public void createIssue() {
		// BaseURL
		PayloadJira.getbaseURI();

		// Create Issue - Create Bug >> JIRA API
		createIssueResponse = 
				given().log().all()
				.contentType(ContentType.JSON)
				.body(PayloadJira.getCreateStoryPayload())
				.filter(sessionFilter)
				.when().post(createIssueURI)
				.then().log().all()
				.assertThat().statusCode(201)
				.extract().body().asString();
	}

	@Test(priority = 3)
	public void createAttachment() {
		// BaseURL
		PayloadJira.getbaseURI();

		JsonPath jsonPath = new JsonPath(createIssueResponse);
		String getStorykey = jsonPath.get("key");
		System.out.println(getStorykey);
		String createAttachemntURI1 = String.format(createAttachemntURI, getStorykey);
		System.out.println(createAttachemntURI);

		File fileObject = new File("src\\test\\resources\\TestDoc.txt");

		// Create Attachment >> JIRA API
		given().log().all()
		.header("contentType", "multipart/form-data")
		.header("X-Atlassian-Token", "nocheck")
		.multiPart("file", fileObject)
		.filter(sessionFilter)
		.when().post(createAttachemntURI1)
		.then().log().all()
		.assertThat().statusCode(200).extract().body().asString();
	}

}
