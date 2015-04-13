package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {
	private static final String url= "jdbc:mysql://localhost:3306/KVS";;
	private static final String user = "root";
	private static final String password = "";

    private static void dbTest() {
    	try {
    		statics.debug.debugMessage("DB", "Loading driver.");
    	    Class.forName("com.mysql.jdbc.Driver");
    	    statics.debug.debugMessage("DB", "Driver loaded!");
    	} catch (ClassNotFoundException e) {
    	    statics.debug.errorMessage("DB", e.getMessage());
    	}
    }
    
    public static void start() {
    	dbTest();
    	Connection con = null;
    	Statement st = null;
    	
    	try {
    		statics.debug.debugMessage("DB", "Connecting database.");
    	    con = DriverManager.getConnection(url, user, password);
    	    statics.debug.debugMessage("DB", "Database connected!");
    	    st = con.createStatement();
    	    String sql = "CREATE TABLE User" +
    	                   "(id int(36) NOT NULL, " +
    	                   " forname VARCHAR(200), " + 
    	                   " lastname VARCHAR(200), " + 
    	                   " PRIMARY KEY ( id ))"; 

    	      st.executeUpdate(sql);
    	} catch (SQLException e) {
    		statics.debug.errorMessage("DB", e.getMessage());
    	} finally {
    		statics.debug.debugMessage("DB", "Closing the connection.");
    	    if (con != null) try { con.close(); } catch (SQLException e) {statics.debug.errorMessage("DB", e.getMessage());}
    	    if (st != null) try { st.close(); } catch (SQLException e) {statics.debug.errorMessage("DB", e.getMessage());}
    	}
    }
    public static boolean saveUser(User newUser) {
    	/*
    	start();
    	Connection con = null;
    	Statement st = null;
    	try {
    		statics.debug.debugMessage("DB", "Connecting database.");
    	    con = DriverManager.getConnection(url, user, password);
    	    statics.debug.debugMessage("DB", "Database connected!");
    	    
    	    String sql = "INSERT INTO User (id, forname, lastName) VALUES ?, ?, ?)";
    	    st = con.prepareStatement(sql);
    	    ((PreparedStatement) st).setInt(1, 1);
    	    ((PreparedStatement) st).setString(2, newUser.getForname());
    	    ((PreparedStatement) st).setString(3, newUser.getLastname());
    	    ((PreparedStatement) st).executeUpdate();
    	    return true;
    	} catch (SQLException e) {
    		statics.debug.errorMessage("DB", e.getMessage());
    		return false;
    	} finally {
    		statics.debug.debugMessage("DB", "Closing the connection.");
    	    if (con != null) try { con.close(); } catch (SQLException e) {statics.debug.errorMessage("DB", e.getMessage());}
    	    if (st != null) try { st.close(); } catch (SQLException e) {statics.debug.errorMessage("DB", e.getMessage());}
    	}
    */
    	return true;
    }
    public static void editUser(User editUser) {
    	start();
    	Connection con = null;
    	Statement st = null;
    	
    	try {
    		statics.debug.debugMessage("DB", "Connecting database.");
    	    con = DriverManager.getConnection(url, user, password);
    	    statics.debug.debugMessage("DB", "Database connected!");
    	    
    		String sql = "UPDATE User SET lastname = ? WHERE id = ?";
    		st = con.prepareStatement(sql);
    		((PreparedStatement) st).setString(1, editUser.getLastname());
    		//((PreparedStatement) st).setInt(2, editUser.getId());
    		((PreparedStatement) st).executeUpdate();
    	} catch (SQLException e) {
    		statics.debug.errorMessage("DB", e.getMessage());
    	} finally {
    		statics.debug.debugMessage("DB", "Closing the connection.");
    	    if (con != null) try { con.close(); } catch (SQLException e) {statics.debug.errorMessage("DB", e.getMessage());}
    	    if (st != null) try { st.close(); } catch (SQLException e) {statics.debug.errorMessage("DB", e.getMessage());}
    	}
    }
    
    public static void deleteUser(User deleteUser) {
    	start();
    }
    
    public static User getUserByName(String forname, String lastname) {
    	start();
    	return null;
    }
}
