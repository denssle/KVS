import controller.MainFrameController;


public class KVS
{
	private static MainFrameController mainControll;
	
	public static void main(String[] args)
	{
		mainControll = new MainFrameController();
		mainControll.start();
	}
}
