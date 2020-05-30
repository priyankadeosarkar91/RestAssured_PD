package com.RestAssured_LibAPI.TestMethods;

import org.testng.annotations.Test;

import com.RestAssured_LibAPI.Utilities.EndpointsURI;
import com.RestAssured_LibAPI.Utilities.Method_Call;

import io.restassured.path.json.JsonPath;

/**
 * This class is used to describe the @test of get book by ID generated in
 * response of Library API POST method With @param {ID}
 * 
 * @author Priyanka Deosarkar,
 * @author Kailas Andhalkar
 */
public class GetBookByID_Library_API_Test extends CreateBook_Library_API_Test {

	/**
	 * This Method will get book by ID generated in response With @param {ID}
	 * 
	 * @return {@code String}
	 * @param {getResponseByID}
	 */
	@Test
	public static String getBookByID() {

		// JSONPath is used to get ID from output Payload Resopnse
		JsonPath js = new JsonPath(CreateBook_Library_API_Test.createBookTest());
		String getID = js.getString("ID");

		// Update endpoint for getMethod URI (Get ID) with String Formatter Method.
		EndpointsURI.getBookWithId = String.format(EndpointsURI.getBookWithId, getID);

		// Call method GET Book(by ID) >> input payload of GET Book(by ID) from record
		// and generate output response
		String getResponseByID = Method_Call.request_GetByID(EndpointsURI.getBookWithId);
		return getResponseByID;
	}
}
