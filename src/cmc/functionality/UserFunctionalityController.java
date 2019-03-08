package cmc.functionality;
import cmc.entity.*;
import cmc.interaction.*;

/**
 * 
 * @author ajheroux
 *
 */
public class UserFunctionalityController {
	
	//Making instance variables
	AccountController account;
	DBController DBCon;
	Boolean loggedIn;

	public UserFunctionalityController() {
		super();
		this.DBCon = new DBController();
		this.loggedIn = false;
	}
	
	public boolean logon(String userName, String password) {
		if (!loggedIn) {
			if (this.DBCon.checkUser(userName)) {
				AccountController userAcc = new AccountController(this.DBCon.getAccount(userName));
				if (userAcc.checkPassword(password)) {
					System.out.println("Login Successful");
					this.account = userAcc;
					this.loggedIn = true;
					return true;
				}
				else {
					System.out.println("Wrong Password");
					return false;
				}
			}
			else {
				System.out.println(userName + " is an invalid username");
				return false;
			}
		}
	}
	
	public void logout() {
		if (loggedIn) {
			this.account = null;
			System.out.println("Logout successful");
		}
	}
	
	public void viewUserProfile(String userName) {
		if (this.DBCon.checkUser(userName)) {
			Account userAcc = DBCon.getAccount(userName);
			System.out.println("First Name: " + userAcc.getFirstName());
			System.out.println("Last Name: " + userAcc.getLastName());
			System.out.println("Username: " + userAcc.getUsername());
			System.out.println("Password: " + userAcc.getPassword());
			System.out.println("Type: " + userAcc.getUserType());
			}
		else {
			throw new IllegalArgumentException(userName + " does not exist in the database!");
		}
	}
	
	
	public void viewSchoolList() {
		University[] universityList = this.DBCon.getUniversityList();
		if (account instanceof Admin) {
			// display list info for admins
		}
		else if (account instanceof Student) {
			// display school list for students
		}
	}
	
	public void forgotPassword(String userName) {
		if (!loggedIn) {
			this.account
		}
	}
	
	

}
