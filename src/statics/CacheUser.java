package statics;

import java.util.Date;

import javax.swing.JTextField;

import agiletrack.swing.JDateChooser;

public class CacheUser {
	private JTextField forNameField;
	private JTextField lastNameField;
	private JTextField streetField;
	private JTextField zipField;
	private JTextField cityField;
	private JDateChooser birthdayChooser;
	
	public CacheUser() {
	}
	
	public void nullIt() {
		forNameField = null;
		lastNameField = null;
		streetField = null;
		zipField = null;
		cityField = null;
		birthdayChooser = null;
	}
	
	public void setFornameField(JTextField forNameField) {
		this.forNameField = forNameField;
	}

	public void setLastnameField(JTextField lastNameField) {
		this.lastNameField = lastNameField;
	}

	public void setStreetField(JTextField streetField) {
		this.streetField = streetField;
	}

	public void setZipField(JTextField zipField) {
		this.zipField = zipField;
	}

	public void setCityField(JTextField cityField) {
		this.cityField = cityField;
	}
	
	public void setBirthdayChooser(JDateChooser chooser) {
		this.birthdayChooser = chooser;
	}
	
	public String getForname() {
		return forNameField.getText();
	}
	
	public String getLastname() {
		return lastNameField.getText();
	}
	
	public String getStreet() {
		return streetField.getText();
	}
	
	public String getZip() {
		return zipField.getText();
	}
	
	public String getCity() {
		return cityField.getText();
	}
	
	public Date getBirthday() {
		return birthdayChooser.getDate();
	}
}
