package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import controller.ShowUserController;

public class SearchUserView implements Observer{
	private static JPanel searchUserPanel;
	private JTextField textfield;
	
	public SearchUserView(ActionListener actionListener) {
		searchUserPanel = new JPanel();
		searchUserPanel.setName(statics.label.searchClient);
		searchUserPanel.setLayout(new FlowLayout());
		
		JLabel label = new JLabel("Suche");
		textfield = new JTextField("nach Max Mustermann. ");
		textfield.setToolTipText("Hier Name eingeben. ");
		textfield.setPreferredSize( new Dimension( 200, 20 ) );
		
		JButton button = new JButton(statics.label.ok);
		button.addActionListener(actionListener);
		
		searchUserPanel.add(label);
		searchUserPanel.add(textfield);
		searchUserPanel.add(button);
		searchUserPanel.setVisible(true);
	}

	public static JPanel getPanel() {
		ShowUserController.setUserNull();
		return searchUserPanel;
	}

	@Override
	public void update(Observable o, Object arg) {
		
	}
}
