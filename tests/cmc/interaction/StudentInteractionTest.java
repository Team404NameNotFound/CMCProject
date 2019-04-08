package cmc.interaction;

import static org.junit.Assert.*;

import java.util.ArrayList;

import javax.xml.transform.Result;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cmc.entity.Account;
import cmc.entity.University;
import cmc.entity.UserSavedSchool;
import cmc.functionality.AccountController;
import cmc.functionality.DBController;
import cmc.functionality.SearchController;
import cmc.functionality.StudentFunctionalityController;
import cmc.functionality.UserFunctionalityController;

public class StudentInteractionTest {
	
	private DBController dbCon = new DBController();
	private StudentInteraction student = new StudentInteraction();
	private String[] emphases = null;
	private University school = new University("BROWN", "RHODEISLAND", "URBAN", "PRIVATE", "10000", "50", "625", "650", "36450", "40", "20", "50", "11500", "5", "4", "5", emphases);
	private AccountController user =  new AccountController(dbCon.getAccount("kmendel001@csbsju.edu"));
	@Before
	public void setUp() throws Exception {
		StudentInteraction student = new StudentInteraction();
		this.student.sfCon.setAccount(user);
		user.removeAllSavedSchools();
		
	}
	
	@After
	public void shutDown() throws Exception{
		student.logout();
	}

	//good
	@Test
	public void testViewSchoolDetailsValidSchool() {
		ArrayList<String> expResult = new ArrayList<String>();
		expResult.add("BROWN");
		expResult.add("RHODEISLAND");
		expResult.add("URBAN"); 
		expResult.add("PRIVATE");
		expResult.add("10000");
		expResult.add("50");
		expResult.add("625");
		expResult.add("650");
		expResult.add("36450");
		expResult.add("40");
		expResult.add("20");
		expResult.add("50");
		expResult.add("11500");
		expResult.add("5");
		expResult.add("4");
		expResult.add("5");
		assertEquals(expResult, student.viewSchoolDetails(school.getName()));
		
	}
	
	//good
	@Test(expected=IllegalArgumentException.class)
	public void testViewSchoolDetailsInvalidSchool() {
		ArrayList<String> expResult = new ArrayList<String>();
		expResult.add("FAKEVILLE COLLEGE");
		expResult.add("RHODEISLAND");
		expResult.add("URBAN"); 
		expResult.add("PRIVATE");
		expResult.add("10000");
		expResult.add("50");
		expResult.add("625");
		expResult.add("650");
		expResult.add("36450");
		expResult.add("40");
		expResult.add("20");
		expResult.add("50");
		expResult.add("11500");
		expResult.add("5");
		expResult.add("4");
		expResult.add("5");
		student.viewSchoolDetails("FAKEVILLE COLLEGE");
	}

	//good
	@Test (expected = IllegalArgumentException.class) 
	public void testTakeQuizNotAllQuestionsAnswered() {
		String location = "URBAN";
		String characteristic = "Social"; 
		String control = ""; 
		student.takeQuiz(location, characteristic, control, emphases);
	}
	
	//good
	@Test
	public void testTakeQuizAcademicBranch() {
		String location = "URBAN";
		String characteristic = "academic"; 
		String control = "PRIVATE"; 
		String[] emphasis = new String[1];
		emphasis[0] = "BIOLOGY";
		ArrayList<String> results = new ArrayList<String>();
		ArrayList<University> list = student.takeQuiz(location, characteristic, control, emphasis);
		for(University uni: list) {
			results.add(uni.getName());
		}
		ArrayList<String> expResults = new ArrayList<String>();
		expResults.add("BARNARD");
		expResults.add("BROWN");
		expResults.add("CLARK UNIVERSITY");
		expResults.add("EMORY");
		expResults.add("HARVARD");
		expResults.add("JOHNS HOPKINS");
		expResults.add("UNIVERSITY OF ROCHESTER");
		expResults.add("UNIVERSITY OF SOUTHERN CALIFORNIA");
		assertEquals(expResults, results);	
	}
	
