package com.RestAssured_LibAPI.TestMethods;

import com.RestAssured_LibAPI.Objects.InputPayload_Post;
import com.RestAssured_LibAPI.Utilities.EndpointsURI;
import com.RestAssured_LibAPI.Utilities.Method_Call;

/**
 * This class is used to describe the get book by Author Name (with Main Method) 
 * generated in response of Library API POST method With @param {getAuthName}
 * 
 * @author Priyanka Deosarkar,
 * @author Kailas Andhalkar
 */
public class GetBookByAuthorName_mainMethod {

	public static InputPayload_Post book;

	public static void main(String[] args) {
		// Call for BaseURL="http://216.10.245.166"
		EndpointsURI.baseURI();

		// Creating object for input payload of create book record
		book = new InputPayload_Post();
		book.setName("Complete Reference to java");
		book.setIsbn("prime");
		book.setAisle("1717");
		book.setAuthor("PriyankaD");

		// Call method POST >> input payload of create book record and generate output
		// response
		Method_Call.request_postURI(book, EndpointsURI.createBook);

		// Get author name from object 'book' and convert to string
		String getAuthName = book.getAuthor().toString();

		// Print AuthorName
		System.out.println("\n--- Author Name is >> " + getAuthName + "----\n");

		// Update getBookWithAuthName URI
		EndpointsURI.getBookWithAuthName = String.format(EndpointsURI.getBookWithAuthName, getAuthName);

		// Method to get book by author name
		Method_Call.request_GetByID(EndpointsURI.getBookWithAuthName);
	}

}
