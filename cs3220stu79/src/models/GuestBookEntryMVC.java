package models;

import java.util.Date;

public class GuestBookEntryMVC {

	Integer id;

	String name;

	String message;
	
	Date date;
	
	public GuestBookEntryMVC(){
		date=new Date();
	}

	public GuestBookEntryMVC(Integer id, String name, String message) {
		this.id = id;
		this.name = name;
		this.message = message;
		this.date =new Date();
	}	
	public GuestBookEntryMVC(String name, String message) {	
		this.name = name;
		this.message = message;
		this.date =new Date();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}