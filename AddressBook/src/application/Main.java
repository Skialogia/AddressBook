package application;

import modele.User;
import modele.UserManager;
import question.Question;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		UserManager userManager = new UserManager();
		userManager.init("src/AddressBook.txt");
		
		Question.countMenInList(userManager.getUsers());
		System.out.print("\n");
		Question.getOldestPersonInList(userManager.getUsers());
		System.out.print("\n");
		Question.getNumberofDaysBetweenTwoPeoples(userManager, "Bill McKnight", "Paul Robinson");
	}

}
