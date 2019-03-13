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
	
	public void viewProfile(String userName)
	{
		ArrayList<String> userInfo = UFCon.viewUserProfile(userName);
		System.out.println("User info gotten for:  " + userInfo.get(0));
		for(int i = 0; i < userInfo.size(); i++)
		{
			System.out.println("" + userInfo.get(i));
		}
	}
	
	public void editProfile(String userName, String firstName, String lastName, String password)
	{
		UFCon.editUserProfile(userName, firstName, lastName, password);
	}
	
	public void logout(){
		this.UFCon.logout();
	}
	
	public void forgetPsw(String username){
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

