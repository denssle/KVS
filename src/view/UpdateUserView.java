package view;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.User;
import controller.CreateUserController;
import controller.UpdateUserController;

public class UpdateUserView implements Observer{
	private static JPanel updateUserPanel;
	private static JTextField[] inputTextFields;
	private static JButton okButton;
	private static JButton cancelButton;
	public UpdateUserView(ActionListener actionListener) {
		updateUserPanel = new JPanel();
		updateUserPanel.setName(statics.label.updateClient);
		updateUserPanel.setLayout(new FlowLayout());		
		inputTextFields = new JTextField[statics.label.userLabels.length];
		
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
		
		label = new JLabel(statics.label.userLabels[0]);
		textfield = new JTextField(user.getForname());
		inputTextFields[0] = textfield;	
		line.add(label);
		line.add(textfield);
		
		label = new JLabel(statics.label.userLabels[1]);
		textfield = new JTextField(user.getLastname());
		inputTextFields[1] = textfield;	
		line.add(label);
		line.add(textfield);
		
		label = new JLabel(statics.label.userLabels[2]);
		textfield = new JTextField(user.getStreet());
		inputTextFields[2] = textfield;	
		line.add(label);
		line.add(textfield);
		
		label = new JLabel(statics.label.userLabels[3]);
		textfield = new JTextField(user.getZip());
		inputTextFields[3] = textfield;	
		line.add(label);
		line.add(textfield);
		
		label = new JLabel(statics.label.userLabels[4]);
		textfield = new JTextField(user.getCity());
		inputTextFields[4] = textfield;	
		line.add(label);
		line.add(textfield);
		
		label = new JLabel(statics.label.userLabels[5]);
		textfield = new JTextField(user.getBirthdate()+"");
		inputTextFields[5] = textfield;	
		line.add(label);
		line.add(textfield);
		
		line.add(okButton);
		line.add(cancelButton);
		updateUserPanel.add(line);
	}
	public String[] getInput() {
		String[] reponse = new String[inputTextFields.length];
		for(int i = 0; i < inputTextFields.length; i++) {
			reponse[i] = inputTextFields[i].getText();
		}
		return reponse;
	}
	
	public static JPanel getPanel() {
		if(UpdateUserController.getUser() != null) {
			buildView(UpdateUserController.getUser());
		}
		return updateUserPanel;
	}
	@Override
	public void update(Observable o, Object arg) {		
		if(arg.equals(statics.label.ok)) {
			UpdateUserController.updateUser(getInput());
		}
	}
}
