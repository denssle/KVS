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

import util.Local;
import controller.ShowUserController;

public class SearchUserView implements Observer{
	private static JPanel searchUserPanel;
	private static JTextField textfield;
	
	public SearchUserView(ActionListener actionListener) {
		Local local = Local.getInstance();
		searchUserPanel = new JPanel();
		searchUserPanel.setName(statics.label.searchClient);
		searchUserPanel.setLayout(new FlowLayout());
		
		JLabel label = new JLabel(statics.label.searchClient);
		textfield = new JTextField(local.getLocalString("searchplaceholder"));
		textfield.setToolTipText(local.getLocalString("searchdescription"));
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
	
	public static String getInput() {
		return textfield.getText();
	}

	@Override
	public void update(Observable o, Object arg) {
		
	}
}
