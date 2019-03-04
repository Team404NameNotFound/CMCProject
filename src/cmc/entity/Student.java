/**
 * 
 */
package cmc.entity;
import java.util.*;
/**
 * @author kmendel001
 *
 */
public class Student extends Account {

	/**
	 * 
	 */
	private ArrayList<UserSavedSchool> savedSchools;

	public Student(String firstName, String lastName, String username, String password, char userType,
			char userStatus, ArrayList<UserSavedSchool> savedSchools) {
		super(firstName, lastName, username, password, userType, userStatus);
		this.savedSchools = savedSchools;
	}

	public ArrayList<UserSavedSchool> getSavedSchools() {
		return savedSchools;
	}

	public void setSavedSchools(ArrayList<UserSavedSchool> savedSchools) {
		this.savedSchools = savedSchools;
	}
}
