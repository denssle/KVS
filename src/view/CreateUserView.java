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
import statics.label;
import util.Local;
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
		label l = new label();
		createUserPanel.removeAll();
		createUserPanel.setName(l.createnewclient);
		createUserPanel.setLayout(new FlowLayout());
		
		JPanel line = new JPanel();
		JLabel label;
		JTextField textfield;
		
		line.setLayout(new GridLayout(l.alluserlabels.length+1,2)); //Spalten, Zeilen
		label = new JLabel(l.forname);
		textfield = new JTextField();
		cache.setFornameField(textfield);
		line.add(label);
		line.add(textfield);
		
		label = new JLabel(l.lastname);
		textfield = new JTextField();
		cache.setLastnameField(textfield);
		line.add(label);
		line.add(textfield);
		
		label = new JLabel(l.street);
		textfield = new JTextField();
		cache.setStreetField(textfield);
		line.add(label);
		line.add(textfield);
		
		label = new JLabel(l.zip);
		textfield = new JTextField();
		cache.setZipField(textfield);
		line.add(label);
		line.add(textfield);
		
		label = new JLabel(l.city);
		textfield = new JTextField();
		cache.setCityField(textfield);
		line.add(label);
		line.add(textfield);
		
		label = new JLabel(l.birthdate);
		JDateChooser chooser = new JDateChooser();
		chooser.setLocale(Locale.GERMANY);
		cache.setBirthdayChooser(chooser);
		line.add(label);
		line.add(chooser);
		
		JButton okButton = new JButton(l.ok);
		okButton.addActionListener(actionListener);
		
		JButton cancelButton = new JButton(l.cancel);
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
		label l = new label();
		if(arg.equals(l.ok)) {
			if(CreateUserController.createUser(cache) == false) {
				Message.getInstance().display(null, l.createvalidationfailed, l.createnewclient);
			} else {
				createUserPanel.setVisible(false);
			}
		}
	}
}
