package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {
	private static final String url= "jdbc:mysql://localhost:3306/KVS";;
	private static final String user = "root";
	private static final String password = "";

    private static void dbTest() {
    	try {
    		statics.debug.debugMessage("DB", "Loading driver...");
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
    	      
    	      String sql = "CREATE TABLE USER " +
    	                   "(id INTEGER not NULL, " +
    	                   " forname VARCHAR(2550), " + 
    	                   " lastName VARCHAR(2550), " + 
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
    	dbTest();
    	start();
    	Connection con = null;
    	Statement st = null;
    	try {
    		statics.debug.debugMessage("DB", "Connecting database.");
    	    con = DriverManager.getConnection(url, user, password);
    	    statics.debug.debugMessage("DB", "Database connected!");
    	    st = con.createStatement();
    	    
    	    String sql = "INSERT INTO USER (id, forname, lastName) " + 
    	    		"VALUES (100, 'Zara', 'Ali')";;
                    
    	    st.executeUpdate(sql);
    	    return true;
    	} catch (SQLException e) {
    		statics.debug.errorMessage("DB", e.getMessage());
    		return false;
    	} finally {
    		statics.debug.debugMessage("DB", "Closing the connection.");
    	    if (con != null) try { con.close(); } catch (SQLException e) {statics.debug.errorMessage("DB", e.getMessage());}
    	    if (st != null) try { st.close(); } catch (SQLException e) {statics.debug.errorMessage("DB", e.getMessage());}
    	}
    }
    public static void editUser(User editUser) {
    	
    }
    
    public static void deleteUser(User deleteUser) {
    	
    }
    
    public static User getUserByName(String forname, String lastname) {
    	return null;
    }
}
