package view;

import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import statics.Message;
import util.Local;
import controller.ShowUserController;
import controller.DeleteUserController;

public class DeleteUserView implements Observer{
	private static JPanel panel;
	
	public DeleteUserView (ActionListener controller) {
		panel = new JPanel();
	}
	
	public static JPanel getPanel() {
		Local local = Local.getInstance();
		if(ShowUserController.getUser() != null) {
			JOptionPane.showConfirmDialog(null, local.getLocalString("deleteconfirmtitle"), local.getLocalString("deleteconfirmtext"),JOptionPane.YES_NO_CANCEL_OPTION);
			return panel;
		} else {
			Message.getInstance().display(panel.getParent(), local.getLocalString("deletenonefound"), statics.label.deleteClient);
			return panel;
		}
	}
	
	@Override
	public void update(Observable o, Object arg) {
		
	}

	public static void deleteUser() {
		Local local = Local.getInstance();
		if(ShowUserController.getUser() != null) {
			// 0 = delete, 1 = Nicht löschen, 2 = cancel
			int res = JOptionPane.showConfirmDialog(null, local.getLocalString("deleteconfirmtitle"), local.getLocalString("deleteconfirmtext"),JOptionPane.YES_NO_CANCEL_OPTION);
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
			Message.getInstance().display(panel.getParent(), local.getLocalString("deletenonefound"), statics.label.deleteClient);
		}
	}
}
