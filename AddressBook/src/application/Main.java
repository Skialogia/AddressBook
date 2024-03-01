package application;

import modele.AddressBook;
import question.Question;
import utils.Constants;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AddressBook addressBook = new AddressBook();
		addressBook.init("src/AddressBook.txt");

		if (addressBook.getUsers() == null) {
			return ;
		}

		System.out.print(Constants.STR_HOW_MANY_MEN_IN_LIST);
		Question.countMenInList(addressBook.getUsers());
		System.out.print("\n");
		System.out.print(Constants.STR_OLDEST_PERSON_IN_LIST);
		Question.getOldestPersonInList(addressBook.getUsers());
		System.out.print("\n");
		System.out.print(Constants.STR_DAYS_BETWEEN_BILL_AND_PAUL);
		Question.getNumberofDaysBetweenTwoPeoples(addressBook, "Bill McKnight", "Paul Robinson");
	}

}
