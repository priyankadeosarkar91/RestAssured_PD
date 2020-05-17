package tests;

public class AddBook {
	
	public static String inputPayload() {
		return("{\r\n" + 
				"\r\n" + 
				"\"name\":\"complete referenece with Java\",\r\n" + 
				"\"isbn\":\"aaabb\",\r\n" + 
				"\"aisle\":\"404\",\r\n" + 
				"\"author\":\"John R\"\r\n" + 
				"}");

	}
	
	public static String getBook() {
		return("{\r\n" + 
				"\"book_name\": \"Selenium automation using Java\",\r\n" + 
				"\"isbn\": \"ahdd\",\r\n" + 
				"\"aisle\": \"1223\"\r\n" + 
				"} \r\n" + 
				"");

	}
	public static String deleteBook() {
		return "{\r\n" + 
				" \r\n" + 
				"\"ID\" : \"%s\"\r\n" + 
				" \r\n" + 
				"}\r\n" + 
				"";

	}

}
