package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import javax.swing.JPanel;
import view.CreateUserView;
import view.SearchUserView;
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
	