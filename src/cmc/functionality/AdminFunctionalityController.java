package cmc.functionality;
import java.util.ArrayList; 
import cmc.entity.*;
/**
 * 
 * @author ajheroux
 *
 */
public class AdminFunctionalityController extends UserFunctionalityController {
	//constructer
	public AdminFunctionalityController() {
		
	}
	
	/**
	 * Calls the database controller to retrieve a list of university objects
	 * @return a list of university objects
	 */
	public ArrayList<University> viewUniversities() {
		return this.DBCon.getUniversityList();
	}
	
	
	/**
	 * Calls the database controller to retrieve a list of account objects
	 * @return a list of account objects
	 */
	public ArrayList<Account> viewUsers() {
		return this.DBCon.getAccountList();
	}

	public void addNewUniversity(String name, String state, String location, String control, String enrollment,
			String percentFemale, String satVerbal, String satMath, String cost, String percentFinAid,
			String percentEnrolled, String applicants, String percentAdmitted, String academicScale, String socialScale,
			String qualityOfLife, String[] emphases) {
			if (this.DBCon.getUniversity(name) != null) {
				System.out.println(name + " already exists");
			}
			else {
			University schoolToAdd = this.universityCon.createNewUniversity(name, state, location, control, enrollment, percentFemale, 
					satVerbal, satMath, cost, percentFinAid, percentEnrolled, applicants, 
					percentAdmitted, academicScale, socialScale, qualityOfLife, emphases);
					
			this.DBCon.addUniversity(schoolToAdd);
			}
		
	}
	
	
	/**
	 * Updated information for specified university to reflect the following information
	 * @param name name of university
	 * @param state state university is located in
	 * @param location setting the university is located in
	 * @param control control the university is under
	 * @param enrollment number of students that attend the university
	 * @param percentFemale percentage of the student body that is female
	 * @param satVerbal average verbal SAT score of student body
	 * @param satMath average math SAT score of student body
	 * @param cost average annual tuition
	 * @param percentFinAid percentage of student body that receives financial aid
	 * @param percentEnrolled percentage of applicants that receive financial aid
	 * @param applicants average number of applicants annually
	 * @param percentAdmitted percentage of applicants admitted annually
	 * @param academicScale whole number between 1 and 5 indicating academic rigor of university
	 * @param socialScale whole number between 1 and 5 indicating social scene of university
	 * @param qualityOfLife whole number between 1 and 5 indicating quality of life at university
	 * @param emphases up to five areas of studies which the university excels in 
	 */
	public void editUniversity(String name, String state, String location, String control, String enrollment,
			String percentFemale, String satVerbal, String satMath, String cost, String percentFinAid,
			String percentEnrolled, String applicants, String percentAdmitted, String academicScale, String socialScale,
			String qualityOfLife, String[] emphases) {
		this.DBCon.setUniversity(universityCon.createNewUniversity(name, state, location, control, enrollment, percentFemale, satVerbal, 
				satMath, cost, percentFinAid, percentEnrolled, applicants, percentAdmitted, academicScale, socialScale, qualityOfLife, emphases));
		
	}
	
	
	/**
	 * Remove specified university from a students saved school list
	 * @param name name of university
	 */
	public void removeUniversity(String name) {
		this.DBCon.removeUniversity(name);
	}
	
	public boolean addUser(String firstname, String lastname, String username, 
			String password, String userType) {
		boolean added = false;
		ArrayList<UserSavedSchool> savedSchoolList = new ArrayList<UserSavedSchool>();
		
		
		if(firstname == "" || lastname == "" || username == "" || password == "" || userType == "") {
			System.out.println("Sorry, you need to specify all fields.");
		}
		else if(!(userType.equals("u") || userType.equals("u"))){
			System.out.println("Sorry, you need to specify a valid user type.");
		}
		else if(DBCon.checkUser(lastname)) {
			System.out.println("Sorry, this username is already taken.");
		}
		else {
			AccountController acCon = new AccountController();
			Account account = acCon.createNewAccount(firstname, lastname, username, password, userType, savedSchoolList);
			if (account != null) {
				DBCon.addUser(account);
				added = true;
			}
		}
		return added;
	}
	
	/**
	 * Changes activation status for specified account
	 * @param accountName user name associated with account being edited
	 */
	public void toggleActivationStatus(String accountName) {
		this.account = new AccountController( DBCon.getAccount(accountName));
		
//		this.account.setAccount(account);
		DBCon.setAccount(this.account.toggleActivationStatus());
	}
	

}
