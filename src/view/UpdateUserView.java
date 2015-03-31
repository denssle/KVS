package view;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class UpdateUserView extends JPanel {

	public UpdateUserView(ActionListener actionListener) {
		this.setLayout(new FlowLayout());
		
		this.add(new JLabel("Hier kommt das bearbeiten von Klienten hin. "));
		
		this.setVisible(true);
	}

}
