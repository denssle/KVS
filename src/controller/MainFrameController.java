package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.MainFrameView;

public class MainFrameController implements ActionListener {
	private MainFrameView mainFrame;
	private SearchUserController searchUserController;
	private CreateUserController createUserController;

	public MainFrameController() {
		mainFrame = new MainFrameView(this);
		createUserController = new CreateUserController();
		searchUserController = new SearchUserController();
	}
	
	public void start() {
		mainFrame.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		System.out.println(command);
		//Beenden
		if(command.equals(statics.label.quit)) {
			mainFrame.quit();
		}
		//Neuer Klient
		if(command.equals(statics.label.newClient)) {
			mainFrame.updatePanel(createUserController.getPanel());
		}
		
		//Client suchen
		if(command.equals(statics.label.searchClient)) {
			mainFrame.updatePanel(searchUserController.getPanel());
		}
	}
}