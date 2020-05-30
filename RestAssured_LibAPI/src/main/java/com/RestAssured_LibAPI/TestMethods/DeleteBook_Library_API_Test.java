package com.RestAssured_LibAPI.TestMethods;

import org.testng.annotations.Test;

import com.RestAssured_LibAPI.Utilities.BaseURL;
import com.RestAssured_LibAPI.Utilities.EndpointsURI;
import com.RestAssured_LibAPI.Utilities.Method_Call;

import io.restassured.path.json.JsonPath;

public class DeleteBook_Library_API_Test extends CreateBook_Library_API_Test {
	
	@Test
	public void deleteBookByID() {
		
		BaseURL.baseURI();
		String deleteBody="{\"ID\" : \"%s\"}";
		JsonPath js= new JsonPath(CreateBook_Library_API_Test.createBook());
		String getID=js.getString("ID");
		deleteBody=String.format(deleteBody, getID);
		
		Method_Call.request_DeleteBookByID(deleteBody,EndpointsURI.deleteBook);

	}

}
