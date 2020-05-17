package com.librarybooks.payloads;

public class CreateBook {
	public static String inputPayload() {
		return("{\r\n" + 
				"\r\n" + 
				"\"name\":\"Head First Java\",\r\n" + 
				"\"isbn\":\"xyz\",\r\n" + 
				"\"aisle\":\"0291\",\r\n" + 
				"\"author\":\"O'Reilly\"\r\n" + 
				"}");

	}

}
