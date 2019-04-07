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
		ArrayList<String> schoolDetials = this.studentConTest.viewSchoolDetails("YALE");
		University school = DBCon.getUniversity("YALE");
		
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
		this.studentConTest.viewSchoolDetails("Lala Land");
	}

	@Test
	public void testSaveSchool() {
		this.studentConTest.saveSchool("YALE");
		ArrayList<UserSavedSchool> savedSchools = this.studentConTest.viewSavedSchools();
		University school = new DBController().getUniversity("YALE");
		UserSavedSchool saveSchool = new UserSavedSchool(school, null);
		assertTrue(savedSchools.contains(saveSchool));
	}

	@Test (expected = IllegalArgumentException.class)
	public void testSaveSchoolFailsForSchoolThatDoesNotExist() {
		this.studentConTest.saveSchool("Lala Land");
	}
	
	@Test
	public void testSetAccountController() {
		Account account = new Account("Andrew", "-1", "-1", "-1", "-1", "-1");
		this.studentConTest.setAccountController(account);
		AccountController result = this.studentConTest.account;
		AccountController expected = new AccountController(account);
		assertEquals(result, expected);
	}

	@Test
	public void testViewSavedSchools() {
		ArrayList<UserSavedSchool> result = this.studentConTest.viewSavedSchools();
		ArrayList<UserSavedSchool> expected = this.studentConTest.account.viewSavedSchools();
		assertEquals(result, expected);
	}

	@Test
	public void testRemoveSavedSchool() {
		this.studentConTest.saveSchool("YALE");
		this.studentConTest.saveSchool("STANFORD");
		this.studentConTest.removeSavedSchool("YALE");
		ArrayList<UserSavedSchool> savedSchools = this.studentConTest.viewSavedSchools();
		assertTrue(savedSchools.size() == 1);
	}
	
	@Test (expected = UnsupportedOperationException.class)
	public void testRemoveSavedSchoolFailsForNonExistingSchool() {
		this.studentConTest.removeSavedSchool("Lala Land");
	}
	

	@Test
	public void testViewSavedSchoolDetails() {
		DBController DBCon = new DBController();
		ArrayList<String> schoolDetials = this.studentConTest.viewSavedSchoolDetails("YALE");
		University school = DBCon.getUniversity("YALE");
		
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
	public void testViewSavedSchoolDetailsFailsForInvalidSchoolName() {
		this.studentConTest.viewSchoolDetails("Lala Land");
	}

	@Test
	public void testViewUserSavedStatistics() {
		this.studentConTest.saveSchool("YALE");
		String[] saveStatistics = this.studentConTest.viewUserSavedStatistics("YALE");
		assertTrue(saveStatistics[0] == "YALE" && saveStatistics[1] == "1");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testViewUserSavedStatisticsFailsForNonExistingSchool() {
		this.studentConTest.viewUserSavedStatistics("Lala Land");
	}

	@Test
	public void testCompareSchoolsByScore() {
		ArrayList<String> result = this.studentConTest.compareSchoolsByScore();
		ArrayList<String> expected = this.studentConTest.account.compareSchoolsByScore();
		assertEquals(result, expected);
	}

}
