package question;

import java.util.Date;
import java.util.List;

import modele.User;

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
		User oldest = users.get(0);
		Date oldBirthDate = oldest.getBirthDate();
		
		for (User u : users)
		{
			if (u.getBirthDate().before(oldBirthDate))
			{
				oldest = u;
				oldBirthDate = oldest.getBirthDate();
			}
		}
		
		System.out.print(oldest);
	}

}
