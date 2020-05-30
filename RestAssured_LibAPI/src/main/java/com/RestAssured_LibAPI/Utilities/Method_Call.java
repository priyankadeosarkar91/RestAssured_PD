package com.RestAssured_LibAPI.Utilities;

import static io.restassured.RestAssured.given;

import com.RestAssured_LibAPI.Objects.CreateBook;

import io.restassured.http.ContentType;

public class Method_Call {
	public static Object request_DeleteBookByID;

	public static CreateBook request_postURI(Object body, String method) {
		
		return given().log().all()
		.contentType(ContentType.JSON)
		.body(body)
		.when()
		.post(method)
		.then().log().all().extract().as(CreateBook.class);

	}
	
	public static void request_GetByID(String method) {
		given().log().all()
		.contentType(ContentType.JSON)
		.when()
		.get(method)
		.then().log().all()
		.assertThat().statusCode(200)
		.extract().body().asString();
	}
	
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
