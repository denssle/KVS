package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class CreateUserView extends JPanel {
	private JTextField[] inputTextFields;
	
	public CreateUserView(ActionListener createUserController) {
		inputTextFields = new JTextField[statics.label.userLabels.length];
		this.setLayout(new FlowLayout());
		buildView(createUserController);
		this.setVisible(true);
	}
	
	private void buildView(ActionListener actionListener) {
		JPanel line = new JPanel();
		line.setLayout(new GridLayout(statics.label.userLabels.length+1,2)); //Spalten, Zeilen
		
		for(int i = 0; i < statics.label.userLabels.length; i++) {
			JLabel label = new JLabel(statics.label.userLabels[i]);
			
			JTextField textfield = new JTextField("Hier " + statics.label.userLabels[i] + " eingeben.");
			textfield.setName(statics.label.userLabels[i]);
			inputTextFields[i] = textfield;	
			
			line.add(label);
			line.add(textfield);
		}
		JButton okButton = new JButton(statics.label.ok);
		okButton.addActionListener(actionListener);
		
		JButton cancelButton = new JButton(statics.label.cancel);
		cancelButton.addActionListener(actionListener);
		
		line.add(okButton);
		line.add(cancelButton);
		this.add(line);
	}
	
	public String[] getInput() {
		String[] reponse = new String[inputTextFields.length];
		for(int i = 0; i < inputTextFields.length; i++) {
			reponse[i] = inputTextFields[i].getText();
		}
		return reponse;
	}
}
