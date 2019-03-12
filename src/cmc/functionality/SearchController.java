/**
 * 
 */
package cmc.functionality;

import java.util.ArrayList;

import cmc.entity.Student;
import cmc.entity.University;


/**
 * @author kmendel001
 *
 */
public class SearchController {

	String[] quizQuestions = {"How would you describe the location of your ideal college?", 
			"Which characteristics are most imporatnt to you when looking for a colelge", 
			"I prefer large lectures where I can observe and be anonymous, rather than small discussions with participation and my professors know my name ",
			"Do you know what you would like to study?"};
	University[] universityList;
	
	/**
	 * 
	 */
	public SearchController(University[] allSchools) {
		this.universityList = allSchools;
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
	
	public ArrayList<University> rankUniversity()
	{
		return null;
	}

	public Double[][] search(String schoolName, String state, String location, int numStudentsMin,
			int numStudentsMax, float percentFemaleMin, float percentFemaleMax, int SATVerbalMin, 
			int SATVerbalMax, int SATMathMin, int SATMathMax, int expensesMin, int expensesMax, 
			float PercentFinancialAidMin, float percenetFinancialAidMax, int numberApplicantsMin, 
			int numberApplicatnsMax, float percentAddmittedMin, float percentAdmittedMax,
			float percentEnrolledMin, float percentEnrolledMax, int academicScaleMin, int academicScaleMax,
			int socialScalemin, int socialScaleMax, int qualityOfLifeMin, int qualityOfLifeMax, String[] emphases
			)
	{
		Double[][] schoolMatches = new Double[this.universityList.length][];
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
		}
		return schoolMatches;
	}
	
	public static void main(String[] args)
	{
//		ArrayList<Integer> test = new ArrayList<Integer>();
//		test.add(5);
//		test.add(9);
//		test.add(2);
//		test.add(50);
//		for(int i = 0; i < 4; i++)
//		{
//			System.out.println(test.get(i));
//		}
	String[] emphases = {"Math", "Science"};
	
	//theoretical values for a school
	University testSchool = new University("name", "state", "location", "control", "5000", ".4",
			"satVerbal", "satMath", "cost", "percentFinAid", "percentEnrolled", "applicants",
			"percentAdmitted", "academicScale", "socialScale", "qualityOfLife", emphases,
			null);
	Double score = 0.0;
	
	//theoretical max/min enrollment values
	int max = 60000; //max found between all schools
	int min = 500; //min ofund between all schools
	for(int i = 0; i < 1; i++)
	{
		if( Integer.parseInt( testSchool.getEnrollment() ) > 0 || Integer.parseInt( testSchool.getEnrollment() ) < 100000)
		{
			score = score + ((Double.parseDouble(testSchool.getEnrollment()) - 1000) / (max-min)) + ( (20000 - (Double.parseDouble(testSchool.getEnrollment()))) / (max-min));
		}
		if( Double.parseDouble( testSchool.getPercentFemale() ) > 0.0 || Double.parseDouble( testSchool.getPercentFemale() ) < 1.0)
		{
			score = score + ((Double.parseDouble(testSchool.getPercentFemale()) - .4) / (1)) + ( ( .4 - (Double.parseDouble(testSchool.getPercentFemale()))) / (1));
		}
	}
	

	System.out.println(score);
	}
}
