package tests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;


import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestService {
	@Test
	public void test() {
		System.out.println("Hello");
		//Rest API's URL
        String restAPIUrl = "http://dummy.restapiexample.com/api/v1/create";
        
        //API Body
        String apiBody = "{\"name\":\"aditi11\",\"salary\":\"700000\",\"age\":\"29\"}";
        
        // Building request by using requestSpecBuilder
        RequestSpecBuilder builder = new RequestSpecBuilder();
        
        //Set API's Body
        builder.setBody(apiBody);
        
        //Setting content type as application/json
        builder.setContentType("application/json; charset=UTF-8");
        
        RequestSpecification reqstSpec=builder.build();
        
        //RequestSpecification requestSpec = builder.build();
        Response response = given().when().spec(reqstSpec).post(restAPIUrl);
       
        System.out.println(response.asString());





	}

}
