/**
 * 
 */
package cmc.interaction;

import java.util.ArrayList;
import java.util.List;

import cmc.entity.Student;
import cmc.entity.University;
import cmc.functionality.AdminFunctionalityController;

/**
 * @author tzhang001
 *
 */
public class AdminInteraction extends AccountInteraction{

	/**
	 * 
	 */
	AdminFunctionalityController afCon;
	
	//constructer
	public AdminInteraction() {
		this.afCon = new AdminFunctionalityController();
	}
	
	/**
	 * Adds a new user to the database
	 * @param firstname
	 * @param lastname
	 * @param username
	 * @param password
	 * @param userType
	 * @param userStatus
	 */
	public void addUser(String firstname, String lastname, String username, 
			String password, String userType, String userStatus) {
		
	}
	
	/**
	 * Edits the specified user with the list of changes
	 * @param student
	 * @param changes
	 */
	public void editUser(Student student, List<String> changes) {
		
	}
	
	/**
	 * Changes the status of the specified user
	 * @param account
	 */
	public void toggleActivationStatus(String account) {
		
	}
	
	/**
	 * Removes the specified user form the database
	 * @param university
	 */
	public void removeUniversity(University university) {
		
	}
	
	/**
	 * Adds a new university to the database with the given parameters
	 * @param name
	 * @param state
	 * @param location
	 * @param control
	 * @param enrollment
	 * @param percentFemale
	 * @param satVerbal
	 * @param satMath
	 * @param cost
	 * @param percentFinAid
	 * @param percentEnrolled
	 * @param applicants
	 * @param percentAdmitted
	 * @param academicScale
	 * @param socialScale
	 * @param qualityOfLife
	 * @param emphases
	 * @param savedSchool
	 */
	public void addUniversity(
    String name, String state, String location, String control, String enrollment, String percentFemale,
	String satVerbal, String satMath, String cost, String percentFinAid, String percentEnrolled,
	String applicants, String percentAdmitted, String academicScale, String socialScale,
	String qualityOfLife, String[] emphases, ArrayList<Student> savedSchool) {
		
	}
	
	/**
	 * Gets complete information for the specified university
	 * @param university
	 */
	public void getUniversityInfo(University university){
		
	}
	
	/**
	 * Edits the specified university with the list of changes
	 * @param university
	 * @param changes
	 */
	public void editUniversityInfo(University university , List<String> changes){
		
	}
	
	/**
	 * Admin view a list of users, if no logged in print error message
	 */
	public void viewUsers(){
		if(afCon.loggedIn) {
			System.out.println(this.afCon.viewUsers().toString());
		}
		else {
			System.out.println("You have not logged in yet, cannot view universities");
		}
		
	}
	
	/**
	 * Admin view a list of users, if no logged in print error message
	 */
	public void viewUniversities() {
		if(afCon.loggedIn) {
			System.out.println(this.afCon.viewUniversities().toString());
		}
		else {
			System.out.println("You have not logged in yet, cannot view universities");
		}
	}
	
	/**
	 * Cancels changes to be made a university
	 */
	public void cancelChanges() {
		
	}
	

}
