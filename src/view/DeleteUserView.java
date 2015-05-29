package view;

import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import statics.Message;
import controller.ShowUserController;
import controller.DeleteUserController;

public class DeleteUserView implements Observer{
	private static JPanel panel;
	
	public DeleteUserView (ActionListener controller) {
		panel = new JPanel();
	}
	
	public static JPanel getPanel() {
		if(ShowUserController.getUser() != null) {
			JOptionPane.showConfirmDialog(null, "Sie sind dabei den gewählten Kunden zu löschen!",statics.label.deleteClient,JOptionPane.YES_NO_CANCEL_OPTION);
			return panel;
		} else {
			Message.getInstance().display(panel.getParent(),"Kein User zum löschen offen. Bitte öffnen Sie erst einen User um ihn zu löschen. ",statics.label.deleteClient);
			return panel;
		}
	}
	
	@Override
	public void update(Observable o, Object arg) {
		
	}

	public static void deleteUser() {
		if(ShowUserController.getUser() != null) {
			// 0 = delete, 1 = Nicht lÃ¶schen, 2 = cancel
			int res = JOptionPane.showConfirmDialog(null, "Sicher?", "User lÃ¶schen.",JOptionPane.YES_NO_CANCEL_OPTION);
			switch (res) {
            case 0:
            	statics.debug.debugMessage("DeleteUserView", "User soll gelÃ¶scht werden");
                break;
            case 1:
            	statics.debug.debugMessage("DeleteUserView", "User soll nicht gelÃ¶scht werden");
                break;
        }
			DeleteUserController.deleteUser(res);
		} else {
			JOptionPane.showMessageDialog(null, "Kein User zum lÃ¶schen offen; bitte Ã¶ffnen Sie erst einen User um ihn zu lÃ¶schen. ");
		}
	}
}
