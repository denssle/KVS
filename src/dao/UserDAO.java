package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import model.User;
import util.DBUtil;

public class UserDAO {
	private Connection connection;

	public UserDAO() {
		connection = DBUtil.getConnection();
	}

	public void addUser(User user) {
		try {
			//TODO: SQL Statement anpassen
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into users() values (?, ?, ?, ? )");
			preparedStatement.setString(1, user.getForname());
			preparedStatement.setString(2, user.getLastname());
			//TODO: Date to TimeStamp und restliche felder ergänzen
			//Date date = new Date(user.getBirthdate());
			//preparedStatement.setDate(3, date);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteUser(int userId) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from users where userid=?");
			preparedStatement.setInt(1, userId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from users");
			while (rs.next()) {
				//TODO: Andere Felder ergänzen
				User user = new User();
				user.setForname(rs.getString("firstname"));
				user.setLastName(rs.getString("lastname"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	public User getUserById(int userId) {

		User user = new User();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("select * from users where userid=?");
			preparedStatement.setInt(1, userId);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				//TODO: Andere Felder ergänzen
				user.setForname(rs.getString("firstname"));
				user.setLastName(rs.getString("lastname"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public void updateUser(User user) {
		try {
			//TODO: SQL Statement anpassen
			PreparedStatement preparedStatement = connection
					.prepareStatement("update users set firstname=?, lastname=?, dob=?, email=?"
							+"where userid=?");
			preparedStatement.setString(1, user.getForname());
			preparedStatement.setString(2, user.getLastname());
			//TODO: Date to TimeStamp und restliche felder ergänzen
			//Date date = new Date(user.getBirthdate());
			//preparedStatement.setDate(3, date);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}