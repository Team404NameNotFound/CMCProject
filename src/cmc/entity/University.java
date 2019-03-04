/**
 * 
 */
package cmc.entity;
import java.util.*;
/**
 * @author kmendel001
 *
 */
public class University {

	/**
	 * 
	 */
	private String name;
	private String state;
	private String location;
	private String control;
	private String enrollment;
	private String percentFemale;
	private String satVerbal;
	private String satMath;
	private String cost;
	private String percentFinAid;
	private String percentEnrolled;
	private String applicants;
	private String percentAdmitted;
	private String academicScale;
	private String socialScale;
	private String qualityOfLife;
	private String[] emphases;
	private ArrayList<Student> savedSchool;



	public University(String name, String state, String location, String control, String enrollment, String percentFemale,
			String satVerbal, String satMath, String cost, String percentFinAid, String percentEnrolled, String applicants,
			String percentAdmitted, String academicScale, String socialScale, String qualityOfLife, String[] emphases,
			ArrayList<Student> savedSchool) {
		super();
		this.name = name;
		this.state = state;
		this.location = location;
		this.control = control;
		this.enrollment = enrollment;
		this.percentFemale = percentFemale;
		this.satVerbal = satVerbal;
		this.satMath = satMath;
		this.cost = cost;
		this.percentFinAid = percentFinAid;
		this.percentEnrolled = percentEnrolled;
		this.applicants = applicants;
		this.percentAdmitted = percentAdmitted;
		this.academicScale = academicScale;
		this.socialScale = socialScale;
		this.qualityOfLife = qualityOfLife;
		this.emphases = emphases;
		this.savedSchool = savedSchool;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getControl() {
		return control;
	}

	public void setControl(String control) {
		this.control = control;
	}

	public String getEnrollment() {
		return enrollment;
	}

	public void setEnrollment(String enrollment) {
		this.enrollment = enrollment;
	}

	public String getPercentFemale() {
		return percentFemale;
	}

	public void setPercentFemale(String percentFemale) {
		this.percentFemale = percentFemale;
	}

	public String getSatVerbal() {
		return satVerbal;
	}

	public void setSatVerbal(String satVerbal) {
		this.satVerbal = satVerbal;
	}

	public String getSatMath() {
		return satMath;
	}

	public void setSatMath(String satMath) {
		this.satMath = satMath;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public String getPercentFinAid() {
		return percentFinAid;
	}

	public void setPercentFinAid(String percentFinAid) {
		this.percentFinAid = percentFinAid;
	}

	public String getPercentEnrolled() {
		return percentEnrolled;
	}

	public void setPercentEnrolled(String percentEnrolled) {
		this.percentEnrolled = percentEnrolled;
	}

	public String getApplicants() {
		return applicants;
	}

	public void setApplicants(String applicants) {
		this.applicants = applicants;
	}

	public String getPercentAdmitted() {
		return percentAdmitted;
	}

	public void setPercentAdmitted(String percentAdmitted) {
		this.percentAdmitted = percentAdmitted;
	}

	public String getAcademicScale() {
		return academicScale;
	}

	public void setAcademicScale(String academicScale) {
		this.academicScale = academicScale;
	}

	public String getSocialScale() {
		return socialScale;
	}

	public void setSocialScale(String socialScale) {
		this.socialScale = socialScale;
	}

	public String getQualityOfLife() {
		return qualityOfLife;
	}

	public void setQualityOfLife(String qualityOfLife) {
		this.qualityOfLife = qualityOfLife;
	}

	public String[] getEmphases() {
		return emphases;
	}

	public void setEmphases(String[] emphases) {
		this.emphases = emphases;
	}

	public ArrayList<Student> getSavedSchool() {
		return savedSchool;
	}

	public void setSavedSchool(ArrayList<Student> savedSchool) {
		this.savedSchool = savedSchool;
	}

}
