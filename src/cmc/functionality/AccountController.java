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
	 * creates new AccountController for student being accessed
	 */
	public AccountController(Account account) {
		this.account = account;
	}

	//Constructor
	public AccountController()
	{
		
	}
	
	/**
	 * Returns list of all schools
	 * @return schoolList
	 */
	public ArrayList<UserSavedSchool> getSchoolList()
	{
		return ((Student) account).getSavedSchools();
	}
	
	/**
	 * Checks to see if any student has saved the specified school
	 */
	public boolean checkIfShoolSaved(University school)
	{
		return ((Student)account).isSchoolSaved(school.getName());
	}
	
	/**
	 * Toggles the status of the current user
	 */
	public void toggleActivationStatus()
	{
		if(account.getUserStatus().equals("N"))
		{
			account.setUserStatus("Y");
		}
		else
		{
			account.setUserStatus("N");
		}
	}
	
	/**
	 * Checks if the password matches for the current user
	 * @param password
	 * @return
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
	 * @return randomPassword
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
	 * @param newPassword
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
	 * @param message
	 */
	public void sendEmail(String message)
	{
		String email = account.getUsername();
	}
	
	/**
	 * Updates the first name, last name, password, type, and status of the current user
	 * @param fName
	 * @param lName
	 * @param password
	 * @param type
	 * @param status
	 * @return
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
	 * @param schoolToSave
	 */
	public void saveSchool(String school)
	{
		University schoolToSave = dbController.getUniversity2(school);

		if(schoolToSave == null) {
			System.out.println("The school to save is not in the Database Library");
		}
		
		if(account == null){
			System.out.println("The current account is invalid.");
		}
	   else if(account.getUserType().equals("a")){
		   System.out.println("The current account is an admin ");
	   }
		else {
			System.out.println(account.getUsername() + " just saved school: " + school);
			this.dbController.saveShool(account.getUsername(), school);
		}
		 
	}
	
	/**
	 * Removes school from the current student saved school list
	 * @param schoolToRemove
	 */
	public void removeUniversity(University schoolToRemove)
	{
		 ((Student) account).removeSchool(schoolToRemove.getName());
	}
	
	/**
	 * Creates a new account with the specified parameters
	 * @param fName
	 * @param lName
	 * @param userName
	 * @param password
	 * @param type
	 * @param savedSchools
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
			throw new IllegalArgumentException("sorry you need to specify the type of user ");
		}
	}
//	public static void main(String[] args)
//	{
//		System.out.println(makeRandomPassword());
//		Date date = new Date();
//		System.out.println(date.toString());
//	}
}
