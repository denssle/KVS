package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import view.CreateUserView;

public class CreateUserController implements ActionListener {
	private CreateUserView createUserView;
	
	public CreateUserController() {
		createUserView = new CreateUserView(this);
	}
	
	public JPanel getPanel() {
		return createUserView;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		System.out.println(command);
	}
}
