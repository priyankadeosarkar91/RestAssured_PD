package tests;

import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;

public class SampleDummyPost {
	@Test
	public void testPost() {
		//BaseURL
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		
		//Endpoint related to employee
		String createURI="/create";
		String deleteURI="/delete/{id}";
		String getALLEmpId="/employees";
		
		//API Body
		String apiBody = "{\"name\":\"Aditi\",\"salary\":\"600000\",\"age\":\"28\"}";
//		String apiBody = "{\"employee_name\": \"PDD\",\"employee_salary\": \"85600\",\"employee_age\": \"23\"}";
		
		String response =given().log().all().header("Content-Type","application/json").body(apiBody).
							when().post(createURI).
								then().log().all().assertThat().statusCode(200).
									body("data.name", equalTo("Aditi")).extract().body().asString();
		System.out.println(response);
		
		given().log().all().header("Content-Type","application/json").
		when().get(getALLEmpId).
			then().log().all().assertThat().statusCode(200);
		
	}

}
