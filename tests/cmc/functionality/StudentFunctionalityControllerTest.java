package cmc.functionality;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StudentFunctionalityControllerTest {
	
	private StudentFunctionalityController studentConTest;

	@Before
	public void setUp() throws Exception {
		this.studentConTest = new StudentFunctionalityController();
	}


	@Test
	public void testRankUniversity() {
		this.studentConTest.rankUniversity("UniName<>");
		
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testRankUniversityUniversityDoesNotExsist() {
		this.studentConTest.rankUniversity("Not a University");
	}

	@Test
	public void testSearch() {
		fail("Not yet implemented");//How to test???
	}

	@Test
	public void testViewSchoolDetails() {
		DBController DBCon = new DBController();
		String schoolDetials = this.studentConTest.viewSchoolDetails("Yale");
		University school = DBCon.getUniversity("Yale");
		String expected = "Name: "+  school.getName() + " State: " + school.getState() + " Location: " + school.getLocation() + "\n" +
				   " Control: " + school.getControl()+ " Entrollment: " +school.getEnrollment()+ " FemalePercent: " + school.getPercentFemale() + " \n" 
				   + " SatVerbal: " + school.getSatVerbal() + " SatMath: " + school.getSatMath() + " Cost: "  + school.getCost() + " \n " +
				   " PercentFinAid: " + school.getPercentFinAid()+ " Applicants: "
					+ school.getApplicants() + " PercentAdmitted: "+ school.getPercentAdmitted() + "\n" + " PercentEnrolled: " 
				    + school.getPercentEnrolled() + " AcademicScale: " + school.getAcademicScale() + " SocialScale: " + school.getSocialScale() + " QualityOfLife: " + school.getQualityOfLife();
		assertEqual(schoolDetials, school);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testViewSchoolDetailsFailsForInvalidSchoolName() {
		String schoolDetials = this.studentConTest.viewSchoolDetails("Lala Land");
	}

	@Test
	public void testSaveSchool() {
		this.studentConTest.saveSchool("Yale");
		ArrayList<String> savedSchools = this.studentConTest.viewSavedSchools();
		Assert.assertTrue(savedSchools.contains("Yale"));
	}

	@Test (expected = IllegalArgumentException.class)
	public void testSaveSchoolFailsForSchoolThatDoesNotExist() {
		this.studentConTest.saveSchool("Lala Land");
	}
	
	@Test
	public void testSetAccountController() {
		AccountController accCon = new AccountController();
		this.studentConTest.setAccount(accCon);
		AccountController result = this.studentConTest.getAccountController();
		assertEquals(result, accCon);
	}

	@Test
	public void testViewSavedSchools() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveSavedSchool() {
		fail("Not yet implemented");
	}

	@Test
	public void testViewSavedSchoolDetails() {
		fail("Not yet implemented");
	}

	@Test
	public void testViewUserSavedStatistics() {
		fail("Not yet implemented");
	}

	@Test
	public void testCompareSchoolsByScore() {
		fail("Not yet implemented");
	}

}
