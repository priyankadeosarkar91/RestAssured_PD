package com.RestAssured_LibAPI.TestMethods;

import org.testng.annotations.BeforeClass;

import com.RestAssured_LibAPI.Objects.InputPayload_Post;
import com.RestAssured_LibAPI.Utilities.EndpointsURI;
import com.RestAssured_LibAPI.Utilities.Method_Call;

/**
 * This class is used to describe the @test of create book of Library API
 * 
 * @author Priyanka Deiosarkar,
 * @author Kailas Andhalkar
 */
public class CreateBook_Library_API_Test {

	/**
	 * This Method will create a new book with @param {name, isbn, aisel,
	 * authorName} verified with input payload and generate response as output
	 * payload verified with given document.
	 *
	 * @return {@code String}
	 * @param {response_OP_Payload}
	 */
	public static InputPayload_Post book;
	public static String getAuthName;

	@BeforeClass
	public static String createBookTest() {

		// Call for BaseURL="http://216.10.245.166"
		EndpointsURI.baseURI();

		// Creating object for input payload of create book record
		book = new InputPayload_Post();
		book.setName("Complete Reference to java");
		book.setIsbn("prime");
		book.setAisle("987001");
		book.setAuthor("PriyankaD");

		// Call method POST >> input payload of create book record and generate output
		// response
		String response_OP_Payload = Method_Call.request_postURI(book, EndpointsURI.createBook);
		return response_OP_Payload;
	}

}
