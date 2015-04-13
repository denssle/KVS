package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import model.User;

@SuppressWarnings("serial")
public class ShowUserView extends JPanel  {
	private JButton updateButton;
	private JButton deleteButton;
	public ShowUserView(ActionListener showUserController) {
		this.setName(statics.label.showClient);
		this.setLayout(new BorderLayout());
		
		updateButton = new JButton(statics.label.update);
		updateButton.addActionListener(showUserController);
		
		deleteButton = new JButton(statics.label.delete);
		deleteButton.addActionListener(showUserController);
		
		this.setVisible(true);
	}

	public void showUser(User user) {
		
		String[][] rowData = {
				{statics.label.forname, user.getForname() }, 
				{statics.label.lastname, user.getLastname() },
				{statics.label.street, user.getStreet()},
				{statics.label.zip, user.getZip()},
				{statics.label.city, user.getCity()}
			    };
		String[] columnNames =  {
			      "XXX", "YYY"
			    };
		
		JTable table = new JTable( rowData, columnNames );

		JPanel northPanel = new JPanel();
		northPanel.setLayout(new FlowLayout());
		northPanel.add(table);
		
		JPanel southPanel = new JPanel();
		southPanel.setLayout(new FlowLayout());
		southPanel.add(updateButton);
		southPanel.add(deleteButton);
		
		this.add(northPanel, BorderLayout.NORTH);
		this.add(southPanel, BorderLayout.SOUTH);
	}
}