	//good
	@Test
	public void testTakeQuizSocialBranch() {
		String location = "URBAN";
		String characteristic = "social"; 
		String control = "PRIVATE"; 
		String[] emphasis = new String[1];
		emphasis[0] = "BIOLOGY";
		ArrayList<String> results = new ArrayList<String>();
		ArrayList<University> list = student.takeQuiz(location, characteristic, control, emphasis);
		for(University uni: list) {
			results.add(uni.getName());
		}
		ArrayList<String> expResults = new ArrayList<String>();
		expResults.add("BROWN");
		expResults.add("EMORY");
		expResults.add("UNIVERSITY OF SOUTHERN CALIFORNIA");
		assertEquals(expResults, results);
	}
	
	//good
	@Test
	public void testTakeQuizQualityOfLifeBranch() {
		String location = "URBAN";
		String characteristic = "qualityOfLife"; 
		String control = "PRIVATE"; 
		String[] emphasis = new String[1];
		emphasis[0] = "BIOLOGY";
		ArrayList<String> results = new ArrayList<String>();
		ArrayList<University> list = student.takeQuiz(location, characteristic, control, emphasis);
		for(University uni: list) {
			results.add(uni.getName());
		}
		ArrayList<String> expResults = new ArrayList<String>();
		expResults.add("BARNARD");
		expResults.add("BROWN");
		expResults.add("EMORY");
		expResults.add("HARVARD");
		assertEquals(expResults, results);
	}
	
	//good
	@Test(expected=NullPointerException.class)
	public void testTakeQuizNullEmphases() {
		String location = "URBAN";
		String characteristic = "qualityOfLife"; 
		String control = "PRIVATE"; 
		student.takeQuiz(location, characteristic, control, emphases);
	}
	
	//good
	@Test
	public void testTakeQuizNoEmphases() {
		String location = "URBAN";
		String characteristic = "qualityOfLife"; 
		String control = "PRIVATE"; 
		String[] emphasis = new String[1];
		emphasis[0] = "";
		ArrayList<String> results = new ArrayList<String>();
		ArrayList<University> list = student.takeQuiz(location, characteristic, control, emphasis);
		for(University uni: list) {
			results.add(uni.getName());
		}
		ArrayList<String> expResults = new ArrayList<String>();
		assertEquals(expResults, results);
	}

	@Test
	public void testFieldSearch() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindRecommended() {
		fail("Not yet implemented");
	}

	//good
	@Test
	public void testSaveSchoolValidSchool() {
		Account user1 = dbCon.getAccount("kmendel001@csbsju.edu");
		user1.setUserStatus("Y");
		dbCon.setAccount(user1);
		student.login("kmendel001@csbsju.edu", "user");
		student.saveSchool("AUGSBURG");
		ArrayList<UserSavedSchool> result = dbCon.getSchoolList2(dbCon.getAccount("kmendel001@csbsju.edu"));
		student.removeSavedSchool("AUGSBURG");
		ArrayList<String> expResult = new ArrayList();
		expResult.add("AUGSBURG");
		expResult.add("BENNINGTON");
		expResult.add("YALE");
		assertEquals("SavedSchools are now"+result, expResult, result);
		
//		Boolean same = true;
//		for(int i=0; i<schools.size(); i++)
//		{
//			System.out.println(schools.get(i).getName() + " " +expSchools.get(i));
//			if(!schools.get(i).getName().equals(expSchools.get(i)))
//				same = false;
//		}
//		assertTrue(same);
	}
	
	//good
	@Test(expected=IllegalArgumentException.class)
	public void testSaveSchoolAlreadySaved() {
		student.login("kmendel001@csbsju.edu", "user");
		student.saveSchool("YALE");
		student.saveSchool("YALE");
	}

	//good
	@Test(expected=IllegalArgumentException.class)
	public void testSaveSchoolInvalidSchool() {
		student.login("kmendel001@csbsju.edu", "user");
		student.saveSchool("FAKE COLLEGE");
	}
	

