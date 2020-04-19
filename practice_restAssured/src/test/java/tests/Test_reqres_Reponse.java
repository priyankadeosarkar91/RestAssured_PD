package tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

/**
 * Test Methods -> POST,PUT,GET,DELETE
 * baseURI="https://reqres.in/"
 * 
 * @author Priyanka
 *
 */
public class Test_reqres_Reponse {
	@Test
	public void testALLreqresMethod() {
		//BaseURL
		RestAssured.baseURI="https://reqres.in/";
		
		//Endpoint related to employee
		String createURI ="/api/users";
		String putURI ="/api/users/%s";
		String deleteURI ="/api/users/%s";
		String getALLEmpId ="/api/users?page=2";
		
		
		//API Body
		String apiBody = "{\"name\":\"Priyanka Deosarkar\",\"job\":\"Functional QA\"}";
		
		/**
		 * given -> headers/paramters/query paramters/body
		 *		when -> get/put/post/delete -> URL/Endpoint
		 *			then -> Assertion /extraction of body
		 *				log().all() -> events trace
		 **/

				
		//******** Post Method ********
		String response =given().log().all().header("Content-Type","application/json").body(apiBody)
							.when().post(createURI)
								.then().log().all().assertThat().statusCode(201)
									.body("name", equalTo("Priyanka Deosarkar")).extract().body().asString();
		System.out.println(response);
		
		//******** getALLEmployees Method ******** 
		//getALLEmpId data
		String getAll_response =given().log().all().header("Content-Type", "application/json")
									.when().get(getALLEmpId)
										.then().log().all().assertThat().statusCode(200)
										.extract().body().asString();
		System.out.println(getAll_response);
		
		//Creating JsonPath to extract ID from response body
		JsonPath jsonPath = new JsonPath(response);
		String id=jsonPath.get("id");
		
	
		//******** Update Method ******** 
		// /update/%s -> /update/{id}
		System.out.println(String.format(putURI,id));
		
		//Update API Body
		String update_apiBody = "{\"name\":\"Priyanka kapadani\",\"job\":\"Sr QA\"}";
		
		//Update data
		String update_response =given().log().all().header("Content-Type","application/json").body(update_apiBody)
									.when().put(String.format(putURI,id))
										.then().log().all().assertThat().statusCode(200)
											.body("job", equalTo("Sr QA")).extract().body().asString();
		System.out.println(update_response);


		//******** delete Method ******** 
		// /delete/%s -> /delete/{id}
		System.out.println(String.format(deleteURI,id));
		
		//delete data
		String delete_response =given().log().all().header("Content-Type","application/json").
									when().delete(String.format(deleteURI,id)).
											then().log().all().assertThat().statusCode(204).extract().body().asString();
		System.out.println(delete_response);

		
		
	
	}
	

}
