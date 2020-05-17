package tests;


import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Test_Post_Get_Update {
	
	@Test
	public void testUpdateMethod() {
		//BaseURL
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		
		//Endpoint related to employee
		String createUrl ="/create";
		String deleteUrl ="/delete/%s";
		String getALLEmpId ="/employees";
		String putUrl ="/update/%s";
		
		
		//API Body
		String apiBody = "{\"name\":\"Priyanka Deosarkar\",\"salary\":\"80000\",\"age\":\"28\"}";
		
		/**
		 * given -> headers/paramters/query paramters/body
		 *		when -> get/put/post/delete -> URL/Endpoint
		 *			then -> Assertion /extraction of body
		 *				log().all() -> events trace
		 **/

				
		//******** Post Method ********
		String response =given().log().all().header("Content-Type","application/json").body(apiBody).
							when().post(createUrl).
								then().log().all().assertThat().statusCode(200).
									body("data.name", equalTo("Priyanka Deosarkar")).extract().body().asString();
		System.out.println(response);
		
		//Creating JsonPath to extract ID from response body
		JsonPath jsonPath = new JsonPath(response);
		int id=jsonPath.get("data.id");
		
		//******** Update Method ******** 
		// /update/%s -> /update/{id}
		System.out.println(String.format(putUrl,id+""));
		
		//Update API Body
//		String update_apiBody = "{\"name\":\"Priya Kapadani\",\"salary\":\"120000\",\"age\":\"29\"}";
		
		//Update data
		String update_response =given().log().all().header("Content-Type","application/json").body("{\"name\":\"Priya Kapadani\"}").
									when().put(String.format(putUrl,id+"")).
										then().log().all().assertThat().statusCode(200).
											body("status", equalTo("success")).extract().body().asString();
		System.out.println(update_response);
		
		//******** delete Method ******** 
		// /delete/%s -> /delete/{id}
		System.out.println(String.format(deleteUrl,id+""));
		
		//delete data
		String delete_response =given().log().all().header("Content-Type","application/json").
									when().delete(String.format(deleteUrl,id+"")).
											then().log().all().assertThat().extract().body().asString();
		System.out.println(delete_response);

		//******** getALLEmployees Method ******** 
		//getALLEmpId data
		String getAll_response =given().log().all().header("Content-Type", "application/json")
						.when().get(getALLEmpId)
							.then().log().all().body("status", equalTo("success")).extract().body().asString();
		System.out.println(getAll_response);
	}
	
	
	
	

}
