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
	protected ArrayList<UserSavedSchool> savedSchools;

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
	
	public void saveSchool(University university, String dateAdded) {
		UserSavedSchool savedUniversity = new UserSavedSchool(university.getName(), university.getState(), university.getLocation(), 
				university.getControl(), university.getEnrollment(), university.getPercentFemale(), university.getSatVerbal(), 
				university.getSatMath(), university.getCost(), university.getPercentFinAid(), university.getPercentEnrolled(), 
				university.getApplicants(), university.getPercentAdmitted(), university.getAcademicScale(), university.getSocialScale(),
				university.getQualityOfLife(), university.getEmphases(), university.getSavedSchool(), dateAdded);
		savedSchools.add(savedUniversity);
	}
	

}
