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
		createUserPanel.removeAll();
		createUserPanel.setName(statics.label.newClient);
		createUserPanel.setLayout(new FlowLayout());
		
		JPanel line = new JPanel();
		JLabel label;
		JTextField textfield;
		Local local = Local.getInstance();
		
		line.setLayout(new GridLayout(local.getUserLabels().length+1,2)); //Spalten, Zeilen
		label = new JLabel(local.getLocalString("forname"));
		textfield = new JTextField();
		cache.setFornameField(textfield);
		line.add(label);
		line.add(textfield);
		
		label = new JLabel(local.getLocalString("lastname"));
		textfield = new JTextField();
		cache.setLastnameField(textfield);
		line.add(label);
		line.add(textfield);
		
		label = new JLabel(local.getLocalString("street"));
		textfield = new JTextField();
		cache.setStreetField(textfield);
		line.add(label);
		line.add(textfield);
		
		label = new JLabel(local.getLocalString("zip"));
		textfield = new JTextField();
		cache.setZipField(textfield);
		line.add(label);
		line.add(textfield);
		
		label = new JLabel(local.getLocalString("city"));
		textfield = new JTextField();
		cache.setCityField(textfield);
		line.add(label);
		line.add(textfield);
		
		label = new JLabel(local.getLocalString("birthdate"));
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
				Message.getInstance().display(null, Local.getInstance().getLocalString("createvalidation"), statics.label.newClient);
			} else {
				createUserPanel.setVisible(false);
			}
		}
	}
}
