package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import modele.User;
import modele.UserManager;

class UserManagerTest {

	@Test
	void testUserManager() {
		UserManager manager = new UserManager();
		
		manager.init("src/AddressBook.txt");
		
		User user = manager.getUserByName("Bill McKnight");
		
		assertEquals("User [name=Bill McKnight, gender=Male, birthDate=1977-03-16]", user.toString());
		
		assertNull(manager.getUserByName("TEST"));
		
		List<User> users = manager.getUsers();
		
		assertEquals(5, users.size());
		assertEquals("User [name=Bill McKnight, gender=Male, birthDate=1977-03-16]", users.get(0).toString());
		
		manager.setUsers(null);
		
		assertNull(manager.getUsers());
		assertNull(manager.getUserByName("TEST"));
		
	}

}
