package view;

import java.awt.event.ActionListener;

import javax.swing.JFrame;


public class MainFrameView extends JFrame
{
	public MainFrameView(ActionListener hauptrahmenController)
	{
		this.setTitle("KVS");
		this.setSize(700,700);
		this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		this.setAlwaysOnTop(true);
	}
	
	public void start()
	{
		this.setVisible(true);
	}
}
