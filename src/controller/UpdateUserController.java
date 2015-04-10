package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import view.UpdateUserView;

public class UpdateUserController implements ActionListener {
	private static UpdateUserView updateUserView;
	
	public UpdateUserController() {
		updateUserView = new UpdateUserView(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		statics.debug.debugMessage("UpdateUserController",command);
	}

	public static JPanel getPanel() {
		return updateUserView;
	}

}
