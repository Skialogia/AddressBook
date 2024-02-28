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
		
		if (!file.exists())
		{
			System.out.print(Constants.ERROR_FILE_DOES_NOT_EXIST);
			return null;
		}
		
		if (!file.isFile())
		{
			System.out.print(Constants.ERROR_IS_NOT_A_FILE);
			return null;
		}
		
		if (!file.canRead())
		{
			System.out.print(Constants.ERROR_CANNOT_READ_FILE);
			return null;
		}
		
		try(BufferedReader br = new BufferedReader(new FileReader(file)))
		{
			
			String line = br.readLine();
			String[] parts;
			DateTimeFormatter simpleformat = DateTimeFormatter.ofPattern("dd/MM/yy");
			while (line != null)
			{
				parts = line.split(", ");
				if (parts.length != 3)
				{
					System.out.print(Constants.ERROR_WRONG_DATA_FORMAT);
					return null;
				}
				LocalDate date = null;
				try
				{
					date = LocalDate.parse(parts[2], simpleformat);
				} catch (DateTimeParseException e)
				{
					e.printStackTrace();
					return null;
				}
				User user = new User(parts[0], Gender.getGenderFromString(parts[1]), date);
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
}
