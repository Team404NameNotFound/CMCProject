package cmc.interaction;

import static org.junit.Assert.*;

import java.util.ArrayList;

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
	
	@Before
	public void setUp() throws Exception {
		StudentInteraction student = new StudentInteraction();
		
	}
	
	@After
	public void shutDown() throws Exception{
		student.logout();
	}

//	@Test
//	public void testViewSchoolDetailsValidSchool() {
//		ArrayList<String> expResult = new ArrayList<String>();
//		expResult.add("BROWN");
//		expResult.add("RHODEISLAND");
//		expResult.add("URBAN"); 
//		expResult.add("PRIVATE");
//		expResult.add("10000");
//		expResult.add("50");
//		expResult.add("625");
//		expResult.add("650");
//		expResult.add("36450");
//		expResult.add("40");
//		expResult.add("20");
//		expResult.add("50");
//		expResult.add("11500");
//		expResult.add("5");
//		expResult.add("4");
//		expResult.add("5");
//		assertEquals(expResult, student.viewSchoolDetails(school.getName()));
//		
//	}
//	
//	@Test(expected=NullPointerException.class)
//	public void testViewSchoolDetailsInvalidSchool() {
//		ArrayList<String> expResult = new ArrayList<String>();
//		expResult.add("FAKEVILLE COLLEGE");
//		expResult.add("RHODEISLAND");
//		expResult.add("URBAN"); 
//		expResult.add("PRIVATE");
//		expResult.add("10000");
//		expResult.add("50");
//		expResult.add("625");
//		expResult.add("650");
//		expResult.add("36450");
//		expResult.add("40");
//		expResult.add("20");
//		expResult.add("50");
//		expResult.add("11500");
//		expResult.add("5");
//		expResult.add("4");
//		expResult.add("5");
//		student.viewSchoolDetails("FAKEVILLE COLLEGE");
//	}
//
//	@Test (expected = IllegalArgumentException.class) 
//	public void testTakeQuizNotAllQuestionsAnswered() {
//		String location = "URBAN";
//		String characteristic = "Social"; 
//		String control = ""; 
//		student.takeQuiz(location, characteristic, control, emphases);
//	}
//	
//	@Test
//	public void testTakeQuizAcademicBranch() {
//		String location = "URBAN";
//		String characteristic = "academic"; 
//		String control = "PRIVATE"; 
//		String[] emphasis = new String[1];
//		emphasis[0] = "BIOLOGY";
//		ArrayList<String> results = new ArrayList<String>();
//		ArrayList<University> list = student.takeQuiz(location, characteristic, control, emphasis);
//		for(University uni: list) {
//			results.add(uni.getName());
//		}
//		ArrayList<String> expResults = new ArrayList<String>();
//		expResults.add("BARNARD");
//		expResults.add("BROWN");
//		expResults.add("CLARK UNIVERSITY");
//		expResults.add("EMORY");
//		expResults.add("HARVARD");
//		expResults.add("JOHNS HOPKINS");
//		expResults.add("UNIVERSITY OF ROCHESTER");
//		expResults.add("UNIVERSITY OF SOUTHERN CALIFORNIA");
//		assertEquals(expResults, results);	
//	}
//	
//	@Test
//	public void testTakeQuizSocialBranch() {
//		String location = "URBAN";
//		String characteristic = "social"; 
//		String control = "PRIVATE"; 
//		String[] emphasis = new String[1];
//		emphasis[0] = "BIOLOGY";
//		ArrayList<String> results = new ArrayList<String>();
//		ArrayList<University> list = student.takeQuiz(location, characteristic, control, emphasis);
//		for(University uni: list) {
//			results.add(uni.getName());
//		}
//		ArrayList<String> expResults = new ArrayList<String>();
//		expResults.add("BROWN");
//		expResults.add("EMORY");
//		expResults.add("UNIVERSITY OF SOUTHERN CALIFORNIA");
//		assertEquals(expResults, results);
//	}
//	
//	@Test
//	public void testTakeQuizQualityOfLifeBranch() {
//		String location = "URBAN";
//		String characteristic = "qualityOfLife"; 
//		String control = "PRIVATE"; 
//		String[] emphasis = new String[1];
//		emphasis[0] = "BIOLOGY";
//		ArrayList<String> results = new ArrayList<String>();
//		ArrayList<University> list = student.takeQuiz(location, characteristic, control, emphasis);
//		for(University uni: list) {
//			results.add(uni.getName());
//		}
//		ArrayList<String> expResults = new ArrayList<String>();
//		expResults.add("BARNARD");
//		expResults.add("BROWN");
//		expResults.add("EMORY");
//		expResults.add("HARVARD");
//		assertEquals(expResults, results);
//	}
//	
//	@Test(expected=NullPointerException.class)
//	public void testTakeQuizNullEmphases() {
//		String location = "URBAN";
//		String characteristic = "qualityOfLife"; 
//		String control = "PRIVATE"; 
//		student.takeQuiz(location, characteristic, control, emphases);
//	}
//	
//	@Test
//	public void testTakeQuizNoEmphases() {
//		String location = "URBAN";
//		String characteristic = "qualityOfLife"; 
//		String control = "PRIVATE"; 
//		String[] emphasis = new String[1];
//		emphasis[0] = "";
//		ArrayList<String> results = new ArrayList<String>();
//		ArrayList<University> list = student.takeQuiz(location, characteristic, control, emphasis);
//		for(University uni: list) {
//			results.add(uni.getName());
//		}
//		ArrayList<String> expResults = new ArrayList<String>();
//		assertEquals(expResults, results);
//	}
//
//	@Test
//	public void testFieldSearch() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testFindRecommended() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testSaveSchoolValidSchool() {
//		Account user1 = dbCon.getAccount("kmendel001@csbsju.edu");
//		user1.setUserStatus("Y");
//		dbCon.setAccount(user1);
//		student.login("kmendel001@csbsju.edu", "user");
//		student.saveSchool("AUGSBURG");
//		ArrayList<UserSavedSchool> schools = dbCon.getSchoolList2(dbCon.getAccount("kmendel001@csbsju.edu"));
//		ArrayList<String> expSchools = new ArrayList();
//		expSchools.add("AUGSBURG");
//		expSchools.add("BENNINGTON");
//		expSchools.add("YALE");
//		
//		Boolean same = true;
//		for(int i=0; i<schools.size(); i++)
//		{
//			System.out.println(schools.get(i).getName() + " " +expSchools.get(i));
//			if(!schools.get(i).getName().equals(expSchools.get(i)))
//				same = false;
//		}
//		assertTrue(same);
//	}
//	
//	@Test(expected=IllegalArgumentException.class)
//	public void testSaveSchoolAlreadySaved() {
//		student.login("kmendel001@csbsju.edu", "user");
//		student.saveSchool("YALE"); //Null
//	}
//
//	@Test(expected=IllegalArgumentException.class)
//	public void testSaveSchoolInvalidSchool() {
//		student.login("kmendel001@csbsju.edu", "user");
//		student.saveSchool("FAKE COLLEGE"); //Null
//	}
//	
//
//	@Test
//	public void testViewSavedSchoolDetails() {
//		student.login("kmendel001@csbsju.edu", "user");
//		student.viewSavedSchoolDetails("YALE");
//		//should get time stamp
//		ArrayList<String> results = new ArrayList();
//		results.add(student.viewSavedSchoolDetails("BROWN").get(0));
//		results.add(student.viewSavedSchoolDetails("BROWN").get(1));
//		results.add(student.viewSavedSchoolDetails("BROWN").get(2));
//		results.add(student.viewSavedSchoolDetails("BROWN").get(3));
//		results.add(student.viewSavedSchoolDetails("BROWN").get(4));
//		results.add(student.viewSavedSchoolDetails("BROWN").get(5));
//		results.add(student.viewSavedSchoolDetails("BROWN").get(5));
//		results.add(student.viewSavedSchoolDetails("BROWN").get(6));
//		results.add(student.viewSavedSchoolDetails("BROWN").get(7));
//		results.add(student.viewSavedSchoolDetails("BROWN").get(8));
//		results.add(student.viewSavedSchoolDetails("BROWN").get(9));
//		results.add(student.viewSavedSchoolDetails("BROWN").get(10));
//		results.add(student.viewSavedSchoolDetails("BROWN").get(11));
//		results.add(student.viewSavedSchoolDetails("BROWN").get(12));
//		results.add(student.viewSavedSchoolDetails("BROWN").get(13));
//		results.add(student.viewSavedSchoolDetails("BROWN").get(14));
//		results.add(student.viewSavedSchoolDetails("BROWN").get(15));
//		for(String emphasis: dbCon.getUniversity("BROWN").getEmphases())
//			results.add(emphasis);
//		
//		ArrayList<String> expResult = new ArrayList();
//		expResult.add("BROWN");
//		expResult.add("RHODEISLAND");
//		expResult.add("URBAN"); 
//		expResult.add("PRIVATE");
//		expResult.add("10000");
//		expResult.add("50");
//		expResult.add("625");
//		expResult.add("650");
//		expResult.add("36450");
//		expResult.add("40");
//		expResult.add("20");
//		expResult.add("50");
//		expResult.add("11500");
//		expResult.add("5");
//		expResult.add("4");
//		expResult.add("5");
//		expResult.add("ARTS-AND-SCIENCES");
//		expResult.add("BIOLOGY");
//		expResult.add("HISTORY");
//		
//		
//		Boolean same = false;
//		for(int i=0; i<results.size(); i++)
//		{
//			if(results.get(i).equals(expResult.get(i)))
//			{
//				same = true;
//			}
//		}
//		assertTrue(same);
//		
//		
//	}
//	
//	@Test(expected=UnsupportedOperationException.class)
//	public void testViewSavedSchoolDetailsSchoolNotSaved() {
//		student.login("kmendel001@csbsju.edu", "user");
//		student.viewSavedSchoolDetails("HARVARD"); //Null pointer
//		
//	}
//	
//	@Test(expected=UnsupportedOperationException.class)
//	public void testViewSavedSchoolInvalidSchool() {
//		student.login("kmendel001@csbsju.edu", "user");
//		student.viewSavedSchoolDetails("FAKE COLLEGE"); //Null pointer
//	}
//
//	@Test
//	public void testViewSavedSchools() {
//		student.login("kmendel001@csbsju.edu", "user");
//		ArrayList<UserSavedSchool> schools = student.viewSavedSchools();
//		ArrayList<String> expSchools = new ArrayList();
//		expSchools.add("AUGSBURG");
//		expSchools.add("BENNINGTON");
//		expSchools.add("YALE");
//	
//		Boolean same = true;
//		for(int i=0; i<schools.size(); i++)
//		{
//			System.out.println(schools.get(i).getName() + " " +expSchools.get(i));
//			if(!schools.get(i).getName().equals(expSchools.get(i)))
//				same = false;
//		}
//		assertTrue(same);
//	}
//
//	@Test
//	public void testViewUserSavedStatisticsValidUserValidSchools() {
//		student.login("kmendel001@csbsju.edu", "user");
//		ArrayList<String> results = student.compareSchoolsByScore();
//		ArrayList<String> expResults = new ArrayList();
//		expResults.add("AUGSBURG 2");
//		expResults.add("BENNINGTON 1");
//		expResults.add("YALE 2");
//		Boolean same = true;
//		for(int i=0; i<results.size(); i++)
//		{
//			if(!results.get(i).equals(expResults.get(i)))
//			{
//				same = false;
//			}
//		}
//		assertTrue(same);
//	}
//	
//	@Test(expected=UnsupportedOperationException.class)
//	public void testViewUserSavedStatisticsInvalidUserNoSchools() {
//		student.login("user@csbsju.edu", "user");
//		student.compareSchoolsByScore();
//	}
//	
//	@Test(expected=UnsupportedOperationException.class)
//	public void testViewUserSavedStatisticsValidUserNoSchools() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetSfCon() {
//		StudentFunctionalityController expResult = student.sfCon;
//		StudentFunctionalityController result = student.getSfCon();
//		assertEquals(result, expResult);
//	}
//
//	@Test
//	public void testSetSfCon() {
//		StudentFunctionalityController sfCon1 = new StudentFunctionalityController();
//		student.setSfCon(sfCon1);
//		StudentFunctionalityController expResult = student.sfCon;
//		StudentFunctionalityController result = sfCon1;
//		assertEquals(result, expResult);
//	}
//
//	@Test(expected=IllegalArgumentException.class)
//	public void testRemoveSavedSchoolNotSaved() {
//		student.login("kmendel001@csbsju.edu", "user");
//		student.removeSavedSchool("HARVARD");
//	}	
//	@Test(expected=IllegalArgumentException.class)
//	public void testRemoveSavedSchoolInvalidSchool() {
//		student.login("kmendel001@csbsju.edu", "user");
//		student.removeSavedSchool("FAKE COLLEGE");
//	}
//	
//	@Test
//	public void testRemoveSavedSchoolValidSchool() {
//		student.login("kmendel001@csbsju.edu", "user");
//		student.removeSavedSchool("AUGSBURG");//null pointer
//	}

	@Test(expected=UnsupportedOperationException.class)
	public void testCompareSchoolsByScoreNoSavedSchools() {
		student.login("irahal@csbsju.edu", "bqv6x");
		student.compareSchoolsByScore();
	}
	
//	@Test
//	public void testCompareSchoolsByScoreManySaved() {
//		student.login("kmendel001@csbsju.edu", "user"); //something wrong with check user
//		ArrayList<String> result = student.compareSchoolsByScore();
//		ArrayList<String> expResult = new ArrayList();
//		expResult.add("AUGSBURG 490");
//		expResult.add("Yale 675");
//		
//		Boolean same = true;
//		for(int i=0; i<result.size(); i++)
//		{
//			if(!result.get(i).equals(expResult.get(i)))
//			{
//				same = false;
//			}
//		}
//		assertTrue(same);
//	}
//	
//	@Test
//	public void testCompareSchoolsByScoreNoSchoolsWithValidScore() {
//		//create new user with all -1 schools
//		fail("not yet implemented");
//	}
//	
//	@Test
//	public void testEditUser() {
//		fail("not yet implemented");
//	}


}
