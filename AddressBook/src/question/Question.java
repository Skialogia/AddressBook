package question;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import modele.User;
import modele.UserManager;
import utils.Constants;
import utils.Gender;

/**
 * This class contains static methods to perform tasks requested in the instructions PDF file
 */
public class Question
{
	// Private constructor to prevent instantiation of the class
	private Question()
	{
		
	}
	
	/**
	 * Counts the number of men in the given list of users
	 * 
	 * @param users List of users
	 */
	public static void countMenInList(List<User> users)
	{
		int nbMen = 0;
		
		for(User u : users)
		{
			if (u.getGender().equals(Gender.MALE.getName()))
				nbMen++;
		}
		
		System.out.print(Constants.STR_ANSWER_FIRST_QUESTION + nbMen + "\n");
	}
	
	/**
	 * Finds the oldest person in the given list of users
	 *  
	 * @param users List of users
	 */
	public static void getOldestPersonInList(List<User> users)
	{
		if (users.size() == 0)
		{
			System.out.print("Empty List\n");
			return;
		}
		
		User oldestUser = users.get(0);
		LocalDate oldestBirthDate = LocalDate.now();
		
		List<User> oldestUsers = new ArrayList<User>();
		
		for (User u : users)
		{
			if (u.getBirthDate().isBefore(oldestBirthDate))
			{
				oldestUser = u;
				oldestBirthDate = oldestUser.getBirthDate();
				if (oldestUsers.size() != 0)
					oldestUsers.clear();
			}
			else if (u.getBirthDate().isEqual(oldestBirthDate))
			{
				if (oldestUsers.size() == 0)
					oldestUsers.add(oldestUser);
				oldestUsers.add(u);
			}
		}
		if (oldestUsers.size() == 0)
			System.out.print(Constants.STR_ANSWER_SECOND_QUESTION + oldestUser.getName() + "\n");
		else
		{
			String prompt = Constants.STR_ANSWER_SECOND_QUESTION;
			
			for (User u : oldestUsers)
			{
				prompt += u.getName() + " ";
			}
			prompt += "\n";
			System.out.print(prompt);
		}
		
	}
	
	/**
	 * Calculates the number of days between the birth dates of two peoples
	 * 
	 * @param userManager User manager
	 * @param name1 Name of the first person
	 * @param name2 Name of the second person
	 */
	public static void getNumberofDaysBetweenTwoPeoples(UserManager userManager, String name1, String name2)
	{
				
		User user1 = userManager.getUserByName(name1);
		User user2 = userManager.getUserByName(name2);
		
		if (user1 == null || user2 == null)
		{
			System.out.print(Constants.ERROR_UNKNOWN_PERSON);
			return ;
		}
		
		long days = ChronoUnit.DAYS.between(user1.getBirthDate(), user2.getBirthDate());
		
		if (days < 0)
			days = -days;
		
		System.out.print(Constants.STR_ANSWER_THIRD_QUESTION + days + "\n");
	}
}
