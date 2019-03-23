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
	
	/**
	 * Create a new StudentInteraction
	 */
	public StudentInteraction() {
		super();
		sfCon = new StudentFunctionalityController();
	}
	
	/**
	 * Student take the personal quiz
	 * @param location
	 * @param characteristic
	 * @param control
	 * @param emphasis
	 */
	public void takeQuiz(String location, String characteristic ,String control ,String[] emphasis) {
		ArrayList<University> personalMatches = new ArrayList<University>();
		
		if(location == null || control == null || characteristic == null )
		{
			System.out.println("Sorry, you must input all paramters");
		}
		else
		{
		 if(characteristic.equals("academic"))
		{
			
			personalMatches = sfCon.search( "", "-1", location, -1,
					-1, (float)-1.0,(float)-1.0, -1, 
					-1, -1, -1, -1, -1, 
					(float)-1.0, (float)-1.0, -1, 
					-1, (float)-1.0, (float)-1.0,
					(float)-1.0, (float)-1.0,3, -1,
					-1, -1, -1, -1, emphasis, control
					);
		}
		else if (characteristic.equals("social"))
		{
			personalMatches = sfCon.search( "", "-1", location, -1,
					-1, (float)-1.0,(float)-1.0, -1, 
					-1, -1, -1, -1, -1, 
					(float)-1.0, (float)-1.0, -1, 
					-1, (float)-1.0, (float)-1.0,
					(float)-1.0, (float)-1.0,-1, -1,
					3, -1, -1, -1, emphasis, control
					);
		}
		else if (characteristic.equals("qualityOfLife"))
		{
			personalMatches = sfCon.search("", "-1", location, -1,
					-1, (float)-1.0,(float)-1.0, -1, 
					-1, -1, -1, -1, -1, 
					(float)-1.0, (float)-1.0, -1, 
					-1, (float)-1.0, (float)-1.0,
					(float)-1.0, (float)-1.0,-1, -1,
					-1, -1, 3, -1, emphasis, control
					);
		}

		}
		
		for(int i = 0; i < personalMatches.size(); i++)
		{
			System.out.println("Match: " + personalMatches.get(i).getName());
			
		}
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
			int socialScalemin, int socialScaleMax, int qualityOfLifeMin, int qualityOfLifeMax, String[] emphases,
			String control) {
		if(!sfCon.loggedIn) {
	    //sfCon.searchCon = new SearchController();
	    // do I need to make a new SearchController using DBController.getUniversityList() as a param?
		ArrayList<University> matchSchools =  
				sfCon.search( schoolName,  state,  location,  numStudentsMin,
						 numStudentsMax,  percentFemaleMin,  percentFemaleMax,  SATVerbalMin, 
						 SATVerbalMax,  SATMathMin,  SATMathMax,  expensesMin,  expensesMax, 
						 PercentFinancialAidMin,  percenetFinancialAidMax,  numberApplicantsMin, 
						 numberApplicatnsMax,  percentAddmittedMin,  percentAdmittedMax,
						 percentEnrolledMin,  percentEnrolledMax,  academicScaleMin,  academicScaleMax,
						 socialScalemin,  socialScaleMax,  qualityOfLifeMin,  qualityOfLifeMax,  emphases, control
						);
		 for(int i = 0; i<matchSchools.size();i++)
		 {
			 System.out.println(matchSchools.get(i).getName());
		 }
		}
		else {
			System.out.println("You have not logged in yet, cannot use the search field function");
		}
		
	}
	
	/**
	 * Returns the five most similar schools to the specified school
	 * @param schoolToCompare
	 */
	public void findRecommended(String schoolToCompare)
	{
		ArrayList<University> closeMatch = sfCon.rankUniversity(schoolToCompare);
		for(int i = 0; i<5; i++)
		{
			System.out.println(closeMatch.get(i).getName());
		}
	}
	
	/**
	 * User save a school
	 * @param school
	 */
	public void saveSchool(String school) { 
		this.sfCon.saveSchool(school);
	}

	
	/**
	 * View a specific school's detail information
	 */
	public void viewSchoolDetails(String universityName) {
		this.sfCon.viewSchoolDetails(universityName);
	}
	
	/**
	 * View a specific saved school's detail information
	 * @param school
	 */
	public void viewSavedSchoolDetails(String school) {
		this.sfCon.viewSavedSchoolDetails(school);
	}
	
	/**
	 * View all the schools on current use's saved school list
	 */
	public void viewSavedSchools() {
		this.sfCon.viewSavedSchools();
	}
	
	/**
	 * View how many times that a school is being saved by users
	 * @param school
	 */
	public void viewUserSavedStatistics(String school) {
		this.sfCon.viewUserSavedStatistics(school);
	}
	
	

	/**
	 * Get the current StudentFunctionalityController
	 * @return the sfCon
	 */
	public StudentFunctionalityController getSfCon() {
		return sfCon;
	}

	/**
	 * Set the current StudentFunctionalityController
	 * @param sfCon the sfCon to set
	 */
	public void setSfCon(StudentFunctionalityController sfCon) {
		this.sfCon = sfCon;
	}

	/**
	 * Remove a school from user's saved schools list
	 * @param school
	 */
	public void removeSavedSchool(String school) {
		this.sfCon.removeSavedSchool(school);
	}
	
	/**
	 * Compare saved school with their Sat Math Scores
	 */
	public void compareSchoolsByScore() {
		sfCon.compareSchoolsByScore();
		
	}

	
	

}
