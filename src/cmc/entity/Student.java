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

	/**
	 * @param firstName first name of the Account
	 * @param lasName last name of the Account
	 * @param username username of the Account
	 * @param password password of the Account
	 * @param userType type of account admin or student
	 * @param userStatus whether account is active or inactive
	 * @param savedSchools schools in the student's saved school list
	 */
	public Student(String firstName, String lastName, String username, String password, String userType,
			String userStatus, ArrayList<UserSavedSchool> savedSchools) {
		super(firstName, lastName, username, password, userType, userStatus);
		this.savedSchools = savedSchools;
	}
	public Student(Account account, ArrayList<UserSavedSchool> savedSchools) {
		super(account.getFirstName(), account.getLastName(), account.getUsername(), 
				account.getPassword(), account.getUserType(), account.getUserStatus());
		this.savedSchools = savedSchools;
	}

	/**
	 * @return list of schools that the student has saved
	 */
	public ArrayList<UserSavedSchool> getSavedSchools() {
		return savedSchools;
	}

	/**
	 * @param savedSchools list of schools that the student has saved
	 */
	public void setSavedSchools(ArrayList<UserSavedSchool> savedSchools) {
		this.savedSchools = savedSchools;
	}
	
	/**
	 * @param universityName name of the university
	 * @return if the student has saved that particular university
	 */
	public boolean isSchoolSaved(String universityName) {
		boolean found = false;
		for(UserSavedSchool university: savedSchools) {
			if(university.getName().equals(universityName)) {
				found = true;
			}
		}
		return found;
	}
	
	/**
	 * @param universityName name of a university
	 */
	public void removeSchool(String universityName) {
		for(int i=0; i<savedSchools.size(); i++) {
			if(savedSchools.get(i).getName().equals(universityName)) {
				savedSchools.remove(i);
			}
		}
	}
	
	/**
	 * @param university university object
	 * @param dateAdded date the school was saved
	 */
	public void saveSchool(University university, String dateAdded) {
		UserSavedSchool schoolToSave = new UserSavedSchool(university, dateAdded);
		savedSchools.add(schoolToSave);
		schoolToSave.getStudents().add(this.getUsername());
	}
	

}
