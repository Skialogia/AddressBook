package application;

import modele.UserManager;
import question.Question;
import utils.Constants;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		UserManager userManager = new UserManager();
		userManager.init("src/AddressBook.txt");

		if (userManager.getUsers() == null) {
			return ;
		}

		System.out.print(Constants.STR_HOW_MANY_MEN_IN_LIST);
		Question.countMenInList(userManager.getUsers());
		System.out.print("\n");
		System.out.print(Constants.STR_OLDEST_PERSON_IN_LIST);
		Question.getOldestPersonInList(userManager.getUsers());
		System.out.print("\n");
		System.out.print(Constants.STR_DAYS_BETWEEN_BILL_AND_PAUL);
		Question.getNumberofDaysBetweenTwoPeoples(userManager, "Bill McKnight", "Paul Robinson");
	}

}
