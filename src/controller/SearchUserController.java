package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.UUID;

import javax.swing.JPanel;

import model.User;
import view.SearchUserView;
import view.ShowUserView;

public class SearchUserController extends Observable implements ActionListener {
	private static Map<UUID, User> userMap;
	private static User user;
	
	public SearchUserController() {
	}
	
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		statics.debug.debugMessage("SearchUserController", command);
		if(command.equals(statics.label.ok))
		{
			setChanged(); 
			notifyObservers(statics.label.ok); 
			
			if(user != null) {
				ShowUserView.showUser(userMap);
				setChanged(); 
				notifyObservers(ShowUserView.getPanel());
			}
		}
	}
	
	public static void searchUser(String name) {
		user = new User();
		userMap = new HashMap<UUID, User>();
		
		String[] splited = name.split("\\s+");
		for(int i = 0; i < splited.length; i++) {
			userMap.putAll(user.searchUser(splited[i]));
		}
	}
}
