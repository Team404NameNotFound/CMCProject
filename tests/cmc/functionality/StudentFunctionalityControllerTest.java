package cmc.functionality;

import static org.junit.Assert.*;
import cmc.entity.*;
import java.util.ArrayList;
import org.junit.Assert.*;
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
		ArrayList<String> schoolDetials = this.studentConTest.viewSchoolDetails("Yale");
		University school = DBCon.getUniversity("Yale");
		
		ArrayList<String> expected = new ArrayList<String>();
		expected.add(school.getName());
		expected.add(school.getState()); 
		expected.add(school.getLocation());
		expected.add(school.getControl());
		expected.add(school.getEnrollment());
		expected.add(school.getPercentFemale());
		expected.add(school.getSatVerbal());
		expected.add(school.getSatMath());
		expected.add(school.getCost());
		expected.add(school.getPercentFinAid());
		expected.add(school.getApplicants());
		expected.add(school.getPercentAdmitted());
		expected.add(school.getPercentEnrolled());
		expected.add(school.getAcademicScale());
		expected.add(school.getSocialScale());
		expected.add(school.getQualityOfLife());
		
		assertEquals(schoolDetials, expected);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testViewSchoolDetailsFailsForInvalidSchoolName() {
		ArrayList<String> schoolDetials = this.studentConTest.viewSchoolDetails("Lala Land");
	}

	@Test
	public void testSaveSchool() {
		this.studentConTest.saveSchool("Yale");
		ArrayList<UserSavedSchool> savedSchools = this.studentConTest.viewSavedSchools();
		University school = new DBController().getUniversity("Yale");
		UserSavedSchool saveSchool = new UserSavedSchool(school, null);
		assertTrue(savedSchools.contains(saveSchool));
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
