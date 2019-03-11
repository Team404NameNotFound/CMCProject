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
	 * @param username
	 * @param password
	 */
	public void logon(String username, String password){
		this.UFCon.logon(username, password);
		
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

