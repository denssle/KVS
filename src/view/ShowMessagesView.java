package view;
import java.awt.FlowLayout;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JList;
import javax.swing.JPanel;
import controller.ShowUserController;
import statics.Message;

public class ShowMessagesView implements Observer{
	private static JPanel messagePanel;
	private static JList<String> messageList;
	
	private static void buildView() {
		messagePanel = new JPanel();
		messagePanel.setName(statics.label.messages);
		messagePanel.setLayout(new FlowLayout());
		
		String[] listContent = new String[Message.getInstance().getLastMessages().entrySet().size()];
		
		int i = 0;
		for(Entry<String,String> set: Message.getInstance().getLastMessages().entrySet()) {
			listContent[i] = set.getKey()+": "+set.getValue();
			i++;
		}
		
		messageList = new JList<String>();
		messageList.setListData(listContent);
		messagePanel.add(messageList);
		messagePanel.setVisible(true);
	}

	public static JPanel getPanel() {
		ShowUserController.setUserNull();
		buildView();
		return messagePanel;
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
	}

}
