/**
 * 
 */
package cmc.functionality;



/**
 * @author kmendel001
 *
 */
public class SearchController {

	List<String> quizQuestions = {};
	List<University> universityList;
	/**
	 * 
	 */
	public SearchController(List<University> allSchools) {
		this.universityList = allSchools;
	}

}
