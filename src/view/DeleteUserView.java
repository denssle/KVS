package view;

import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;
<<<<<<< HEAD
import javax.swing.JPanel;

import controller.DeleteUserController;
import controller.ShowUserController;
=======
>>>>>>> origin/reskes-branch

public class DeleteUserView implements Observer{
	private static JPanel panel;
	
	public DeleteUserView (ActionListener controller) {
		panel = new JPanel();
	}
	
	public static JPanel getPanel() {
		return panel;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		
	}

	public static void deleteUser() {
		if(ShowUserController.getUser() != null) {
			// 0 = delete, 1 = Nicht löschen, 2 = cancel
			int res = JOptionPane.showConfirmDialog(null, "Sicher?", "User löschen.",JOptionPane.YES_NO_CANCEL_OPTION);
			switch (res) {
            case 0:
            	statics.debug.debugMessage("DeleteUserView", "User soll gelöscht werden");
                break;
            case 1:
            	statics.debug.debugMessage("DeleteUserView", "User soll nicht gelöscht werden");
                break;
        }
			DeleteUserController.deleteUser(res);
		} else {
			JOptionPane.showMessageDialog(null, "Kein User zum löschen offen; bitte öffnen Sie erst einen User um ihn zu löschen. ");
		}
	}
}
