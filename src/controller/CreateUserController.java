package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import model.User;
import view.CreateUserView;
import view.MainFrameView;
import view.ShowUserView;

public class CreateUserController extends Observable implements ActionListener {
	private static User newUser;
	
	public CreateUserController(Observer mainFrameView) {
		this.addObserver((Observer) mainFrameView); 
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		statics.debug.debugMessage("CreateUserController",command);
		
		if(command.equals(statics.label.ok)) {
			setChanged(); 
			notifyObservers(statics.label.ok);
			
			ShowUserView.showUser(newUser);
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
	
	public static void crateUser(String[] input) {
		newUser = new User(input);
		newUser.saveUser();
		statics.debug.debugMessage("CreateUserController", newUser.getForname());
	}
}
