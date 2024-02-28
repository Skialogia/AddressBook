package application;

import java.util.List;

import modele.User;
import modele.UserManager;
import question.Question;
import utils.CustomFileReader;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		CustomFileReader reader = new CustomFileReader("src/AddressBook.txt");
//		List<User> users = reader.read();
//		
		UserManager userManager = new UserManager();
		userManager.init("src/AddressBook.txt");
		
//		for(User u : userManager.getUsers())
//		{
//			System.out.print(u + "\n");
//		}
		
		Question.countMenInList(userManager.getUsers());
		System.out.print("\n");
		Question.getOldestPersonInList(userManager.getUsers());
		System.out.print("\n");
		Question.getNumberofDaysBetweenTwoPeoples(userManager, "Bill McKnight", "Paul Robinson");
	}

}
