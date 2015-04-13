package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import model.DataBase;
import model.User;
import view.MainFrameView;
import view.ProgressBarView;

public class MainFrameController implements ActionListener {
	private static MainFrameView mainFrame;
	private ProgressBarView progressBarView;
	public DataBase dataBase;
	
	public MainFrameController() {
		mainFrame = new MainFrameView(this);
		progressBarView = new ProgressBarView();
	}
	
	public void start() {
		mainFrame.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		statics.debug.debugMessage("MainFrameController",command);
		
		if(command != null) {
			startProgressBar();
		}
		//Beenden
		if(command.equals(statics.label.quit)) {
			mainFrame.quit();
		}
		//Neuer Klient
		if(command.equals(statics.label.newClient)) {
			mainFrame.updatePanel(CreateUserController.getPanel());
		}
		//Client suchen
		if(command.equals(statics.label.searchClient)) {
			mainFrame.updatePanel(SearchUserController.getPanel());
		}
		//Client löschen
		if(command.equals(statics.label.deleteClient)) {
		}
		//Client bearbeiten. 
		if(command.equals(statics.label.updateClient)) {
			mainFrame.updatePanel(UpdateUserController.getPanel());
		}
	}
	public static void changeJPanel(JPanel newJPanel) {
		mainFrame.updatePanel(newJPanel);
	}
	private void startProgressBar() {
		mainFrame.updatePanel(progressBarView);
		progressBarView.start();
		while(progressBarView.isRunning()) {
			if(progressBarView.updateBar()) {
				mainFrame.updatePanel(progressBarView);
			}
		}
		progressBarView.stop();
	}
}