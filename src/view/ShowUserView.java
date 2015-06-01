package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import controller.ShowUserController;
import model.User;

public class ShowUserView {
	private static JPanel showUserPanel;
	private static ActionListener actionListener;
	
	public ShowUserView(ActionListener showUserController) {
		actionListener = showUserController;
		ShowUserView.setActionListener(showUserController);
		showUserPanel = new JPanel();
		showUserPanel.setName(statics.label.showClient);
		showUserPanel.setLayout(new FlowLayout());
		showUserPanel.setVisible(true);
	}
	/**
	 * Zeigt einen User an. 
	 */
	public static void showUser(User user) {
		if(user != null) {
			showUserPanel.removeAll();
			String[][] rowData = {
					{statics.label.forname, user.getForname() }, 
					{statics.label.lastname, user.getLastname() },
					{statics.label.street, user.getStreet()},
					{statics.label.zip, user.getZip()},
					{statics.label.city, user.getCity()},
					{statics.label.birthdate, user.getNiceBirthday()}
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
	}
	/**
	 * Zeigt die Erbenisse einer Suche an. Nimmt Map entgegen. 
	 */
	public static void showUser(List<User> userMap) {
		showUserPanel.removeAll();
		JPanel subArtikelPanel = new JPanel();
		
		Iterator<User> iterator = userMap.iterator();
		
		if(userMap.size() == 1) {
			showUser(iterator.next());
		} else {
			subArtikelPanel.setLayout(new GridLayout(userMap.size(),1));			
		}
		
		while(iterator.hasNext()) {	
	        User user = iterator.next();
	        JPanel userPanel = new JPanel();
	        userPanel.setLayout(new FlowLayout());
	        userPanel.add(new JLabel(user.getForname()));
	        userPanel.add(new JLabel(user.getLastname()));
			JButton showButton = new JButton(statics.label.showClient);
			showButton.addActionListener(getActionListener());
			showButton.setName(user.getId().toString());
			userPanel.add(showButton);
			
			subArtikelPanel.add(userPanel);
		}
		subArtikelPanel.setBorder(new EmptyBorder(5, 5, 5, 5) );	
		showUserPanel.add(subArtikelPanel);
	}
	
	public static JPanel getPanel() {
		showUser(ShowUserController.getUser());
		return showUserPanel;
	}

	public static ActionListener getActionListener() {
		return actionListener;
	}

	public static void setActionListener(ActionListener actionListener) {
		ShowUserView.actionListener = actionListener;
	}
}
