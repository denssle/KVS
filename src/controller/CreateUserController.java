package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Observable;

import javax.swing.JPanel;

import model.User;
import statics.CacheUser;
import view.CreateUserView;
import view.MainFrameView;
import view.ShowUserView;

public class CreateUserController extends Observable implements ActionListener {	
	private static User user;
	public CreateUserController() {
	}
	/*
	 * nimmt ActionEvents von der CreateUserView entgegen und informiert die View über notifyObservers über Änderungen. 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		statics.debug.debugMessage("CreateUserController",command);
		
		if(command.equals(statics.label.ok)) {
			setChanged(); 
			notifyObservers(statics.label.ok);
			/*
			 * Infomiert View darüber das ein neuer User erstellt werden soll. 
			 * Bei Erfolg nutzt die View die createUser Methode und setzt damit den User auf != null. 
			 */
			
			if(user != null) {
				// Hier wird auf die ShowUserView gewechselt, der neu erstellte User wird angezeigt. 
				ShowUserController.setUser(user);
				setChanged(); 
				notifyObservers(statics.label.showClient);
			}
		}
		
		if(command.equals(statics.label.cancel)) {
			//Schließt die Usererstellung. 
			ShowUserController.setUserNull();
			setChanged(); 
			notifyObservers(statics.label.cancel);
		}
	}
	/*
	 * Erstellt neuen User; gibt true bei Erfolg zurück. 
	 * Bei gescheiterter Validierung false. 
	 */
	public static boolean createUser(CacheUser cacheUser) {
		if(validation(cacheUser)) {
			user = new User(cacheUser);
			user.saveUser();
			statics.debug.debugMessage("CreateUserController", "New User: "+user.getForname()+" "+user.getBirthdate());
			return true;
		}
		return false;
	}
	/*
	 * Validiert die Eingaben und gibt true zurück wenn alles in Ordnung ist. 
	 */
	private static boolean validation(CacheUser cacheUser) {
		if(cacheUser.getBirthday() != null) {
			return true;
		}
		return false;
	}
}
