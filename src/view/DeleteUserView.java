package view;

import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.User;
import controller.DeleteUserController;

public class DeleteUserView implements Observer{
	private static JPanel panel;
	public DeleteUserView (ActionListener controller) {
		panel = new JPanel();
	}
	
	public static JPanel getPanel() {
		JOptionPane.showMessageDialog(null, "My Goodness, this is so concise");
		return panel;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		
	}
}
