package cmc.functionality;
import java.util.ArrayList;
import cmc.entity.*;
/**
 * 
 * @author ajheroux
 *
 */
public class AdminFunctionalityController extends UserFunctionalityController {
	//constructer
	public AdminFunctionalityController() {
		
	}
	
	/**
	 * Calls the database controller to retrieve a list of university objects
	 * @return a list of university objects
	 */
	public ArrayList<University> viewUniversities() {
		return this.DBCon.getUniversityList();
	}
	
	
	/**
	 * Calls the database controller to retrieve a list of account objects
	 * @return a list of account objects
	 */
	public ArrayList<Account> viewUsers() {
		return this.DBCon.getAccountList();
	}

}
