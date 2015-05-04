package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Address implements Serializable{
	private String street;
	private String zip;
	private String city;
	
	public Address() {
		
	}
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}
