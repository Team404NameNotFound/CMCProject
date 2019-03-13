/**
 * 
 */
package cmc.functionality;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import cmc.entity.Student;
import cmc.entity.University;


/**
 * @author kmendel001
 *
 */
public class SearchController {

	String[] quizQuestions = {"How would you describe the location of your ideal college?", 
			"Which characteristics are most imporatnt to you when looking for a college", 
			"I prefer large lectures where I can observe and be anonymous, rather than small discussions with participation and my professors know my name ",
			"Do you know what you would like to study?"};
	University[] universityList;
	
	/**
	 * 
	 */
	public SearchController(ArrayList<University> allSchools) {
		for(int i = 0; i < allSchools.size(); i++)
		{
			universityList = new University[allSchools.size()];
			System.out.println("test");
			System.out.println(allSchools.get(i).toString());
			this.universityList[i] = allSchools.get(i);
		}
		
	}
	
	public String[] getQuizQuestions()
	{
		return quizQuestions;
	}
	
	public ArrayList<University> doQuizSearch()
	{
		ArrayList<University> closeSchools = new  ArrayList<University>();
		return closeSchools;
	}
	
	public ArrayList<University> rankUniversity(University university)
	{
		ArrayList<University> returnUniversity = new ArrayList<University>();
		int numStudents = Integer.parseInt(university.getEnrollment());
		float percentFemale = Float.parseFloat(university.getPercentFemale());
		int SatVerbal = Integer.parseInt(university.getSatVerbal());
		int SatMath = Integer.parseInt(university.getSatMath());
		int expenses = Integer.parseInt(university.getCost());
		float percentFinAid = Float.parseFloat(university.getPercentFinAid());
		int numApplicants = Integer.parseInt(university.getApplicants());
		float percentAdmitted = Float.parseFloat(university.getPercentAdmitted());
		float percentEnrolled = Float.parseFloat(university.getPercentEnrolled());
		int academicScale = Integer.parseInt(university.getAcademicScale());
		int socialScale = Integer.parseInt(university.getSocialScale());
		int qualityOfLifeScale = Integer.parseInt(university.getQualityOfLife());
		
		Double[][] schoolMatches = new Double[this.universityList.length][2];
		//finding closest schools to provided school
		for(int i = 0; i < this.universityList.length; i++)
		{
			Double score = 0.0;
			
			//testing distance based on enrollment
			score = score + (Math.abs((Double.parseDouble(universityList[i].getEnrollment()) - numStudents)) / (numStudents)) ;
			
			//testing distance based on percent female
			score = score + (Math.abs((Double.parseDouble(universityList[i].getPercentFemale()) - percentFemale)) / (percentFemale));
			
			//testing distance based on SATVerbal
			score = score + (Math.abs((Double.parseDouble(universityList[i].getSatVerbal()) - SatVerbal)) / (SatVerbal));
			
			//testing distance based on SATMath
			score = score + (Math.abs((Double.parseDouble(universityList[i].getSatMath()) - SatMath)) / (SatMath));
			
			//calculating score based on epenses
				score = score + (Math.abs((Double.parseDouble(universityList[i].getCost()) - expenses)) / (expenses));
			
			//testing distance based on FinancialAid
				score = score + (Math.abs((Double.parseDouble(universityList[i].getPercentFinAid()) - percentFinAid)) / (percentFinAid));
				
			//testing distance based on numberApplicants

				score = score + (Math.abs((Double.parseDouble(universityList[i].getApplicants()) - numApplicants)) / (numApplicants));
			
			//testing distance based on percentAdmitted
				score = score + (Math.abs((Double.parseDouble(universityList[i].getPercentAdmitted()) - percentAdmitted)) / (percentAdmitted));
			
			//testing distance based on percentEnrolled
				score = score + (Math.abs((Double.parseDouble(universityList[i].getPercentEnrolled()) - percentEnrolled)) / (percentEnrolled));
			
			//testing distance based on academicSclae
			score = score + (Math.abs((Double.parseDouble(universityList[i].getAcademicScale()) - academicScale)) / (academicScale));
			
			//testing distance based on socialScale
			score = score + (Math.abs((Double.parseDouble(universityList[i].getSocialScale()) - socialScale)) / (socialScale));
			
			//tesing distance distance based on qualityoflife
			score = score + (Math.abs((Double.parseDouble(universityList[i].getQualityOfLife()) - qualityOfLifeScale)) / (qualityOfLifeScale));

			
			//setting final score of university
			schoolMatches[i][0] = score;//i};
			schoolMatches[i][1] = Double.parseDouble(""+i);
		}
		Arrays.sort(schoolMatches);
		
		for (int i =1; i<5; i++)
		{
			int position = Integer.parseInt("" + schoolMatches[i][1]);
			returnUniversity.add(universityList[position]);
		}
		return returnUniversity;
	}

