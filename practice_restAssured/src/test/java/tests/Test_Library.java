package tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class Test_Library {
	
	@Test
	public void test01() {
		//BaseURL
		RestAssured.baseURI="http://216.10.245.166";
		
		//Endpoint related to employee
		String createURI ="Library/Addbook.php";
		String deleteURI ="/Library/DeleteBook.php";
		String getbookbyAuthorname="/Library/GetBook.php?AuthorName=somename";
		String getbookbyID="Library/%s";//GetBook.php?ID=3389
		
		
		JsonPath jsonPath = new JsonPath(AddBook.inputPayload());
		String isbn=jsonPath.get("isbn");
		String aisle=jsonPath.get("aisle");
		String actualID=isbn+aisle;
		System.out.println(actualID);
		
		//API Body
		
				
		//******** Post Method ********
		String response =given().log().all().header("Content-Type","application/json").body(AddBook.inputPayload())
							.when().post(createURI)
								.then().log().all().assertThat().statusCode(200)
									.extract().body().asString();
		System.out.println(response);
		JsonPath js1 = new JsonPath(response);
		String expectedID=js1.get("ID");
		System.out.println(expectedID);
		Assert.assertEquals(actualID, expectedID);
		
		
		//******** getbook Method ******** 
		JsonPath js2 = new JsonPath(response);
		String getBID=js2.getString("ID");
		System.out.println(getBID);
		String getauthor=js2.getString("author");
		System.out.println(getauthor);
		
		getBID="GetBook.php?ID="+getBID;
		String getURI=String.format(getbookbyID,getBID);
		
				String getAll_response =given().log().all().header("Content-Type", "application/json")
											.when().get(getURI)
												.then().log().all().assertThat().statusCode(200)
												.extract().body().asString();
		System.out.println(getAll_response);
		
		System.out.println(response);
		JsonPath js3 = new JsonPath(response);
		String expauthor=js3.get("author");
		System.out.println(expauthor);
		Assert.assertEquals(getauthor, expauthor);
		
		//******** delete Method ******** 
		String deleteApibody= "{\"ID\" : \"%s\"}";
		
		deleteApibody=String.format(deleteApibody, expectedID);
		System.out.println(deleteApibody);

		//delete data
		String delete_response =given().log().all().header("Content-Type","application/json").body(deleteApibody).
									when().post(deleteURI).
												then().log().all().assertThat().statusCode(200).extract().body().asString();
		System.out.println(delete_response);
		
		JsonPath js4 = new JsonPath(delete_response);
		String expmsg=js4.getString("msg");
//		System.out.println(expmsg);
		Assert.assertEquals("book is successfully deleted",expmsg);
		
		


	}	
				
			

}
	
