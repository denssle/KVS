package view;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import controller.DeleteUserController;


@SuppressWarnings("serial")
public class MainFrameView extends JFrame implements Observer{
	private JMenuItem menuItem;
	private JPanel mainPanel;
	
	public MainFrameView(ActionListener mainControll) {
		this.setSettings();
		
		mainPanel = new JPanel();
		this.add(mainPanel, BorderLayout.NORTH);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(createUserMenu(mainControll));
		menuBar.add(createEditMenu(mainControll));
		this.setJMenuBar(menuBar);
	}
	private void setSettings() {
		this.setTitle(statics.label.titel);
		this.setSize(700, 700);//java.awt.Toolkit.getDefaultToolkit().getScreenSize()
		this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
	}
	/*
	 * Erstellt erstes, linkes JMenu. Hier kann KVS neue Klienten erstellen, suchen oder beendet werden.
	 */
	private JMenu createUserMenu(ActionListener mainControll) {
		JMenu userMenu = new JMenu(statics.label.clients);
		//Neuer Klient
		menuItem = new JMenuItem(statics.label.newClient);
		menuItem.addActionListener(mainControll);
		userMenu.add(menuItem);
		// Klient Suchen
		menuItem = new JMenuItem(statics.label.searchClient);
		menuItem.addActionListener(mainControll);
		userMenu.add(menuItem);
		
		userMenu.addSeparator();
		
		// Klient Suchen
		menuItem = new JMenuItem(statics.label.messages);
		menuItem.addActionListener(mainControll);
		userMenu.add(menuItem);
		
		menuItem = new JMenuItem(statics.label.quit);
		menuItem.getAccessibleContext().setAccessibleDescription(statics.label.quit);
		menuItem.addActionListener(mainControll);
		userMenu.add(menuItem);
		return userMenu;
	}
	/*
	 *  Erstellt das zweite JMenu, hier kann ein offener Klient bearbeitet oder gelöscht werden. 
	 */
	private JMenu createEditMenu(ActionListener mainControll) {
		JMenu editMenu = new JMenu(statics.label.updateClient);
		//Bearbeiten
		menuItem = new JMenuItem(statics.label.updateClient);
		menuItem.addActionListener(mainControll);
		editMenu.add(menuItem);
		//Löschen
		menuItem = new JMenuItem(statics.label.deleteClient);
		menuItem.addActionListener(mainControll);
		editMenu.add(menuItem);
		
		return editMenu;
	}
	
	public void start()
	{
		this.setVisible(true);
	}
	
	private void quit() {
		this.dispose();
	}
	
	/*
	 * Nimmt ein JPanel, das eine View per getPanel zur Verfügung stellt, entgegen und setzt sie als Mainview ein. 
	 */
	private void updatePanel(JPanel newPanel) {
		mainPanel.setVisible(false);
		mainPanel = newPanel;
		if(mainPanel != null) {
			String debug = mainPanel.getName();
			mainPanel.setVisible(true);
			statics.debug.debugMessage("MainFrameView","Wechsel von "+debug+" zu "+ mainPanel.getName());
			this.add(mainPanel, BorderLayout.NORTH);
			this.validate();
		}
	}
	/*
	 * Nimmt Änderungen von Controllern entgegen, vor allem in Bezug auf Viewwechsel.
	 */
	@Override
	public void update(Observable o, Object arg) {
		JPanel panel = new JPanel();
		//Beenden
		if(arg.equals(statics.label.quit)) {
			quit();
		}
		//Neuer Klient
		if(arg.equals(statics.label.newClient)) {
			panel = CreateUserView.getPanel();
		}
		//Client suchen
		if(arg.equals(statics.label.searchClient)) {
			panel = SearchUserView.getPanel();
		}
		//Client löschen
		if(arg.equals(statics.label.deleteClient)) {
			DeleteUserView.deleteUser();
		}
		//Client bearbeiten. 
		if(arg.equals(statics.label.updateClient)) {
			panel = UpdateUserView.getPanel();
		}
		//Client anzeigen
		if(arg.equals(statics.label.showClient)) {
			panel = ShowUserView.getPanel();
		}
		if(arg.equals(statics.label.messages)) {
			panel = ShowMessagesView.getPanel();
		}
		updatePanel(panel);
	}
}
