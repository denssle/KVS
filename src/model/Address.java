package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Address implements Serializable{
	private String street;
	private String zip;
	private String city;
	
	public Address() {
		
	}
	
	public Address(String street, String zip, String city) {
		this.street = street;
		this.zip = zip;
		this.city = city;
	}
	
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		if(street != null) {
			this.street = street;
		}else {
			this.street = " ";
		}
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		if(zip != null) {
			this.zip = zip;
		} else {
			this.zip = " ";
		}
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		if(city != null) {
			this.city = city;
		} else {
			this.city = " ";
		}
	}
}
