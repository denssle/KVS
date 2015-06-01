package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.mysql.jdbc.CommunicationsException;

import model.User;
import util.DBUtil;

public class UserDAO {
	private static UserDAO userDAO;

	private UserDAO() {
	}
	
	public static UserDAO getInstance() {
		if(userDAO == null)
			userDAO = new UserDAO();
		return userDAO;
	}

	public void addUser(User user) {
		try {
			PreparedStatement preparedStatement = DBUtil.getConnection()
					.prepareStatement("insert into Users(UUID,FORENAME,LASTNAME,BIRTHDATE,STREET,ZIP,CITY) values (?, ?, ?, ?, ?, ?, ?)");
			preparedStatement.setString(1, user.getId().toString());
			preparedStatement.setString(2, user.getForname());
			preparedStatement.setString(3, user.getLastname());
			java.util.Date d = user.getBirthdate();
			long milliseconds = d.getTime();
			Date date = new Date(milliseconds);
			preparedStatement.setDate(4, date);
			preparedStatement.setString(5, user.getStreet());
			preparedStatement.setString(6, user.getZip());
			preparedStatement.setString(7, user.getCity());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteUser(String userId) {
		try {
			PreparedStatement preparedStatement = DBUtil.getConnection()
					.prepareStatement("delete from Users where UUID=?");
			preparedStatement.setString(1, userId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		try {
			Statement statement = DBUtil.getConnection().createStatement();
			ResultSet rs = statement.executeQuery("select * from Users");
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getString("UUID"));
				user.setForname(rs.getString("FORENAME"));
				user.setLastName(rs.getString("LASTNAME"));
				user.setBirthdate(rs.getDate("BIRTHDATE"));
				user.setStreet(rs.getString("STREET"));
				user.setZip(rs.getString("ZIP"));
				user.setCity(rs.getString("CITY"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	
	public List<User> getUserByTags(String[] tags) {
		List<User> users = new ArrayList<User>();
		for (String tag : tags) {
			users.addAll(getUserByTag(tag));
		}
		return removeDuplicates(users);
	}
	
    static <E> List<E> removeDuplicates(List<E> list) {
		ArrayList<E> result = new ArrayList<E>();
		HashSet<E> set = new HashSet<E>();
		for (E item : list) {
		    if (!set.contains(item)) {
			result.add(item);
			set.add(item);
		    }
		}
		return result;
    }
	
	public List<User> getUserByTag(String tag) {
		List<User> users = new ArrayList<User>();
		try {
			PreparedStatement preparedStatement = DBUtil.getConnection()
					.prepareStatement("select * from Users where FORENAME like ? or LASTNAME like ? or CITY like ?");
			preparedStatement.setString(1, tag);
			preparedStatement.setString(2, tag);
			preparedStatement.setString(3, tag);
			preparedStatement.execute();
			ResultSet rs = preparedStatement.getResultSet();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getString("UUID"));
				user.setForname(rs.getString("FORENAME"));
				user.setLastName(rs.getString("LASTNAME"));
				user.setBirthdate(rs.getDate("BIRTHDATE"));
				user.setStreet(rs.getString("STREET"));
				user.setZip(rs.getString("ZIP"));
				user.setCity(rs.getString("CITY"));
				statics.debug.debugMessage("DB", "getUserByTag("+tag+") : "+user);
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	public User getUserById(String userId) {

		User user = new User();
		try {
			PreparedStatement preparedStatement = DBUtil.getConnection().
					prepareStatement("select * from Users where UUID=?");
			preparedStatement.setString(1, userId);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				user.setId(rs.getString("UUID"));
				user.setForname(rs.getString("FORENAME"));
				user.setLastName(rs.getString("LASTNAME"));
				user.setBirthdate(rs.getDate("BIRTHDATE"));
				user.setStreet(rs.getString("STREET"));
				user.setZip(rs.getString("ZIP"));
				user.setCity(rs.getString("CITY"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public void updateUser(User user) {
		try {
			PreparedStatement preparedStatement = DBUtil.getConnection()
					.prepareStatement("update Users set FORENAME=?, LASTNAME=?, BIRTHDATE=?, STREET=?, ZIP=?, CITY=?"
							+" where UUID=?");
			preparedStatement.setString(1, user.getForname());
			preparedStatement.setString(2, user.getLastname());
			java.util.Date d = user.getBirthdate();
			long milliseconds = d.getTime();
			Date date = new Date(milliseconds);
			preparedStatement.setDate(3, date);
			preparedStatement.setString(4, user.getStreet());
			preparedStatement.setString(5, user.getZip());
			preparedStatement.setString(6, user.getCity());
			preparedStatement.setString(7, user.getId().toString());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}