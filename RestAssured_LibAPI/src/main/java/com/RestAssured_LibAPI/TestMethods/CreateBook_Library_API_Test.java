package com.RestAssured_LibAPI.TestMethods;


import org.testng.annotations.Test;

import com.RestAssured_LibAPI.Objects.CreateBook;
import com.RestAssured_LibAPI.Utilities.BaseURL;
import com.RestAssured_LibAPI.Utilities.EndpointsURI;
import com.RestAssured_LibAPI.Utilities.Method_Call;

public class CreateBook_Library_API_Test {
	
	/**
	 * This Method will create a new book with name, isbn, aisel,author name.
	 * 
	 * @author Priyanka
	 */
	public static CreateBook book;
	
	@Test
	public static void createBook() {
		BaseURL.baseURI();	
		book=new CreateBook();
		book.setName("Complete Reference to java");
		book.setIsbn("PDDKK");
		book.setAisle("0291");
		book.setAuthor("Priyanka");
		//String getAuthName=book.getAuthor();
		
//		String createBookResponse=
		Method_Call.request_postURI(book, EndpointsURI.createBook);
		
		//return createBookResponse;

	}

}
