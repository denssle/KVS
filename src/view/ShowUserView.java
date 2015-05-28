package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import controller.ShowUserController;
import model.User;

public class ShowUserView {
	private static JPanel showUserPanel;
	private static ActionListener actionListener;
	
	public ShowUserView(ActionListener showUserController) {
		ShowUserView.setActionListener(showUserController);
		showUserPanel = new JPanel();
		showUserPanel.setName(statics.label.showClient);
		showUserPanel.setLayout(new FlowLayout());
		showUserPanel.setVisible(true);
	}

	public static void showUser(User user) {
		showUserPanel.removeAll();
		String[][] rowData = {
				{statics.label.forname, user.getForname() }, 
				{statics.label.lastname, user.getLastname() },
				{statics.label.street, user.getStreet()},
				{statics.label.zip, user.getZip()},
				{statics.label.city, user.getCity()},
				{statics.label.birthdate, user.getBirthdate()}
			    };
		String[] columnNames =  {
			      "XXX", "YYY"
			    };
		JTable table = new JTable(rowData, columnNames);
		//table.setRowHeight(25);
		table.setRowMargin(2);
		table.setShowHorizontalLines(true);
		table.setPreferredSize(new Dimension(400, 100));
		ShowUserController.setUser(user);
		showUserPanel.add(table);
	}

	public static void showUser(Map<UUID, User> userMap) {
		showUserPanel.removeAll();
		JPanel subArtikelPanel = new JPanel();
		
		showUserPanel.add(subArtikelPanel, BorderLayout.PAGE_START);
		subArtikelPanel.setLayout(new GridLayout(userMap.size(),3));

		Iterator<Entry<UUID, User>> iterator = userMap.entrySet().iterator();
		
		while(iterator.hasNext())
		{	
			Map.Entry<UUID, User> pairs = iterator.next();
	        UUID uuid = (UUID) pairs.getKey();
	        User user = (User) pairs.getValue();
			
			subArtikelPanel.add(new JLabel(user.getForname()));
			subArtikelPanel.add(new JLabel(user.getLastname()));
			
			JButton showButton = new JButton(statics.label.showClient);
			showButton.addActionListener(getActionListener());
			showButton.setName(uuid.toString());
	        subArtikelPanel.add(showButton);
		}
	}
	
	public static JPanel getPanel() {
		return showUserPanel;
	}

	public static ActionListener getActionListener() {
		return actionListener;
	}

	public static void setActionListener(ActionListener actionListener) {
		ShowUserView.actionListener = actionListener;
	}
}
