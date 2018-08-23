package models;

import java.util.Date;

public class GuestBookEntry {
	
	static int count=0;
	int id;
	String name;
	String message;
	Date created;
	 
	public GuestBookEntry(String name, String message) {
		super();
		this.name = name;
		this.message = message;
		this.created= new Date();
		this.id= count++;
	}	
	
	public int getId(){
		return id;
	}
	
	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
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
