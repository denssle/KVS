package view;

import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import statics.Message;
import statics.label;
import util.Local;
import controller.ShowUserController;
import controller.DeleteUserController;

public class DeleteUserView implements Observer{
	private static JPanel panel;
	
	public DeleteUserView (ActionListener controller) {
		panel = new JPanel();
	}
	
	public static JPanel getPanel() {
		label l = new label();
		if(ShowUserController.getUser() != null) {
			JOptionPane.setDefaultLocale(Local.getInstance().getLocale());
			JOptionPane.showConfirmDialog(null, l.deleteconfirmtitle, l.deleteconfirmtext, JOptionPane.YES_NO_CANCEL_OPTION);
			return panel;
		} else {
			Message.getInstance().display(panel.getParent(), l.deletenonefound, l.deleteclient);
			return panel;
		}
	}
	
	@Override
	public void update(Observable o, Object arg) {
		
	}

	public static void deleteUser() {
		label l = new label();
		if(ShowUserController.getUser() != null) {
			// 0 = delete, 1 = Nicht löschen, 2 = cancel
			JOptionPane.setDefaultLocale(Local.getInstance().getLocale());
			int res = JOptionPane.showConfirmDialog(null, l.deleteconfirmtitle, l.deleteconfirmtext, JOptionPane.YES_NO_CANCEL_OPTION);
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
			Message.getInstance().display(panel.getParent(), l.deletenonefound, l.deleteclient);
		}
	}
}
