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
		System.out.println("-------------------------\n\n\n");
		
		//UC 2 Logout
		System.out.println("UC 2: Successful logout:");
		System.out.println("-------------------------");
		user.logout();
		System.out.println("-------------------------\n\n\n");
		
		//successful login (admin)
		System.out.println("UC 1: Successful login (admin):");
		System.out.println("-------------------------");
		String adminUsername = "nadmin";
		String adminPassword = "a";
		user.login(adminUsername, adminPassword);
		System.out.println("-------------------------\n\n\n");
		
		//successful logout
		System.out.println("UC 2: Successful logout:");
		System.out.println("-------------------------");
		user.logout();
		System.out.println("-------------------------\n\n\n");
		
		//failed login - invalid credentials (admin and user)
		System.out.println("UC 1: Failed login (invalid credentials):");
		System.out.println("-------------------------");
		String username1 = "Team";
		String password1 = "404";
		user.login(username1, password1);
		System.out.println("-------------------------\n\n\n");
		
		//failed login - inactive status (admin and user)
		System.out.println("UC 1: Failed login (inactive status):");
		System.out.println("-------------------------");
		String username2 = "luser";
		String password2 = "user";
		user.login(username2, password2);
		System.out.println("-------------------------\n\n\n");
		
		//UC 3 Request new password
		System.out.println("UC 3: Request New Password");
		System.out.println("-------------------------");
		adInt.addUser("Imad", "Rahal", "irahal@csbsju.edu", "password", "u");
		System.out.println("UC 3: Forgot Password");
		adInt.forgotPsw("irahal@csbsju.edu");
		System.out.println("-------------------------\n\n\n");
		
		//Login to test the rest of the functionalities
		System.out.println("Login to test the rest of the functionalities");
		System.out.println("-------------------------");
		adInt.login("nadmin", "a");
		System.out.println("-------------------------\n\n\n");
		

		
		//UC 4 Search Abstract fulfilled by U5 & U6
	
		
		//UC 5 Take personality quiz
		
		
		//UC 6&7  Search by entering fields
		System.out.println("UC 6 & 7 Searching and Matching on Fields:");
		System.out.println("-------------------------");
		String state = "Texas";
		int numStudentsLower = 2000;
		int numStudentsUpper = 50000;
		String[] emphases = {};
		student.fieldSearch( "-1", state, "-1", numStudentsLower,
				numStudentsUpper, (float)-1.0,(float)-1.0, -1, 
				-1, -1, -1, -1, -1, 
				(float)-1.0, (float)-1.0, -1, 
				-1, (float)-1.0, (float)-1.0,
				(float)-1.0, (float)-1.0, -1, -1,
				-1, -1, -1, -1, emphases, "-1"
				);
		System.out.println("-------------------------\n\n\n");
		
	//U8 View searched school details
		System.out.println("UC 8 Testing printing  a school's details:");
		System.out.println("-------------------------");
		user.viewSchoolDetails("UNIVERSITY OF MINNESOTA");
		
		System.out.println("Testing Adding a university");
		admin.addNewUniversity("Dummy", "State", "location", "private", "5000", "1", "800", "800", "100000", "20", "1", "5", "1", 
				"3", "4", "5", emphases);
		System.out.println("\nPrinting Dummy school added details: \n");
		user.viewSchoolDetails("Dummy");
		System.out.println("-------------------------\n\n\n");
		
	//U9 View additional recommended schools
		System.out.println("UC 9 Closest Matches From Selected University:");
		System.out.println("-------------------------");
		DBController db = new DBController();
		ArrayList<University> uniSchools = db.getUniversityList();
		University university = uniSchools.get(9);
		student.findRecommended(university);
		System.out.println("-------------------------\n\n\n");
		
	//U10 Save school
		System.out.print("UC 10 Save School:");
		System.out.println("-------------------------");
		sfCon.setAccount(accountController);
		studentInteraction.setSfCon(sfCon);
		System.out.println("-------------------------\n\n\n");
		
		//test saveSchool()
		System.out.println("-------------------------");
		System.out.println("Testing save schools: ");
		sfCon.setAccount(accountController);
		studentInteraction.setSfCon(sfCon);

		studentInteraction.saveSchool("AMERICAN UNIVERSITY OF BEIRUT");
		studentInteraction.saveSchool("YALE");
		studentInteraction.saveSchool("AUGSBURG"); 
		studentInteraction.saveSchool("GEORGE WASHINGTON");

		System.out.println("Schools being saved are:");
	    studentInteraction.viewSavedSchools();
	    System.out.println("-------------------------\n\n\n");

		
	//U11 View saved schools
	    System.out.println("UC 11 View saved schools:");
	    System.out.println("-------------------------");
	    System.out.println("Testing view saved schools: ");
	    studentInteraction.viewSavedSchools();
	    System.out.println("-------------------------\n\n\n");
	    
	//U12 Remove a saved school
	    System.out.println("Remove a saved school:");
	    System.out.println("-------------------------");
	    System.out.println("Testing remove a saved school, remove: GEORGE WASHINGTON\"");
	    studentInteraction.removeSavedSchool("GEORGE WASHINGTON");
	    System.out.println("After removing, the new saved school list for current user is");
	    studentInteraction.viewSavedSchools();
	    System.out.println("-------------------------\n\n\n");
	    
	//U13 View saved school details
	    System.out.println("View saved school details:");
	    System.out.println("-------------------------");
	    System.out.println("Testing view a saved school details: ");
	    studentInteraction.viewSavedSchoolDetails("YALE");
	    System.out.println("-------------------------\n\n\n");
	    
	//U14 View user saved statistics
	    System.out.println("View user saved statistics:");
	    System.out.println("-------------------------");
	    System.out.println("Testing view userSavedStatistisc: ");
	    studentInteraction.viewUserSavedStatistics("YALE");
	    studentInteraction.viewUserSavedStatistics("GEORGE WASHINGTON");;
	    System.out.println("-------------------------\n\n\n");
	    
		
	//U15 Compare schools by score
	    System.out.println("UC 15 Compare Schools by SAT Math Score:");
	    System.out.println("-------------------------");
	    System.out.println("Testing compare scores");
	    studentInteraction.compareSchoolsByScore();
	    System.out.println("-------------------------\n\n\n");
	
	//U16 View user profile
	    System.out.println("UC 16 View User Profile");
	    System.out.println("-------------------------");
		user.login("nadmin", adminPassword);		
		user.viewProfile(adminUsername);
		System.out.println("-------------------------\n\n\n");
		
	//U17 Edit user information
	    System.out.println("UC 17 Edit User Information:");
	    System.out.println("-------------------------");
		user.editProfile("newUser","Nor","A","fasd");
		user.viewProfile("nadmin");
		System.out.println();
		user.editProfile("Noreen", "nadmin", "Admin", "a");
		
	//U18 View school list
	    System.out.println("UC 18 View School list:");
		//adInt.login(adminUsername, adminPassword);
		adInt.viewUniversities();
		System.out.println("-------------------------\n\n\n");
		
	//U21 Add new university
	    System.out.println("UC 21 Add new University:");
	    System.out.println("-------------------------");
		System.out.println("Testing Adding a university");
			admin.addNewUniversity("Dummy", "State", "location", "private", "5000", "1", "800", "800", "100000", "20", "1", "5", "1", 
					"3", "4", "5", emphases);
		System.out.println("\nPrinting Dummy school added details: \n");
			user.viewSchoolDetails("Dummy");
		System.out.println("-------------------------\n\n\n");
		
		
		
		//U20 Edit school information
		System.out.println("UC 20 Edit school info:");
		System.out.println("-------------------------");
		admin.editUniversityInfo("Dummy", "State2", "location2", "-1", "-1", "-1", "-1", "-1", "10000000", "-1", "-1", "-1", "-1",
				"-1", "-1", "-1", emphases);
		System.out.println("\n");
		System.out.println();
		
		//Edited schoolInfo Information
		System.out.println("UC 20 Results");
		admin.viewSchoolDetails("Dummy");
		System.out.println("-------------------------\n\n\n");
		
		
		//U19 Remove university
	    System.out.println("UC 19 Remove university:");
	    System.out.println("-------------------------");
		admin.removeUniversity("Dummy");
		System.out.println("School Removed");
		System.out.println("-------------------------\n\n\n");
		
		
	//U22 View users
		System.out.println("UC 22 View Users:");
		System.out.println("-------------------------");
		adInt.viewUsers();
		System.out.println("-------------------------\n\n\n");
		
	//U23 Add a new user & U24 Toggle activation status
		System.out.println("UC 23 Add a new user & UC 24 Toggle Activation Status:");
		System.out.println("-------------------------");
		adInt.addUser("Carrie", "Zhang", "cz001", "password", "u");
		adInt.toggleActivationStatus("cz001");
		System.out.println("-------------------------\n\n\n");
		System.out.println("END OF DRIVER");
	}
}