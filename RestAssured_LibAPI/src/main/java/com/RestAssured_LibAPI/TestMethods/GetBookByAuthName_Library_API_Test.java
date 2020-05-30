package com.RestAssured_LibAPI.TestMethods;

import org.testng.annotations.Test;

import com.RestAssured_LibAPI.Utilities.EndpointsURI;
import com.RestAssured_LibAPI.Utilities.Method_Call;

/**
 * This class is used to describe the @test of get book by Author Name generated
 * in response of Library API POST method With @param {getAuthName}
 * 
 * @author Priyanka Deosarkar,
 * @author Kailas Andhalkar
 */
public class GetBookByAuthName_Library_API_Test extends CreateBook_Library_API_Test {

	/**
	 * This Method will get book by AuthorName generated in response 
	 * With @param {getAuthName}
	 * 
	 */
	@Test
	public void getBookByAuthName() {

		// GetAuthor name from Object book and convet it to string
		getAuthName = book.getAuthor().toString();
		System.out.println("--- Author Name is >> " + getAuthName + "----");

		// Update endpoint for getMethod URI (by AuthorName) with String Formatter
		// Method.
		EndpointsURI.getBookWithAuthName = String.format(EndpointsURI.getBookWithAuthName, getAuthName);

		// Call method GET Book(by Author Name)- input payload of GET Book(by
		// AuthorName) from record and generate output response
		Method_Call.request_GetByID(EndpointsURI.getBookWithAuthName);

//		JsonPath js= new JsonPath(book.toString());
//		String getAuthName=js.getString("author");
//		EndpointsURI.getBookWithId=String.format(EndpointsURI.getBookWithId, getAuthName);
//		String getResponseByID=Method_Call.request_GetByID(EndpointsURI.getBookWithId);
//		return getResponseByID;

	}
}
