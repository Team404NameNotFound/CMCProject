package cmc.interaction;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import cmc.entity.University;

public class StudentInteractionTest {

	private StudentInteraction student = new StudentInteraction();
	private String[] emphases = null;
	private University school = new University("BROWN", "RHODEISLAND", "URBAN", "PRIVATE", "10000", "50", "625", "650", "36450", "40", "20", "50", "11500", "5", "4", "5", emphases);

	@Before
	public void setUp() throws Exception {
		StudentInteraction student = new StudentInteraction();
	}

//	@Test
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
	
//	@Test(expected=NullPointerException.class)
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
//	@Test
//	public void testStudentInteraction() {
//		fail("Not yet implemented");
//	}
//
//	@Test (expected = IllegalArgumentException.class) 
	public void testTakeQuizNotAllQuestionsAnswered() {
		String location = "URBAN";
		String characteristic = "Social"; 
		String control = ""; 
		student.takeQuiz(location, characteristic, control, emphases);
	}
	
//	@Test
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
	
//	@Test
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
	
//	@Test
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
	
	@Test(expected=NullPointerException.class)
	public void testTakeQuizNullEmphases() {
		String location = "URBAN";
		String characteristic = "qualityOfLife"; 
		String control = "PRIVATE"; 
		student.takeQuiz(location, characteristic, control, emphases);
	}
	
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
//	public void testSaveSchool() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testViewSavedSchoolDetails() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testViewSavedSchools() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testViewUserSavedStatistics() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetSfCon() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testSetSfCon() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testRemoveSavedSchool() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testCompareSchoolsByScore() {
//		fail("Not yet implemented");
//	}

}
