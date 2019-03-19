import java.util.ArrayList;

import cmc.entity.Admin;
import cmc.entity.Student;
import cmc.entity.UserSavedSchool;
import cmc.functionality.AccountController;
<<<<<<< HEAD
import cmc.functionality.StudentFunctionalityController;
=======
import cmc.functionality.AdminFunctionalityController;
>>>>>>> d6dd5d56471dc1c7d3e85fb92a29e9f4bf360d86
import cmc.interaction.AccountInteraction;
import cmc.interaction.AdminInteraction;
import cmc.interaction.StudentInteraction;
import dblibrary.project.csci230.UniversityDBLibrary;

public class ZhangTestDriver {
	
	static ArrayList<UserSavedSchool> studentSavedSchools = new ArrayList<>();
	static Student student = new Student("Cool", "User", "cuser", "user" ,"u", "Y", studentSavedSchools);
	static AccountController accountController = new AccountController(student);
    static StudentInteraction studentInteraction = new StudentInteraction();
<<<<<<< HEAD
    static StudentFunctionalityController sfCon = new StudentFunctionalityController();
    
	public static void main(String[] args) {
		
		sfCon.setAccount(accountController);
		studentInteraction.setSfCon(sfCon);
		
		//test saveSchool()
		studentInteraction.saveSchool("AMERICAN UNIVERSITY OF BEIRUT");
		studentInteraction.saveSchool("YALE");
		studentInteraction.saveSchool("AUGSBURG"); 
		studentInteraction.saveSchool("GEORGE WASHINGTON");
		System.out.println("Schools being saved are: ");
	    studentInteraction.viewSavedSchools();
	    
=======
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
>>>>>>> d6dd5d56471dc1c7d3e85fb92a29e9f4bf360d86
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
<<<<<<< HEAD
//	    System.out.println("----------------");
//	    //test viewUserSavedStatistics(String school)
//	    studentInteraction.viewUserSavedStatistics("YALE");
//	    studentInteraction.viewUserSavedStatistics("AUGSBURG");
=======

		
		adInt.addUser("Carrie", "Zhang", "cz001", "password", "u");
		adInt.toggleActivationStatus("Zhang");
		
>>>>>>> d6dd5d56471dc1c7d3e85fb92a29e9f4bf360d86
	    
	}
}
