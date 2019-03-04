/**
 * 
 */
package cmc.functionality;

import java.awt.List;
import java.util.ArrayList;

import cmc.entity.*;

/**
 * @author kmendel001
 *
 */
public class AccountController {

		Account account;
	/**
	 * creates new AccountController for student being accessed
	 */
	public AccountController(Account account) {
		this.account = account;
	}

	public AccountController()
	{
		
	}
	public ArrayList<UserSavedSchool> getSchoolList()
	{
		return ((Student) account).getSavedSchools();
	}
	
	public boolean checkIfShoolSaved(University school)
	{
		return account.isSchoolSaved(school);
	}
	
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
	
	public void updatePassword(String newPassword)
	{
		if(newPassword.equals(null) || newPassword.equals(""))
		{
			throw new IllegalArgumentException("Sorry, new password has to have a password");
		}
		else
		{
		account.setPassword(newPassword);
		sendEmail();
		}
	}
	
	public void sendEmail()
	{
		String email = account.getUsername();
	}
	
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
	
	public boolean saveSchool(University schoolToSave)
	{
		return account.saveSchool(schoolToSave);
	}
	
	public boolean removeUniversity(University schoolToRemove)
	{
		return account.removeSchool(schoolToRemove);
	}
	
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
//	}
}
