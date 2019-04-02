package cmc.interaction;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cmc.entity.University;

public class StudentInteractionTest {

	private StudentInteraction student = new StudentInteraction();
	private String[] emphases = null;
	private University school = new University("name", "state", "location", "control", "enrollment", "perFem", "satVerb", "satMath", "cost", "perFinAid", "perEnr", "app", "perAdm", "acaScale", "socScale", "qolScale", emphases);

	@Before
	public void setUp() throws Exception {
		StudentInteraction student = new StudentInteraction();
	}

	@Test
	public void testViewSchoolDetails() {
		String expResult = " Name: "+  school.getName() + " State: " + school.getState() + " Location: " + school.getLocation() + "\n" +
				   " Control: " + school.getControl()+ " Entrollment: " +school.getEnrollment()+ " FemalePercent: " + school.getPercentFemale() + " \n" 
				   + " SatVerbal: " + school.getSatVerbal() + " SatMath: " + school.getSatMath() + " Cost: "  + school.getCost() + " \n " +
				   " PercentFinAid: " + school.getPercentFinAid()+ " Applicants: "
					+ school.getApplicants() + " PercentAdmitted: "+ school.getPercentAdmitted() + "\n" + " PercentEnrolled: " 
				    + school.getPercentEnrolled() + " AcademicScale: " + school.getAcademicScale() + " SocialScale: " + school.getSocialScale() + " QualityOfLife: " + school.getQualityOfLife();
		assertEquals(expResult, student.viewSchoolDetails(school.getName()));
		
	}

//	@Test
//	public void testStudentInteraction() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testTakeQuiz() {
//		
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
