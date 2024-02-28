package application;

import java.util.List;

import modele.CustomFileReader;
import modele.User;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CustomFileReader reader = new CustomFileReader("src/AddressBook.txt");
		List<User> users = reader.read();
		
		for(User u : users)
		{
			System.out.print(u + "\n");
		}
	}

}
