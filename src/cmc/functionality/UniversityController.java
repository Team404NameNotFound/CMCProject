/**
 * 
 */
package cmc.functionality;
import cmc.entity.*;
import java.util.ArrayList;

import cmc.entity.*;

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
		if(!name.equals(null))
		{
			school.setName(name);
		}
		if(!state.equals(null))
		{
			school.setState(state);
		}
		if(!location.equals(null))
		{
			school.setLocation(location);
		}
		if(!control.equals(null))
		{
			school.setControl(null);
		}
		if(!enrollment.equals(null))
		{
			school.setEnrollment(enrollment);
		}
		if(!percentFemale.equals(null))
		{
			school.setPercentFemale(percentFemale);
		}
		if(!satVerbal.equals(null))
		{
			school.setSatVerbal(satVerbal);
		}
		if(!satMath.equals(null))
		{
			school.setSatMath(satMath);
		}
		if(!cost.equals(null))
		{
			school.setCost(cost);
		}
		if(!percentFinAid.equals(null))
		{
			school.setPercentFinAid(percentFinAid);
		}
		if(!applicants.equals(null))
		{
			school.setApplicants(applicants);
		}
		if(!percentAdmitted.equals(null))
		{
			school.setPercentAdmitted(percentAdmitted);
		}
		if(!percentEnrolled.equals(null))
		{
			school.setPercentEnrolled(percentEnrolled);
		}
		if(!academicScale.equals(null))
		{
			school.setAcademicScale(academicScale);
		}
		if(!socialScale.equals(null))
		{
			school.setSocialScale(socialScale);
		}
		if(!qualityOfLife.equals(null))
		{
			school.setQualityOfLife(qualityOfLife);
		}
		if(!emphases.equals(null))
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
