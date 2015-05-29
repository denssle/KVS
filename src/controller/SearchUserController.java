package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import dao.UserDAO;
import model.User;
import view.ShowUserView;

public class SearchUserController extends Observable implements ActionListener {
	private static User user;
	
	public SearchUserController() {
	}
	/*
	 *Nimmt Ok von der View entgegen und informiert die View darüber. Diese ruft die searchUser Methode auf, welche die userMap füllt. 
	 *Die Map wird an die ShowUserView geschickt, die alle passenden User anzeigt. 
	 */
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		statics.debug.debugMessage("SearchUserController", command);
		if(command.equals(statics.label.ok)) {
			setChanged(); 
			notifyObservers(statics.label.ok); 
				ShowUserView.showUser(UserDAO.getInstance().getUserByTag(command));
				setChanged(); 
				notifyObservers(statics.label.showClient);
		}
	}
}
