package test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import modele.User;
import utils.CustomFileReader;

class CustomFileReaderTest {

	CustomFileReader reader;

	// Test what happens when the file does not exist
	@Test
	void testFileNotExists()
	{
		String filepath = "Nowhere.txt";
		reader = new CustomFileReader(filepath);
		List<User> users = reader.read();

		assertNull(users);
	}

	// Test what happens when the file is not a normal file
	@Test
	void testFileNotANormalFile()
	{
		String filepath = "src/test";
		reader = new CustomFileReader(filepath);
		List<User> users = reader.read();

		assertNull(users);
	}

	// Test what happens when the file is unreadable
	// Requires an unreadable file to test, but the unreadable file used for testing cannot be pushed to the repository due to permissions problems
//	@Disabled
	@Test
	void testUnreadableFile()
	{
		String filepath = "src/test/unread_file.txt";
		reader = new CustomFileReader(filepath);
		List<User> users = reader.read();

		assertNull(users);
	}

	// Test what happens when file path is empty
	@Test
	void testWithNoFilePath()
	{
		String filepath = "";
		reader = new CustomFileReader(filepath);
		List<User> users = reader.read();

		assertNull(users);

		filepath = null;
		reader = new CustomFileReader(filepath);
		users = reader.read();

		assertNull(users);
	}

	// Test what happens when the format read is wrong
	@Test
	void testWrongFormatData()
	{
		File file = null;
		try
		{
			file = File.createTempFile("tmp", ".txt");
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write("Wrong, data, format, !");
			writer.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
			Assertions.fail("Cannot create temporary file\n");
		}

		reader = new CustomFileReader(file.getAbsolutePath());
		List<User> users = reader.read();

		assertNull(users);
		file.delete();
	}

	// Test what happens when the date format is wrong
	@Test
	void testWrongDateFormatData()
	{
		File file = null;
		try
		{
			file = File.createTempFile("tmp", ".txt");
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write("John Doe, Male, Unknown");
			writer.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
			Assertions.fail("Cannot create temporary file\n");
		}

		reader = new CustomFileReader(file.getAbsolutePath());
		List<User> users = reader.read();

		assertNull(users);
		file.delete();
	}

	// Test what happens if the file is empty
	@Test
	void testEmptyFile()
	{
		File file = null;
		try
		{
			file = File.createTempFile("tmp", ".txt");
		}
		catch (IOException e)
		{
			e.printStackTrace();
			Assertions.fail("Cannot create temporary file\n");
		}

		reader = new CustomFileReader(file.getAbsolutePath());
		List<User> users = reader.read();

		assertNull(users);
		file.delete();
	}

	// Test what happens when the file has a lot of lines
//	@Disabled
	@Test
	void testBigFile()
	{
		File file = null;
		try
		{
			file = File.createTempFile("tmp", ".txt");
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			int i = -1;
			while (++i < 10000) {
				writer.write("Bill McKnight, Male, 16/03/77\n");
			}
			writer.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
			Assertions.fail("Cannot create temporary file\n");
		}

		reader = new CustomFileReader(file.getAbsolutePath());
		List<User> users = reader.read();
		assertNotNull(users);
		file.delete();
	}

	// Test what happens when file name has special characters
	@Test
	void testFileNameWithSpecialCharacters()
	{
		File file = null;
		try
		{
			file = File.createTempFile("tmp $!$$$", ".txt");
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write("John Doe, Male, 16/03/77\n");
			writer.write("Jeanne Doe, Female, 16/03/77\n");
			writer.write("Alf, Other, 16/03/77\n");
			writer.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
			Assertions.fail("Cannot create temporary file\n");
		}

		reader = new CustomFileReader(file.getAbsolutePath());
		List<User> users = reader.read();
		assertNotNull(users);
		file.delete();
	}
}
