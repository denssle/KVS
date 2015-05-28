package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import model.User;

public class DeleteUserController extends Observable implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
	public static void deleteUser(int res) {
		if(res == 0) {
			User updateUser = ShowUserController.getUser();
			if(updateUser != null) {
				updateUser.deleteUser();
				ShowUserController.setUserNull();
			}
		}
	}
}
