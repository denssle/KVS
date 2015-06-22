import view.CreateUserView;
import view.DeleteUserView;
import view.MainFrameView;
import view.SearchUserView;
import view.ShowMessagesView;
import view.ShowUserView;
import view.UpdateUserView;
import controller.CreateUserController;
import controller.DeleteUserController;
import controller.MainFrameController;
import controller.SearchUserController;
import controller.ShowUserController;
import controller.UpdateUserController;


public class KVS {
	private static CreateUserController createUserController;
	private static MainFrameController mainControll;
	private static SearchUserController searchUserController;
	private static ShowUserController showUserController;
	private static UpdateUserController updateUserController;
	private static DeleteUserController deleteUserController;
	
	private static CreateUserView createUserView;
	private static ShowMessagesView showMessageView;
	private static MainFrameView mainFrameView;
	private static SearchUserView searchUserView;
	private static UpdateUserView updateUserView;
	private static DeleteUserView deleteUserView;
<<<<<<< HEAD
	
=======
>>>>>>> master
	public static void main(String[] args){
		mainControll = new MainFrameController();
		mainFrameView = new MainFrameView(mainControll);
		mainControll.addObserver(mainFrameView);
		
		showMessageView = new ShowMessagesView();
		mainControll.addObserver(showMessageView);
		
		createUserController = new CreateUserController();
		createUserController.addObserver(mainFrameView);
		createUserView = new CreateUserView(createUserController);
		createUserController.addObserver(createUserView);
		
		searchUserController = new SearchUserController();
		searchUserController.addObserver(mainFrameView);
		searchUserView = new SearchUserView(searchUserController);
		searchUserController.addObserver(searchUserView);
		
		showUserController = new ShowUserController();
		new ShowUserView(showUserController);
		showUserController.addObserver(mainFrameView);
		
		updateUserController = new UpdateUserController();
		updateUserController.addObserver(mainFrameView);
		updateUserView = new UpdateUserView(updateUserController);
		updateUserController.addObserver(updateUserView);

		deleteUserController = new DeleteUserController();
		deleteUserView = new DeleteUserView(deleteUserController);
		deleteUserController.addObserver(deleteUserView);
				
		mainFrameView.start();
	}
}
