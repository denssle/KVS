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

import statics.label;
import util.Local;
import controller.ShowUserController;

public class SearchUserView implements Observer{
	private static JPanel searchUserPanel;
	private static JTextField textfield;
	
	public SearchUserView(ActionListener actionListener) {
		label l = new label();
		searchUserPanel = new JPanel();
		searchUserPanel.setName(l.searchclient);
		searchUserPanel.setLayout(new FlowLayout());
		
		JLabel label = new JLabel(l.searchclient);
		textfield = new JTextField(l.searchplaceholder);
		textfield.setToolTipText(l.searchdescription);
		textfield.setPreferredSize( new Dimension( 200, 20 ) );
		
		JButton button = new JButton(l.ok);
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
	
	public static String getInput() {
		return textfield.getText();
	}

	@Override
	public void update(Observable o, Object arg) {
		
	}
}
