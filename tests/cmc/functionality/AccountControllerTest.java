package cmc.functionality;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import cmc.entity.Account;

public class AccountControllerTest {
	private AccountController user;
	private AccountController admin;
	private AccountController noSavedSchoolUser;
	private DBController dbController = new DBController();

	@Before
	public void setUp() throws Exception {
		user = new AccountController(dbController.getAccount("cuser"));
		user.removeAllSavedSchools();
		admin = new AccountController(dbController.getAccount("nadmin"));
		noSavedSchoolUser = new AccountController(dbController.getAccount("juser"));
	}

	/*
	 * @Test public void testAccountControllerAccount() {
	 * fail("Not yet implemented"); }
	 * 
	 * @Test public void testAccountController() { fail("Not yet implemented"); }
	 */
	@Test(expected = UnsupportedOperationException.class)
	public void testCheckIfSchoolSaved_invalidSchool_case1() {
		user.checkIfSchoolSaved("-1");
	}

	@Test
	public void testCheckIfSchoolSaved_savedSchool_case2() {
		user.saveSchool("EMORY");
		Boolean expResult = true;
		assertTrue("Check if school saved", expResult.equals(user.checkIfSchoolSaved("EMORY")));
	}

	@Test
	public void testCheckIfSchoolSaved_unsavedSchool_case3() {
		Boolean expResult = false;
		assertTrue("Check if school is not saved", expResult.equals(user.checkIfSchoolSaved("AUGSBURG")));
	}

	@Test(expected = UnsupportedOperationException.class)
	public void testCheckIfSchoolSaved_invalidAccount_case4() {
		admin.checkIfSchoolSaved("BROWN");
	}

	/*
	 * @Test public void testViewSavedSchools_invalidAccount_case1() {
	 * fail("Not yet implemented"); }
	 * 
	 * @Test public void testViewSavedSchools_noSavedSchools_case2() {
	 * fail("Not yet implemented"); }
	 * 
	 * 
	 * @Test public void testViewSavedSchools_hasSavedSchools_case3() {
	 * fail("Not yet implemented"); }
	 */

	@Test(expected = UnsupportedOperationException.class)
	public void testSaveSchool_invalidSchool_case1() {
		user.saveSchool("notExistingSchool");
	}

	@Test(expected = UnsupportedOperationException.class)
	public void testSaveSchool_invalidAccount_case2() {
		admin.saveSchool("YALE");
	}

	@Test
	public void testSaveSchool_saveSchoolSuccess_case3() {
		Boolean expResult = true;
		Boolean result = user.saveSchool("CORNELL");;
		assertEquals("Save a school successfully " + expResult, expResult, result);
	}

	@Test(expected = UnsupportedOperationException.class)
	public void testSaveSchool_saveSameSchoolTwice_case4() {
		user.saveSchool("HARVARD");
		user.saveSchool("HARVARD");
	}

	@Test(expected = UnsupportedOperationException.class)
	public void testRemoveSavedSchool_invalidAccount_case1() {
		admin.removeSavedSchool("YALE");
	}

	@Test(expected = UnsupportedOperationException.class)
	public void testRemoveSavedSchool_invalidSchool_case2() {
		user.removeSavedSchool("hahahahaYeah");
	}

	@Test
	public void testRemoveSavedSchool_schoolHasNotBeenSaved_case3() {
		Boolean expResult = false;
		Boolean result = user.removeSavedSchool("AUGSBURG");;
		assertEquals("Cannot remove an unsaved School " + expResult, expResult, result);
	}

	@Test
	public void testRemoveSavedSchool_removeSavedSchoolSuccessful_case4() {
		user.saveSchool("BARD");
		Boolean result = user.removeSavedSchool("BARD");
		Boolean expResult = true;
		assertEquals("The saved school is being removed: "+ expResult, expResult, result);
	}

	@Test(expected = UnsupportedOperationException.class)
	public void testCompareSchoolsByScore_invalidAccount_case1() {
		admin.compareSchoolsByScore();
	}

	@Test(expected = UnsupportedOperationException.class)
	public void testCompareSchoolsByScore_noSchoolsToCompare_case2() {
		noSavedSchoolUser.compareSchoolsByScore();
	}

	@Test
	public void testCompareSchoolsByScore_oneSchoolToCompare_case3() {
		user.saveSchool("VASSAR");
		ArrayList<String> expResult = new ArrayList<>();
		expResult.add("VASSAR 600.0");
		ArrayList<String> result = user.compareSchoolsByScore();
		assertEquals("One saved school to compare " + expResult, expResult, result);
	}

	@Test
	public void testCompareSchoolsByScore_moreThanOneSchoolToCompare_case4() {
		user.saveSchool("BOSTON COLLEGE");
		user.saveSchool("BROWN");
		ArrayList<String> expResult = new ArrayList<>();
		expResult.add("BOSTON COLLEGE 550.0");
		expResult.add("BROWN 650.0");
		ArrayList<String> result = user.compareSchoolsByScore();
		assertEquals("One saved school to compare " + expResult, expResult, result);
	}

	@Test
	public void testCompareSchoolsByScore_savedSchoolDoesNotHaveSATMathScore_case5() {
		user.saveSchool("ABILENE CHRISTIAN UNIVERSITY"); //sat score is -1
		user.saveSchool("BOSTON COLLEGE");
		user.saveSchool("BROWN");
		ArrayList<String> expResult = new ArrayList<String>();
		expResult.add("BOSTON COLLEGE 550.0");
		expResult.add("BROWN 650.0");
		ArrayList<String> result = user.compareSchoolsByScore();
		assertEquals("One saved school to compare " + expResult, expResult, result);
	}

	/*
	 * @Test public void testToggleActivationStatus() { fail("Not yet implemented");
	 * }
	 * 
	 * @Test public void testCheckPassword() { fail("Not yet implemented"); }
	 * 
	 * @Test public void testMakeRandomPassword() { fail("Not yet implemented"); }
	 * 
	 * @Test public void testUpdatePassword() { fail("Not yet implemented"); }
	 * 
	 * @Test public void testSendEmail() { fail("Not yet implemented"); }
	 * 
	 * @Test public void testUpdateUserInfo() { fail("Not yet implemented"); }
	 * 
	 * @Test public void testCreateNewAccount() { fail("Not yet implemented"); }
	 */

}
