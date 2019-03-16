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
	
	public UniversityController()
	{
		this.school = null;
	}
	/**
	 * constructs a new UniversityController with the school provided 
	 * @param schooltoChange the University object that will be changed/updated
	 */
	public UniversityController(University schoolToChange) {
		this.school = schoolToChange;
	}
	
	/*
	 * returns a string of all the school's attributes
	 * @return String the string for the school
	 */
	public String getSchoolDetails()
	{
		return school.toString();
	}
	
	/*
	 * updates the information for a school from what the admin provided
	 */
	public University updateUniversityInfo(String name, String state, String location, String control, String enrollment, String percentFemale,
			String satVerbal, String satMath, String cost, String percentFinAid, String percentEnrolled, String applicants,
			String percentAdmitted, String academicScale, String socialScale, String qualityOfLife, String[] emphases,
			ArrayList<Student> savedSchool)
	{
		//goes through and tests every parameter to see if it has a value so that only the parameters with new values are updated
		if(!name.equals(null) && !name.equals(""))
		{
			school.setName(name);
		}
		if(!state.equals(null) && !state.equals(""))
		{
			school.setState(state);
		}
		if(!location.equals(null) && !location.equals(""))
		{
			school.setLocation(location);
		}
		if(!control.equals(null) && !control.equals(""))
		{
			school.setControl(null);
		}
		if(!enrollment.equals(null) && !enrollment.equals(""))
		{
			school.setEnrollment(enrollment);
		}
		if(!percentFemale.equals(null) && !percentFemale.equals(""))
		{
			school.setPercentFemale(percentFemale);
		}
		if(!satVerbal.equals(null) && !satVerbal.equals(""))
		{
			school.setSatVerbal(satVerbal);
		}
		if(!satMath.equals(null) && !satMath.equals(""))
		{
			school.setSatMath(satMath);
		}
		if(!cost.equals(null) && !cost.equals(""))
		{
			school.setCost(cost);
		}
		if(!percentFinAid.equals(null) && !percentFinAid.equals(""))
		{
			school.setPercentFinAid(percentFinAid);
		}
		if(!applicants.equals(null) && !applicants.equals(""))
		{
			school.setApplicants(applicants);
		}
		if(!percentAdmitted.equals(null) && !percentAdmitted.equals(""))
		{
			school.setPercentAdmitted(percentAdmitted);
		}
		if(!percentEnrolled.equals(null) && !percentEnrolled.equals(""))
		{
			school.setPercentEnrolled(percentEnrolled);
		}
		if(!academicScale.equals(null) && !academicScale.equals(""))
		{
			school.setAcademicScale(academicScale);
		}
		if(!socialScale.equals(null) && !socialScale.equals(""))
		{
			school.setSocialScale(socialScale);
		}
		if(!qualityOfLife.equals(null) && !qualityOfLife.equals(""))
		{
			school.setQualityOfLife(qualityOfLife);
		}
		if(!emphases.equals(null) && !emphases.equals(""))
		{
			school.setEmphases(emphases);
		}
		return school;
	}
	
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
