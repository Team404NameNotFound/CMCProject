/**
 * 
 */
package cmc.functionality;

import java.util.ArrayList;

import cmc.entity.University;


/**
 * @author kmendel001
 *
 */
public class SearchController {

	String[] quizQuestions = {"Question 1", "Question2", "QUestoin 3", "Question 4"};
	ArrayList<University> universityList;
	
	/**
	 * 
	 */
	public SearchController(ArrayList<University> allSchools) {
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

	public University[] search()
	{
		University[] schoolMatches = new University[this.universityList.size()];
		return schoolMatches;
	}
}
