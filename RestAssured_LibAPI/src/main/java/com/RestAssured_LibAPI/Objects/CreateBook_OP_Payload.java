package com.RestAssured_LibAPI.Objects;

/**
 * This Class will present the getter setter methods for output payload of
 * Library API For POST method as per document given.
 * 
 * @author Priyanka Deiosarkar,
 * @author Kailas Andhalkar
 */

public class CreateBook_OP_Payload {

	private String Msg;
	private String ID;

	public String getMsg() {
		return Msg;
	}

	public void setMsg(String Msg) {
		this.Msg = Msg;
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

}
