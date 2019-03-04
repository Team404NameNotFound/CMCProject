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
	private int enrollment;
	private float percentFemale;
	private float satVerbal;
	private float satMath;
	private float cost;
	private float percentFinAid;
	private float percentEnrolled;
	private int applicants;
	private float percentAdmitted;
	private int academicScale;
	private int socialScale;
	private int qualityOfLife;
	private String[] emphases;
	private ArrayList<Student> savedSchool;



	public University(String name, String state, String location, String control, int enrollment, float percentFemale,
			float satVerbal, float satMath, float cost, float percentFinAid, float percentEnrolled, int applicants,
			float percentAdmitted, int academicScale, int socialScale, int qualityOfLife, String[] emphases,
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

	public int getEnrollment() {
		return enrollment;
	}

	public void setEnrollment(int enrollment) {
		this.enrollment = enrollment;
	}

	public float getPercentFemale() {
		return percentFemale;
	}

	public void setPercentFemale(float percentFemale) {
		this.percentFemale = percentFemale;
	}

	public float getSatVerbal() {
		return satVerbal;
	}

	public void setSatVerbal(float satVerbal) {
		this.satVerbal = satVerbal;
	}

	public float getSatMath() {
		return satMath;
	}

	public void setSatMath(float satMath) {
		this.satMath = satMath;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public float getPercentFinAid() {
		return percentFinAid;
	}

	public void setPercentFinAid(float percentFinAid) {
		this.percentFinAid = percentFinAid;
	}

	public float getPercentEnrolled() {
		return percentEnrolled;
	}

	public void setPercentEnrolled(float percentEnrolled) {
		this.percentEnrolled = percentEnrolled;
	}

	public int getApplicants() {
		return applicants;
	}

	public void setApplicants(int applicants) {
		this.applicants = applicants;
	}

	public float getPercentAdmitted() {
		return percentAdmitted;
	}

	public void setPercentAdmitted(float percentAdmitted) {
		this.percentAdmitted = percentAdmitted;
	}

	public int getAcademicScale() {
		return academicScale;
	}

	public void setAcademicScale(int academicScale) {
		this.academicScale = academicScale;
	}

	public int getSocialScale() {
		return socialScale;
	}

	public void setSocialScale(int socialScale) {
		this.socialScale = socialScale;
	}

	public int getQualityOfLife() {
		return qualityOfLife;
	}

	public void setQualityOfLife(int qualityOfLife) {
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
