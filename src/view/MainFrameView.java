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
		
		menuItem = new JMenuItem("Neuen Klienten anlegen");
		userMenu.add(menuItem);
		
		menuItem = new JMenuItem("Klient suchen");
		userMenu.add(menuItem);
		
		userMenu.addSeparator();
		
		menuItem = new JMenuItem("Beenden");
		menuItem.getAccessibleContext().setAccessibleDescription("Quit KVS");
		userMenu.add(menuItem);
		return userMenu;
	}
	
	private JMenu createEditMenu() {
		JMenu editMenu = new JMenu("Bearbeiten");
		
		menuItem = new JMenuItem("Klient bearbeiten");
		editMenu.add(menuItem);
		
		menuItem = new JMenuItem("Klient löschen");
		editMenu.add(menuItem);
		
		return editMenu;
	}
	
	public void start()
	{
		this.setVisible(true);
	}
}
