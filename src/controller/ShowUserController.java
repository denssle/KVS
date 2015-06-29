package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.JButton;

import dao.UserDAO;
import model.User;
import statics.label;
import view.ShowUserView;

public class ShowUserController extends Observable implements ActionListener {	
	private static User actualUser;
	
	public ShowUserController() {
	}
	
	public void showUser(User user) {
		actualUser = user;
		ShowUserView.showUser(user);
		setChanged(); 
		notifyObservers(ShowUserView.getPanel());
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		JButton pressdButton = (JButton) e.getSource();
		statics.debug.debugMessage("ShowUserController", command);
		label l = new label();
		if(command.equals(l.showclient)) {
			User user = new User();
			user = UserDAO.getInstance().getUserById(pressdButton.getName());
			actualUser = user;
			ShowUserView.showUser(user);
			setChanged(); 
			notifyObservers(l.showclient);
		}
	}
	public static User getUser() {
		return actualUser;
	}
	public static void setUserNull() {
		actualUser = null;
	}
	public static void setUser(User user) {
		statics.debug.debugMessage("ShowUserController", "Aktueller User: "+user.getForname());
		actualUser = user;
	}
}
