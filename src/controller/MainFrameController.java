package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.MainFrameView;

public class MainFrameController implements ActionListener {
	private MainFrameView mainFrame;
	
	public MainFrameController() {
		mainFrame = new MainFrameView(this);
	}
	
	public void start() {
		mainFrame.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
