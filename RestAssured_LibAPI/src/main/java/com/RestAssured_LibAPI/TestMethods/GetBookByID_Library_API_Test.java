package com.RestAssured_LibAPI.TestMethods;


import org.testng.annotations.Test;

import com.RestAssured_LibAPI.Utilities.BaseURL;
import com.RestAssured_LibAPI.Utilities.Call_Method;
import com.RestAssured_LibAPI.Utilities.EndpointsURI;
import com.RestAssured_LibAPI.Utilities.Method_Call;

import io.restassured.path.json.JsonPath;

public class GetBookByID_Library_API_Test extends CreateBook_Library_API_Test{
	
	@Test
	public void getBookByID() {
		
		BaseURL.baseURI();
		JsonPath js= new JsonPath(CreateBook_Library_API_Test.createBook());
		String getID=js.getString("ID");
		EndpointsURI.getBookWithId=String.format(EndpointsURI.getBookWithId, getID);
		Method_Call.request_GetByID(EndpointsURI.getBookWithId);
		
	}

}
