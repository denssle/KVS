	package view;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Locale;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import statics.CacheUser;
import agiletrack.swing.JDateChooser;
import controller.CreateUserController;
import controller.ShowUserController;

public class CreateUserView implements Observer{
	private static JPanel createUserPanel;
	private static CacheUser cache;
	public CreateUserView(ActionListener createUserController) {
		cache = new CacheUser();
		createUserPanel = new JPanel();
		createUserPanel.setName(statics.label.newClient);
		createUserPanel.setLayout(new FlowLayout());
		buildView(createUserController);
		createUserPanel.setVisible(true);
	}
	
	private void buildView(ActionListener actionListener) {
		JPanel line = new JPanel();
		JLabel label;
		JTextField textfield;
		line.setLayout(new GridLayout(statics.label.userLabels.length+1,2)); //Spalten, Zeilen
		
		label = new JLabel(statics.label.userLabels[0]);
		textfield = new JTextField();
		cache.setFornameField(textfield);
		line.add(label);
		line.add(textfield);
		
		label = new JLabel(statics.label.userLabels[1]);
		textfield = new JTextField();
		cache.setLastnameField(textfield);
		line.add(label);
		line.add(textfield);
		
		label = new JLabel(statics.label.userLabels[2]);
		textfield = new JTextField();
		cache.setStreetField(textfield);
		line.add(label);
		line.add(textfield);
		
		label = new JLabel(statics.label.userLabels[3]);
		textfield = new JTextField();
		cache.setZipField(textfield);
		line.add(label);
		line.add(textfield);
		
		label = new JLabel(statics.label.userLabels[4]);
		textfield = new JTextField();
		cache.setCityField(textfield);
		line.add(label);
		line.add(textfield);
		
		label = new JLabel(statics.label.userLabels[5]);
		JDateChooser chooser = new JDateChooser();
		chooser.setLocale(Locale.GERMANY);
		cache.setBirthdayChooser(chooser);
		line.add(label);
		line.add(chooser);
		
		JButton okButton = new JButton(statics.label.ok);
		okButton.addActionListener(actionListener);
		
		JButton cancelButton = new JButton(statics.label.cancel);
		cancelButton.addActionListener(actionListener);
		
		line.add(okButton);
		line.add(cancelButton);
		createUserPanel.add(line);
	}
	
	public static JPanel getPanel() {
		createUserPanel.setVisible(true);
		ShowUserController.setUserNull();
		return createUserPanel;
	}

	@Override
	public void update(Observable o, Object arg) {
		if(arg.equals(statics.label.ok)) {
			if(CreateUserController.createUser(cache) == false) {
				JOptionPane.showMessageDialog(null, "My Goodness, this is so concise");
			} else {
				createUserPanel.setVisible(false);
			}
		}
	}
}
