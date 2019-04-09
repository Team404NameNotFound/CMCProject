package cmc.functionality;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import cmc.entity.University;

public class SearchControllerTest {
	private DBController dbCon = new DBController();
	private ArrayList<University> allSchools = dbCon.getUniversityList();
	private SearchController searchCon= new SearchController(allSchools);
	
	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void testGetQuizQuestions() {
		String expResult = "How would you describe the location of your ideal college?" + 
				"Which characteristics are most important to you when looking for a college" + 
				"I prefer large lectures where I can observe and be anonymous, rather than small discussions with participation and my professors know my name " +
		"Do you know what you would like to study?";
		String result = "";
		String[] questions = searchCon.getQuizQuestions();
		for(int i=0; i<questions.length; i++)
		{
			result += questions[i];
		}
		assertEquals(result, expResult);
	}

	@Test
	public void testFieldSearch() {
		String schoolName = "BROWN";
		String state = "RHODEISLAND";
		String location = "URBAN";
		int numStudentsMin = -1;
		int numStudentsMax = -1;
		float percentFemaleMin = -1; 
		float percentFemaleMax = -1;
		int SATVerbalMin = -1; 
		int SATVerbalMax = -1;
		int SATMathMin = -1;
		int SATMathMax = -1; 
		int expensesMin = -1; 
		int expensesMax = -1;
		float PercentFinancialAidMin = -1;
		float percenetFinancialAidMax = -1;
		int numberApplicantsMin = -1;
		int numberApplicatnsMax = -1;
		float percentAddmittedMin = -1;
		float percentAdmittedMax = -1;
		float percentEnrolledMin = -1;
		float percentEnrolledMax = -1;
		int academicScaleMin = -1;
		int academicScaleMax =-1;
		int socialScaleMin = -1;
		int socialScaleMax = -1 ;
		int qualityOfLifeMin = -1; 
		int qualityOfLifeMax = -1;
		String[] emphases = new String[0];
		String control = "-1";
		ArrayList<University> result = searchCon.fieldSearch(schoolName, state, location, numStudentsMin, numStudentsMax, percentFemaleMin
				, percentFemaleMax, SATVerbalMin, SATVerbalMax, SATMathMin, SATMathMax, expensesMin, expensesMax
				, PercentFinancialAidMin, percenetFinancialAidMax, numberApplicantsMin, numberApplicatnsMax
				, percentAddmittedMin, percentAdmittedMax, percentEnrolledMin, percentEnrolledMax, academicScaleMin
				, academicScaleMax, socialScaleMin, socialScaleMax, qualityOfLifeMin, qualityOfLifeMax, emphases
				, control);
		
		ArrayList<University> expResult = new ArrayList();
		expResult.add(dbCon.getUniversity("BROWN"));
		for(int i=0; i<result.size(); i++)
		{
			System.out.print(result.get(i).getName());
			assertEquals(result.get(i).getName(), expResult.get(i).getName());
		}
	}

	//@Test
	public void testRankUniversity2() {
		ArrayList<University> result = searchCon.rankUniversity2(dbCon.getUniversity("BARUCH"));
		ArrayList<University> expResults = new ArrayList();
		expResults.add(dbCon.getUniversity("FORDHAM"));
		expResults.add(dbCon.getUniversity("UNIVERSITY OF LOWELL"));
		expResults.add(dbCon.getUniversity("SAN JOSE STATE"));
		expResults.add(dbCon.getUniversity("ORAL ROBERTS UNIVERSITY"));
		expResults.add(dbCon.getUniversity("WILLIAM PATERSON COLLEGE"));

		for(int i=0; i<result.size(); i++) {
			System.out.println(result.get(i).getName());
		}
		assertEquals("Additional recommended schools are "+result, expResults, result);
	}

}
