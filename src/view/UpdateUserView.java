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
import util.Local;
import agiletrack.swing.JDateChooser;
import model.User;
import controller.ShowUserController;
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
		
		okButton = new JButton(Local.getInstance().getLocalString("ok"));
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
		Local local = Local.getInstance();
		line.setLayout(new GridLayout(local.getUserLabels().length+1,2)); //Spalten, Zeilen
		
		cache = new CacheUser();
		
		label = new JLabel(local.getLocalString("forname"));
		textfield = new JTextField(user.getForname());
		cache.setFornameField(textfield);
		line.add(label);
		line.add(textfield);
		
		label = new JLabel(local.getLocalString("lastname"));
		textfield = new JTextField(user.getLastname());
		cache.setLastnameField(textfield);
		line.add(label);
		line.add(textfield);
		
		label = new JLabel(local.getLocalString("street"));
		textfield = new JTextField(user.getStreet());
		cache.setStreetField(textfield);
		line.add(label);
		line.add(textfield);
		
		label = new JLabel(local.getLocalString("zip"));
		textfield = new JTextField(user.getZip());
		cache.setZipField(textfield);
		line.add(label);
		line.add(textfield);
		
		label = new JLabel(local.getLocalString("city"));
		textfield = new JTextField(user.getCity());
		cache.setCityField(textfield);
		line.add(label);
		line.add(textfield);
		
		label = new JLabel(local.getLocalString("birthdate"));
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
		} else {
			statics.Message.getInstance().display(null, Local.getInstance().getLocalString("updatenonefound"), statics.label.updateClient);
		}
		return updateUserPanel;
	}
	@Override
	public void update(Observable o, Object arg) {		
		if(arg.equals(Local.getInstance().getLocalString("ok"))) {
			UpdateUserController.updateUser(cache);
		}
	}
}
