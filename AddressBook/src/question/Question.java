package question;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import modele.User;
import modele.UserManager;
import utils.Constants;
import utils.Gender;

public class Question
{

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
		System.out.print(Constants.STR_HOW_MANY_MEN_IN_LIST);
		
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
		System.out.print(Constants.STR_OLDEST_PERSON_IN_LIST);
		User oldestUser = users.get(0);
		LocalDate oldestBirthDate = oldestUser.getBirthDate();
		
		for (User u : users)
		{
			if (u.getBirthDate().isBefore(oldestBirthDate))
			{
				oldestUser = u;
				oldestBirthDate = oldestUser.getBirthDate();
			}
		}
		
		System.out.print(Constants.STR_ANSWER_SECOND_QUESTION + oldestUser.getName() + "\n");
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
		System.out.print(Constants.STR_DAYS_BETWEEN_BILL_AND_PAUL);
		
		User user1 = userManager.getUserByName(name1);
		User user2 = userManager.getUserByName(name2);
		
		if (user1 == null || user2 == null)
		{
			System.out.print(Constants.ERROR_UNKNOWN_PERSON);
			return ;
		}
		
		long days = ChronoUnit.DAYS.between(user1.getBirthDate(), user2.getBirthDate());
		System.out.print(Constants.STR_ANSWER_THIRD_QUESTION + days + "\n");
	}
}
