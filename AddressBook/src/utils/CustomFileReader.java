package utils;

import java.util.List;

import modele.User;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * This class is used to read data from a file and creates a list of users 
 */
public class CustomFileReader
{
	private String _filename;

	/**
	 * Constructor
	 * 
	 * @param filename The filename to be read
	 */
	public CustomFileReader(String filename) {
		super();
		this._filename = filename;
	}
	
	/**
	 * Reads the content of the file and creates a list of users
	 * 
	 * @return List of users read from the file, or null if an error occurs
	 */
	public List<User> read()
	{
		File file = new File(_filename);
		List<User> users = new ArrayList<User>();
		
		if (checkFile(file))
			return null;
		
		try(BufferedReader br = new BufferedReader(new FileReader(file)))
		{
			
			String line = br.readLine();
			while (line != null)
			{
				User user = createUserFromLine(line);
				users.add(user);
				line = br.readLine();
			}
			
			br.close();
		} catch (IOException e)
		{
			e.printStackTrace();
			return null;
		}
		return users;
	}
	
	/**
	 * Checks if the file exists, is a normal file and readable
	 * 
	 * @param file File
	 * 
	 * @return True if any of the checks fail, false otherwise
	 */
	private boolean checkFile(File file)
	{
		if (!file.exists())
		{
			System.out.print(Constants.ERROR_FILE_DOES_NOT_EXIST);
			return true;
		}
		
		if (!file.isFile())
		{
			System.out.print(Constants.ERROR_IS_NOT_A_FILE);
			return true;
		}
		
		if (!file.canRead())
		{
			System.out.print(Constants.ERROR_CANNOT_READ_FILE);
			return true;
		}
		
		return false;
	}
	
	/**
	 * Creates a user from a line read from the file
	 * 
	 * @param line Line read from the file
	 * 
	 * @return New User, or null if error occurs
	 */
	private User createUserFromLine(String line)
	{
		String[] parts;
		DateTimeFormatter simpleformat = DateTimeFormatter.ofPattern("dd/MM/yy");
		LocalDate date = null;
		
		parts = line.split(", ");
		if (parts.length != 3)
		{
			System.out.print(Constants.ERROR_WRONG_DATA_FORMAT);
			return null;
		}
		
		try
		{
			date = LocalDate.parse(parts[2], simpleformat);
			
			// LocalDate, with this format, starts from 2000
			// So, I substract 100 years to make the provided years more realistic
			date = date.withYear(date.getYear() - 100);
		} catch (DateTimeParseException e)
		{
			e.printStackTrace();
			return null;
		}
		
		return new User(parts[0], Gender.getGenderFromString(parts[1]), date);
	}
}
