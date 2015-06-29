package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import model.User;
import statics.CacheUser;
import statics.label;
import util.Local;
import view.ShowUserView;

public class UpdateUserController extends Observable implements ActionListener {	
	private static User updateUser;
	public UpdateUserController() {
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		statics.debug.debugMessage("UpdateUserController",command);
		label l = new label();
		if(command.equals(l.ok)) {
			//Informiert die View, welche dann die updateUser Methode aufruft. 
			setChanged(); 
			notifyObservers(l.ok);
			
			if(updateUser != null) {
				//Der geänderte User wird angezeigt. 
				ShowUserView.showUser(updateUser);
				setChanged(); 
				notifyObservers(l.showclient);
			}
		}
		if(command.equals(l.cancel)) {
			//Bei Abbruch wird der User nicht verändert aber auch nicht geschlossen.
			setChanged(); 
			notifyObservers(l.showclient);
		}
	}
	/**
	 * nimmt die Änderungen, die in die Textfelder eingetragen wurden, von der View entgegen und ändert den User. 
	 */
	public static void updateUser(CacheUser cache) {
		updateUser = ShowUserController.getUser();
		updateUser.setForname(cache.getForname());
		updateUser.setLastName(cache.getLastname());
		updateUser.setStreet(cache.getStreet());
		updateUser.setZip(cache.getZip());
		updateUser.setCity(cache.getCity());
		updateUser.setBirthdate(cache.getBirthday());
		updateUser.updateUser();
		statics.debug.debugMessage("CreateUserController", updateUser.getForname());
	}
}
