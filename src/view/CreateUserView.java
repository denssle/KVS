package view;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import statics.CacheUser;
import statics.Message;
import agiletrack.swing.JDateChooser;
import controller.CreateUserController;
import controller.ShowUserController;

public class CreateUserView implements Observer{
	private static JPanel createUserPanel;
	private static CacheUser cache;
	private static ActionListener actionListener;
	
	public CreateUserView(ActionListener createUserController) {
		cache = new CacheUser();
		actionListener = createUserController;
		createUserPanel = new JPanel();
		buildView();
		createUserPanel.setVisible(true);
	}
	
	private static void buildView() {
		createUserPanel.removeAll();
		createUserPanel.setName(statics.label.newClient);
		createUserPanel.setLayout(new FlowLayout());
		
		JPanel line = new JPanel();
		JLabel label;
		JTextField textfield;
		line.setLayout(new GridLayout(statics.label.userLabels.length+1,2)); //Spalten, Zeilen
		
		label = new JLabel(statics.label.forname);
		textfield = new JTextField();
		cache.setFornameField(textfield);
		line.add(label);
		line.add(textfield);
		
		label = new JLabel(statics.label.lastname);
		textfield = new JTextField();
		cache.setLastnameField(textfield);
		line.add(label);
		line.add(textfield);
		
		label = new JLabel(statics.label.street);
		textfield = new JTextField();
		cache.setStreetField(textfield);
		line.add(label);
		line.add(textfield);
		
		label = new JLabel(statics.label.zip);
		textfield = new JTextField();
		cache.setZipField(textfield);
		line.add(label);
		line.add(textfield);
		
		label = new JLabel(statics.label.city);
		textfield = new JTextField();
		cache.setCityField(textfield);
		line.add(label);
		line.add(textfield);
		
		label = new JLabel(statics.label.birthdate);
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
	/**
	 * Gibt das Panel für die MainFrameView zurück und setzt aktuellen User auf null. 
	 */
	public static JPanel getPanel() {
		buildView();
		createUserPanel.setVisible(true);
		ShowUserController.setUserNull();
		return createUserPanel;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if(arg.equals(statics.label.ok)) {
			if(CreateUserController.createUser(cache) == false) {
				Message.getInstance().display(null, statics.label.createValidation, statics.label.newClient);
			} else {
				createUserPanel.setVisible(false);
			}
		}
	}
}
