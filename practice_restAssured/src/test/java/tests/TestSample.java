package tests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestSample {
	
	//Endpoint related to employee
	String createUrl="/create";
	String deleteUrl="/delete/{id}";
	String getALLEmpId="/employees";
	
	
	
	@Test(priority = 0)
	public void testPostMethod() {
		
		//BaseURL
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		//API Body
		String apiBody = "{\"name\":\"Priyanka\",\"salary\":\"80000\",\"age\":\"28\"}";
		
		//Post Method
		given().log().all().header("Content-Type","application/json").body(apiBody).
			when().post(createUrl).
				then().log().all().assertThat().statusCode(200).body("data.name", equalTo("PriyankaD"));
	
	}
//	
//	@Test(priority = 1)
//	public void testgetMethod() {
//		
//		//get Method
//		given().log().all().header("Content-Type","application/json")
//			.when().get(getALLEmpId)
//				.then().log().all().assertThat().statusCode(200);	
//
//	}
}
