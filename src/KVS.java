import model.DataBase;
import controller.CreateUserController;
import controller.MainFrameController;
import controller.SearchUserController;
import controller.ShowUserController;
import controller.UpdateUserController;


public class KVS
{
	private static MainFrameController mainControll;
	private static SearchUserController searchUserController;
	private static CreateUserController createUserController;
	private static UpdateUserController updateUserController;
	private static ShowUserController showUserController;
	
	public static void main(String[] args)
	{
		mainControll = new MainFrameController();
		createUserController = new CreateUserController();
		searchUserController = new SearchUserController();
		showUserController = new ShowUserController();
		updateUserController = new UpdateUserController();
		
		DataBase.start();
		mainControll.start();
	}
}
