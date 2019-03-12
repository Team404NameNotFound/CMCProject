package cmc.functionality;
import java.util.List;

import cmc.entity.Account;
import cmc.entity.University;
import dblibrary.project.csci230.UniversityDBLibrary;


public class DBController 
{
	private UniversityDBLibrary dbLibrary;

	public DBController() {
		dbLibrary = new UniversityDBLibrary("error404", "csci230");
	}
	
	public Boolean checkUser(String inputString)
	{
		String[][] userList = dbLibrary.user_getUsers();
		int n = 0;
		String username = "";
		while (userList[n][2] != null)
		{
			 
			if (userList[n][2].equals(inputString))
			{
				if (userList[n][5] == "Y")
				{
					return true;
				}
			}
			else
			{
				n++;
			}
		}
		return false;
	}
	
	public void removeUniversity(String schoolName)
	{
		dbLibrary.university_deleteUniversity(schoolName);
	}
	
	public void addUniversity(University school)
	{
		dbLibrary.university_addUniversity(school.getName(), school.getState(), school.getLocation(), school.getControl(), Integer.parseInt(school.getEnrollment()), Double.parseDouble(school.getPercentFemale()), Double.parseDouble(school.getSatVerbal()), Double.parseDouble(school.getSatMath()), Double.parseDouble(school.getCost()), Double.parseDouble(school.getPercentFinAid()), Integer.parseInt(school.getApplicants()), Double.parseDouble(school.getPercentAdmitted()), Double.parseDouble(school.getPercentEnrolled()), Integer.parseInt(school.getAcademicScale()), Integer.parseInt(school.getSocialScale()), Integer.parseInt(school.getQualityOfLife()));
	}
	
	public University getUniversity(String school)
	{
		String[][] schoolList = dbLibrary.university_getUniversities();
		//String[][] emphasis = dbLibrary.university_getEmphases();
		int n = 0;
		University returnUniversity;
		//while (emphasis[])
		while (schoolList[n][0] != null)
		{
			 
			if (schoolList[n][0].equals(school))
			{
				
				returnUniversity = new University(schoolList[n][0], schoolList[n][1], schoolList[n][2], schoolList[n][3], schoolList[n][4], schoolList[n][5], schoolList[n][6], schoolList[n][7], schoolList[n][8], schoolList[n][9], schoolList[n][10], schoolList[n][11], schoolList[n][12], schoolList[n][13], schoolList[n][14], schoolList[n][15]);
			}
			else
			{
				n++;
			}
		}
		
		
	}
	
	public void setUniversity(University school)
	{
		dbLibrary.university_editUniversity(school.getName(), school.getState(), school.getLocation(), school.getControl(), Integer.parseInt(school.getEnrollment()), Double.parseDouble(school.getPercentFemale()), Double.parseDouble(school.getSatVerbal()), Double.parseDouble(school.getSatMath()), Double.parseDouble(school.getCost()), Double.parseDouble(school.getPercentFinAid()), Integer.parseInt(school.getApplicants()), Double.parseDouble(school.getPercentAdmitted()), Double.parseDouble(school.getPercentEnrolled()), Integer.parseInt(school.getAcademicScale()), Integer.parseInt(school.getSocialScale()), Integer.parseInt(school.getQualityOfLife()));
	}
	
	public Account getAccount(String accountName)
	{
		String[][] accountList = dbLibrary.user_getUsers();
		int n = 0;
		Account returnAccount;
		while (accountList[n][2] != null)
		{
			 
			if (accountList[n][2].equals(accountName))
			{
				
				returnAccount = new Account(accountList[n][0], accountList[n][1],accountList[n][2],accountList[n][3],accountList[n][4],accountList[n][5]);
				return returnAccount;
			}
			else
			{
				n++;
			}
		}
		return new Account("","","","","","");
	}
	
	public void setAccount(Account account)
	{
		dbLibrary.user_editUser(account.getUsername(), account.getFirstName(), account.getLastName(), account.getPassword(), account.getUserType().charAt(0), account.getUserStatus().charAt(0));
	}
	
	public void addUser(Account account)
	{
		dbLibrary.user_addUser(account.getUsername(), account.getFirstName(), account.getLastName(), account.getPassword(), account.getUserType().charAt(0));
	}
	
	public boolean findUniversity(String school)
	{
		String[][] schoolList = dbLibrary.university_getUniversities();
		int n = 0;
		
		while (schoolList[n][0] != null)
		{
			if (schoolList[n][0].equals(school))
			{
				return true;
			}
			else
			{
				n++;
			}
		}
		return false;
	}
	
	public List<University> getUniversityList()
	{
		String[][] schoolList = dbLibrary.university_getUniversities();
		int n = 0;
		List<University> returnList;
		while (schoolList[n][0] != null)
		{
			try
			{
				returnList.add(new University(schoolList[n][0], schoolList[n][1], schoolList[n][2], schoolList[n][3], schoolList[n][4], schoolList[n][5], schoolList[n][6], schoolList[n][7], schoolList[n][8], schoolList[n][9], schoolList[n][10], schoolList[n][11], schoolList[n][12], schoolList[n][13], schoolList[n][14], schoolList[n][15]));
			}
			catch(Exception e)
			{
				return returnList;
			}
			n++;
			
		}
		return returnList;
		
	}
	
	public List<Account> getAccountList()
	{
		String[][] accountList = dbLibrary.user_getUsers();
		int n = 0;
		List<Account> returnList;
		while (accountList[n][0] != null)
		{
			try
			{
				returnList.add(new Account(accountList[n][0], accountList[n][1],accountList[n][2],accountList[n][3],accountList[n][4],accountList[n][5]));
			}
			catch(Exception e)
			{
				return returnList;
			}
			n++;
			
		}
		return returnList;
		
	}
	
	public List<University> getSchoolList(Account account)
	{
		String[][] accountList = dbLibrary.user_getUsers();

	}
}
