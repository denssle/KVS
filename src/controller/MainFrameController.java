package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import statics.label;
import util.Local;

public class MainFrameController extends Observable implements ActionListener {
	
	public MainFrameController() {
	}
	/**
	 * Nimmt gedrückte Buttons in der Navigation entgegen und informiert die MainFrameView darüber; via notifyObservers.
	 */
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		label l = new label();
		Local local = Local.getInstance();
		statics.debug.debugMessage("MainFrameController",command);		
		if(command.equals(l.german)) {
			local.init("de", "DE");
			command = l.language;
		} else if(command.equals(l.english)) {
			local.init("en", "US");
			command = l.language;
		} else if(command.equals(l.turkish)) {
			local.init("tr", "TR");
			command = l.language;
		}
		setChanged(); 
		notifyObservers(command); 
	}
}
	