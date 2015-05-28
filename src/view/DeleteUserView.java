package view;

import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;

public class DeleteUserView implements Observer{
	public DeleteUserView (ActionListener controller) {
		JOptionPane.showMessageDialog(null, "My Goodness, this is so concise");
	}

	@Override
	public void update(Observable o, Object arg) {
		JOptionPane.showMessageDialog(null, "My Goodness, this is so concise");
	}
	
}
