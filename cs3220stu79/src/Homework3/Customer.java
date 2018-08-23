package Homework3;

import java.util.Date;

public class Customer {
	int id;
	static int count = 1;
	String name;
	String purchase_item;
	String email_id;
	String phone_number;
	Date date;

	public Customer() {
		date = new Date();
	}
	
	
	public Customer(String name, String purchase_item, String email_id, String phone_number) {
		super();
		this.id = count++;
		this.name = name;
		this.purchase_item = purchase_item;
		this.email_id = email_id;
		this.phone_number = phone_number;
		this.date = new Date();
	}

//
//	public Customer(String name, String purchase_item) {
//		this.id = count++;
//		this.name = name;
//		this.purchase_item = purchase_item;
//		this.date = new Date();
//	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPurchase_item() {
		return purchase_item;
	}

	public void setPurchase_item(String purchase_item) {
		this.purchase_item = purchase_item;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
}
