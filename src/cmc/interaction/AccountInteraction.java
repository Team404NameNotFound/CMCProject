package cmc.interaction;

import java.util.ArrayList;
import cmc.entity.*;

import cmc.functionality.UserFunctionalityController;

/**
 * @author tzhang001
 *
 */
public class AccountInteraction {
	
	UserFunctionalityController UFCon;

	public AccountInteraction(){
		UFCon = new UserFunctionalityController();
	}
	
	public AccountInteraction(UserFunctionalityController UFCon){
		this.UFCon = UFCon;
	}
	
	
	
	/**
	 * Student or Admin log in. 
	 * @param String username
	 * @param String password
	 */
	public void login(String username, String password){
		if(this.UFCon.login(username, password)) {
			System.out.println("Login Successfully");
		}
		else {
			System.out.println("Login UnSuccessfully");
		}
	
		
	}
	
	/**
	 * @param univeristyName
	 */
	public void viewSchoolDetails(String univeristyName)
	{
		String school = UFCon.viewUniversityDetials(univeristyName);
		System.out.print(school);
	}
	
	/**
	 * Displays the profile of the specified user
	 * @param userName
	 */
	public void viewProfile(String userName)
	{
		ArrayList<String> userInfo = UFCon.viewUserProfile(userName);
		System.out.println("User info gotten for:  " + userInfo.get(0));
		for(int i = 0; i < userInfo.size(); i++)
		{
			System.out.println("" + userInfo.get(i));
		}
	}
	
	/**
	 * Updates the first name, last name, and password for the specified user 
	 * @param userName
	 * @param firstName
	 * @param lastName
	 * @param password
	 */
	public void editProfile(String userName, String firstName, String lastName, String password)
	{
		UFCon.editUserProfile(userName, firstName, lastName, password);
	}
	
	/**
	 * Logs out the currently logged in user
	 */
	public void logout(){
		this.UFCon.logout();
	}
	
	/**
	 * Generates a random password then sets it as the specified user and sends it to the email address of that user
	 * @param username
	 */
	public void forgotPsw(String username){
		this.UFCon.forgotPassword(username);
	}
	
	/**
	 * Displays information about all schools in the database
	 */
	public void viewSchoolList(){
		ArrayList<University> universityList = this.UFCon.viewSchoolList();
		for (int index = 0; index < universityList.size(); index++) {
			System.out.print("Name:" + universityList.get(index).getName() + ", State: " + universityList.get(index).getState() + ", Location: " + universityList.get(index).getLocation()
					+ ", Control: " + universityList.get(index).getControl() + ", Enrollment: " + universityList.get(index).getEnrollment()
					 + ", %Female" + universityList.get(index).getPercentFemale() + ", SAT Verbal: " + universityList.get(index).getSatVerbal() + ", SAT Math: " + universityList.get(index).getSatMath()
					 + ", Cost: " + universityList.get(index).getCost() + ", %Finantial Aid: " + universityList.get(index).getPercentFinAid() + ", % Enrolled: " + universityList.get(index).getPercentEnrolled()
					 + ", Applicants: " + universityList.get(index).getApplicants() + ", %Admitted: " + universityList.get(index).getPercentAdmitted()
					 + ", Academic Scale(1-5): " + universityList.get(index).getAcademicScale() + ", Social Scale(1-5): " 
					 + universityList.get(index).getSocialScale() + ", Quality of Lift(1-5): " + universityList.get(index).getQualityOfLife() + ", Emphases(es): ");
			String[] emphases = universityList.get(index).getEmphases();
			for (int i = 0; i < emphases.length; i++) {
				System.out.print(" " + emphases[i]);
			}
			System.out.println();
		}
	}
}

