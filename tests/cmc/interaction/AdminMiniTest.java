package cmc.interaction;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cmc.functionality.AccountController;
import cmc.functionality.DBController;

public class AdminMiniTest {

	private DBController dbController; 
	private AdminInteraction admin;
	
	@Before
	public void setUp() {
		dbController = new DBController();
		admin = new AdminInteraction();
		this.admin.afCon.setAccount(new AccountController(dbController.getAccount("nadmin")));
	}
	
	@After
	public void shutDown() {
		admin.logout();
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testEditProfile_adminEnterEmpty_case2() {
		admin.login("nadmin", "Admin");
		admin.editProfile("", "", "", "", "", "");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testEditProfile_adminNonExistingUsername_case3() {
		admin.login("nadmin", "Admin");
		admin.editProfile("cz002", "cf", "cl", "cp", "u", "Y");
	
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testEditProfile_adminInvalidUserType_case4() {
		admin.login("nadmin", "Admin");
		admin.editProfile("cz001", "cf", "cl", "cp", "invalidUserType", "Y");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testEditProfile_adminInvalidUserStatus_case5() {
		admin.login("nadmin", "Admin");
		admin.editProfile("cz001", "cf", "cl", "cp", "u", "invalidUserStatus");
	}
	
	@Test
	public void testEditProfile_adminEditProfileSuccessfully_case6() {
		admin.login("nadmin", "Admin");
		admin.editProfile("cz001", "Carrie222", "cl", "cp", "a", "Y"); //last Y
		String expFirstName = "Carrie222";
		String expUserType = "a";
		String resultFirstName = (this.dbController.getAccount("cz001").getFirstName());
		String resultUserType= (this.dbController.getAccount("cz001").getUserType());
		assertEquals("Admin edit profile: first name" + expFirstName, expFirstName,resultFirstName );
		assertEquals("Admin edit profile: user type" + expUserType, expUserType,resultUserType );
		
	}


}

