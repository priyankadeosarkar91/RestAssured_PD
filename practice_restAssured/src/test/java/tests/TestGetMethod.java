package tests;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestGetMethod {
	@Test(priority = 1)
	public void testgetMethod() {
		//BaseURL
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		
		//Endpoint related to employee
		String createUrl="/create";
		String deleteUrl="/delete/{id}";
		String getALLEmpId="/employees";
		
		//API Body
		String apiBody = "{\"name\":\"Priyanka\",\"salary\":\"80000\",\"age\":\"28\"}";
		
		//get Method
		String response=given().log().all().header("Content-Type","application/json")
					.when().get(getALLEmpId)
				.then().log().all().extract().response().asString();
		System.out.println("response data  : "+ response);

	}

}
