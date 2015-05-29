package model;

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
		if(forname != null) {
			this.forname = forname;
		} else {
			this.forname = "";
		}
		
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastName(String lastname) {
		if(lastname != null) {
			this.lastname = lastname;
		} else {
			this.lastname = "";
		}
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
		if(street != null) {
			address.setStreet(street);
		} else {
			address.setStreet("");
		}
	}

	public String getZip() {
		return address.getZip();
	}

	public void setZip(String zip) {
		if(zip != null) {
			address.setZip(zip);
		} else {
			address.setZip("");;
		}
	}

	public String getCity() {
		return address.getCity();
	}

	public void setCity(String city) {
		if(city != null) {
			address.setCity(city);
		} else {
			address.setCity("");;
		}
	}
	public void deleteUser() {
		UserDAO.getInstance().deleteUser(this.getId().toString());
	}

	public String toString() {
		return "User[id = "+id+",forname = "+forname+", lastname = "+lastname+", birthdate = "+birthdate+", street = "+address.getStreet()+", zip = "+address.getZip()+", city = "+address.getCity()+"]";
	}
}
