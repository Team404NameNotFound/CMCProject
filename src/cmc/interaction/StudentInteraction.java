/**
 * 
 */
package cmc.interaction;

import java.util.ArrayList;
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
	
	public void fieldSearch(String schoolName, String state, String location, int numStudentsMin,
			int numStudentsMax, float percentFemaleMin, float percentFemaleMax, int SATVerbalMin, 
			int SATVerbalMax, int SATMathMin, int SATMathMax, int expensesMin, int expensesMax, 
			float PercentFinancialAidMin, float percenetFinancialAidMax, int numberApplicantsMin, 
			int numberApplicatnsMax, float percentAddmittedMin, float percentAdmittedMax,
			float percentEnrolledMin, float percentEnrolledMax, int academicScaleMin, int academicScaleMax,
			int socialScalemin, int socialScaleMax, int qualityOfLifeMin, int qualityOfLifeMax, String[] emphases
			) {
		if(sfCon.loggedIn) {
	    //sfCon.searchCon = new SearchController();
	    // do I need to make a new SearchController using DBController.getUniversityList() as a param?
		ArrayList<University> matchSchools =  
				sfCon.searchCon.search( schoolName,  state,  location,  numStudentsMin,
						 numStudentsMax,  percentFemaleMin,  percentFemaleMax,  SATVerbalMin, 
						 SATVerbalMax,  SATMathMin,  SATMathMax,  expensesMin,  expensesMax, 
						 PercentFinancialAidMin,  percenetFinancialAidMax,  numberApplicantsMin, 
						 numberApplicatnsMax,  percentAddmittedMin,  percentAdmittedMax,
						 percentEnrolledMin,  percentEnrolledMax,  academicScaleMin,  academicScaleMax,
						 socialScalemin,  socialScaleMax,  qualityOfLifeMin,  qualityOfLifeMax,  emphases
						);
		 for(int i = 0; i<10;i++)
		 {
			 System.out.println(matchSchools.get(i));
		 }
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