	//BAD
	@Test
	public void testViewSavedSchoolDetails() {
		student.login("kmendel001@csbsju.edu", "user");
		student.saveSchool("BROWN");
		student.viewSavedSchoolDetails("BROWN"); //null pointer
		//should get time stamp
		ArrayList<String> results = new ArrayList();
		ArrayList<String> expResult = new ArrayList();
		expResult.add("BROWN");
		expResult.add("RHODEISLAND");
		expResult.add("URBAN"); 
		expResult.add("PRIVATE");
		expResult.add("10000");
		expResult.add("50");
		expResult.add("625");
		expResult.add("650");
		expResult.add("36450");
		expResult.add("40");
		expResult.add("20");
		expResult.add("50");
		expResult.add("11500");
		expResult.add("5");
		expResult.add("4");
		expResult.add("5");
		expResult.add("ARTS-AND-SCIENCES");
		expResult.add("BIOLOGY");
		expResult.add("HISTORY");
		
		assertEquals("Saved school details are"+ results, expResult, results);
		
//		Boolean same = false;
//		for(int i=0; i<results.size(); i++)
//		{
//			if(results.get(i).equals(expResult.get(i)))
//			{
//				same = true;
//			}
//		}
//		assertTrue(same);
	}
	
	//BAD
	@Test(expected=IllegalArgumentException.class)
	public void testViewSavedSchoolDetailsSchoolNotSaved() {
		student.login("kmendel001@csbsju.edu", "user");
		student.viewSavedSchoolDetails("HARVARD");
		
	}
	
	//BAD
	@Test(expected=UnsupportedOperationException.class)
	public void testViewSavedSchoolInvalidSchool() {
		student.login("kmendel001@csbsju.edu", "user");
		student.viewSavedSchoolDetails("FAKE COLLEGE");
	}

	//BAD
	@Test
	public void testViewSavedSchools() {
		student.login("kmendel001@csbsju.edu", "user");
		student.saveSchool("AUGSBURG");
		student.saveSchool("BENNINGTON");
		student.saveSchool("YALE");
		ArrayList<UserSavedSchool> result = student.viewSavedSchools();
		ArrayList<String> expResult = new ArrayList();
		expResult.add("AUGSBURG");
		expResult.add("BENNINGTON");
		expResult.add("YALE");
		
		assertEquals("Saved schools are "+result, expResult, result);
//		Boolean same = true;
//		for(int i=0; i<schools.size(); i++)
//		{
//			System.out.println(schools.get(i).getName() + " " +expSchools.get(i));
//			if(!schools.get(i).getName().equals(expSchools.get(i)))
//				same = false;
//		}
//		assertTrue(same);
	}

	//BAD
	@Test
	public void testViewUserSavedStatisticsValidUserValidSchools() {
		student.login("kmendel001@csbsju.edu", "user");
		student.saveSchool("AUGSBURG");
		student.saveSchool("BENNINGTON");
		student.saveSchool("YALE");
		String[] results = student.viewUserSavedStatistics("YALE");
		ArrayList<String> expResults = new ArrayList();
		expResults.add("YALE 2");
		
		assertEquals("Saved schools are "+results, expResults, results);
		
//		Boolean same = true;
//		for(int i=0; i<results.size(); i++)
//		{
//			if(!results.get(i).equals(expResults.get(i)))
//			{
//				same = false;
//			}
//		}
//		assertTrue(same);
	}
	
	//BAD
	@Test(expected=UnsupportedOperationException.class)
	public void testViewUserSavedStatisticsInvalidUserNoSchools() {
		student.login("user@csbsju.edu", "user");
		student.compareSchoolsByScore();
	}
	
	//BAD
	@Test(expected=UnsupportedOperationException.class)
	public void testViewUserSavedStatisticsValidUserNoSchools() {
		student.login("user@csbsju.edu", "user");
		student.compareSchoolsByScore();
	}

