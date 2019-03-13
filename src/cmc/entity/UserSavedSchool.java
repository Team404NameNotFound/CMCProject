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
	
	
	public UserSavedSchool(String name, String state, String location, String control, String enrollment,
			String percentFemale, String satVerbal, String satMath, String cost, String percentFinAid,
			String percentEnrolled, String applicants, String percentAdmitted, String academicScale, String socialScale,
			String qualityOfLife, String[] emphases, ArrayList<Student> savedSchool, String dateAdded) {
		super(name, state, location, control, enrollment, percentFemale, satVerbal, satMath, cost, percentFinAid,
				percentEnrolled, applicants, percentAdmitted, academicScale, socialScale, qualityOfLife, emphases, savedSchool);
		this.dateAdded = dateAdded;
	}
	public UserSavedSchool(University school, String dateAdded) {
		super(school.getName(), school.getState(), school.getLocation(), school.getControl(), school.getEnrollment(), school.getPercentFemale(), school.getSatVerbal(), school.getSatMath(), school.getCost(), school.getPercentFinAid(),
				school.getPercentEnrolled(), school.getApplicants(), school.getPercentAdmitted(), school.getAcademicScale(), school.getSocialScale(), school.getQualityOfLife(), school.getEmphases(), school.getSavedSchool());
		this.dateAdded = dateAdded;
	}

	public String getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(String dateAdded) {
		this.dateAdded = dateAdded;
	}

	public int getSavedStatistics(University university) {
		int count = 0;
		for(@SuppressWarnings("unused") Student student: university.getSavedSchool()) {
				count += 1;
		}
		return count;
	}
	

}
