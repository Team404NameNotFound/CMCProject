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

	public Student(String firstName, String lastName, String username, String password, String userType,
			String userStatus, ArrayList<UserSavedSchool> savedSchools) {
		super(firstName, lastName, username, password, userType, userStatus);
		this.savedSchools = savedSchools;
	}

	public ArrayList<UserSavedSchool> getSavedSchools() {
		return savedSchools;
	}

	public void setSavedSchools(ArrayList<UserSavedSchool> savedSchools) {
		this.savedSchools = savedSchools;
	}
	
	public boolean isSchoolSaved(String universityName) {
		boolean found = false;
		for(UserSavedSchool university: savedSchools) {
			if(university.getName().equals(universityName)) {
				found = true;
			}
		}
		return found;
	}
	
	public void removeSchool(String universityName) {
		for(int i=0; i<savedSchools.size(); i++) {
			if(savedSchools.get(i).getName().equals(universityName)) {
				savedSchools.remove(i);
			}
		}
	}

}
