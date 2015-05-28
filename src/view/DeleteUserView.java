package view;

import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import controller.ShowUserController;


public class DeleteUserView implements Observer{
	private static JPanel panel;
	
	public DeleteUserView (ActionListener controller) {
		panel = new JPanel();
	}
	
	public static JPanel getPanel() {
		if(ShowUserController.getUser() != null) {
			JOptionPane.showConfirmDialog(null, "Sicher?", "User löschen.",JOptionPane.YES_NO_CANCEL_OPTION);
			return panel;
		} else {
			JOptionPane.showMessageDialog(null, "Kein User zum löschen offen; bitte öffnen Sie erst einen User um ihn zu löschen. ");
			return panel;
		}
		
	}
	
	@Override
	public void update(Observable o, Object arg) {
		
	}
}
