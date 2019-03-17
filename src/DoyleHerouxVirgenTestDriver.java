
	import cmc.*;
	import cmc.entity.*;
	import cmc.functionality.DBController;
	import cmc.interaction.*;
	import java.util.ArrayList;
	
public class DoyleHerouxVirgenTestDriver {

	


	/**
	 * @author kmendel001
	 *
	 */
	static AccountInteraction user = new AccountInteraction();
	static StudentInteraction student =  new StudentInteraction();
	static AdminInteraction admin = new AdminInteraction();
	
	public static void main(String[] args) {
		

		
		//successful login (user)
		System.out.println("Successful login (user):");
		System.out.println("-------------------------");
		String userUsername = "juser";
		String userPassword = "user";
		user.login(userUsername, userPassword);

		System.out.println("\nSearching and Matching on Fields:");
		System.out.println("-------------------------");
		String state = "California";
		int numStudentsLower = 2000;
		int numStudentsUpper = 30000;
		String[] emphases = {};
		student.fieldSearch( "", state, "", numStudentsLower,
				numStudentsUpper, (float)-1.0,(float)-1.0, -1, 
				-1, -1, -1, -1, -1, 
				(float)-1.0, (float)-1.0, -1, 
				-1, (float)-1.0, (float)-1.0,
				(float)-1.0, (float)-1.0, -1, -1,
				-1, -1, -1, -1, emphases
				);
		
		//printing a school's details
		System.out.println("\n Testing printing  a school's details\n");
		user.viewSchoolDetails("UNIVERSITY OF MINNESOTA");
		
		System.out.println("Testing Adding a university");
		admin.addNewUniversity("Dummy", "State", "location", "private", "5000", "1", "800", "800", "100000", "20", "1", "5", "1", 
				"3", "4", "5", emphases);
		System.out.println("Printing Dummy school added details: ");
		user.viewSchoolDetails("Dummy");
		
		System.out.println("Testing removing a school");
		admin.removeUniversity("Dummy");
		
	}
}