	//good
	@Test
	public void testGetSfCon() {
		StudentFunctionalityController expResult = student.sfCon;
		StudentFunctionalityController result = student.getSfCon();
		assertEquals(result, expResult);
	}

	//good
	@Test
	public void testSetSfCon() {
		StudentFunctionalityController sfCon1 = new StudentFunctionalityController();
		student.setSfCon(sfCon1);
		StudentFunctionalityController expResult = student.sfCon;
		StudentFunctionalityController result = sfCon1;
		assertEquals(result, expResult);
	}

	//BAD
	@Test(expected=IllegalArgumentException.class)
	public void testRemoveSavedSchoolNotSaved() {
		student.login("kmendel001@csbsju.edu", "user");
		student.removeSavedSchool("HARVARD");
	}	
	
	//BAD
	@Test(expected=UnsupportedOperationException.class)
	public void testRemoveSavedSchoolInvalidSchool() {
		student.login("kmendel001@csbsju.edu", "user");
		student.removeSavedSchool("FAKE COLLEGE");
	}
	
	//good
	@Test
	public void testRemoveSavedSchoolValidSchool() {
		student.login("kmendel001@csbsju.edu", "user");
		student.saveSchool("AUGSBURG");
		student.removeSavedSchool("AUGSBURG");
		assertTrue(!dbCon.getSchoolList2(dbCon.getAccount("kmendel001@csbsju.edu")).contains(dbCon.getUniversity2("AUGSBURG")));
	}

	//BAD
	@Test(expected=UnsupportedOperationException.class)
	public void testCompareSchoolsByScoreNoSavedSchools() {
		student.login("irahal@csbsju.edu", "bqv6x");
		student.compareSchoolsByScore();
	}
	
	//BAD
	@Test
	public void testCompareSchoolsByScoreManySaved() {
		student.login("kmendel001@csbsju.edu", "user"); 
		student.saveSchool("AUGSBURG");
		student.saveSchool("BENNINGTON");
		student.saveSchool("YALE");
		
		ArrayList<String> result = student.compareSchoolsByScore();
		ArrayList<String> expResult = new ArrayList();
		expResult.add("AUGSBURG 490.0");
		expResult.add("Yale 675.0");
		assertEquals("Compared schools are"+result, expResult, result);
//		Boolean same = true;
//		for(int i=0; i<result.size(); i++)
//		{
//			if(!result.get(i).equals(expResult.get(i)))
//			{
//				same = false;
//			}
//		}
//		assertTrue(same);
	}
	
	//BAD
	@Test
	public void testCompareSchoolsByScoreNoSchoolsWithValidScore() {
		//create new user with all -1 schools
		fail("not yet implemented");
	}
	
	//good
	@Test(expected=IllegalArgumentException.class)
	public void testEditUserFirstNameBlank() {
		student.login("irahal@csbsju.edu", "bqv6x");
		student.editProfile("irahal@csbsju.edu", "", "Rahal", "password");
	}
	
	//good
	@Test(expected=IllegalArgumentException.class)
	public void testEditUserLastNameBlank() {
		student.login("irahal@csbsju.edu", "bqv6x");
		student.editProfile("irahal@csbsju.edu", "Imad", "", "password");
	}

	//good
	@Test(expected=IllegalArgumentException.class)
	public void testEditUserPasswordBlank() {
		student.login("irahal@csbsju.edu", "bqv6x");
		student.editProfile("irahal@csbsju.edu", "Imad", "Rahal", "");
	}
	
	//good
	@Test
	public void testEditUserValidInputs() {
		student.login("user@csbsju.edu", "user");
		student.editProfile("user@csbsju.edu", "No", "Schools", "user");
		Account result = dbCon.getAccount("user@csbsju.edu");
		Account expResult = new Account("No", "Schools", "user@csbsju.edu", "user", "u", "Y");
		assertEquals(result.toString(), expResult.toString());
	}
	
}
