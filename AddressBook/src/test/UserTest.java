package test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import modele.User;
import utils.Gender;

class UserTest {

	@Test
	void testToString() {
		User user = new User("John Doe", Gender.MALE, LocalDate.of(1900, 1, 1));
		String test = "User [name=John Doe, gender=Male, birthDate=" + LocalDate.of(1900, 1, 1) + "]";
		assertEquals(test, user.toString());
	}
	
	@Test
	void testSetterGetter()
	{
		User user = new User("John Doe", Gender.MALE, LocalDate.of(1900, 1, 1));
		
		assertEquals("John Doe", user.getName());
		assertEquals("Male", user.getGender());
		assertEquals(LocalDate.of(1900, 1, 1), user.getBirthDate());
		
		user.setUser("Jeanne Doe");
		user.setGender(Gender.FEMALE);
		user.setBirthDate(LocalDate.of(1989, 12, 15));
		
		assertEquals("Jeanne Doe", user.getName());
		assertEquals("Female", user.getGender());
		assertEquals(LocalDate.of(1989, 12, 15), user.getBirthDate());
	}

}
