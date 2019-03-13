package cmc.functionality;
import cmc.entity.*;
import cmc.interaction.*;
import java.util.ArrayList;
/**
 * 
 * @author ajheroux
 *
 */
public class UserFunctionalityController {
	
	//Making instance variables
	AccountController account;
	DBController DBCon;
	UniversityController universityCon;
	Boolean loggedIn;
	//class constructor
	public UserFunctionalityController() {
		super();
		this.DBCon = new DBController();
		this.universityCon = new UniversityController();
		this.loggedIn = false;
	}
	
	/**
	 * Log on checks to see if the the user is logged in and is an active user. If both are true, 
	 * the password and user name are verified and the user is logged in.
	 * @param userName
	 * @param password
	 * @return true in log on is successful
	 */
	public boolean login(String userName, String password) {
		if (!loggedIn) {
			if (this.DBCon.checkUser(userName)) {
				if (this.DBCon.getAccount(userName).getUserStatus().equals('Y')) {
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
			}
			else {
				System.out.println(userName + " is an invalid username");
				return false;
			}
		}
		return false;
	}
	
	
	/**
	 * Checks if the the user is logged in and if not logs out
	 */
	public void logout() {
		if (loggedIn) {
			this.account = null;
			System.out.println("Logout successful");
		}
	}
	
	/**
	 * Finds the information of a specified user and prints the users details
	 * @param userName
	 */
	public ArrayList<String> viewUserProfile(String userName) {
		if
			if (this.DBCon.checkUser(userName)) {
				Account userAcc = this.DBCon.getAccount(userName);
				ArrayList<String> profile = new ArrayList<String>();
				profile.add(userAcc.getFirstName());
				profile.add(userAcc.getLastName());
				profile.add(userAcc.getUsername());
				profile.add(userAcc.getPassword());
				profile.add(userAcc.getUserType());
				return profile;
			}
		else {
			throw new IllegalArgumentException(userName + " does not exist in the database!");
		}
	}
	
	/**
	 * Updates the first name, last name and password of the specified user
	 * @param userName
	 * @param firstName
	 * @param lastName
	 * @param password
	 */
	public void editUserProfile(String userName, String firstName, String lastName, 
			String password) {
		if (this.DBCon.checkUser(userName)) {
			Account userAcc = this.DBCon.getAccount(userName);
			userAcc.setFirstName(firstName);
			userAcc.setLastName(lastName);
			userAcc.setPassword(password);
			this.DBCon.setAccount(userAcc);
		}
	}
	
	/**
	 * Displays information for all schools in the database
	 * the information displayed is different for admins and students
	 */
	public void viewSchoolList() {
		University[] universityList = this.DBCon.getUniversityList();
		if (this.account.account instanceof Admin) {
			// display list info for admins
		}
		else if (account.account instanceof Student) {
			// display school list for students
		}
	}
	
	/**
	 * The password for a specified user is changed to a random password. The new password is sent to the users email(username)
	 * @param userName
	 */
	public void forgotPassword(String userName) {
		if (!loggedIn ) {
			if (this.DBCon.checkUser()) {
			AccountController userAcc = new AccountController(this.DBCon.getAccount(userName));
			String rndPassword = userAcc.makeRandomPassword();
			userAcc.updatePassword(rndPassword);
			String message = "Hello " + this.DBCon.getAccount(userName).getFirstName() + " . Your password has been updated to " + rndPassword + ".";
			userAcc.sendEmail(message);
			}
			else {
				System.out.println("Invalid Username");
			}
		}
	}
	
	/**
	 * Returns a list of all details for a specified school 
	 * @param universityName
	 * @return
	 */
	public ArrayList<String> viewUniversityDetials(String universityName) {
		University university = this.DBCon.getUniversity(universityName);
		ArrayList<String> universityList = new ArrayList<String>();
		universityList.add(university.getName());
		universityList.add(university.getState());
		universityList.add(university.getLocation());
		universityList.add(university.getControl());
		universityList.add(university.getEnrollment());
		universityList.add(university.getPercentFemale());
		universityList.add(university.getSatVerbal());
		universityList.add(university.getSatMath());
		universityList.add(university.getEmphases());
		universityList.add(university.getPercentFinAid());
		universityList.add(university.getApplicants());
		universityList.add(university.getPercentAdmitted());
		universityList.add(university.getPercentEnrolled());
		universityList.add(university.getAcademicScale());
		universityList.add(university.getSocialScale());
		universityList.add(university.getQualityOfLife());
		
		return universityList;
	}
	
	/**
	 * Confirms that a password matches with the currently logged in user
	 * @param password
	 * @return
	 */
	public Boolean checkPassword(String password) {
		if (this.loggedIn) {
			if (this.account.checkPassword(password)) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
}
