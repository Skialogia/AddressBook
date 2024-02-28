package question;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import modele.User;
import modele.UserManager;

public class Question
{

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
			if (u.getGender().equals("Male"))
				nbMen++;
		}
		
		System.out.print(nbMen);
	}
	
	/**
	 * Finds the oldest person in the given list of users
	 *  
	 * @param users List of users
	 */
	public static void getOldestPersonInList(List<User> users)
	{
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
		
		System.out.print(oldestUser);
	}
	
	public static void getNumberofDaysBetweenTwoPeoples(UserManager userManager, String name1, String name2)
	{
		User user1 = userManager.getUserByName(name1);
		User user2 = userManager.getUserByName(name2);
		
		long days = ChronoUnit.DAYS.between(user1.getBirthDate(), user2.getBirthDate());
		System.out.print(days);
	}
}
