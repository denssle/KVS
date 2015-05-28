package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.DataBase;
import model.User;
import view.CreateUserView;
import view.MainFrameView;
import view.SearchUserView;
import view.ShowUserView;
import view.UpdateUserView;

public class MainFrameController extends Observable implements ActionListener {
	
	public MainFrameController() {
	}
	/*
	 * Nimmt gedrückte Buttons in der Navigation entgegen und informiert die MainFrameView darüber; via notifyObservers.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		statics.debug.debugMessage("MainFrameController",command);		
		setChanged(); 
		notifyObservers(command); 
	}
}
	