package com.gi.springboot.model;

public class Address {

	private String address1Txt;
	private String state;
	private String postCode;
	
	public Address(){
		
	}

	public Address(String address1Txt, String state, String postCode) {
		super();
		this.address1Txt = address1Txt;
		this.state = state;
		this.postCode = postCode;
	}

	public String getAddress1Txt() {
		return address1Txt;
	}

	public void setAddress1Txt(String address1Txt) {
		this.address1Txt = address1Txt;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

}
