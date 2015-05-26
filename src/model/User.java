package model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import dao.UserDAO;

public class User {
	private UUID id;
	private String forname;
	private String lastname;
	private Address address;
	private String birthdate;
	
	public User() {
		this.id = UUID.randomUUID();
	}
	public User(String[] inputs) {
		this.id = UUID.randomUUID();
		forname = inputs[0];
		lastname = inputs[1];
		address = new Address();
		address.setStreet(inputs[2]);
		address.setZip(inputs[3]);
		address.setCity(inputs[4]);

		statics.debug.debugMessage("User", "User erstellt.");
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
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String input) {
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
	
}
