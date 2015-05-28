package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import model.User;
import statics.CacheUser;
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
			
			if(updateUser != null) {
				ShowUserView.showUser(updateUser);
				setChanged(); 
				notifyObservers(statics.label.showClient);
			}
		}
		if(command.equals(statics.label.cancel)) {
			setChanged(); 
			notifyObservers(statics.label.showClient);
		}
	}

	public static void updateUser(CacheUser cache) {
		updateUser = ShowUserController.getUser();
		updateUser.setForname(cache.getForname());
		updateUser.setLastName(cache.getLastname());
		updateUser.setStreet(cache.getStreet());
		updateUser.setZip(cache.getZip());
		updateUser.setCity(cache.getCity());
		updateUser.setBirthdate(cache.getBirthday());
		updateUser.saveUser();
		statics.debug.debugMessage("CreateUserController", updateUser.getForname());
		
	}
}
