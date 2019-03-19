import java.util.ArrayList;

import cmc.entity.Student;
import cmc.entity.UserSavedSchool;
import cmc.functionality.AccountController;
import cmc.functionality.StudentFunctionalityController;
import cmc.interaction.AccountInteraction;
import cmc.interaction.StudentInteraction;
import dblibrary.project.csci230.UniversityDBLibrary;

public class ZhangTestDriver {
	
	static ArrayList<UserSavedSchool> studentSavedSchools = new ArrayList<>();
	static Student student = new Student("Cool", "User", "cuser", "user" ,"u", "Y", studentSavedSchools);
	static AccountController accountController = new AccountController(student);
    static StudentInteraction studentInteraction = new StudentInteraction();
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
//	    System.out.println("----------------");
//	    //test viewUserSavedStatistics(String school)
//	    studentInteraction.viewUserSavedStatistics("YALE");
//	    studentInteraction.viewUserSavedStatistics("AUGSBURG");
	    
	}
}
