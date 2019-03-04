/**
 * 
 */
package cmc.entity;

public class UserSavedSchool {

	/**
	 * @author kmendel001
	 * 
	 */
	
	private String dateAdded;
	private University university;
	
	
	public UserSavedSchool(String dateAdded, University university) {
		super();
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
