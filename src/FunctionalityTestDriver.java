/**
 * 
 */
import cmc.*;
/**
 * @author kmendel001
 *
 */
public class FunctionalityTestDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//successful login (user)
		String userUsername = "John";
		String userPassword = "User";
		Account user = login(userUsername, userPassword);
		
		//successful login (admin)
		String adminUsername = "Noreen";
		String adminPassword = "Admin";
		user = login(adminUsername, adminPassword);
		
		//failed login - invalid credentials (admin and user)
		String username = "Team";
		String password = "404";
		user = login(username, password);
		
		//failed login - inactive status (admin and user)
		String username = "Lynn";
		String password = "User";
		user = login(username, password);
		
		//view profile (user)
		user = login(userUsername, userPassword);
		
		user.viewProfile();
		
		
		//edit profile (user)
		user.editProfile("","","","");
		user.viewProfile();
		
		//view profile (admin)
		user = login(adminUsername, adminPassword);
		
		user.viewProfile();
		
		//edit profile (admin)
		user.editProfile("","","","", "", "");
		user.viewProfile();
		
		//Search for schools - state, # of students (user)
		user = login(userUsername, userPassword);

		String state = "Texas";
		int numStudentsLower = 10000;
		int numStudentsUpper = 12000;
		String results = search(state, numStudentsLower, numStudentsUpper);
		print(results);
		
		//find top 5 recommended schools (user)
		University university = new University(/*info for a school*/);
		String recommended = findRecommended(university);
		print(recommended);
		
		//view list of universities (admin)
		user = login(adminUsername, adminPassword);
		viewUniversityList(/*parameters*/);

	}

}
