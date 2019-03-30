/**
 * 
 */
package cmc.functionality;
import cmc.entity.*;
import java.util.ArrayList;

/**
 * @author kmendel001
 *
 */
public class UniversityController {

	University school;
	/**
	 * constructs a new UniversityController with the school provided 
	 * @param schooltoChange the University object that will be changed/updated
	 */
	public UniversityController(University schoolToChange) {
		this.school = schoolToChange;
	}
	
	public UniversityController() {
		this.school = new University();
	}

	/**
	 * returns a string of all the school's attributes
	 * @return String the string for the school
	 */
	public String getSchoolDetails()
	{
		String schoolDetails = " Name: "+  school.getName() + " State: " + school.getState() + " Location: " + school.getLocation() + "\n" +
	   " Control: " + school.getControl()+ " Entrollment: " +school.getEnrollment()+ " FemalePercent: " + school.getPercentFemale() + " \n" 
	   + " SatVerbal: " + school.getSatVerbal() + " SatMath: " + school.getSatMath() + " Cost: "  + school.getCost() + " \n " +
	   " PercentFinAid: " + school.getPercentFinAid()+ " Applicants: "
		+ school.getApplicants() + " PercentAdmitted: "+ school.getPercentAdmitted() + "\n" + " PercentEnrolled: " 
	    + school.getPercentEnrolled() + " AcademicScale: " + school.getAcademicScale() + " SocialScale: " + school.getSocialScale() + " QualityOfLife: " + school.getQualityOfLife();
		return schoolDetails;
		
	}
	
	/**
	 * updates the information for a school from what the admin provided
	 * @param name
	 * @param state
	 * @param location
	 * @param control
	 * @param enrollment
	 * @param percentFemale
	 * @param satVerbal
	 * @param satMath
	 * @param cost
	 * @param percentFinAid
	 * @param percentEnrolled
	 * @param applicants
	 * @param percentAdmitted
	 * @param academicScale
	 * @param socialScale
	 * @param qualityOfLife
	 * @param emphases
	 * @param savedSchool
	 * @return
	 */
	public University updateUniversityInfo(String name, String state, String location, String control, String enrollment, String percentFemale,
			String satVerbal, String satMath, String cost, String percentFinAid, String percentEnrolled, String applicants,
			String percentAdmitted, String academicScale, String socialScale, String qualityOfLife, String[] emphases
			)
	{
		//goes through and tests every parameter to see if it has a value so that only the parameters with new values are updated
		if(!name.equals("-1"))
		{
			school.setName(name);
		}
		if(!state.equals("-1") && !state.equals(""))
		{
			school.setState(state);
		}
		if(!location.equals("-1") && !location.equals(""))
		{
			school.setLocation(location);
		}
		if(!control.equals("-1"))
		{
			school.setControl(control);
		}
		if(!enrollment.equals("-1") && !enrollment.equals(""))
		{
			school.setEnrollment(enrollment);
		}
		if(!percentFemale.equals("-1") && !percentFemale.equals(""))
		{
			school.setPercentFemale(percentFemale);
		}
		if(!satVerbal.equals("-1") && !satVerbal.equals(""))
		{
			school.setSatVerbal(satVerbal);
		}
		if(!satMath.equals("-1") && !satMath.equals(""))
		{
			school.setSatMath(satMath);
		}
		if(!cost.equals("-1") && !cost.equals(""))
		{
			school.setCost(cost);
		}
		if(!percentFinAid.equals("-1") && !percentFinAid.equals(""))
		{
			school.setPercentFinAid(percentFinAid);
		}
		if(!applicants.equals("-1") && !applicants.equals(""))
		{
			school.setApplicants(applicants);
		}
		if(!percentAdmitted.equals("-1") && !percentAdmitted.equals(""))
		{
			school.setPercentAdmitted(percentAdmitted);
		}
		if(!percentEnrolled.equals("-1") && !percentEnrolled.equals(""))
		{
			school.setPercentEnrolled(percentEnrolled);
		}
		if(!academicScale.equals("-1") && !academicScale.equals(""))
		{
			school.setAcademicScale(academicScale);
		}
		if(!socialScale.equals("-1") && !socialScale.equals(""))
		{
			school.setSocialScale(socialScale);
		}
		if(!qualityOfLife.equals("-1") && !qualityOfLife.equals(""))
		{
			school.setQualityOfLife(qualityOfLife);
		}
		if(!emphases[0].equals("-1") && !emphases[0].equals(""))
		{
			school.setEmphases(emphases);
		}
		return school;
	}
	
	/**Create a new University
	 * @param name
	 * @param state
	 * @param location
	 * @param control
	 * @param enrollment
	 * @param percentFemale
	 * @param satVerbal
	 * @param satMath
	 * @param cost
	 * @param percentFinAid
	 * @param percentEnrolled
	 * @param applicants
	 * @param percentAdmitted
	 * @param academicScale
	 * @param socialScale
	 * @param qualityOfLife
	 * @param emphases
	 * @return
	 */
	public University createNewUniversity(String name, String state, String location, String control, String enrollment, String percentFemale,
			String satVerbal, String satMath, String cost, String percentFinAid, String percentEnrolled, String applicants,
			String percentAdmitted, String academicScale, String socialScale, String qualityOfLife, String[] emphases)
	{
		University newSchool;
		newSchool = new University(name, state, location, control, enrollment, percentFemale, satVerbal,
				satMath, cost, percentFinAid, percentEnrolled, applicants, percentAdmitted, academicScale, socialScale,
				qualityOfLife, emphases);
		this.school = newSchool;
		return newSchool;
	}

}
