/**
 * 
 */
import cmc.*;
import cmc.entity.*;
import cmc.interaction.*;
/**
 * @author kmendel001
 *
 */
public class FunctionalityTestDriver {
	
	AccountInteraction user = new AccountInteraction();
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//successful login (user)
		String userUsername = "John";
		String userPassword = "User";
		user.login(userUsername, userPassword);
		user.logout();
		
		//successful login (admin)
		String adminUsername = "Noreen";
		String adminPassword = "Admin";
		user.login(adminUsername, adminPassword);
		user.logout();
		
		//failed login - invalid credentials (admin and user)
		String username = "Team";
		String password = "404";
		user.login(username, password);
		user.logout();
		
		//failed login - inactive status (admin and user)
		String username = "Lynn";
		String password = "User";
		user.login(username, password);
		user.logout();
		
		//view profile (user)
		user.login(userUsername, userPassword);
		
		user.viewProfile();
		
		
		//edit profile (user)
		user.editProfile("","","","");
		user.viewProfile();
		
		user.logout();
		
		//view profile (admin)
		user.login(adminUsername, adminPassword);
		
		user.viewProfile();
		
		//edit profile (admin)
		user.editProfile("","","","", "", "");
		user.viewProfile();
		
		user.logout();
		
		//Search for schools - state, # of students (user)
		user.login(userUsername, userPassword);

		String state = "Texas";
		int numStudentsLower = 10000;
		int numStudentsUpper = 12000;
		String results = search(state, numStudentsLower, numStudentsUpper);
		print(results);
		
		//find top 5 recommended schools (user)
		University university = new University(/*info for a school*/);
		String recommended = findRecommended(university);
		print(recommended);
		
		user.logout();
		
		//view list of universities (admin)
		user.login(adminUsername, adminPassword);
		viewUniversityList(/*parameters*/);
		
		user.logout();

	}

}
