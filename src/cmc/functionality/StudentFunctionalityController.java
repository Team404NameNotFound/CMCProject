package cmc.functionality;
import java.util.ArrayList;
import cmc.entity.*;


/**
 * 
 * @author ajheroux
 *
 */
public class StudentFunctionalityController extends UserFunctionalityController {
	
	SearchController searchCon;
	//constructer
	public StudentFunctionalityController() {
		this.searchCon = new SearchController(this.DBCon.getUniversityList());
	}
	
	/**
	 * returns the five most similar universities to the specified university
	 * @param universityName
	 * @return
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
	 * @return
	 */
	public ArrayList<University> search(String schoolName, String state, String location, int numStudentsMin,
			int numStudentsMax, float percentFemaleMin, float percentFemaleMax, int SATVerbalMin, 
			int SATVerbalMax, int SATMatMin, int SATMathMax, int expensesMin, int expensesMax, 
			float PercentFinancialAidMin, float percenetFinancialAidMax, int numberApplicantsMin, 
			int numberApplicatnsMax, float percentAddmittedMin, float percentAdmittedMax,
			float percentEnrolledMin, float percentEnrolledMax, int academicScaleMin, int academicScaleMax,
			int socialScalemin, int socialScaleMax, int qualityOfLifeMin, int qualityOfLifeMax, String[] emphases) {
		
		
		Double[][] searchResults = this.searchCon.search(schoolName, state, location, numStudentsMin, 
				numStudentsMax, percentFemaleMin, percentFemaleMax, SATVerbalMin, 
				SATVerbalMax, SATMatMin, SATMathMax, expensesMin, expensesMax, 
				PercentFinancialAidMin, percenetFinancialAidMax, numberApplicantsMin, 
				numberApplicatnsMax, percentAddmittedMin, percentAdmittedMax, 
				percentEnrolledMin, percentEnrolledMax, academicScaleMin, academicScaleMax, 
				socialScalemin, socialScaleMax, qualityOfLifeMin, qualityOfLifeMax, emphases);
		return null;
	}
	
	//incomplete
	public ArrayList<University> viewSearchResults(){
		return null;
	}
	
	
	
	
	

}
