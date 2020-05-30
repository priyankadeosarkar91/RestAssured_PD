package com.RestAssured_LibAPI.Utilities;

import io.restassured.RestAssured;

public class BaseURL {
	// BaseURL >> LibraryAPI
	public static String baseURI() {
		
		return(RestAssured.baseURI="http://216.10.245.166");
	}
}
