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
		if(command.equals(Local.getInstance().getLocalString("german"))) {
			local.init("de", "de");
			command = Local.getInstance().getLocalString("language");
		} else if(command.equals(Local.getInstance().getLocalString("english"))) {
			local.init("en", "en");
			command = Local.getInstance().getLocalString("language");
		} else if(command.equals(Local.getInstance().getLocalString("turkish"))) {
			local.init("tr", "tr");
			command = Local.getInstance().getLocalString("language");
		}
		setChanged(); 
		notifyObservers(command); 
	}
}
	