package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

import statics.CacheUser;

@SuppressWarnings("serial")
public class User implements Serializable {
	private UUID id;
	private String forname;
	private String lastname;
	private Address address;
	private Date birthdate;
	private static UserDAO userDAO;
	
	public User() {
		this.id = UUID.randomUUID();
		userDAO = new UserDAO();
	}
	public User(CacheUser cache) {
		this.id = UUID.randomUUID();
		userDAO = new UserDAO();
		address = new Address();
		
		this.setForname(cache.getForname());
		this.setLastName(cache.getLastname());
		this.setStreet(cache.getStreet());
		this.setZip(cache.getZip());
		this.setCity(cache.getCity());
		this.setBirthdate(cache.getBirthday());
	}
	
	public Map<UUID, User> searchUser(String name) {
		Map<UUID, User> map = new HashMap<UUID, User>();
		User user;
		for(Entry<UUID, User> e : userDAO.getAllUsers().entrySet()) {
			user = e.getValue();
			if(user.getForname().equals(name) || user.getLastname().equals(name)) {
				map.put(user.getId(), user);
			}
		}
		return map;
	}
	
	public boolean saveUser() {
		if(userDAO.saveUser(this)){
			return true;
		}
		return false;
	}
	
	public User getUserByLastame(String name) {
		for(Entry<UUID, User> e : userDAO.getAllUsers().entrySet()) {
			statics.debug.debugMessage("User", "Aktueller User: "+e.getKey()+" "+e.getValue().getLastname());
			if(name.equals(e.getValue().getLastname())) {
				return e.getValue();
			}
		}
		return null;
	}
	public User getUserByForname(String name) {
		for(Entry<UUID, User> e : userDAO.getAllUsers().entrySet()) {
			statics.debug.debugMessage("User", "Aktueller User: "+e.getKey()+" "+e.getValue().getForname());
			if(name.equals(e.getValue().getLastname())) {
				return e.getValue();
			}
		}
		return null;
	}
	
	public User getUserByID(String string) {
		UUID uuid = null;
		uuid = UUID.fromString(string);
		
		for(Entry<UUID, User> e : userDAO.getAllUsers().entrySet()) {
			statics.debug.debugMessage("User", "Key: "+e.getKey()+" String: "+string);
			if(uuid.equals(e.getKey())) {
				return e.getValue();
			}
		}
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
		userDAO.deleteUser(this);
	}
	
}
