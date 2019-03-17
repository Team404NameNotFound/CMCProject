import java.util.ArrayList;

import cmc.entity.Student;
import cmc.entity.UserSavedSchool;
import cmc.functionality.AccountController;
import dblibrary.project.csci230.UniversityDBLibrary;

public class ZhangTestDriver {
	
	static UniversityDBLibrary dbLibrary = new UniversityDBLibrary("error404", "csci230");
	static String[][] universities = dbLibrary.university_getUniversities();
	static String[][] users = dbLibrary.user_getUsers();
	static String[][] nwe = dbLibrary.university_getNamesWithEmphases();
	
	ArrayList<UserSavedSchool> studentSavedSchools = new ArrayList<>();
	Student account = new Student("Cool", "User", "cuser", "user" ,"u", "Y", studentSavedSchools);
	AccountController accountController = new AccountController(account);
	
	public static void main(String[] args) {
		
		ArrayList<UserSavedSchool> studentSavedSchools = new ArrayList<>();
		Student student = new Student("Cool", "User", "cuser", "user" ,"u", "Y", studentSavedSchools);
		AccountController accountController = new AccountController(student);
		
		//test saveSchool()
		accountController.saveSchool("AMERICAN UNIVERSITY OF BEIRUT");
		accountController.saveSchool("YALE");
		System.out.println("Schools being saved are: ");
	    for(UserSavedSchool ss: student.getSavedSchools()) {
	    	System.out.println(ss.getName());
	    }
	}
}