	public ArrayList<University> search(String schoolName, String state, String location, int numStudentsMin,
			int numStudentsMax, float percentFemaleMin, float percentFemaleMax, int SATVerbalMin, 
			int SATVerbalMax, int SATMathMin, int SATMathMax, int expensesMin, int expensesMax, 
			float PercentFinancialAidMin, float percenetFinancialAidMax, int numberApplicantsMin, 
			int numberApplicatnsMax, float percentAddmittedMin, float percentAdmittedMax,
			float percentEnrolledMin, float percentEnrolledMax, int academicScaleMin, int academicScaleMax,
			int socialScalemin, int socialScaleMax, int qualityOfLifeMin, int qualityOfLifeMax, String[] emphases
			)
	{
		Double[][] schoolMatches = new Double[this.universityList.length][2];
		int schoolNumStudentMin = 0;
		int schoolNumStudentMax = 1000000;
		float schoolPerFemaleMin = (float) 1.0;
		float schoolPerFemaleMax = (float) 0.0;
		int schoolSATVMin = 800;
		int schoolSATVMax = 0;
		int schoolSATMMin = 800;
		int schoolSATMMax = 0;
		int schoolExpensesMin = 10000000;
		int schoolExpensesMax = 0;
		float schoolFinAidMin = 10000000;
		float schoolFinAidMax = 0;
		int schoolApplicantsMin = 10000000;
		int schoolApplicantsMax = 0;
		float schoolAdmittedMin = (float)1.0;
		float schoolAdmittedMax = (float) 0.0;
		float schoolEnrolledMin = (float)1.0;
		float schoolEnrolledMax = (float) 0.0;
		int schoolAcademicScaleMin = 6;
		int schoolAcademicScaleMax = 0;
		int schoolSocialScaleMin = 6;
		int schoolSocialScaleMax = 0;
		int schoolQualityofLifeMin = 6;
		int schoolQualityofLifeMax = 0;
		for(University testSchool: universityList)
		{
			if(Integer.parseInt(testSchool.getEnrollment()) < schoolNumStudentMin)
			{
				schoolNumStudentMin = Integer.parseInt(testSchool.getEnrollment());
			}
			if(Integer.parseInt(testSchool.getEnrollment()) > schoolNumStudentMax)
			{
				schoolNumStudentMax = Integer.parseInt(testSchool.getEnrollment());
			}
			if(Float.parseFloat(testSchool.getPercentFemale()) < schoolPerFemaleMin)
			{
				schoolPerFemaleMin = Float.parseFloat(testSchool.getEnrollment());
			}
			if(Float.parseFloat(testSchool.getPercentFemale()) > schoolPerFemaleMax)
			{
				schoolPerFemaleMax = Float.parseFloat(testSchool.getEnrollment());
			}
			if(Integer.parseInt(testSchool.getSatVerbal()) < schoolSATVMin)
			{
				schoolSATVMin = Integer.parseInt(testSchool.getSatVerbal());
			}
			if(Integer.parseInt(testSchool.getSatVerbal()) > schoolSATVMax)
			{
				schoolSATVMax = Integer.parseInt(testSchool.getSatVerbal());
			}
			if(Integer.parseInt(testSchool.getSatMath()) < schoolSATMMin)
			{
				schoolSATMMin = Integer.parseInt(testSchool.getSatMath());
			}
			if(Integer.parseInt(testSchool.getSatMath()) > schoolSATMMax)
			{
				schoolSATMMax = Integer.parseInt(testSchool.getSatMath());
			}
			if(Integer.parseInt(testSchool.getCost()) > schoolExpensesMin)
			{
				schoolExpensesMin = Integer.parseInt(testSchool.getCost());
			}
			if(Integer.parseInt(testSchool.getCost()) > schoolExpensesMax)
			{
				schoolExpensesMax = Integer.parseInt(testSchool.getCost());
			}
			if(Float.parseFloat(testSchool.getPercentFinAid()) < schoolFinAidMin)
			{
				schoolFinAidMin = Integer.parseInt(testSchool.getPercentFinAid());
			}
			if(Float.parseFloat(testSchool.getPercentFinAid()) > schoolFinAidMax)
			{
				schoolFinAidMax = Float.parseFloat(testSchool.getPercentFinAid());
			}
			if(Integer.parseInt(testSchool.getPercentFinAid()) < schoolApplicantsMin)
			{
				schoolApplicantsMin = Integer.parseInt(testSchool.getApplicants());
			}
			if(Integer.parseInt(testSchool.getPercentFinAid()) > schoolApplicantsMax)
			{
				schoolApplicantsMax = Integer.parseInt(testSchool.getApplicants());
			}
			if(Float.parseFloat(testSchool.getPercentAdmitted()) < schoolAdmittedMin)
			{
				schoolAdmittedMin = Float.parseFloat(testSchool.getPercentAdmitted());
			}
			if(Float.parseFloat(testSchool.getPercentAdmitted()) > schoolAdmittedMax)
			{
				schoolAdmittedMax = Float.parseFloat(testSchool.getPercentAdmitted());
			}
			if(Float.parseFloat(testSchool.getPercentEnrolled()) < schoolEnrolledMin)
			{
				schoolAdmittedMin = Float.parseFloat(testSchool.getPercentEnrolled());
			}
			if(Float.parseFloat(testSchool.getPercentEnrolled()) > schoolEnrolledMax)
			{
				schoolEnrolledMax = Float.parseFloat(testSchool.getPercentEnrolled());
			}
			if(Integer.parseInt(testSchool.getSocialScale()) < schoolAcademicScaleMin)
			{
				schoolAcademicScaleMin = Integer.parseInt(testSchool.getAcademicScale());
			}
			if(Integer.parseInt(testSchool.getAcademicScale()) > schoolAcademicScaleMax)
			{
				schoolAcademicScaleMax = Integer.parseInt(testSchool.getAcademicScale());
			}
			if(Integer.parseInt(testSchool.getSocialScale()) < schoolSocialScaleMin)
			{
				schoolSocialScaleMin = Integer.parseInt(testSchool.getSocialScale());
			}
			if(Integer.parseInt(testSchool.getSocialScale()) > schoolSocialScaleMax)
			{
				schoolSocialScaleMax = Integer.parseInt(testSchool.getSocialScale());
			}
			if(Integer.parseInt(testSchool.getSocialScale()) < schoolQualityofLifeMin)
			{
				schoolQualityofLifeMin = Integer.parseInt(testSchool.getQualityOfLife());
			}
			if(Integer.parseInt(testSchool.getSocialScale()) > schoolQualityofLifeMax)
			{
				schoolQualityofLifeMax = Integer.parseInt(testSchool.getQualityOfLife());
			}
		}
		for(int i = 0; i < this.universityList.length; i++)
		{
			Double score = 0.0;
			//testing distance based on enrollment
			if(numStudentsMin != -1 && numStudentsMax != -1)
			{
				score = score + (Math.abs((Double.parseDouble(universityList[i].getEnrollment()) - numStudentsMin)) / (schoolNumStudentMax-schoolNumStudentMin)) + ( Math.abs((numStudentsMax - (Double.parseDouble(universityList[i].getEnrollment())))) / (schoolNumStudentMax-schoolNumStudentMin));
			}
			else if(numStudentsMin == -1)
			{
				score = score + (Math.abs((Double.parseDouble(universityList[i].getEnrollment()) - numStudentsMax)) / (schoolNumStudentMax-schoolNumStudentMin));// + ( Math.abs((numStudentsMax - (Double.parseDouble(universityList[i].getEnrollment())))) / (schoolNumStudentMax-schoolNumStudentMin));
			}
			else if(numStudentsMax == -1)
			{
				score = score + (Math.abs((Double.parseDouble(universityList[i].getEnrollment()) - numStudentsMin)) / (schoolNumStudentMax-schoolNumStudentMin));// + ( Math.abs((numStudentsMin - (Double.parseDouble(universityList[i].getEnrollment())))) / (schoolNumStudentMax-schoolNumStudentMin));
			}
			
			//testing distance based on percent female
			if(percentFemaleMin != -1 && percentFemaleMax != -1)
			{
				score = score + (Math.abs((Double.parseDouble(universityList[i].getPercentFemale()) - percentFemaleMin)) / (schoolPerFemaleMax-schoolPerFemaleMin)) + ( Math.abs((percentFemaleMax - (Double.parseDouble(universityList[i].getPercentFemale())))) / (schoolPerFemaleMax-schoolPerFemaleMin));
			}
			else if(percentFemaleMin == -1)
			{
				score = score + (Math.abs((Double.parseDouble(universityList[i].getPercentFemale()) - percentFemaleMax)) / (schoolPerFemaleMax-schoolPerFemaleMin));// + ( Math.abs((percentFemaleMax - (Double.parseDouble(universityList[i].getPercentFemale())))) / (schoolPerFemaleMax-schoolPerFemaleMin));
			}
			else if(percentFemaleMax == -1)
			{
				score = score + (Math.abs((Double.parseDouble(universityList[i].getPercentFemale()) - percentFemaleMin)) / (schoolPerFemaleMax-schoolPerFemaleMin));// + ( Math.abs((percentFemaleMin - (Double.parseDouble(universityList[i].getPercentFemale())))) / (schoolPerFemaleMax-schoolPerFemaleMin));
			}
			
			//testing distance based on SATVerbal
			if(SATVerbalMin != -1 && SATVerbalMax != -1)
			{
				score = score + (Math.abs((Double.parseDouble(universityList[i].getSatVerbal()) - SATVerbalMin)) / (schoolSATVMax-schoolSATVMin)) + ( Math.abs((numStudentsMax - (Double.parseDouble(universityList[i].getSatVerbal())))) / (schoolSATVMax-schoolSATVMin));
			}
			else if(SATVerbalMin == -1)
			{
				score = score + (Math.abs((Double.parseDouble(universityList[i].getSatVerbal()) - SATVerbalMax)) / (schoolSATVMax-schoolSATVMin));// + ( Math.abs((SATVerbalMax - (Double.parseDouble(universityList[i].getSatVerbal())))) / (schoolSATVMax-schoolSATVMin));
			}
			else if(SATVerbalMax == -1)
			{
				score = score + (Math.abs((Double.parseDouble(universityList[i].getSatVerbal()) - SATVerbalMin)) / (schoolSATVMax-schoolSATVMin));// + ( Math.abs((SATVerbalMin - (Double.parseDouble(universityList[i].getSatVerbal())))) / (schoolSATVMax-schoolSATVMin));
			}
			
			//testing distance based on SATMath
			if(SATMathMin != -1 && SATMathMax != -1)
			{
				score = score + (Math.abs((Double.parseDouble(universityList[i].getSatMath()) - SATMathMin)) / (schoolSATMMax-schoolSATMMin)) + ( Math.abs((SATMathMin - (Double.parseDouble(universityList[i].getSatMath())))) / (schoolSATMMax-schoolSATMMin));
			}
			else if(SATVerbalMin == -1)
			{
				score = score + (Math.abs((Double.parseDouble(universityList[i].getSatMath()) - SATMathMax)) / (schoolSATMMax-schoolSATMMin));// + ( Math.abs((SATMathMax - (Double.parseDouble(universityList[i].getSatMath())))) / (schoolSATMMax-schoolSATMMin));
			}
			else if(SATVerbalMax == -1)
			{
				score = score + (Math.abs((Double.parseDouble(universityList[i].getSatMath()) - SATMathMin)) / (schoolSATMMax-schoolSATMMin));// + ( Math.abs((SATMathMin - (Double.parseDouble(universityList[i].getSatMath())))) / (schoolSATMMax-schoolSATMMin));
			}
			
			//testing distance based on expenses
			if(expensesMin != -1 && expensesMax != -1)
			{
				score = score + (Math.abs((Double.parseDouble(universityList[i].getCost()) - expensesMin)) / (schoolExpensesMax - schoolExpensesMin)) + ( Math.abs((expensesMax - (Double.parseDouble(universityList[i].getCost())))) / (schoolExpensesMax - schoolExpensesMin));
			}
			else if(expensesMin == -1)
			{
				score = score + (Math.abs((Double.parseDouble(universityList[i].getCost()) - expensesMax)) / (schoolExpensesMax - schoolExpensesMin));//+ ( Math.abs((expensesMax - (Double.parseDouble(universityList[i].getSatMath())))) / (schoolExpensesMax - schoolExpensesMin));
			}
			else if(expensesMax == -1)
			{
				score = score + (Math.abs((Double.parseDouble(universityList[i].getCost()) - expensesMin)) / (schoolExpensesMax - schoolExpensesMin));// + ( Math.abs((expensesMin - (Double.parseDouble(universityList[i].getSatMath())))) / (schoolExpensesMax - schoolExpensesMin));
			}
			
			//testing distance based on FinancialAid
			if(PercentFinancialAidMin != -1 && percenetFinancialAidMax != -1)
			{
				score = score + (Math.abs((Double.parseDouble(universityList[i].getPercentFinAid()) - PercentFinancialAidMin)) / (schoolFinAidMax - schoolFinAidMin)) + ( Math.abs((percenetFinancialAidMax - (Double.parseDouble(universityList[i].getPercentFinAid())))) / (schoolFinAidMax - schoolFinAidMin));
			}
			else if(PercentFinancialAidMin == -1)
			{
				score = score + (Math.abs((Double.parseDouble(universityList[i].getPercentFinAid()) - percenetFinancialAidMax)) / (schoolFinAidMax - schoolFinAidMin));//+ ( Math.abs((expensesMax - (Double.parseDouble(universityList[i].getSatMath())))) / (schoolExpensesMax - schoolExpensesMin));
			}
			else if(percenetFinancialAidMax == -1)
			{
				score = score + (Math.abs((Double.parseDouble(universityList[i].getPercentFinAid()) - PercentFinancialAidMin)) / (schoolFinAidMax - schoolFinAidMin));// + ( Math.abs((expensesMin - (Double.parseDouble(universityList[i].getSatMath())))) / (schoolExpensesMax - schoolExpensesMin));
			}
			
			//testing distance based on numberApplicants
			if(numberApplicantsMin != -1 && numberApplicatnsMax != -1)
			{
				score = score + (Math.abs((Double.parseDouble(universityList[i].getApplicants()) - numberApplicantsMin)) / (schoolApplicantsMin - schoolApplicantsMax)) + ( Math.abs((numberApplicatnsMax - (Double.parseDouble(universityList[i].getApplicants())))) / (schoolApplicantsMin - schoolApplicantsMax));
			}
			else if(numberApplicantsMin == -1)
			{
				score = score + (Math.abs((Double.parseDouble(universityList[i].getApplicants()) - numberApplicatnsMax)) / (schoolApplicantsMin - schoolApplicantsMax));//+ ( Math.abs((expensesMax - (Double.parseDouble(universityList[i].getSatMath())))) / (schoolExpensesMax - schoolExpensesMin));
			}
			else if(numberApplicatnsMax == -1)
			{
				score = score + (Math.abs((Double.parseDouble(universityList[i].getApplicants()) - numberApplicantsMin)) / (schoolApplicantsMin - schoolApplicantsMax));// + ( Math.abs((expensesMin - (Double.parseDouble(universityList[i].getSatMath())))) / (schoolExpensesMax - schoolExpensesMin));
			}
			
			//testing distance based on percentAdmitted
			if(percentAddmittedMin != -1 && percentAdmittedMax != -1)
			{
				score = score + (Math.abs((Double.parseDouble(universityList[i].getPercentAdmitted()) - percentAddmittedMin)) / (schoolAdmittedMax - schoolAdmittedMin)) + ( Math.abs((percentAdmittedMax - (Double.parseDouble(universityList[i].getPercentAdmitted())))) / (schoolApplicantsMin - schoolApplicantsMax));
			}
			else if(numberApplicantsMin == -1)
			{
				score = score + (Math.abs((Double.parseDouble(universityList[i].getPercentAdmitted()) - percentAdmittedMax)) / (schoolAdmittedMax - schoolAdmittedMin));//+ ( Math.abs((expensesMax - (Double.parseDouble(universityList[i].getSatMath())))) / (schoolExpensesMax - schoolExpensesMin));
			}
			else if(numberApplicatnsMax == -1)
			{
				score = score + (Math.abs((Double.parseDouble(universityList[i].getPercentAdmitted()) - percentAddmittedMin)) / (schoolAdmittedMax - schoolAdmittedMin));// + ( Math.abs((expensesMin - (Double.parseDouble(universityList[i].getSatMath())))) / (schoolExpensesMax - schoolExpensesMin));
			}
			
			//testing distance based on percentEnrolled
			if(percentEnrolledMin != -1 && percentEnrolledMax != -1)
			{
				score = score + (Math.abs((Double.parseDouble(universityList[i].getPercentEnrolled()) - percentEnrolledMin)) / (schoolEnrolledMin - schoolEnrolledMax)) + ( Math.abs((percentEnrolledMax - (Double.parseDouble(universityList[i].getPercentEnrolled())))) / (schoolEnrolledMin - schoolEnrolledMax));
			}
			else if(percentEnrolledMin == -1)
			{
				score = score + (Math.abs((Double.parseDouble(universityList[i].getPercentEnrolled()) - percentEnrolledMax)) / (schoolEnrolledMin - schoolEnrolledMax));//+ ( Math.abs((expensesMax - (Double.parseDouble(universityList[i].getSatMath())))) / (schoolExpensesMax - schoolExpensesMin));
			}
			else if(percentEnrolledMax == -1)
			{
				score = score + (Math.abs((Double.parseDouble(universityList[i].getPercentEnrolled()) - percentAddmittedMin)) / (schoolEnrolledMin - schoolEnrolledMax));// + ( Math.abs((expensesMin - (Double.parseDouble(universityList[i].getSatMath())))) / (schoolExpensesMax - schoolExpensesMin));
			}
			
			//testing distance based on academicSclae
			if(academicScaleMin != -1 && academicScaleMax != -1)
			{
				score = score + (Math.abs((Double.parseDouble(universityList[i].getAcademicScale()) - academicScaleMin)) / (schoolAcademicScaleMax - schoolAcademicScaleMin)) + ( Math.abs((academicScaleMax - (Double.parseDouble(universityList[i].getAcademicScale())))) / (schoolAcademicScaleMax - schoolAcademicScaleMin));
			}
			else if(percentEnrolledMin == -1)
			{
				score = score + (Math.abs((Double.parseDouble(universityList[i].getAcademicScale()) - academicScaleMax)) / (schoolAcademicScaleMax - schoolAcademicScaleMin));//+ ( Math.abs((expensesMax - (Double.parseDouble(universityList[i].getSatMath())))) / (schoolExpensesMax - schoolExpensesMin));
			}
			else if(percentEnrolledMax == -1)
			{
				score = score + (Math.abs((Double.parseDouble(universityList[i].getAcademicScale()) - academicScaleMin)) / (schoolAcademicScaleMax - schoolAcademicScaleMin));// + ( Math.abs((expensesMin - (Double.parseDouble(universityList[i].getSatMath())))) / (schoolExpensesMax - schoolExpensesMin));
			}
			
			//testing distance based on socialScale
			if(socialScalemin != -1 && socialScaleMax != -1)
			{
				score = score + (Math.abs((Double.parseDouble(universityList[i].getSocialScale()) - socialScalemin)) / (schoolSocialScaleMax - schoolSocialScaleMin)) + ( Math.abs((socialScaleMax - (Double.parseDouble(universityList[i].getSocialScale())))) / (schoolSocialScaleMax - schoolSocialScaleMin));
			}
			else if(socialScalemin == -1)
			{
				score = score + (Math.abs((Double.parseDouble(universityList[i].getSocialScale()) - socialScaleMax)) / (schoolSocialScaleMax - schoolSocialScaleMin));//+ ( Math.abs((expensesMax - (Double.parseDouble(universityList[i].getSatMath())))) / (schoolExpensesMax - schoolExpensesMin));
			}
			else if(socialScaleMax == -1)
			{
				score = score + (Math.abs((Double.parseDouble(universityList[i].getSocialScale()) - socialScalemin)) / (schoolSocialScaleMax - schoolSocialScaleMin));// + ( Math.abs((expensesMin - (Double.parseDouble(universityList[i].getSatMath())))) / (schoolExpensesMax - schoolExpensesMin));
			}
			
			//testing distance based on qualityOfLife
			if(qualityOfLifeMin != -1 && qualityOfLifeMax != -1)
			{
				score = score + (Math.abs((Double.parseDouble(universityList[i].getQualityOfLife()) - qualityOfLifeMin)) / (schoolQualityofLifeMax - schoolQualityofLifeMax)) + ( Math.abs((qualityOfLifeMax - (Double.parseDouble(universityList[i].getQualityOfLife())))) / (schoolQualityofLifeMax - schoolQualityofLifeMax));
			}
			else if(qualityOfLifeMin == -1)
			{
				score = score + (Math.abs((Double.parseDouble(universityList[i].getQualityOfLife()) - qualityOfLifeMax)) / (schoolQualityofLifeMax - schoolQualityofLifeMax));//+ ( Math.abs((expensesMax - (Double.parseDouble(universityList[i].getSatMath())))) / (schoolExpensesMax - schoolExpensesMin));
			}
			else if(qualityOfLifeMax == -1)
			{
				score = score + (Math.abs((Double.parseDouble(universityList[i].getQualityOfLife()) - qualityOfLifeMin)) / (schoolQualityofLifeMax - schoolQualityofLifeMax));// + ( Math.abs((expensesMin - (Double.parseDouble(universityList[i].getSatMath())))) / (schoolExpensesMax - schoolExpensesMin));
			}
			
			//testing distance based on schoolName
			if(!universityList[i].getName().toLowerCase().trim().contains(schoolName.toLowerCase().trim()))
			{
				score = score  + 1;
			}
			
			//testing distance based on location
			if(!universityList[i].getLocation().toLowerCase().trim().equals(location.toLowerCase().trim()))
			{
				score = score  + 1;
			}
			
			//testing distance based on state
			if(!universityList[i].getState().toLowerCase().trim().equals(state.toLowerCase().trim()))
			{
				score = score  + 1;
			}
			
			//setting final score of university
			schoolMatches[i][0] = score;//i};
			schoolMatches[i][1] = Double.parseDouble(""+i);
		}
		
		Arrays.sort(schoolMatches);
		ArrayList<University>  returnUniversity = new ArrayList<University>();
		for (int i =0; i<universityList.length; i++)
		{
			int position = Integer.parseInt("" + schoolMatches[i][1]);
			returnUniversity.add(universityList[position]);
		}
		for(int i = 0; i<schoolMatches.length;i++)
		{
			System.out.println("Score: " + schoolMatches[i][0] + " Position: " + schoolMatches[i][1]);
		}
		return returnUniversity;
	}
	
	
//	public static void main(String[] args)
//	{
//
//		DBController db = new DBController();
//		SearchController sc = new SearchController(db.getUniversityList());
//		University testUniversity = new University();
//	}
}
