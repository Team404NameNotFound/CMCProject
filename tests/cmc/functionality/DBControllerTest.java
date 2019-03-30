package cmc.functionality;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import cmc.entity.Account;
import cmc.entity.University;

public class DBControllerTest {

	private DBController dbcon;
	private String[] emphases = null;
	private University testuni;
	private University testuni2;
	private Account testacc;
	private Account testacc2;

	
	@Before
	public void setUp() throws Exception {
		dbcon = new DBController();
		testuni = new University("testuni", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", emphases);
		testuni2 = new University("testuni", "edit", "", "", "", "", "", "", "", "", "", "", "", "", "", "", emphases);
		testacc = new Account("first", "last", "testacc", "password", "u", "Y");
		testacc = new Account("first", "editedlast", "testacc", "password", "u", "Y");
	}

	@Test
	public void testDBController() {
		DBController result = new DBController();
		DBController expResult = dbcon;
		assertEquals(result, expResult);
	}

	@Test
	public void testCheckUserYStatus() {
		boolean result = dbcon.checkUser("juser");
		boolean expResult = true;
		assertEquals(result, expResult);
		}
	
	@Test
	public void testCheckUserNStatus() {
		boolean result = dbcon.checkUser("luser");
		boolean expResult = false;
		assertEquals(result, expResult);
		}

	@Test
	public void testAddUniversity() {
		dbcon.addUniversity(testuni);
		boolean result = dbcon.findUniversity("testuni");
		boolean expResult = true;
		assertEquals(result, expResult);	
		}
	
	@Test
	public void testGetUniversity() {
		University result = dbcon.getUniversity("testuni");
		University expResult = testuni;
		assertEquals(result, expResult);	
		}

	@Test
	public void testGetUniversity2() {
		University result = dbcon.getUniversity("testuni");
		University expResult = testuni;
		assertEquals(result, expResult);	
		}

	@Test
	public void testSetUniversity() {
		dbcon.setUniversity(testuni2);
		University result = dbcon.getUniversity("testuni");
		University expResult = testuni2;
		assertEquals(result, expResult);	}
	@Test
	public void testRemoveUniversity() {
		dbcon.removeUniversity("testuni");
		boolean result = dbcon.findUniversity("testuni");
		boolean expResult = false;
		assertEquals(result, expResult);	
		}

	@Test
	public void testAddUser() {
		dbcon.addUser(testacc);
		Account result = dbcon.getAccount("testacc");
		Account expResult = testacc;
		assertEquals(result, expResult);
	}

	@Test
	public void testGetAccount() {
		Account result = dbcon.getAccount("testacc");
		Account expResult = testacc;
		assertEquals(result, expResult);
		}

	@Test
	public void testSetAccount() {
		dbcon.setAccount(testacc2);
		Account result = dbcon.getAccount("testacc");
		Account expResult = testacc2;
		assertEquals(result, expResult);
	}

	@Test
	public void testFindUniversityExists() {
		boolean result = dbcon.findUniversity("BROWN");
		boolean expResult = true;
		assertEquals(result, expResult);	
		}
	
	@Test
	public void testFindUniversityDoesNotExist() {
		boolean result = dbcon.findUniversity("NONEXISTINGUNIVERSITY");
		boolean expResult = true;
		assertEquals(result, expResult);	
		}

	@Test
	public void testGetUniversityList() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAccountList() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSchoolList2() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSchoolList() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddEmphasis() {
		fail("Not yet implemented");
	}

	@Test
	public void testSaveShool() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveSavedSchool() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetUserSavedStatistics() {
		fail("Not yet implemented");
	}

}
