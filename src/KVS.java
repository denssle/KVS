import controller.CreateUserController;
import controller.MainFrameController;
import controller.SearchUserController;
import controller.UpdateUserController;


public class KVS
{
	private static MainFrameController mainControll;
	private static SearchUserController searchUserController;
	private static CreateUserController createUserController;
	private static UpdateUserController updateUserController;
	
	public static void main(String[] args)
	{
		mainControll = new MainFrameController();
		createUserController = new CreateUserController();
		searchUserController = new SearchUserController();
		updateUserController = new UpdateUserController();
		
		mainControll.start();
	}
}
