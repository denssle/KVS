package statics;

import java.awt.Component;
import java.util.Date;
import java.util.HashMap;

import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class Message {

	private static Message message;
	private static HashMap<String, String> messageStack = new HashMap<String, String>(); 
	
	private Message() {
		
	}
	
	public static Message getInstance() {
		if(message == null) {
			message = new Message();
		}
		
		return message;
	}
	
	public void display(String text) {
		display(null, text);
	}
	
	public void display(Component parent, String text) {
		display(parent, text, null);
	}
	
	public void display(Component parent, String text, String title) {
		display(parent, text, title, JOptionPane.DEFAULT_OPTION);
		messageStack.put(new Date().toString()+" | "+title, text);
	}
	
	public void display(Component parent, String text, String title, int type) {
		JOptionPane.showMessageDialog(parent, text, title, type);
		messageStack.put(new Date().toString()+" | "+title, text);
	}
	
	public HashMap<String, String> getLastMessages() {
		return messageStack;
	
	}

}
