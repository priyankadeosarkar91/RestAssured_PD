import io.restassured.RestAssured;

public class PayloadJira {
	
	public static String getbaseURI() {
		RestAssured.baseURI = "http://localhost:8080";
		return RestAssured.baseURI;
		
	}
	
	public static String getSessionPayload() {
		return "{" + 
				"    \"username\": \"priyadeosarkar91\"," + 
				"    \"password\": \"SPriyanka@1123\"" + 
				"}";
	}
	
	public static String getCreateBugPayload() {
		return "{" + 
				"    \"fields\": {" + 
				"       \"project\":" + 
				"       {" + 
				"          \"key\": \"PRIYAD\"" + 
				"       }," + 
				"       \"summary\": \"Priyanka create bug\"," + 
				"       \"description\": \"This is my second Bug   >> Postman\"," + 
				"       \"issuetype\": {" + 
				"          \"name\": \"Bug\"" + 
				"       }" + 
				"   }" + 
				"}" + 
				"";
	}
	
	public static String getCreateStoryPayload() {
		return "{" + 
				"    \"fields\": {" + 
				"       \"project\":" + 
				"       {" + 
				"          \"key\": \"PRIYAD\"" + 
				"       },\r\n" + 
				"       \"summary\": \"As Developer,My First Story in Jira through Automation\"," + 
				"       \"description\": \"I would like to share better report of our success and failures. \"," + 
				"       \"issuetype\": {" + 
				"          \"name\": \"Story\"" + 
				"       }" + 
				"   }" + 
				"}" + 
				"";
		
	}
	

}
