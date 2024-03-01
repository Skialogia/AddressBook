package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import modele.User;
import modele.AddressBook;

class AddressBookTest {

	@Test
	void testAddressBook() {
		AddressBook addressBook = new AddressBook();
		
		addressBook.init("src/AddressBook.txt");
		
		User user = addressBook.getUserByName("Bill McKnight");
		
		assertEquals("User [name=Bill McKnight, gender=Male, birthDate=1977-03-16]", user.toString());
		
		assertNull(addressBook.getUserByName("TEST"));
		
		List<User> users = addressBook.getUsers();
		
		assertEquals(5, users.size());
		assertEquals("User [name=Bill McKnight, gender=Male, birthDate=1977-03-16]", users.get(0).toString());
		
		addressBook.setUsers(null);
		
		assertNull(addressBook.getUsers());
		assertNull(addressBook.getUserByName("TEST"));
		
	}

}
