/**
 * 
 */
package cmc.interaction;

import java.util.List;

import cmc.entity.University;
import cmc.functionality.StudentFunctionalityController;

/**
 * @author tzhang001
 *
 */
public class StudentInteraction extends AccountInteraction{

	/**
	 * 
	 */
	StudentFunctionalityController SFCon;
	
	public StudentInteraction() {
		SFCon = new StudentFunctionalityController();
	}
	
	public void takeQuiz() {
		
	}
	
	public void fieldSearch() {
		
	}
	
	public void viewSavedSchools() {
		
	}

	public void viewSchoolDetails(String universityName) {
		
	}
	
	public void viewProfile(String username) {
		
	}
	
	public void editProfile(List<String> changes) {
		
	}
	
	public void saveSchool(University university) {
		
	}
	
	public void compareSchools(List<University> schoolList){
		
	}
	
	public void removeSavedSchool(University removedSchool) {
		
	}
	//what does this function do???????
	public void passRespnses(String password) {
		
	}
	
	public void viewUserSaveStatistics(University university) {
		
	}
	
	
	
	

}
