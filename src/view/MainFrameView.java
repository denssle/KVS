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

import statics.label;
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
		label l = new label();
		this.setTitle(l.title);
		this.setSize(700, 700);//java.awt.Toolkit.getDefaultToolkit().getScreenSize()
		this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
	}
	/**
	 * Erstellt erstes, linkes JMenu. Hier kann KVS neue Klienten erstellen, suchen oder beendet werden.
	 */
	private JMenu createUserMenu(ActionListener mainControll) {
		label l = new label();
		JMenu userMenu = new JMenu(l.clients);
		//Neuer Klient
		menuItem = new JMenuItem(l.createnewclient);
		menuItem.addActionListener(mainControll);
		userMenu.add(menuItem);
		// Klient Suchen
		menuItem = new JMenuItem(l.searchclient);
		menuItem.addActionListener(mainControll);
		userMenu.add(menuItem);
		
		userMenu.addSeparator();
		
		// letzte Meldung
		menuItem = new JMenuItem(l.lastmessages);
		menuItem.addActionListener(mainControll);
		userMenu.add(menuItem);
		
		menuItem = new JMenuItem(l.quit);
		menuItem.getAccessibleContext().setAccessibleDescription(l.quit);
		menuItem.addActionListener(mainControll);
		userMenu.add(menuItem);
		return userMenu;
	}
	/**
	 *  Erstellt das zweite JMenu, hier kann ein offener Klient bearbeitet oder gelöscht werden. 
	 */
	private JMenu createEditMenu(ActionListener mainControll) {
		label l = new label();
		JMenu editMenu = new JMenu(l.editclient);
		//Bearbeiten
		menuItem = new JMenuItem(l.editclient);
		menuItem.addActionListener(mainControll);
		editMenu.add(menuItem);
		//Löschen
		menuItem = new JMenuItem(l.deleteclient);
		menuItem.addActionListener(mainControll);
		editMenu.add(menuItem);
		
		return editMenu;
	}
	/**
	 * erstellt das Sprachenmenue
	 */
	private JMenu createLangMenu(ActionListener mainControll) {
		label l = new label();
		JMenu editMenu = new JMenu(l.language);
		//Deutsche Sprache
		menuItem = new JMenuItem(l.german);
		menuItem.addActionListener(mainControll);
		editMenu.add(menuItem);
		//Englische Sprache
		menuItem = new JMenuItem(l.english);
		menuItem.addActionListener(mainControll);
		editMenu.add(menuItem);
		//Türkische Sprache
		menuItem = new JMenuItem(l.turkish);
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
		label l = new label();
		l.update();
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
		label l = new label();
		//Beenden
		if(arg.equals(l.quit)) {
			quit();
		}
		//Neuer Klient
		if(arg.equals(l.createnewclient)) {
			panel = CreateUserView.getPanel();
		}
		//Client suchen
		if(arg.equals(l.searchclient)) {
			panel = SearchUserView.getPanel();
		}
		//Client löschen
		if(arg.equals(l.deleteclient)) {
			DeleteUserView.deleteUser();
		}
		//Client bearbeiten. 
		if(arg.equals(l.editclient)) {
			panel = UpdateUserView.getPanel();
		}
		//Client anzeigen
		if(arg.equals(l.showclient)) {
			panel = ShowUserView.getPanel();
		}
		if(arg.equals(l.lastmessages)) {
			panel = ShowMessagesView.getPanel();
		}
		if(arg.equals(l.language)) {
			updateFrame();
			start();
		}
		updatePanel(panel);
	}
}
