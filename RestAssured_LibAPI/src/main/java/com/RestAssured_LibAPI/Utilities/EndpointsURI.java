package com.RestAssured_LibAPI.Utilities;

public class EndpointsURI {
	public static String createBook = "Library/Addbook.php";
	public static String getBookWithAuthName = "/Library/GetBook.php?AuthorName=%s";
	public static String getBookWithId = "/Library/GetBook.php?ID=%s";
	public static String deleteBook = "/Library/DeleteBook.php";

}
