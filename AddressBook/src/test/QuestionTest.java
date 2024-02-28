package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import modele.User;
import question.Question;
import utils.Constants;
import utils.Gender;

class QuestionTest {

	// Tests different scenarios 
	// List of 3 men, List of 3 females, List of 5 persons but no men in, List of 6 persons with one man
	@Test
	void testCountMenInList() {
		List<User> users = new ArrayList<User>();
		
		int i = -1;
		while (++i < 3)
		{
			users.add(new User("Name " + i, Gender.MALE, LocalDate.of(1900, 1, 1)));
		}
		
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
		
		Question.countMenInList(users);
		
		String output = outputStream.toString();
		
		assertEquals(Constants.STR_ANSWER_FIRST_QUESTION + "3\n", output);
		
		users.clear();
		
		i = -1;
		while (++i < 3)
		{
			users.add(new User("Name " + i, Gender.FEMALE, LocalDate.of(1900, 1, 1)));
		}
		
		outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
		
		Question.countMenInList(users);
		
		output = outputStream.toString();
		
		assertEquals(Constants.STR_ANSWER_FIRST_QUESTION + "0\n", output);
		
		users.clear();
		
		i = -1;
		while(++i < 5)
		{
			if (i % 2 == 0)
				users.add(new User("Name " + i, Gender.FEMALE, LocalDate.of(1900, 1, 1)));
			else
				users.add(new User("Name " + i, Gender.OTHER, LocalDate.of(1900, 1, 1)));
		}
		
		outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
		
		Question.countMenInList(users);
		
		output = outputStream.toString();
		
		assertEquals(Constants.STR_ANSWER_FIRST_QUESTION + "0\n", output);
		
		users.clear();
		
		i = -1;
		while(++i < 5)
		{
			if (i % 2 == 0)
				users.add(new User("Name " + i, Gender.FEMALE, LocalDate.of(1900, 1, 1)));
			else
				users.add(new User("Name " + i, Gender.OTHER, LocalDate.of(1900, 1, 1)));
		}
		users.add(new User("Name " + i, Gender.MALE, LocalDate.of(1900, 1, 1)));
		
		outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
		
		Question.countMenInList(users);
		
		output = outputStream.toString();
		
		assertEquals(Constants.STR_ANSWER_FIRST_QUESTION + "1\n", output);

		System.setOut(System.out);
	}
	
	// Tests a normal case, with all users have a different birth date
	@Test
	void testgetOnlyOneOldestPersonInList()
	{
		List<User> users = new ArrayList<User>();
		
		int i = -1;
		while (++i < 3)
		{
			users.add(new User("Name " + i, Gender.MALE, LocalDate.of(1900 + i, 1, 1)));
		}
		
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
		
		Question.getOldestPersonInList(users);
		
		String output = outputStream.toString();
		
		assertEquals(Constants.STR_ANSWER_SECOND_QUESTION + users.get(0).getName() +"\n", output);
		
		System.setOut(System.out);
	}
	
	// Test what happens when at least two persons have the same birth date
	@Test
	void getSeveralOldestPersonInList()
	{
		List<User> users = new ArrayList<User>();
		
		users.add(new User("Name 0", Gender.MALE, LocalDate.of(1900, 1, 1)));
		users.add(new User("Name 1", Gender.MALE, LocalDate.of(1900, 1, 1)));
		
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
		
		Question.getOldestPersonInList(users);
		
		String output = outputStream.toString();
		
		String strExpected = Constants.STR_ANSWER_SECOND_QUESTION + "Name 0 Name 1 " + "\n";
		
		assertEquals(strExpected, output);
		
		System.setOut(System.out);
	}
	
	// Test what happens when the user list is empty
	@Test 
	void getOldestPersonInEmptyList()
	{
		List<User> users = new ArrayList<User>();
	
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
		
		Question.getOldestPersonInList(users);
		
		String output = outputStream.toString();
		
		assertEquals("Empty List\n", output);
		
		System.setOut(System.out);
	}

}
