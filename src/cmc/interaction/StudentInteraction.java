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
	 * 
	 */
	public StudentInteraction() {
		super();
		sfCon = new StudentFunctionalityController();
	}
	
	/**
	 * @param location
	 * @param characteristic
	 * @param control
	 * @param emphasis
	 */
	public void takeQuiz(String location, String characteristic ,String control ,String[] emphasis) {
		if (characteristic.equals("academic"))
		{
			fieldSearch("", "", location, -1,
					-1, -1, -1, -1, 
					-1, -1, -1, -1, -1, 
					-1, -1, -1, 
					1, -1, -1,
					-1, -1, 4, -1,
					-1, -1, -1, -1, emphasis,
					control);
		}
		else if (characteristic.equals("social"))
		{
			fieldSearch("", "", location, -1,
					-1, -1, -1, -1, 
					-1, -1, -1, -1, -1, 
					-1, -1, -1, 
					1, -1, -1,
					-1, -1, -1, -1,
					4, -1, -1, -1, emphasis,
					control);
		}
		else if (characteristic.equals("qualityOfLife"))
		{
			fieldSearch("", "", location, -1,
					-1, -1, -1, -1, 
					-1, -1, -1, -1, -1, 
					-1, -1, -1, 
					1, -1, -1,
					-1, -1, -1, -1,
					-1, -1, 4, -1, emphasis,
					control);
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
				sfCon.searchCon.search( schoolName,  state,  location,  numStudentsMin,
						 numStudentsMax,  percentFemaleMin,  percentFemaleMax,  SATVerbalMin, 
						 SATVerbalMax,  SATMathMin,  SATMathMax,  expensesMin,  expensesMax, 
						 PercentFinancialAidMin,  percenetFinancialAidMax,  numberApplicantsMin, 
						 numberApplicatnsMax,  percentAddmittedMin,  percentAdmittedMax,
						 percentEnrolledMin,  percentEnrolledMax,  academicScaleMin,  academicScaleMax,
						 socialScalemin,  socialScaleMax,  qualityOfLifeMin,  qualityOfLifeMax,  emphases, control
						);
		 for(int i = 0; i<10;i++)
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
	public void findRecommended(University schoolToCompare)
	{
		ArrayList<University> closeMatch = sfCon.rankUniversity(schoolToCompare.getName());
		for(int i = 0; i<5; i++)
		{
			System.out.println(closeMatch.get(i).getName());
		}
	}
	public void saveSchool(String school) { 
		this.sfCon.saveSchool(school);
	}
	
	/* (non-Javadoc)
	 * @see cmc.interaction.AccountInteraction#viewSchoolDetails(java.lang.String)
	 */
	public void viewSchoolDetails(String universityName) {
		this.sfCon.viewSchoolDetails(universityName);
	}
	
	/**
	 * @param school
	 */
//	public void viewSavedSchoolDetails(String school) {
//		Boolean found = false;
//		for(University savedUni : this.sfCon.viewSavedSchools()) {
//			if(savedUni.getName().equals(school)) {
//				found = true;
//				this.sfCon.viewSchoolDetails(school);
//			}
//		}
//		if(!found) System.out.println("Cannot found " + school +  " in saved school list");
//		
//	}
	
	/**
	 * 
	 */
	public void viewSavedSchools() {
		this.sfCon.viewSavedSchools();
	}
	
	public void viewUserSavedStatistics(String school) {
		this.sfCon.viewUserSavedStatistics(school);
	}
	
	

	/**
	 * @return the sfCon
	 */
	public StudentFunctionalityController getSfCon() {
		return sfCon;
	}

	/**
	 * @param sfCon the sfCon to set
	 */
	public void setSfCon(StudentFunctionalityController sfCon) {
		this.sfCon = sfCon;
	}
	
	/**
	 * @param school
	 */
	public void removeSavedSchool(String school) {
		this.sfCon.removeSavedSchool(school);
	}
	
	public void compareSchoolsByScore(String username) {
		sfCon.compareSchoolsByScore(username);
		
	}

	
	

}
