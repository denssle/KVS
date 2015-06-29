package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import util.Local;

public class MainFrameController extends Observable implements ActionListener {
	
	public MainFrameController() {
	}
	/**
	 * Nimmt gedrückte Buttons in der Navigation entgegen und informiert die MainFrameView darüber; via notifyObservers.
	 */
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		statics.debug.debugMessage("MainFrameController",command);		
		Local local = Local.getInstance();
		if(command.equals(statics.label.german)) {
			local.init("de", "de");
		} else if(command.equals(statics.label.english)) {
			local.init("en", "en");
		}
		setChanged(); 
		notifyObservers(command); 
	}
}
	