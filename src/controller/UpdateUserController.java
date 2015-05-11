package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import model.User;
import view.ShowUserView;
import view.UpdateUserView;

public class UpdateUserController extends Observable implements ActionListener {	
	private static User updateUser;
	public UpdateUserController() {
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		statics.debug.debugMessage("UpdateUserController",command);
		if(command.equals(statics.label.ok)) {
			setChanged(); 
			notifyObservers(statics.label.ok);
			
			ShowUserView.showUser(updateUser);
			setChanged(); 
			notifyObservers(ShowUserView.getPanel());
		}
		if(command.equals(statics.label.cancel)) {
			setChanged(); 
			JPanel panel = new JPanel();
			panel.setVisible(true);
			notifyObservers(panel);
		}
	}
	
	
	public static User getUser() {
		return ShowUserController.getUser();
	}

	public static void updateUser(String[] input) {
		updateUser = getUser();
		updateUser.setForname(input[0]);
		updateUser.setLastName(input[1]);
		updateUser.setStreet(input[2]);
		updateUser.setZip(input[3]);
		updateUser.setStreet(input[4]);
		updateUser.setBirthdate(input[5]);
		updateUser.saveUser();
		statics.debug.debugMessage("CreateUserController", updateUser.getForname());
		
	}
}
