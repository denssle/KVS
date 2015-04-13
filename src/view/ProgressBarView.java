package view;

import java.awt.BorderLayout;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

@SuppressWarnings("serial")
public class ProgressBarView extends JPanel {
	private JProgressBar progressBar;
	private Date date;
	private long start;
	private final int minBorder = 1;
	private final int maxBorder = 2000;
	
	public ProgressBarView() {
		this.setLayout(new BorderLayout());
		this.setName("ProgressBarView");
		date = new Date();
		start = date.getTime();
		progressBar = new JProgressBar(minBorder,maxBorder);
		progressBar.setStringPainted(true);
		this.add(new JLabel("Ein Text. "), BorderLayout.WEST);
		this.add(progressBar, BorderLayout.CENTER);
		this.setVisible(true);
	}
	
	public void start() {
		progressBar.setValue(minBorder);
	}
	/*
	 * Return is true if update was successful.
	 */
	public boolean updateBar() {
		Long passedSec = (new Date().getTime() - start);
		int now = passedSec.intValue();
		if(now > progressBar.getValue()) {
			statics.debug.debugMessage("ProgressBarView", "Zeit: "+(now));
			progressBar.setValue(now);
			return true;
		}
		return false;
	}
	
	public void stop() {
		date = new Date();
		start = date.getTime();
	}
	
	public int getValue() {
		return progressBar.getValue();
	}
	
	public boolean isRunning() {
		if(progressBar.getValue() >= maxBorder) {
			return false;
		}
		return true;
	}
}
