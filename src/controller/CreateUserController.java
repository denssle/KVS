package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import model.User;
import view.CreateUserView;

public class CreateUserController implements ActionListener {
	private static CreateUserView createUserView;
	
	public CreateUserController() {
		createUserView = new CreateUserView(this);
	}
	
	public static JPanel getPanel() {
		return createUserView;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		System.out.println(command);
		
		if(command.equals(statics.label.ok)) {
			String[] inputs = createUserView.getInput();
			User user = new User(inputs);
			if(user.saveUser()) {
				System.out.println(user.getForname()+" wurde gespeichert.");
			}
		}
	}
}
