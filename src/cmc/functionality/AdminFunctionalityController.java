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

	public void addNewUniversity(String name, String state, String location, String control, String enrollment,
			String percentFemale, String satVerbal, String satMath, String cost, String percentFinAid,
			String percentEnrolled, String applicants, String percentAdmitted, String academicScale, String socialScale,
			String qualityOfLife, String[] emphases) {
			if (this.DBCon.getUniversity(name) != null) {
				System.out.println(name + " already exists");
			}
			else {
			University schoolToAdd = this.universityCon.createNewUniversity(name, state, location, control, enrollment, percentFemale, 
					satVerbal, satMath, cost, percentFinAid, percentEnrolled, applicants, 
					percentAdmitted, academicScale, socialScale, qualityOfLife, emphases);
					
			this.DBCon.addUniversity(schoolToAdd);
			}
		
	}

}
