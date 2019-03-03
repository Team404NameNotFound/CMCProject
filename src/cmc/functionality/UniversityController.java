/**
 * 
 */
package cmc.functionality;

import cmc.entity.University;

/**
 * @author kmendel001
 *
 */
public class UniversityController {

	University school;
	
	/**
	 * 
	 */
	public UniversityController(University schoolToChange) {
		this.school = schoolToChange;
	}
	
	
	public String getSchoolDetails()
	{
		return school.toString();
	}
	public University updateUniversityInfo(String schoolName, String state, String location,
			String control, String numStudents, String perFemale, String SATVerbal, String SATMath,
			String expenses, String financialAid, String numAplicants, String admitted, String enrolled,
			String academicScale, String socialScale, String qualityLife, String emphases)
	
	{
		
		if(!schoolName.equals(null))
		{
			school.setSchoolName(schoolName);
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
		if(!numStudents.equals(null))
		{
			school.setNumStudents(numStudents);
		}
		if(!perFemale.equals(nul))
		{
			school.setPercentFemale(perFemale);
		}
		if(!SATVerbal.equals(null))
		{
			school.setSATVerbal(SATVerbal);
		}
		if(!SATMath.equals(null))
		{
			school.setSATMath(SATMath);
		}
		if(!expenses.equals(null))
		{
			school.setExpenses(expenses);
		}
		if(!financialAid.equals(null))
		{
			school.setFinancialAid(financialAid);
		}
		if(!numAplicants.equals(null))
		{
			school.setNumberOfApplicants(numAplicants);
		}
		if(!admitted.equals(null))
		{
			schol.setAdmitted(admitted);
		}
		if(!enrolled.equals(null))
		{
			school.setEnrolled(enrolled);
		}
		if(!academicScale.equals(null))
		{
			school.setAcademicScale(academicScale);
		}
		if(!socialScale.equals(null))
		{
			school.setSocialScale(socialScale);
		}
		if(!qualityLife.equals(null))
		{
			school.setQualityOfLife(qualityLife);
		}
		if(!emphases.equals(null))
		{
			school.setEmphases(emphases);
		}
		return school;
	}
	public University createNewUniversity(String schoolName, String state, String location,
			String control, String numStudents, String perFemale, String SATVerbal, String SATMath,
			String expenses, String financialAid, String numAplicants, String admitted, String enrolled,
			String academicScale, String socialScale, String qualityLife, String empahses)
	{
		University newSchool;
		newSchool = new University(schoolName, state, location, control, numStudents, perFemale, SATVerbal,
				SATMath, expenses, financialAid, numAplicants, admitted, enrolled, academicScale, socialScale,
				qualityLife, empahses);
		
		return newSchool;
	}
}
