package com.RestAssured_LibAPI.TestMethods;

import org.testng.annotations.Test;

import com.RestAssured_LibAPI.Utilities.EndpointsURI;
import com.RestAssured_LibAPI.Utilities.Method_Call;

import io.restassured.path.json.JsonPath;

/**
 * This class is used to describe the @test of delete book by ID generated in
 * response of Library API Using POST method
 * 
 * @author Priyanka Deosarkar,
 * @author Kailas Andhalkar
 */
public class DeleteBook_Library_API_Test extends CreateBook_Library_API_Test {
	/**
	 * This delete method will use to delete the books with ID.
	 * 
	 * @param deleteBody
	 * @param getID
	 */
	@Test
	public void deleteBookByID() {
		// Creating Delete API Body
		String deleteBody = "{\"ID\" : \"%s\"}";

		// JSONPath is used to get ID from output Payload Resopnse
		JsonPath js = new JsonPath(CreateBook_Library_API_Test.createBookTest());
		String getID = js.getString("ID");

		// Update Delete body (Get ID) with String Formatter Method.
		deleteBody = String.format(deleteBody, getID);

		// Delete
		Method_Call.request_DeleteBookByID(deleteBody, EndpointsURI.deleteBook);

	}

}
