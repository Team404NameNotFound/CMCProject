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
		fail("Not yet implemented");
	}

	@Test
	public void testRankUniversity() {
		ArrayList<University> result = searchCon.rankUniversity(dbCon.getUniversity("BARUCH"));
		ArrayList<University> expResults = new ArrayList();
		expResults.add(dbCon.getUniversity("ST JOHN'S UNIVERSITY"));
		expResults.add(dbCon.getUniversity("NEWYORK IT"));
		expResults.add(dbCon.getUniversity("FORDHAM"));
		expResults.add(dbCon.getUniversity("HOFSTRA"));
		expResults.add(dbCon.getUniversity("UNIVERSITY OF GEORGIA"));
		for(int i=0; i<result.size(); i++) {
			System.out.println(result.get(i).getName());
		}
		assertEquals("Additional recommended schools are "+result, expResults, result);
	}

}
