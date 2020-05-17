package tests;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;
import org.testng.annotations.Test;
 
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
 

public class Test_DeleteMethod {
	
	
	@Test
	public void deleteEmpRecord() {
		int empid = 41;
	 
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
	 
		String delete_response =given().log().all().header("Content-Type","application/json").
				when().get("/delete/"+ empid).
						then().log().all().assertThat().statusCode(200).extract().body().asString();
		System.out.println(delete_response);

			
			
//		RequestSpecification request = RestAssured.given(); 
//	 
//	 // Add a header stating the Request body is a JSON
//	 request.header("Content-Type", "application/json"); 
//	 
//	 // Delete the request and check the response
//	 Response response = request.delete("/delete/"+ empid); 
//	 
//	 int statusCode = response.getStatusCode();
//	 System.out.println(response.asString());
//	 Assert.assertEquals(statusCode, 200);
//	 
//	 String jsonString =response.asString();
//	 Assert.assertEquals(jsonString.contains("successfully! deleted Records"), true);
	 }

}
