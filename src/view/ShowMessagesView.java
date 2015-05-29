package view;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JList;
import javax.swing.JPanel;

import statics.Message;

public class ShowMessagesView implements Observer{
	private static JPanel messagePanel;
	private JList messageList;
	
	public ShowMessagesView() {
		messagePanel = new JPanel();
		messagePanel.setName(statics.label.messages);
		messagePanel.setLayout(new FlowLayout());
		
		ArrayList<String> listContent = new ArrayList<String>();
		
		for(Entry<String,String> set: Message.getInstance().getLastMessages().entrySet()) {
			listContent.add(set.getKey()+": "+set.getValue());
		}
		
		messageList = new JList(listContent.toArray());
		messagePanel.add(messageList);
		messagePanel.setVisible(true);
	}

	public static JPanel getPanel() {
		return messagePanel;
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

}
