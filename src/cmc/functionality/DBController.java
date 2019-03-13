package cmc.functionality;
import java.util.ArrayList;


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
		for (int n = 0; n < userList.length; n++)
		{
			 
			if (userList[n][2].equals(inputString))
			{
				return true;
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
		University returnUniversity;
		//while (emphasis[])
		for (int n = 0; n < schoolList.length; n++)
		{
			 
			if (schoolList[n][0].equals(school))
			{

				
				returnUniversity = new University(schoolList[n][0], schoolList[n][1], schoolList[n][2], schoolList[n][3], schoolList[n][4], schoolList[n][5], schoolList[n][6], schoolList[n][7], schoolList[n][8], schoolList[n][9], schoolList[n][10], schoolList[n][11], schoolList[n][12], schoolList[n][13], schoolList[n][14], schoolList[n][15]);
			}
			else
			{
				n++;

				//finds users that have saved the school
				String[][] accountList = dbLibrary.user_getUsernamesWithSavedSchools();
				ArrayList<Account> savedStudents= new ArrayList<Account>();
				for(int i = 0; i < accountList.length;i++)
				{
					if(accountList[i][1].equals(school))
					{						
						Account student = getAccount(accountList[i][0]);
						savedStudents.add(student);
					}
				}
				
				String[][] emphases = dbLibrary.university_getEmphases();
				int emphCounter = 0;
				for(int i = 0; i < emphases.length; i++)
				{
					if(emphases[i][0].equals(school))
					{
						emphCounter++;
					}
				}
				String[] returnEmphases = new String[emphCounter];
				int placer = 0;
				for(int i = 0; i < emphases.length; i++)
				{
					if(emphases[i][0].equals(school))
					{
						returnEmphases[placer] = emphases[i][1];
					}
				}
				
				return new University(schoolList[n][0], schoolList[n][1], schoolList[n][2], schoolList[n][3], schoolList[n][4], schoolList[n][5], schoolList[n][6], schoolList[n][7], schoolList[n][8], schoolList[n][9], schoolList[n][10], schoolList[n][11], schoolList[n][12], schoolList[n][13], schoolList[n][14], schoolList[n][15], returnEmphases, savedStudents);

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
		Account returnAccount;
		for (int n = 0; n < accountList.length; n++)
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
		return null;
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
	
	public ArrayList<University> getUniversityList()
	{
		String[][] schoolList = dbLibrary.university_getUniversities();

		ArrayList<University> returnList;
		for (int i = 0; i < schoolList.length; i++)
		{
				returnList.add(new University(schoolList[n][0], schoolList[n][1], schoolList[n][2], schoolList[n][3], schoolList[n][4], schoolList[n][5], schoolList[n][6], schoolList[n][7], schoolList[n][8], schoolList[n][9], schoolList[n][10], schoolList[n][11], schoolList[n][12], schoolList[n][13], schoolList[n][14], schoolList[n][15]));

		University[] returnArray = new University[schoolList.length];
		
		for (int i = 0; i < schoolList.length; i++)
		{
				returnArray[i] = getUniversity(schoolList[i][0]);

		}
		return returnList;
		
	}
	
	public ArrayList<Account> getAccountList()
	{
		String[][] accountList = dbLibrary.user_getUsers();
		ArrayList<Account> returnList = new ArrayList<Account>();
		for (int n = 0; n < accountList.length; n++)
		{
				returnList.add(new Account(accountList[n][0], accountList[n][1],accountList[n][2],accountList[n][3],accountList[n][4],accountList[n][5]));
		}
		return returnList;
		
	}
	
	public ArrayList<University> getSchoolList(Account account)
	{
		String[][] schoolList = dbLibrary.university_getUniversities();
		String[][] savedSchools = dbLibrary.user_getUsernamesWithSavedSchools();
		
		for(int n = 0; n < savedSchools.length; n++)
		{

			

			if(savedSchools[n][0].equals(account.getUsername()))
			{
				returnArray[placer][0] = savedSchools[n][1];
				returnArray[placer][1] = savedSchools[n][2];
				placer++;
			}

		}
		
		return null;
	}
	
	public void addEmphasis(String school, String emphasis)
	{
		dbLibrary.university_addUniversityEmphasis(school, emphasis);
	}
}
