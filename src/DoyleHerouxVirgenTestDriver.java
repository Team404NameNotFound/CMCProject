
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


	}
}
