/**
 * 
 */
package cmc.functionality;

import java.util.Date;
import java.util.ArrayList;

import cmc.entity.*;
import dblibrary.project.csci230.UniversityDBLibrary;

/**
 * @author kmendel001
 *
 */
public class AccountController {
    DBController dbController = new DBController();
	Account account;
	/**
	 * creates new AccountController object
	 * @param Account student being accessed
	 */
	public AccountController(Account account) {
		this.account = account;
	}

	/**
	 * creates new AccountController object
	 */
	public AccountController()
	{
		
	}
	
	/**
	 * Returns list of all schools
	 * @return schoolList list of schools the student has on saved school list
	 */
	public ArrayList<UserSavedSchool> getSchoolList()
	{
		return ((Student) account).getSavedSchools();
	}
	
	/**
	 * Checks to see if any student has saved the specified school
	 * @param University university user is trying to save
	 * @return boolean true if school already saved, else false
	 */
	public boolean checkIfShoolSaved(University school)
	{
		return ((Student)account).isSchoolSaved(school.getName());
	}
	

	/**
	 * Toggles the status of the current user
	 * @return Account account with activation status changed
	 */
	public Account toggleActivationStatus()
	{
		if(account == null) System.out.println("account is still null //line64 AccountController");
		if(account.getUserStatus().equals("N"))
		{
			account.setUserStatus("Y");
		}
		else
		{
			account.setUserStatus("N");
		}
		return account;
	}
	
	/**
	 * Checks if the password matches for the current user
	 * @param password password for the account trying to log in
	 * @return boolean true if password matches, else false
	 */
	public boolean checkPassword(String password)
	{
		//check to see if passwords match, if they do not then returns false
		if(password.equals("") || password.equals(null))
		{
			throw new IllegalArgumentException("sorry, you need to provide a valid password");
		}
		
		if (this.account.getPassword().equals(password))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Randomly generates a password
	 * @return randomPassword password generated to be sent to user and added to profile
	 */
	public String makeRandomPassword()
	{
		String newPass = "";
		String[] character = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q"
		 		             , "r", "s", "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5", "6"
				             , "7", "8", "9"};
		
		
		for(int i = 0; i < 5; i++)
		{
			int newChar =  (int) ((int)35*Math.random());
			newPass = newPass + character[newChar];
//			System.out.println(newPass);;
		}
		return newPass;
	}
	
	/**
	 * Updates the password of the current user
	 * @param newPassword new password to be put in to account
	 */
	public void updatePassword(String newPassword)
	{
		if(newPassword.equals(null) || newPassword.equals(""))
		{
			throw new IllegalArgumentException("Sorry, new password has to have a password");
		}
		else
		{
		account.setPassword(newPassword);
		
		}
	}
	
	/**
	 * Sends an email to the current user
	 * @param message content of email to send to user containing randomly generated password
	 */
	public void sendEmail(String message)
	{
		String email = account.getUsername();
	}
	
	/**
	 * Updates the first name, last name, password, type, and status of the current user
	 * @param fName first name associated with account
	 * @param lName last name associated with account
	 * @param password password associated with account
	 * @param type whether account is admin or user
	 * @param status active status of user
	 * @return Account account with information edited
	 */
	public Account updateUserInfo(String fName, String lName, String password, String type, String status)
	{
		if(!fName.equals(null) && !fName.equals(""))
		{
			account.setFirstName(fName);
		}
		if(!lName.equals(null) && !lName.equals(""))
		{
			account.setLastName(lName);
		}
		if(!password.equals(null) && !password.equals(""))
		{
			account.setPassword(password);
		}
		if(!type.equals(null) && !type.equals(""))
		{
			if(type.equals("u"))
			{
				account.setUserType("u");
			}
			else if(type.equals("a"))
			{
				account.setUserType("a");
			}
		}
		if(!status.equals(null) && !status.equals(""))
		{
			if(status.equals("Y"))
			{
				account.setUserStatus("Y");
			}
			else if(status.equals("N"))
			{
				account.setUserStatus("N");
			}
		}
		return account;
	}
	
	/**
	 * Saves the specified school to the current users saved school list
	 * @param schoolToSave school user would like to add to saved school list
	 */
	public void saveSchool(String schoolName)
	{
		Date time = new Date();
		University schoolToSave = dbController.getUniversity2(schoolName);
		
		//if the shool name is not valid, print message
		
		if(schoolToSave == null) {
			System.out.println("The school to save is not in the Database Library");
		}
		
		if(account == null) {
			System.out.println("The current account is null");
		}
		 ((Student)account).saveSchool(schoolToSave, time.toString());
	}
	
	/**
	 * Removes school from the current student saved school list
	 * @param schoolToRemove school user would like to remove from saved school list
	 */
	public void removeUniversity(University schoolToRemove)
	{
		 ((Student) account).removeSchool(schoolToRemove.getName());
	}
	
	/**
	 * Creates a new account with the specified parameters
	 * @param fName first name associated with account
	 * @param lName last name associated with account
	 * @param userName user name associated with account
	 * @param password password associated with account
	 * @param type whether account is admin or user
	 * @param savedSchools list of schools user has saved
	 * @return
	 */
	public Account createNewAccount(String fName, String lName, String userName, String password, String type,
			ArrayList<UserSavedSchool> savedSchools)
	{
		if(type.equals("a"))
		{
			account = new Admin(fName, lName, userName, password, type, "Y");
			return account;
		}
		else if(type.equals("u"))
		{
			account = new Student(fName, lName, userName, password, type, "Y", savedSchools);
			return account;
		}
		else 
		{
			throw new IllegalArgumentException("Sorry you need to specify the type of user.");
		}
	}
//	public static void main(String[] args)
//	{
//		System.out.println(makeRandomPassword());
//		Date date = new Date();
//		System.out.println(date.toString());
//	}
}
