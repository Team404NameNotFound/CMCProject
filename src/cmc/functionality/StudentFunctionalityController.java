package cmc.functionality;
import java.util.ArrayList;
import cmc.entity.*;


/**
 * 
 * @author ajheroux
 *
 */
public class StudentFunctionalityController extends UserFunctionalityController {
	
	public SearchController searchCon;
	//constructer
	
	/**
	 * Creating a new StudentFunctionalityController
	 */
	public StudentFunctionalityController() {
		super();
		this.searchCon = new SearchController(this.DBCon.getUniversityList());
	}
	
	/**
	 * returns the five most similar universities to the specified university
	 * @param universityName
	 * @return rankedUniversities
	 */
	public ArrayList<University> rankUniversity(String universityName) {
		University uni = this.DBCon.getUniversity(universityName);
		ArrayList<University> rankedUniversities = this.searchCon.rankUniversity(uni);
		return rankedUniversities;
	}
	
	/**
	 * Generates search results for the fields provided and returns a list of matches based on search parameters.
	 * @param schoolName
	 * @param state
	 * @param location
	 * @param numStudentsMin
	 * @param numStudentsMax
	 * @param percentFemaleMin
	 * @param percentFemaleMax
	 * @param SATVerbalMin
	 * @param SATVerbalMax
	 * @param SATMatMin
	 * @param SATMathMax
	 * @param expensesMin
	 * @param expensesMax
	 * @param PercentFinancialAidMin
	 * @param percenetFinancialAidMax
	 * @param numberApplicantsMin
	 * @param numberApplicatnsMax
	 * @param percentAddmittedMin
	 * @param percentAdmittedMax
	 * @param percentEnrolledMin
	 * @param percentEnrolledMax
	 * @param academicScaleMin
	 * @param academicScaleMax
	 * @param socialScalemin
	 * @param socialScaleMax
	 * @param qualityOfLifeMin
	 * @param qualityOfLifeMax
	 * @param emphases
	 * @param control
	 * @return
	 */
	public ArrayList<University> search(String schoolName, String state, String location, int numStudentsMin,
			int numStudentsMax, float percentFemaleMin, float percentFemaleMax, int SATVerbalMin, 
			int SATVerbalMax, int SATMatMin, int SATMathMax, int expensesMin, int expensesMax, 
			float PercentFinancialAidMin, float percenetFinancialAidMax, int numberApplicantsMin, 
			int numberApplicatnsMax, float percentAddmittedMin, float percentAdmittedMax,
			float percentEnrolledMin, float percentEnrolledMax, int academicScaleMin, int academicScaleMax,
			int socialScalemin, int socialScaleMax, int qualityOfLifeMin, int qualityOfLifeMax, String[] emphases, String control) {
		
		
		ArrayList<University> searchResults = this.searchCon.fieldSearch(schoolName, state, location, numStudentsMin, 
				numStudentsMax, percentFemaleMin, percentFemaleMax, SATVerbalMin, 
				SATVerbalMax, SATMatMin, SATMathMax, expensesMin, expensesMax, 
				PercentFinancialAidMin, percenetFinancialAidMax, numberApplicantsMin, 
				numberApplicatnsMax, percentAddmittedMin, percentAdmittedMax, 
				percentEnrolledMin, percentEnrolledMax, academicScaleMin, academicScaleMax, 
				socialScalemin, socialScaleMax, qualityOfLifeMin, qualityOfLifeMax, emphases, control);
		return searchResults;
	}

	/**
	 * View a school's detail information
	 * @param universityName
	 */
	public void viewSchoolDetails(String universityName) {
		this.universityCon = new UniversityController(this.DBCon.getUniversity2(universityName));
		System.out.println(this.universityCon.getSchoolDetails());
		
	}
	
	/**
	 * Save a school for current user
	 * @param school
	 */
	public void saveSchool(String school) {
//	this.account = new AccountrController(this.DBCon.getAccount());
		this.account.saveSchool(school);
		this.DBCon.getUniversity2(school).addStudent(this.account.account.getUsername());
		
	}
	
	/**
	 * View current user's saved schools list
	 */
	public void viewSavedSchools() {
		if(this.account.account.getUserType().equals("a")) {
			System.out.println("Current account cannot view saved schools because it is an admin");
		}else {
			this.account.viewSavedSchools();
		}
	}
	
	/**
	 * Remove a school from the saved schools list
	 * @param school String, the name of school to remove
	 */
	public void removeSavedSchool(String school) {
		this.account.removeSavedSchool(school);
	}
	
	/**
	 * View a saved school's detail information
	 * @param school String, saved school name to view details
	 */
	public void viewSavedSchoolDetails(String school) {
		Boolean schoolSaved = this.account.checkIfSchoolSaved(school);
		if(schoolSaved) {
		   this.setUniversityCon(new UniversityController(this.DBCon.getUniversity2(school)));
		   System.out.println(this.universityCon.getSchoolDetails());
		}else {
			System.out.println("This school is not saved");
		}
	}

	/**
	 * View how many times a school being saved by users
	 * @param school
	 */
	public void viewUserSavedStatistics(String school){
		int savedTimes = this.DBCon.getUserSavedStatistics(school);
		System.out.println(school + " has been saved for " + savedTimes + " times");
	}

	/**
	 * Compare saved schools with their required SatMath scores
	 */
	public void compareSchoolsByScore( ) {
		this.account.compareSchoolsByScore();
	}
}
