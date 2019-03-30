/**
 * 
 */
package cmc.functionality;

import java.util.Date; 
import java.util.ArrayList;
import java.util.Collections;

import java.util.*; 
import javax.mail.*; 
import javax.mail.internet.*; 
import javax.activation.*; 
import javax.mail.Session; 
import javax.mail.Transport; 

import cmc.entity.*;
import dblibrary.project.csci230.UniversityDBLibrary;

/**
 * @author kmendel001
 *
 */
public class AccountController {
    DBController dbController = new DBController();
	Account account;
	/**
	 * creates new AccountController object
	 * @param Account student being accessed
	 */
	public AccountController(Account account) {
		if(account == null)
		{
			System.out.println("Sorry, account cannot be null");
		}
		else
		{
			this.account = account;
		}
	}

	/**
	 * creates new AccountController object
	 */
	public AccountController()
	{
		
	}
	
	/**
	 * Returns list of all schools
	 * @return schoolList list of schools the student has on saved school list
	 */
	public void viewSavedSchools()
	{
		if(this.account.getUserType().equals("a")) System.out.println("Current account is an admin ");
		else {
			for(University savedSchool: this.dbController.getSchoolList2(this.account)) {
				System.out.println(savedSchool.getName());
			}
		}
	}
	
	
	/**
	 * Checks to see if any student has saved the specified school
	 * @param University university user is trying to save
	 * @return boolean true if school already saved, else false
	 */
	public boolean checkIfSchoolSaved(String school)
	{
		boolean saved = false;
		for(University savedSchool: this.dbController.getSchoolList2(this.account)) {
			if(savedSchool.getName().equals(school)) {
				saved = true;
			}
		}
		return saved;
	}
	

	/**
	 * Toggles the status of the current user
	 * @return Account account with activation status changed
	 */
	public Account toggleActivationStatus()
	{
		if(account == null) System.out.println("account is still null //line64 AccountController");
		if(account.getUserStatus().equals("N"))
		{
			account.setUserStatus("Y");
		}
		else
		{
			account.setUserStatus("N");
		}
		return account;
	}
	
	/**
	 * Checks if the password matches for the current user
	 * @param password password for the account trying to log in
	 * @return boolean true if password matches, else false
	 */
	public boolean checkPassword(String password)
	{
		//check to see if passwords match, if they do not then returns false
		if(password.equals("") || password.equals(null))
		{
			throw new IllegalArgumentException("sorry, you need to provide a valid password");
		}
		
		if (this.account.getPassword().equals(password))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Randomly generates a password
	 * @return randomPassword password generated to be sent to user and added to profile
	 */
	public String makeRandomPassword()
	{
		String newPass = "";
		String[] character = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q"
		 		             , "r", "s", "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5", "6"
				             , "7", "8", "9"};
		
		
		for(int i = 0; i < 5; i++)
		{
			int newChar =  (int) ((int)35*Math.random());
			newPass = newPass + character[newChar];
//			System.out.println(newPass);;
		}
		return newPass;
	}
	
	/**
	 * Updates the password of the current user
	 * @param newPassword new password to be put in to account
	 */
	public void updatePassword(String newPassword)
	{
		if(newPassword.equals(null) || newPassword.equals(""))
		{
			throw new IllegalArgumentException("Sorry, new password has to have a password");
		}
		else
		{
		account.setPassword(newPassword);
		
		}
	}
	
