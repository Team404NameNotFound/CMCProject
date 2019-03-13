package cmc.interaction;

import cmc.functionality.UserFunctionalityController;

/**
 * @author tzhang001
 *
 */
public class AccountInteraction {
	
	UserFunctionalityController UFCon;

	public AccountInteraction(){
		UFCon = new UserFunctionalityController();
	}
	/**
	 * Student or Admin log in. 
	 * @param String username
	 * @param String password
	 */
	public void login(String username, String password){
		if(this.UFCon.login(username, password)) {
			System.out.println("Login Successfully");
		}
		
	}
	
	public void logout(){
		this.UFCon.logout();
	}
	
	public void forgetPsw(String username){
		this.UFCon.forgotPassword(username);
	}
	public void viewSchoolList(){
		this.UFCon.viewSchoolList();
	}


}

