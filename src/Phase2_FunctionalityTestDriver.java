import cmc.*;
import cmc.entity.*;
import cmc.functionality.AccountController;
import cmc.functionality.DBController;
import cmc.functionality.StudentFunctionalityController;
import cmc.interaction.*;
import java.util.ArrayList;
	
public class Phase2_FunctionalityTestDriver {

	static AccountInteraction user = new AccountInteraction();
	static StudentInteraction student =  new StudentInteraction();
	static AdminInteraction admin = new AdminInteraction();
	static AdminInteraction adInt = new AdminInteraction();
	
	static ArrayList<UserSavedSchool> studentSavedSchools = new ArrayList<>();
	static Student student1 = new Student("Cool", "User", "cuser", "user" ,"u", "Y", studentSavedSchools);
	static AccountController accountController = new AccountController(student1);
    static StudentInteraction studentInteraction = new StudentInteraction();
    static StudentFunctionalityController sfCon = new StudentFunctionalityController();
	
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
		
		//
		adInt.login("nadmin", "a");
	//UC 3 Request new password
		
		
	//UC 4 Search Abstract fulfilled by U5 & U6
	
		
	//UC 5 Take personality quiz
		
		
	//UC 6&7  Search by entering fields
		System.out.println("\nSearching and Matching on Fields:");
		System.out.println("-------------------------");
		String state = "Minnesota";
		int numStudentsLower = 2000;
		int numStudentsUpper = 50000;
		String[] emphases = {};
		student.fieldSearch( "GS", state, "-1", numStudentsLower,
				numStudentsUpper, (float)-1.0,(float)-1.0, -1, 
				-1, -1, -1, -1, -1, 
				(float)-1.0, (float)-1.0, -1, 
				-1, (float)-1.0, (float)-1.0,
				(float)-1.0, (float)-1.0, -1, -1,
				-1, -1, -1, -1, emphases, "-1"
				);
		System.out.println();
		
	//U8 View searched school details
		System.out.println("\n Testing printing  a school's details\n");
		user.viewSchoolDetails("UNIVERSITY OF MINNESOTA");
		
		System.out.println("Testing Adding a university");
		admin.addNewUniversity("Dummy", "State", "location", "private", "5000", "1", "800", "800", "100000", "20", "1", "5", "1", 
				"3", "4", "5", emphases);
		System.out.println("\nPrinting Dummy school added details: \n");
		user.viewSchoolDetails("Dummy");
		System.out.println();
		
	//U9 View additional recommended schools
		System.out.println("UC 9 Closest Matches From Selected University:");
		System.out.println("-------------------------");
		DBController db = new DBController();
		ArrayList<University> uniSchools = db.getUniversityList();
		University university = uniSchools.get(9);
		student.findRecommended(university);
		System.out.println();
		
	//U10 Save school
		System.out.print("UC 10 Save School");
		sfCon.setAccount(accountController);
		studentInteraction.setSfCon(sfCon);
		
		//test saveSchool()
		System.out.println("-------------------------");
		System.out.println("Testing save schools: ");
		sfCon.setAccount(accountController);
		studentInteraction.setSfCon(sfCon);

		studentInteraction.saveSchool("AMERICAN UNIVERSITY OF BEIRUT");
		studentInteraction.saveSchool("YALE");
		studentInteraction.saveSchool("AUGSBURG"); 
		studentInteraction.saveSchool("GEORGE WASHINGTON");

		System.out.println("Schools being saved are: ");
	    studentInteraction.viewSavedSchools();
	    System.out.println();

		
	//U11 View saved schools
	    System.out.println("-------------------------");
	    System.out.println("Testing view saved schools: ");
	    studentInteraction.viewSavedSchools();
	    
	//U12 Remove a saved school
	    System.out.println("-------------------------");
	    System.out.println("Testing remove a saved school, remove: GEORGE WASHINGTON\"");
	    studentInteraction.removeSavedSchool("GEORGE WASHINGTON");
	    System.out.println("After removing, the new saved school list for current user is");
	    studentInteraction.viewSavedSchools();
	    
	//U13 View saved school details
	    System.out.println("-------------------------");
	    System.out.println("Testing view a saved school details: ");
	    studentInteraction.viewSavedSchoolDetails("YALE");
	    
	//U14 View user saved statistics
	    System.out.println("-------------------------");
	    System.out.println("Testing view userSavedStatistisc: ");
	    studentInteraction.viewUserSavedStatistics("YALE");
	    studentInteraction.viewUserSavedStatistics("GEORGE WASHINGTON");;
	    
		
	//U15 Compare schools by score
	    System.out.println("UC 15 Compare Schools by SAT Math Score");
	    System.out.println("-------------------------");
	    System.out.println("Testing compare scores");
	    studentInteraction.compareSchoolsByScore();
	    System.out.println();
	
	//U16 View user profile
	    System.out.println("UC 16 View User Profile");
		user.login("nadmin", adminPassword);		
		user.viewProfile(adminUsername);
		System.out.println();
		
	//U17 Edit user information
	    System.out.println("UC 17 Edit User Information");
		user.editProfile("newUser","Nor","A","fasd");
		user.viewProfile("nadmin");
		System.out.println();
		user.editProfile("Noreen", "nadmin", "Admin", "a");
	//U18 View school list
	    System.out.println("UC 18 View School list");
		//adInt.login(adminUsername, adminPassword);
		adInt.viewUniversities();
		System.out.println();
		
	//U21 Add new university
	    System.out.println("UC 21 Add new University");
			System.out.println("Testing Adding a university");
			admin.addNewUniversity("Dummy", "State", "location", "private", "5000", "1", "800", "800", "100000", "20", "1", "5", "1", 
					"3", "4", "5", emphases);
			System.out.println("\nPrinting Dummy school added details: \n");
			user.viewSchoolDetails("Dummy");
			System.out.println();
		
		
		
	//U20 Edit school information
			System.out.println("UC 20 Edit school info");
		admin.editUniversityInfo("Dummy", "State2", "location2", "-1", "-1", "-1", "-1", "-1", "10000000", "-1", "-1", "-1", "-1",
				"-1", "-1", "-1", emphases);
		System.out.println("\n");
		System.out.println();
		
		//Edited schoolInfo Information
		System.out.println("UC 20 Results");
		admin.viewSchoolDetails("Dummy");
		System.out.println("\n");
		System.out.println();
		
		
		//U19 Remove university
	    System.out.println("UC 19 Remove university");
	//	user.viewSchoolDetails("Dummy");
		System.out.println("\n");	
		//System.out.println("\n Testing removing a school");
		admin.removeUniversity("Dummy");
		System.out.println("School Removed \n");
		
		
	//U22 View users
		System.out.println("UC 22 View Users");
		adInt.viewUsers();
		System.out.println();
		
	//U23 Add a new user
		System.out.println("UC 23 Add a new user");
	//	adInt.addUser("Carrie", "Zhang", "cz001", "password", "u");
	//	adInt.toggleActivationStatus("Zhang");
		System.out.println();
		
	//U24 Toggle activation status
//		System.out.println("UC 24 Toggle Activation Status");
//		adInt.addUser("Carrie", "Zhang", "cz001", "password", "u");
//		adInt.addUser("Carrie", "Zhang", "cz001", "", "u");
//		System.out.println();
		
		
	}
}