	/**
	 * Sends an email to the current user
	 * @param message content of email to send to user containing randomly generated password
	 */
	public void sendEmail(String emailMessage, String emailAddress)
	{
		String host="127.0.0.1";  
		  final String user = "csbsju.cmc@gmail.com";
		  final String password = "jumpingfrog12";
		    
		  String to = emailAddress;
		  
		   //Get the session object  
		   Properties props = new Properties();  
		   props.put("mail.smtp.host",host);  
		   props.put("mail.smtp.auth", "true");  
		     
		   Session session = Session.getDefaultInstance(props,  
		    new javax.mail.Authenticator() {  
		      protected PasswordAuthentication getPasswordAuthentication() {  
		    return new PasswordAuthentication(user,password);  
		      }  
		    });  
		  
		   //Compose the message  
		    try {  
		     MimeMessage message = new MimeMessage(session);  
		     message.setFrom(new InternetAddress(user));  
		     message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
		     message.setSubject("CMC Password Reset");  
		     message.setText(emailMessage);  
		       
		    //send the message  
		     Transport.send(message);  
		  
		   
		     } catch (MessagingException e) {e.printStackTrace();} 
	   }  
		
	
	/**
	 * Updates the first name, last name, password, type, and status of the current user
	 * @param fName first name associated with account
	 * @param lName last name associated with account
	 * @param password password associated with account
	 * @param type whether account is admin or user
	 * @param status active status of user
	 * @return Account account with information edited
	 */
	public Account updateUserInfo(String fName, String lName, String password, String status, String type)
	{
		if(!fName.equals("-1") )
		{
			account.setFirstName(fName);
		}
		if(!lName.equals("-1") )
		{
			account.setLastName(lName);
		}
		if(!password.equals("-1") )
		{
			account.setPassword(password);
		}
		if(!type.equals("-1") )
		{
			if(type.equals("u"))
			{
				account.setUserType("u");
			}
			else if(type.equals("a"))
			{
				account.setUserType("a");
			}
		}
		if(!status.equals("-1"))
		{
			if(status.equals("Y"))
			{
				account.setUserStatus("Y");
			}
			else if(status.equals("N"))
			{
				account.setUserStatus("N");
			}
		}
		return account;
	}
	
	/**
	 * Saves the specified school to the current users saved school list
	 * @param schoolToSave school user would like to add to saved school list
	 */
	public void saveSchool(String school)
	{
		University schoolToSave = dbController.getUniversity2(school);

		if(schoolToSave == null) {
			System.out.println("The school to save is not in the Database Library");
		}
		
		if(account == null){
			System.out.println("The current account is invalid.");
		}
	   else if(account.getUserType().equals("a")){
		   System.out.println("The current account is an admin ");
	   }
		else {
			System.out.println(account.getUsername() + " just saved school: " + school);
			this.dbController.saveShool(account.getUsername(), school);
		}
		 
	}
	
	/**
	 * Remove a saved school
	 * @param school
	 */
	public void removeSavedSchool(String school)
	{
		Boolean found = false;
		ArrayList<UserSavedSchool> saveSchools = this.dbController.getSchoolList2(this.account);
		
		if(saveSchools == null){
			System.out.println("The user have not saved any school yet");
			}
		if(account == null){
			System.out.println("The current account is invalid.");
			}
	    else if(account.getUserType().equals("a")){
		   System.out.println("The current account is an admin ");
		   }
	    else {
	    	for(University savedSchool: saveSchools) {
	    		if(savedSchool.getName().equals(school)) {
	    			found = true;
	    			System.out.println(account.getUsername() + " is removing school: " + school);
	    			this.dbController.removeSavedSchool(account.getUsername(), school);
	    		}
	    	}
	    }
		if(!found) {
			System.out.println("Cannot find " + school + " in the saved school list");
		}
	}
	
	/**
	 * Creates a new account with the specified parameters
	 * @param fName first name associated with account
	 * @param lName last name associated with account
	 * @param userName user name associated with account
	 * @param password password associated with account
	 * @param type whether account is admin or user
	 * @param savedSchools list of schools user has saved
	 * @return
	 */
	public Account createNewAccount(String fName, String lName, String userName, String password, String type,
			ArrayList<UserSavedSchool> savedSchools)
	{
		if(type.equals("a"))
		{
			account = new Admin(fName, lName, userName, password, type, "Y");
			return account;
		}
		else if(type.equals("u"))
		{
			account = new Student(fName, lName, userName, password, type, "Y", savedSchools);
			return account;
		}
		else 
		{
			throw new IllegalArgumentException("Sorry you need to specify the type of user.");
		}
	}
	//comparing SAT math for now
	/**
	 * Compare saved schools with their satMath scores
	 */
	public void compareSchoolsByScore() {	
		Account student = dbController.getAccount(account.getUsername());
		ArrayList<University> savedSchools = dbController.getSchoolList(student);
		
		double[][] scores = new double[savedSchools.size()][2];
		
		for (int i = 0; i<savedSchools.size(); i++) {
			scores[i][0] = Double.parseDouble(savedSchools.get(i).getSatMath());
			scores[i][1] = Double.parseDouble(""+i);
		}
		
		java.util.Arrays.sort(scores, new java.util.Comparator<double[]>() {
		    public int compare(double[] a, double[] b) {
		        return Double.compare(a[0], b[0]);
		    }
		});
		
		    
		for(int j = 0; j < scores.length; j++) {
			System.out.println("University: "+savedSchools.get(j).getName()+" Math score: "+ scores[j][0]);
		}
	}
}
	
