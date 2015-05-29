package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.UUID;
import model.User;
import view.ShowUserView;

public class SearchUserController extends Observable implements ActionListener {
	private static Map<UUID, User> userMap;
	private static User user;
	
	public SearchUserController() {
	}
	/**
	 *Nimmt Ok von der View entgegen und informiert die View darüber. Diese ruft die searchUser Methode auf, welche die userMap füllt. 
	 *Die Map wird an die ShowUserView geschickt, die alle passenden User anzeigt. 
	 */
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		statics.debug.debugMessage("SearchUserController", command);
		if(command.equals(statics.label.ok)) {
			setChanged(); 
			notifyObservers(statics.label.ok); 
			
			if(user != null) {
				ShowUserView.showUser(userMap);
				setChanged(); 
				notifyObservers(statics.label.showClient);
			}
		}
	}
	/**
	 * Sucht einen User nach Vor und Nachname, wenn eins von beiden passt kommt er in die Map. 
	 */
	public static void searchUser(String name) {
		user = new User();
		userMap = new HashMap<UUID, User>();
		
		String[] splited = name.split("\\s+");
		for(int i = 0; i < splited.length; i++) {
			userMap.putAll(user.searchUser(splited[i]));
		}
	}
}
