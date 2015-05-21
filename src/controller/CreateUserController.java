package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Observable;

import javax.swing.JPanel;

import model.User;
import statics.CacheUser;
import view.CreateUserView;
import view.MainFrameView;
import view.ShowUserView;

public class CreateUserController extends Observable implements ActionListener {	
	private static User user;
	public CreateUserController() {
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		statics.debug.debugMessage("CreateUserController",command);
		
		if(command.equals(statics.label.ok)) {
			setChanged(); 
			notifyObservers(statics.label.ok);
			
			if(user != null) {
				ShowUserController.setUser(user);
				setChanged(); 
				notifyObservers(statics.label.showClient);
			}
		}
		
		if(command.equals(statics.label.cancel)) {
			setChanged(); 
			notifyObservers(statics.label.cancel);
		}
	}
	
	public static boolean createUser(CacheUser cacheUser) {
		if(validation(cacheUser)) {
			user = new User(cacheUser);
			user.saveUser();
			statics.debug.debugMessage("CreateUserController", "New User: "+user.getForname()+" "+user.getBirthdate());
			return true;
		}
		return false;
	}

	private static boolean validation(CacheUser cacheUser) {
		if(cacheUser.getBirthday() != null) {
			return true;
		}
		return false;
	}
}
