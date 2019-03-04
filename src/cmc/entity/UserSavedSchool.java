/**
 * 
 */
package cmc.entity;

import java.util.ArrayList;

public class UserSavedSchool extends University{

	/**
	 * @author kmendel001
	 * 
	 */
	
	private String dateAdded;
	private University university;
	
	
	public UserSavedSchool(String name, String state, String location, String control, String enrollment,
			String percentFemale, String satVerbal, String satMath, String cost, String percentFinAid,
			String percentEnrolled, String applicants, String percentAdmitted, String academicScale, String socialScale,
			String qualityOfLife, String[] emphases, ArrayList<Student> savedSchool, String dateAdded, University university) {
		super(name, state, location, control, enrollment, percentFemale, satVerbal, satMath, cost, percentFinAid,
				percentEnrolled, applicants, percentAdmitted, academicScale, socialScale, qualityOfLife, emphases, savedSchool);
		this.dateAdded = dateAdded;
		this.university = university;
	}


	public String getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(String dateAdded) {
		this.dateAdded = dateAdded;
	}



	public University getUniversity() {
		return university;
	}



	public void setUniversity(University university) {
		this.university = university;
	}



	public int getSavedStatistics(University university) {
		int count = 0;
		for(@SuppressWarnings("unused") Student student: university.getSavedSchool()) {
				count += 1;
		}
		return count;
	}
	

}
