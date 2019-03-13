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
	
	public AdminInteraction() {
		this.afCon = new AdminFunctionalityController();
	}
	
	public void addUser(String firstname, String lastname, String username, 
			String password, String userType, String userStatus) {
		
	}
	public void editUser(Student student, List<String> changes) {
		
	}
	public void toggleActivationStatus() {
		
	}
	
	public void removeUniversity(University university) {
		
	}
	
	public void addUniversity(
    String name, String state, String location, String control, String enrollment, String percentFemale,
	String satVerbal, String satMath, String cost, String percentFinAid, String percentEnrolled,
	String applicants, String percentAdmitted, String academicScale, String socialScale,
	String qualityOfLife, String[] emphases, ArrayList<Student> savedSchool) {
		
	}
	public void getUniversityInfo(University university){
		
	}
	
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
	
	public void cancelChanges() {
		
	}
	

}
