package view;

import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


@SuppressWarnings("serial")
public class MainFrameView extends JFrame
{
	private JMenuItem menuItem;
	
	public MainFrameView(ActionListener hauptrahmenController)
	{
		this.setTitle("KVS");
		this.setSize(java.awt.Toolkit.getDefaultToolkit().getScreenSize());
		this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		this.setAlwaysOnTop(true);
		
		JMenuBar menuBar = new JMenuBar();
		
		menuBar.add(createUserMenu());
		menuBar.add(createEditMenu());
		this.setJMenuBar(menuBar);
	}
	
	private JMenu createUserMenu() {
		JMenu userMenu = new JMenu("Clienten");
		//Neuer Klient
		menuItem = new JMenuItem(statics.label.menuItemNewClient);
		userMenu.add(menuItem);
		// Klient Suchen
		menuItem = new JMenuItem(statics.label.menuItemSearchClient);
		userMenu.add(menuItem);
		
		userMenu.addSeparator();
		
		menuItem = new JMenuItem(statics.label.menuItemQuit);
		menuItem.getAccessibleContext().setAccessibleDescription("Quit KVS");
		userMenu.add(menuItem);
		return userMenu;
	}
	
	private JMenu createEditMenu() {
		JMenu editMenu = new JMenu("Bearbeiten");
		//Bearbeiten
		menuItem = new JMenuItem(statics.label.menuItemUpdateClient);
		editMenu.add(menuItem);
		//Löschen
		menuItem = new JMenuItem(statics.label.menuItemDeleteClient);
		editMenu.add(menuItem);
		
		return editMenu;
	}
	
	public void start()
	{
		this.setVisible(true);
	}
}
