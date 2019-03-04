/**
 * 
 */
package cmc.functionality;

import java.awt.List;

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
	public List<University> getSchoolList()
	{
		return account.getSchoolList();
	}
	
	public boolean checkIfShoolSaved(University school)
	{
		return account.isSchoolSaved(school);
	}
	
	public void toggleActivationStatus()
	{
		account.changeStatus();
	}
	
	public boolean checkPassword(String password)
	{
		//check to see if passwords match, if they do not then returns false
		if account.getPassword.equals(password)
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
			System.out.println(newPass);;
		}
		return newPass;
	}
	
	public void updatePassword(String newPassword)
	{
		account.setPassword(newPassword);
	}
	
	public void sendEmail()
	{
		
	}
	
	public Account updateUserInfo(String fName, String lName, String password, String type, String status)
	{
		if(!fName.equals(null))
		{
			account.setFirstName(fName);
		}
		if(!lName.equals(null))
		{
			account.setLastName(lName);
		}
		if(!password.equals(null))
		{
			account.setPassword(password);
		}
		if(!type.equals(null))
		{
			if(type.equals("u"))
			{
				account.setType("u");
			}
			else if(type.equals("a"))
			{
				account.setType("a");
			}
		}
		if(!status.equals(null));
		{
			if(status.equals("Y"))
			{
				account.setStatus("Y");
			}
			else if(status.equals("N"))
			{
				account.setStatus("N");
			}
		}
	}
	
	public boolean saveSchool(University schoolToSave)
	{
		return account.saveSchool(schoolToSave);
	}
	
	public boolean removeUniversity(University schoolToRemove)
	{
		return account.removeSchool(schoolToRemove);
	}
	
	public Account createNewAccount(String fName, String lName, String userName, String password, String type)
	{
		if(type.equals("a"))
		{
			
		}
		else if(type.equals("u"))
		{
			
		}
		else 
		{
			
		}
	}
//	public static void main(String[] args)
//	{
//		System.out.println(makeRandomPassword());
//	}
}
