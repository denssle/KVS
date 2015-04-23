package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import view.ShowUserView;
import model.User;

public class ShowUserController implements ActionListener {
	private static ShowUserView showUserView;
	
	public ShowUserController() {
		showUserView = new ShowUserView(this);
	}
	
	public static void showUser(User user) {
		showUserView.showUser(user);
	}
	
	public JPanel getPanel() {
		return showUserView;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
