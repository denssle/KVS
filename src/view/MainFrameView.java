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

import util.Local;

@SuppressWarnings("serial")
public class MainFrameView extends JFrame implements Observer{
	private JMenuItem menuItem;
	private JPanel mainPanel;
	private ActionListener actionListener;
	
	public MainFrameView(ActionListener mainControll) {
		this.setSettings();
		
		mainPanel = new JPanel();
		this.add(mainPanel, BorderLayout.NORTH);
		actionListener = mainControll;
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(createUserMenu(actionListener));
		menuBar.add(createEditMenu(actionListener));
		menuBar.add(createLangMenu(actionListener));
		this.setJMenuBar(menuBar);
	}
	
	private void setSettings() {
		this.setTitle(Local.getInstance().getLocalString("title"));
		this.setSize(700, 700);//java.awt.Toolkit.getDefaultToolkit().getScreenSize()
		this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
	}
	/**
	 * Erstellt erstes, linkes JMenu. Hier kann KVS neue Klienten erstellen, suchen oder beendet werden.
	 */
	private JMenu createUserMenu(ActionListener mainControll) {
		Local local = Local.getInstance();
		JMenu userMenu = new JMenu(local.getLocalString("clients"));
		//Neuer Klient
		menuItem = new JMenuItem(local.getLocalString("newClient"));
		menuItem.addActionListener(mainControll);
		userMenu.add(menuItem);
		// Klient Suchen
		menuItem = new JMenuItem(local.getLocalString("searchClient"));
		menuItem.addActionListener(mainControll);
		userMenu.add(menuItem);
		
		userMenu.addSeparator();
		
		// letzte Meldung
		menuItem = new JMenuItem(local.getLocalString("messages"));
		menuItem.addActionListener(mainControll);
		userMenu.add(menuItem);
		
		menuItem = new JMenuItem(local.getLocalString("quit"));
		menuItem.getAccessibleContext().setAccessibleDescription(Local.getInstance().getLocalString("quit"));
		menuItem.addActionListener(mainControll);
		userMenu.add(menuItem);
		return userMenu;
	}
	/**
	 *  Erstellt das zweite JMenu, hier kann ein offener Klient bearbeitet oder gelöscht werden. 
	 */
	private JMenu createEditMenu(ActionListener mainControll) {
		Local local = Local.getInstance();
		JMenu editMenu = new JMenu(local.getLocalString("updateClient"));
		//Bearbeiten
		menuItem = new JMenuItem(local.getLocalString("updateClient"));
		menuItem.addActionListener(mainControll);
		editMenu.add(menuItem);
		//Löschen
		menuItem = new JMenuItem(local.getLocalString("deleteClient"));
		menuItem.addActionListener(mainControll);
		editMenu.add(menuItem);
		
		return editMenu;
	}
	/**
	 * erstellt das Sprachenmenue
	 */
	private JMenu createLangMenu(ActionListener mainControll) {
		Local local = Local.getInstance();
		JMenu editMenu = new JMenu(local.getLocalString("language"));
		//Deutsche Sprache
		menuItem = new JMenuItem(local.getLocalString("german"));
		menuItem.addActionListener(mainControll);
		editMenu.add(menuItem);
		//Englische Sprache
		menuItem = new JMenuItem(local.getLocalString("english"));
		menuItem.addActionListener(mainControll);
		editMenu.add(menuItem);
		//Türkische Sprache
		menuItem = new JMenuItem(local.getLocalString("turkish"));
		menuItem.addActionListener(mainControll);
		editMenu.add(menuItem);
		
		return editMenu;
	}
	public void start() {
		this.setVisible(true);
	}
	
	private void quit() {
		this.dispose();
	}
	private void updateFrame() {
		this.setSettings();
		this.add(mainPanel, BorderLayout.NORTH);
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(createUserMenu(actionListener));
		menuBar.add(createEditMenu(actionListener));
		menuBar.add(createLangMenu(actionListener));
		this.setJMenuBar(menuBar);
	}
	/**
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
	/**
	 * Nimmt Änderungen von Controllern entgegen, vor allem in Bezug auf Viewwechsel.
	 */
	@Override
	public void update(Observable o, Object arg) {
		JPanel panel = new JPanel();
		Local local = Local.getInstance();
		//Beenden
		if(arg.equals(local.getLocalString("quit"))) {
			quit();
		}
		//Neuer Klient
		if(arg.equals(local.getLocalString("newClient"))) {
			panel = CreateUserView.getPanel();
		}
		//Client suchen
		if(arg.equals(local.getLocalString("searchClient"))) {
			panel = SearchUserView.getPanel();
		}
		//Client löschen
		if(arg.equals(local.getLocalString("deleteClient"))) {
			DeleteUserView.deleteUser();
		}
		//Client bearbeiten. 
		if(arg.equals(local.getLocalString("updateClient"))) {
			panel = UpdateUserView.getPanel();
		}
		//Client anzeigen
		if(arg.equals(local.getLocalString("showClient"))) {
			panel = ShowUserView.getPanel();
		}
		if(arg.equals(local.getLocalString("messages"))) {
			panel = ShowMessagesView.getPanel();
		}
		if(arg.equals(local.getLocalString("language"))) {
			updateFrame();
			start();
		}
		updatePanel(panel);
	}
}
