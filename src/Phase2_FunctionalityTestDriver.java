	import cmc.*;
	import cmc.entity.*;
	import cmc.functionality.DBController;
	import cmc.interaction.*;
	import java.util.ArrayList;
	
public class Phase2_FunctionalityTestDriver {

	static AccountInteraction user = new AccountInteraction();
	static StudentInteraction student =  new StudentInteraction();
	static AdminInteraction admin = new AdminInteraction();
	static AdminInteraction adInt = new AdminInteraction();
	
	public static void main(String[] args) {
	//UC 1 Login
		//successful login (user)
		System.out.println("UC 1: Successful login (user):");
		System.out.println("-------------------------");
		String userUsername = "juser";
		String userPassword = "user";
		user.login(userUsername, userPassword);
	//UC 2 Logout
		System.out.println("UC 2: Successful logout:");
		System.out.println("-------------------------");
		user.logout();
		System.out.println();
		
		//successful login (admin)
		System.out.println("UC 1: Successful login (admin):");
		System.out.println("-------------------------");
		String adminUsername = "nadmin";
		String adminPassword = "a";
		user.login(adminUsername, adminPassword);
		System.out.println("UC 2: Successful logout:");
		System.out.println("-------------------------");
		user.logout();
		System.out.println();
		
		//failed login - invalid credentials (admin and user)
		System.out.println("UC 1: Failed login (invalid credentials):");
		System.out.println("-------------------------");
		String username1 = "Team";
		String password1 = "404";
		user.login(username1, password1);
		System.out.println();
		
		//failed login - inactive status (admin and user)
		System.out.println("UC 1: Failed login (inactive status):");
		System.out.println("-------------------------");
		String username2 = "luser";
		String password2 = "user";
		user.login(username2, password2);
		System.out.println();
		
	//UC 3 Request new password
		
		
	//UC 4 Search
	//UC 5 Take personality quiz
		
		
	//UC 6 Search by entering fields
	//U7 View Search results
		System.out.println("\nSearching and Matching on Fields:");
		System.out.println("-------------------------");
		String state = "Minnesota";
		int numStudentsLower = 2000;
		int numStudentsUpper = 30000;
		String[] emphases = {};
		student.fieldSearch( "", state, "", numStudentsLower,
				numStudentsUpper, (float)-1.0,(float)-1.0, -1, 
				-1, -1, -1, -1, -1, 
				(float)-1.0, (float)-1.0, -1, 
				-1, (float)-1.0, (float)-1.0,
				(float)-1.0, (float)-1.0, -1, -1,
				-1, -1, -1, -1, emphases, ""
				);
		
	//U8 View searched school details
		System.out.println("\n Testing printing  a school's details\n");
		user.viewSchoolDetails("UNIVERSITY OF MINNESOTA");
		
		System.out.println("Testing Adding a university");
		admin.addNewUniversity("Dummy", "State", "location", "private", "5000", "1", "800", "800", "100000", "20", "1", "5", "1", 
				"3", "4", "5", emphases);
		System.out.println("\nPrinting Dummy school added details: \n");
		user.viewSchoolDetails("Dummy");
		
	//U9 View additional recommended schools
		System.out.println("UC 9 Closest Matches From Selected University:");
		System.out.println("-------------------------");
		DBController db = new DBController();
		ArrayList<University> uniSchools = db.getUniversityList();
		University university = uniSchools.get(9);
		student.findRecommended(university);
		
	//U10 Save school
		
	//U11 View saved schools
		
	//U12 Remove a saved school
		
	//U13 View saved school details
		
	//U14 View user saved statistics
		
	//U15 Compare schools by score
		userUsername = "juser";
		userPassword = "user";
		user.login(userUsername, userPassword);
		student.compareSchoolsByScore(userUsername);
		
	//U16 View user profile
		user.login(adminUsername, adminPassword);		
		user.viewProfile(adminUsername);
		
	//U17 Edit user information
		user.editProfile("","","","");
		user.viewProfile(adminUsername);
		
	//U18 View school list
		user.login(adminUsername, adminPassword);
		adInt.viewUniversities();
		
	//U21 Add new university
			System.out.println("Testing Adding a university");
			admin.addNewUniversity("Dummy", "State", "location", "private", "5000", "1", "800", "800", "100000", "20", "1", "5", "1", 
					"3", "4", "5", emphases);
			System.out.println("\nPrinting Dummy school added details: \n");
			user.viewSchoolDetails("Dummy");
		
	//U19 Remove university
			user.viewSchoolDetails("Dummy");
			System.out.println("\n");	
			System.out.println("\n Testing removing a school");
			admin.removeUniversity("Dummy");
		
		
	//U20 Edit school information
		admin.editUniversityInfo("Dummy", "State2", "location2", "-1", "-1", "-1", "-1", "-1", "10000000", "-1", "-1", "-1", "-1",
				"-1", "-1", "-1", emphases);
		System.out.println("\n");
		
	//U22 View users
		adInt.viewUsers();
		
	//U23 Add a new user
		adInt.addUser("Carrie", "Zhang", "cz001", "password", "u");
		adInt.toggleActivationStatus("Zhang");
		
	//U24 Toggle activation status
		adInt.addUser("Carrie", "Zhang", "cz001", "password", "u");
		adInt.addUser("Carrie", "Zhang", "cz001", "", "u");
		
		
	}
}