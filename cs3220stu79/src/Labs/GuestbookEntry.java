package Labs;

import java.util.Date;

public class GuestbookEntry {
	
	String  name;
	String message;
	Date created;
	
	
	
	public GuestbookEntry(String name, String message) {
		super();
		this.name = name;
		this.message = message;
		this.created = new Date();
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
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	
	

}
