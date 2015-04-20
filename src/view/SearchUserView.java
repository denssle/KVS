package view;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class SearchUserView extends JPanel {
	/*
	 * Suche nach allen Attributen; mehrere Suchfelder nötig. 
	 */
	public SearchUserView(ActionListener actionListener) {
		this.setName(statics.label.searchClient);
		this.setLayout(new FlowLayout());
		
		JLabel label = new JLabel("Suche… ");
		JTextField textfield = new JTextField("… nach Klienten. ");
		
		JButton button = new JButton(statics.label.ok);
		button.addActionListener(actionListener);
		
		this.add(label);
		this.add(textfield);
		this.add(button);
		this.setVisible(true);
	}
}
