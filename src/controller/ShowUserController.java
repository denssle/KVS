package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JPanel;

import view.ShowUserView;
import model.User;

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
		if(command.equals(statics.label.showClient)) {
			User user = new User();
			user = user.getUserByID(pressdButton.getName());
			actualUser = user;
			ShowUserView.showUser(user);
			setChanged(); 
			notifyObservers(ShowUserView.getPanel());
		}
	}
	public static User getUser() {
		return actualUser;
	}
	public static void setUserNull() {
		actualUser = null;
	}
	public static void setUser(User user) {
		actualUser = user;
	}
}
