package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import view.SearchUserView;

public class SearchUserController implements ActionListener {
	private SearchUserView searchUserView;
	
	public SearchUserController() {
		searchUserView = new SearchUserView(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		statics.debug.debugMessage("SearchUserController", command);
		if(command.equals(statics.label.ok))
		{
			System.out.println("Suche wird gestartet. Oder so. ");
		}
	}

	public JPanel getPanel() {
		return searchUserView;
	}

}
