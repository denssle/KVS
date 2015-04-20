package model;

import java.sql.Date;
import java.util.UUID;

public class User {
	private UUID id;
	private String forname;
	private String lastname;
	private String street;
	private String zip;
	private String city;
	private Date birthdate;
	private Date lastVisit;
	private Date fistVisit;
	
	public User(String[] inputs) {
		this.id = UUID.randomUUID();
		forname = inputs[0];
		lastname = inputs[1];
		street = inputs[2];
		zip = inputs[3];
		city = inputs[4];
	}
	public boolean saveUser() {
		if(DataBase.saveUser(this)){
			return true;
		}
		return false;
	}
	
	public User getUserByName() {
		return null;
	}
	
	public User getUserByID() {
		return null;
	}
	
	public String getForname() {
		return forname;
	}

	public void setForname(String forname) {
		this.forname = forname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastName(String lastName) {
		this.lastname = lastName;
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

	public UUID getId() {
		return id;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public Date getLastVisit() {
		return lastVisit;
	}
	public void setLastVisit(Date lastVisit) {
		this.lastVisit = lastVisit;
	}
	public Date getFistVisit() {
		return fistVisit;
	}
	public void setFistVisit(Date fistVisit) {
		this.fistVisit = fistVisit;
	}
}
