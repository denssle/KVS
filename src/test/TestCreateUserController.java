package test;

import controller.CreateUserController;

public class TestCreateUserController {	
	public void testCreation() throws Exception {
		CreateUserController createUserController = new CreateUserController();
		createUserController.createUser(cacheUser);
	    
}
