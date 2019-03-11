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
	AdminFunctionalityController AFCon;
	
	public AdminInteraction() {
		this.AFCon = new AdminFunctionalityController();
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
	public List<String > getUniversityInfo(University university){
		
	}
	
	public void editUniversityInfo(University university , List<String> changes){
		
	}
	
	public List<Student> viewUsers(){
		
	}
	
	public void cancelChanges() {
		
	}
	

}
