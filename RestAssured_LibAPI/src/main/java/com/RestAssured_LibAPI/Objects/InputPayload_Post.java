package com.RestAssured_LibAPI.Objects;

/**
 * This Class will present the getter setter methods for input payload of
 * Library API For POST method as per document given.
 * 
 * @author Priyanka Deiosarkar,
 * @author Kailas Andhalkar
 */

public class InputPayload_Post {

	private String name;
	private String isbn;
	private String aisle;
	private String author;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAisle() {
		return aisle;
	}

	public void setAisle(String aisle) {
		this.aisle = aisle;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}
