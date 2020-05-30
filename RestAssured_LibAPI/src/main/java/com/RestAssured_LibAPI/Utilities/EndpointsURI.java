package com.RestAssured_LibAPI.Utilities;

import io.restassured.RestAssured;

/**
 * This Class will present to get base URL and endpoints required to execute
 * Methods (POSt,Get,DELETE) referred from the given Library_API Document.
 * 
 * @author Priyanka Deiosarkar,
 * @author Kailas Andhalkar
 */
public class EndpointsURI {
	public static String createBook = "Library/Addbook.php";
	public static String getBookWithAuthName = "/Library/GetBook.php?AuthorName=%s";
	public static String getBookWithId = "/Library/GetBook.php?ID=%s";
	public static String deleteBook = "/Library/DeleteBook.php";

	// BaseURL >> LibraryAPI
	public static String baseURI() {

		return (RestAssured.baseURI = "http://216.10.245.166");
	}

}
