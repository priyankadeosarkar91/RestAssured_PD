package com.RestAssured_LibAPI.Utilities;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;

/** This class is used to describe the Methods to handle liv=brary API operations
 * Such as POST,Get(Book by ID or by Author Name), DELETE.
 * 
 * @author Priyanka Deiosarkar,
 * @author Kailas Andhalkar
 */
public class Method_Call {
	
	/**
	 * This Post method will present to upload input Payload of library API to create a book record
	 * 
	 * @param body
	 * @param method
	 * @return  {@code:String}
	 */

	public static String request_postURI(Object body, String method) {
		
		return given().log().all()
		.contentType(ContentType.JSON)
		.body(body)
		.when()
		.post(method)
		.then().log().all().extract().asString();
	}
	/** 
	 * This get method will present to get the book with ID.
	 * 
	 * @param method
	 * @return {@code:String}
	 */
	public static String request_GetByID(String method) {
		return given().log().all()
		.contentType(ContentType.JSON)
		.when()
		.get(method)
		.then().log().all()
		.assertThat().statusCode(200)
		.extract().body().asString();
	}
	
	/**
	 * This get method will present to get the book with AuthorName.
	 * 
	 * @param parameterValues
	 * @param method
	 */
	
	public static void request_GetByAuthName(String parameterValues, String method) {
		given().log().all()
		.queryParam("AuthorName", parameterValues)
		.contentType(ContentType.JSON)
		.when()
		.get(method)
		.then().log().all()
		.assertThat().statusCode(200)
		.extract().body().asString();
	}
	
	/**
	 * This delete method will present to delete the books with ID.
	 * 
	 * @param delBody
	 * @param method
	 */
	public static Object request_DeleteBookByID(String delBody, String method) {
		return given().log().all()
		.contentType(ContentType.JSON).
		body(delBody)
		.when()
		.post(method)
		.then().log().all()
		.assertThat().statusCode(200)
		.extract().body().asString();
	}

}
