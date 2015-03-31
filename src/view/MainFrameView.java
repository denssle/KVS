package view;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class MainFrameView extends JFrame
{
	private JMenuItem menuItem;
	private JPanel mainPanel;
	
	public MainFrameView(ActionListener mainControll)
	{
		this.setTitle("KVS");
		this.setSize(java.awt.Toolkit.getDefaultToolkit().getScreenSize());
		this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
		mainPanel = new JPanel();
		this.add(mainPanel, BorderLayout.NORTH);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(createUserMenu(mainControll));
		menuBar.add(createEditMenu(mainControll));
		this.setJMenuBar(menuBar);
	}
	
	private JMenu createUserMenu(ActionListener mainControll) {
		JMenu userMenu = new JMenu("Klienten");
		//Neuer Klient
		menuItem = new JMenuItem(statics.label.newClient);
		menuItem.addActionListener(mainControll);
		userMenu.add(menuItem);
		// Klient Suchen
		menuItem = new JMenuItem(statics.label.searchClient);
		menuItem.addActionListener(mainControll);
		userMenu.add(menuItem);
		
		userMenu.addSeparator();
		
		menuItem = new JMenuItem(statics.label.quit);
		menuItem.getAccessibleContext().setAccessibleDescription("Quit KVS");
		menuItem.addActionListener(mainControll);
		userMenu.add(menuItem);
		return userMenu;
	}
	
	private JMenu createEditMenu(ActionListener mainControll) {
		JMenu editMenu = new JMenu("Bearbeiten");
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
	
	public void quit() {
		this.dispose();
	}
	
	public void updatePanel(JPanel newPanel) {
		mainPanel.removeAll();
		mainPanel = newPanel;
		this.add(mainPanel);
		this.validate();
	}
}
