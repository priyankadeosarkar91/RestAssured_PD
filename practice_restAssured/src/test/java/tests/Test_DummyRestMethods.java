package tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
/**
 * Test Methods -> POST,PUT,GET,DELETE
 * baseURI="http://dummy.restapiexample.com/api/v1"
 * 
 * @author Priyanka
 *
 */
public class Test_DummyRestMethods {
	@Test
	public void testALLMethod() {
		//BaseURL
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		
		//Endpoint related to employee
		String createURI ="/create";
		String deleteURI ="/delete/%s";
		String getALLEmpId ="/employees";
		String putURI ="/update/%s";
		
		//API Body
		String apiBody = "{\"name\":\"Priyanka Deosarkar\",\"salary\":\"80000\",\"age\":\"28\"}";
		
		/**
		 * given -> headers/paramters/query paramters/body
		 *		when -> get/put/post/delete -> URL/Endpoint
		 *			then -> Assertion /extraction of body
		 *				log().all() -> events trace
		 **/

				
		//******** Post Method ********
		String response =given().log().all().header("Content-Type","application/json").body(apiBody)
							.when().post(createURI)
								.then().log().all().assertThat().statusCode(200)
									.body("data.name", equalTo("Priyanka Deosarkar")).extract().body().asString();
		System.out.println(response);
		
		//Creating JsonPath to extract ID from response body
		JsonPath jsonPath = new JsonPath(response);
		int id=jsonPath.get("data.id");
		
		
		//******** Update Method ******** 
		// /update/%s -> /update/{id}
		System.out.println(String.format(putURI,id+""));
		
		//Update API Body
		String update_apiBody = "{\"name\":\"Priya Kapadani\",\"salary\":\"120000\",\"age\":\"29\"}";
		
		//Update data
		String update_response =given().log().all().header("Content-Type","application/json").body(update_apiBody)
									.when().put(String.format(putURI,id+""))
										.then().log().all().assertThat().statusCode(200)
											.body("status", equalTo("success")).extract().body().asString();
		System.out.println(update_response);
		
		//******** getALLEmployees Method ******** 
		//getALLEmpId data
		String getAll_response =given().log().all().header("Content-Type", "application/json")
						.when().get(getALLEmpId)
							.then().log().all().assertThat().statusCode(200)
							.body("status", equalTo("success")).extract().body().asString();
		System.out.println(getAll_response);
		
		//******** delete Method ******** 
		// /delete/%s -> /delete/{id}
		System.out.println(String.format(deleteURI,id+""));
		
		//delete data
		String delete_response =given().log().all().header("Content-Type","application/json").
									when().delete(String.format(deleteURI,id+"")).
											then().log().all().assertThat().statusCode(200).body("status", equalTo("success")).extract().body().asString();
		System.out.println(delete_response);

		
	}
	
	

}
