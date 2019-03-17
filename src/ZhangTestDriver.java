import java.util.ArrayList;

import cmc.entity.Admin;
import cmc.entity.Student;
import cmc.entity.UserSavedSchool;
import cmc.functionality.AccountController;
import cmc.functionality.AdminFunctionalityController;
import cmc.interaction.AccountInteraction;
import cmc.interaction.AdminInteraction;
import cmc.interaction.StudentInteraction;
import dblibrary.project.csci230.UniversityDBLibrary;

public class ZhangTestDriver {
	
	static UniversityDBLibrary dbLibrary = new UniversityDBLibrary("error404", "csci230");
	static String[][] universities = dbLibrary.university_getUniversities();
	static String[][] users = dbLibrary.user_getUsers();
	static String[][] nwe = dbLibrary.university_getNamesWithEmphases();
	
	ArrayList<UserSavedSchool> studentSavedSchools = new ArrayList<>();
	Student account = new Student("Cool", "User", "cuser", "user" ,"u", "Y", studentSavedSchools);
	AccountController accountController = new AccountController(account);
    static StudentInteraction studentInteraction = new StudentInteraction();
	static AdminInteraction adInt = new AdminInteraction();
	
	public static void main(String[] args) {
		
		ArrayList<UserSavedSchool> studentSavedSchools = new ArrayList<>();
		Student student = new Student("Cool", "User", "cuser", "user" ,"u", "Y", studentSavedSchools);
		AccountController accountController = new AccountController(student);
		Admin admin = new Admin("Noreen", "Admin", "nadmin", "admin", "a", "Y");
		//Create a new accontController2 for admin account
		AccountController accountController2 = new AccountController(admin);
		accountController2.setAccount(admin);
		AdminFunctionalityController afCon = new AdminFunctionalityController();
		afCon.setAccount(accountController2);
		adInt = new AdminInteraction(afCon);
	    
		
//		//test saveSchool()
//		accountController.saveSchool("AMERICAN UNIVERSITY OF BEIRUT");
//		accountController.saveSchool("YALE");
//		System.out.println("Schools being saved are: ");
//	    for(UserSavedSchool ss: student.getSavedSchools()) {
//	    	System.out.println(ss.getName());
//	    }
//	    
//	    System.out.println("----------------");
//	    //test viewSavedSchool()
//	    studentInteraction.getSfCon().setAccount(new AccountController(student));
//	    studentInteraction.viewSavedSchools();
//	    
//	    System.out.println("----------------");
//	    //test removeSavedSchool(String school)
//	    studentInteraction.removeSavedSchool("YALE");
//	    System.out.println("After removing YALE ");
//	    studentInteraction.viewSavedSchools();
//	    
//	    System.out.println("----------------");
//	    //test viewSavedSchoolDetails(String school)
//	    studentInteraction.viewSavedSchoolDetails("AMERICAN UNIVERSITY OF BEIRUT");
//	    studentInteraction.viewSavedSchoolDetails("YALE");
//	    

		
		adInt.addUser("Carrie", "Zhang", "cz001", "password", "u");
		adInt.toggleActivationStatus("cz001");
		
	    
	}
}
