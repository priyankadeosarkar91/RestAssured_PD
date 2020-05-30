package com.RestAssured_LibAPI.TestMethods;

import org.testng.annotations.Test;

import com.RestAssured_LibAPI.Utilities.BaseURL;
import com.RestAssured_LibAPI.Utilities.EndpointsURI;
import com.RestAssured_LibAPI.Utilities.Method_Call;

public class GetBookByAuthName_Library_API_Test extends CreateBook_Library_API_Test {
	
	@Test
	public void getBookByAuthName() {
		
		BaseURL.baseURI();
		String getAuthName=book.getAuthor();
		EndpointsURI.getBookWithAuthName=String.format(EndpointsURI.getBookWithAuthName,getAuthName );	
		Method_Call.request_GetByAuthName(getAuthName, EndpointsURI.getBookWithAuthName);
		
	}
}
