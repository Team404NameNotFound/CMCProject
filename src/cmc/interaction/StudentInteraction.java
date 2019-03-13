/**
 * 
 */
package cmc.interaction;

import java.util.List;

import cmc.entity.University;
import cmc.functionality.SearchController;
import cmc.functionality.StudentFunctionalityController;

/**
 * @author tzhang001
 *
 */
public class StudentInteraction extends AccountInteraction{

	StudentFunctionalityController sfCon;
	
	public StudentInteraction() {
		sfCon = new StudentFunctionalityController();
	}
	
	public void takeQuiz() {
		
		
	}
	/**
	 * Only test search for schools by the combination of state and number of students right now, 
     * for testing purposes, other parameters are setting as fixed number. 
	 * search should return University[] instead of Double[][]
	 * @param String state
	 * @param int numStudentsMin, minimal number of students
	 * @param int numStduentsMax, maximal number of students
	 */
	
	public void fieldSearch(String state, int numStudentsMin, int numStudentsMax) {
		if(sfCon.loggedIn) {
	    //sfCon.searchCon = new SearchController();
	    // do I need to make a new SearchController using DBController.getUniversityList() as a param?
		Double[][] matchSchools =  
				sfCon.searchCon.search("", state, "", numStudentsMin, numStudentsMax, 
				(float)0.0, (float)1.0, 0,1000,0,1000,0,1000000000,
				(float)0.0,(float)1.0,0,1000000000,(float)0.0,(float)1.0,
				(float)0.0,(float)1.0,0,10000,0,1000000,0,10000000, new String[] {"",""});
		 System.out.println(matchSchools.toString()); 
		}
		else {
			System.out.println("You have not logged in yet, cannot use the search field function");
		}
		
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
