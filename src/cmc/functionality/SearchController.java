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
			int SATVerbalMax, int SATMatMin, int SATMathMax, int expensesMin, int expensesMax, 
			float PercentFinancialAidMin, float percenetFinancialAidMax, int numberApplicantsMin, 
			int numberApplicatnsMax, float percentAddmittedMin, float percentAdmittedMax,
			float percentEnrolledMin, float percentEnrolledMax, int academicScaleMin, int academicScaleMax,
			int socialScalemin, int socialScaleMax, int qualityOfLifeMin, int qualityOfLifeMax, String[] emphases
			)
	{
		Double[][] schoolMatches = new Double[this.universityList.length][];
		for(int i = 0; i < this.universityList.length;)
		{
			
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
			score = score + ((Double.parseDouble(testSchool.getEnrollment()) - 4000) / (max-min)) + ( (8000 - (Double.parseDouble(testSchool.getEnrollment()))) / (max-min));
		}
		if( Double.parseDouble( testSchool.getPercentFemale() ) > 0.0 || Double.parseDouble( testSchool.getPercentFemale() ) < 1.0)
		{
			score = score + ((Double.parseDouble(testSchool.getPercentFemale()) - .4) / (1)) + ( (  .4 - (Double.parseDouble(testSchool.getPercentFemale()))) / (1));
		}
	}
	

	System.out.println(score);
	}
}
