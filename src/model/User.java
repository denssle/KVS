package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import dao.UserDAO;
import statics.CacheUser;

public class User {
	private UUID id;
	private String forname;
	private String lastname;
	private Address address;
	private Date birthdate;
	private static UserDAO userDAO;
	
	public User() {
		this.id = UUID.randomUUID();
	}
	
	public User(CacheUser cache) {
		this.id = UUID.randomUUID();
		this.forname = cache.getForname();
		this.lastname = cache.getLastname();
		this.address.setCity(cache.getCity());
		this.address.setStreet(cache.getStreet());
		this.address.setZip(cache.getZip());
		this.birthdate = cache.getBirthday();
	}
	
	public User(UUID id, String forname, String lastname, Date birthdate, Address address) {
		this.id = id;
		this.forname = forname;
		this.lastname = lastname;
		this.birthdate = birthdate;
		this.address = address;
		statics.debug.debugMessage("User", "User erstellt. "+this.id.toString());
	}
	
	public User(UUID id, String forname, String lastname, Date birthdate, String street, String zip, String city) {
		this.id = id;
		this.forname = forname;
		this.lastname = lastname;
		this.birthdate = birthdate;
		this.address = new Address(street,zip,city);
		statics.debug.debugMessage("User", "User erstellt. "+this.id.toString());
	}
	
	
	public Map<UUID, User> searchUser(String name) {
		Map<UUID, User> map = new HashMap<UUID, User>();
		User user;
		for(User e :  UserDAO.getInstance().getAllUsers()) {
			user = e;
			if(user.getForname().equals(name) || user.getLastname().equals(name)) {
				map.put(user.getId(), user);
			}
		}
		return map;
	}
	
	public void setId(String id)
	{
		this.id = UUID.fromString(id);
	}
	
	public boolean saveUser() {
		UserDAO.getInstance().updateUser(this);
		return true;	
	}
	
	public User getUserByLastame(String name) {
		for(User e : UserDAO.getInstance().getAllUsers()) {
			statics.debug.debugMessage("User", "Aktueller User: "+e);
			if(name.equals(e.getLastname())) {
				return e;
			}
		}
		return null;
	}
	public User getUserByForname(String name) {
		for(User e : UserDAO.getInstance().getAllUsers()) {
			statics.debug.debugMessage("User", "Aktueller User: "+e);
			if(name.equals(e.getLastname())) {
				return e;
			}
		}
		return null;
	}
	
	public User getUserByID(String string) {
		return UserDAO.getInstance().getUserById(string);	
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
	public UUID getId() {
		return id;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	/*
	 * Returns date without the time. As String.
	 */
	public String getNiceBirthday() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(birthdate);

		int month = cal.get(Calendar.MONTH)+1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int year = cal.get(Calendar.YEAR);
		
		return day+"."+month+"."+year;
	}
	public void setBirthdate(Date input) {
		this.birthdate = input;
	}
	public String getStreet() {
		return address.getStreet();
	}

	public void setStreet(String street) {
		address.setStreet(street);
	}

	public String getZip() {
		return address.getZip();
	}

	public void setZip(String zip) {
		address.setZip(zip);
	}

	public String getCity() {
		return address.getCity();
	}

	public void setCity(String city) {
		address.setCity(city);
	}
	public void deleteUser() {
		UserDAO.getInstance().deleteUser(this.getId().toString());
	}

	public String toString() {
		return "User[id = "+id+",forname = "+forname+", lastname = "+lastname+", birthdate = "+birthdate+", street = "+address.getStreet()+", zip = "+address.getZip()+", city = "+address.getCity()+"]";
	}
}
