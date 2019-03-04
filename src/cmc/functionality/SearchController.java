/**
 * 
 */
package cmc.functionality;

import java.util.ArrayList;

import cmc.entity.University;
import cmc.entity.UserSavedSchool;

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

}
