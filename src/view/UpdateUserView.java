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
import agiletrack.swing.JDateChooser;
import model.User;
import controller.CreateUserController;
import controller.ShowUserController;
import model.User;
import controller.UpdateUserController;

public class UpdateUserView implements Observer{
	private static JPanel updateUserPanel;
	private static JButton okButton;
	private static JButton cancelButton;
	private static CacheUser cache;
	
	public UpdateUserView(ActionListener actionListener) {
		updateUserPanel = new JPanel();
		updateUserPanel.setName(statics.label.updateClient);
		updateUserPanel.setLayout(new FlowLayout());		
		
		okButton = new JButton(statics.label.ok);
		okButton.addActionListener(actionListener);
		
		cancelButton = new JButton(statics.label.cancel);
		cancelButton.addActionListener(actionListener);
		
		updateUserPanel.setVisible(true);
	}
	private static void buildView(User user) {
		updateUserPanel.removeAll();
		
		updateUserPanel.setLayout(new FlowLayout());	
		JPanel line = new JPanel();
		JLabel label;
		JTextField textfield;
		line.setLayout(new GridLayout(statics.label.userLabels.length+1,2)); //Spalten, Zeilen
		
		cache = new CacheUser();
		
		label = new JLabel(statics.label.forname);
		textfield = new JTextField(user.getForname());
		cache.setFornameField(textfield);
		line.add(label);
		line.add(textfield);
		
		label = new JLabel(statics.label.lastname);
		textfield = new JTextField(user.getLastname());
		cache.setLastnameField(textfield);
		line.add(label);
		line.add(textfield);
		
		label = new JLabel(statics.label.street);
		textfield = new JTextField(user.getStreet());
		cache.setStreetField(textfield);
		line.add(label);
		line.add(textfield);
		
		label = new JLabel(statics.label.zip);
		textfield = new JTextField(user.getZip());
		cache.setZipField(textfield);
		line.add(label);
		line.add(textfield);
		
		label = new JLabel(statics.label.city);
		textfield = new JTextField(user.getCity());
		cache.setCityField(textfield);
		line.add(label);
		line.add(textfield);
		
		label = new JLabel(statics.label.birthdate);
		JDateChooser chooser = new JDateChooser();
		chooser.setLocale(Locale.GERMANY);
		chooser.setDate(user.getBirthdate());
		cache.setBirthdayChooser(chooser);
		line.add(label);
		line.add(chooser);
		
		line.add(okButton);
		line.add(cancelButton);
		updateUserPanel.add(line);
	}
	
	public static JPanel getPanel() {
		if(ShowUserController.getUser() != null) {
			buildView(ShowUserController.getUser());
		}
		else
			statics.Message.getInstance().display(null, statics.label.updateNone, statics.label.updateClient);
		return updateUserPanel;
	}
	@Override
	public void update(Observable o, Object arg) {		
		if(arg.equals(statics.label.ok)) {
			UpdateUserController.updateUser(cache);
		}
	}
}
