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
	
	
	public void editUniversity(String name, String state, String location, String control, String enrollment,
			String percentFemale, String satVerbal, String satMath, String cost, String percentFinAid,
			String percentEnrolled, String applicants, String percentAdmitted, String academicScale, String socialScale,
			String qualityOfLife, String[] emphases) {
		this.DBCon.setUniversity(universityCon.createNewUniversity(name, state, location, control, enrollment, percentFemale, satVerbal, 
				satMath, cost, percentFinAid, percentEnrolled, applicants, percentAdmitted, academicScale, socialScale, qualityOfLife, emphases));
		
	}
	
	
	/**
	 * 
	 * @param name
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
	
	public void toggleActivationStatus(String accountName) {
		this.account = new AccountController( DBCon.getAccount(accountName));
		
//		this.account.setAccount(account);
		DBCon.setAccount(this.account.toggleActivationStatus());
	}
	

}
