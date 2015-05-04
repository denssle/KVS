package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.DataBase;
import model.User;
import view.CreateUserView;
import view.MainFrameView;
import view.SearchUserView;
import view.ShowUserView;
import view.UpdateUserView;

public class MainFrameController extends Observable implements ActionListener {
	
	public MainFrameController() {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		statics.debug.debugMessage("MainFrameController",command);
		JPanel panel = null;
		
		//Beenden
		if(command.equals(statics.label.quit)) {
			setChanged(); 
			notifyObservers(statics.label.quit); 
		}
		//Neuer Klient
		if(command.equals(statics.label.newClient)) {
			panel = CreateUserView.getPanel();
		}
		//Client suchen
		if(command.equals(statics.label.searchClient)) {
			panel = SearchUserView.getPanel();
		}
		//Client löschen
		if(command.equals(statics.label.deleteClient)) {
			UpdateUserController.deleteUser();
			panel = new JPanel();
		}
		//Client bearbeiten. 
		if(command.equals(statics.label.updateClient)) {
			panel = UpdateUserView.getPanel();
		}
		setChanged(); 
		notifyObservers(panel); 
	}
}
	