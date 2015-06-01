package test;

import java.util.Date;
import java.util.UUID;
import javax.swing.JTextField;

import agiletrack.swing.JDateChooser;
import statics.CacheUser;
import model.User;
import junit.framework.TestCase;

public class ModelTest extends TestCase {

	  public static void testA() {
		  User testUser = new User();
		  assertNull(testUser.getBirthdate());
		  assertTrue(null != testUser.getId());
	  }
	  public static void testB() {
		  String forname = "forname";
		  String lastname = "lastname";
		  String city = "city";
		  String street = "street";
		  String zip = "zip";
		  
		  CacheUser testCache = new CacheUser();
		  JTextField fornameField = new JTextField();
		  fornameField.setText(forname);
		  testCache.setFornameField(fornameField);
		  
		  JTextField lastnameField = new JTextField();
		  lastnameField.setText(lastname);
		  testCache.setLastnameField(lastnameField);
		  
		  JTextField cityField = new JTextField();
		  cityField.setText(city);
		  testCache.setCityField(cityField);
		  
		  JTextField streetField = new JTextField();
		  streetField.setText(street);
		  testCache.setStreetField(streetField);
		  
		  JTextField zipField = new JTextField();
		  zipField.setText(zip);
		  testCache.setZipField(zipField);
		  
		  JDateChooser bithday = new JDateChooser();
		  testCache.setBirthdayChooser(bithday);
		  
		  try {
			  User testUser = new User(testCache);
			  assertTrue(forname.equals(testUser.getForname()));
			  assertEquals(street, testUser.getStreet());
			  assertEquals(zip, testUser.getZip());
			  
		  } catch(Exception e) {
			  e.printStackTrace();
		  }
	  }
	  
	  public static void testC() {
		  UUID id;
		  id = UUID.randomUUID();
		  Date date = new Date();
		  
		  User testUser = new User(id, "forname",  "lastname", date, "street", "zip", "city");
		  
		  assertNotNull(testUser.getId());
		  assertEquals("forname", testUser.getForname());
	  }
	  public static void main(String[] args) {
	    testA();
	    testB();
	    testC();
	  }
	}
