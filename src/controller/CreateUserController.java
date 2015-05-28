package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import javax.swing.JPanel;
import model.User;
import view.ShowUserView;
import dao.UserDAO;

public class CreateUserController extends Observable implements ActionListener {
	private static User newUser;
	
	public CreateUserController() {
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
	
	public static void createUser(String[] input) {
		newUser = new User(input);
		UserDAO.getInstance().addUser(newUser);
		statics.debug.debugMessage("CreateUserController", newUser.getForname());
	}
}
