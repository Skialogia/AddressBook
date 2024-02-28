package modele;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
			System.out.print("");
			return null;
		}
		
		if (!file.isFile())
		{
			System.out.print("");
			return null;
		}
		
		if (!file.canRead())
		{
			System.out.print("");
			return null;
		}
		
		try(BufferedReader br = new BufferedReader(new FileReader(file)))
		{
			
			String line = br.readLine();
			String[] parts;
			SimpleDateFormat simpleformat = new SimpleDateFormat("dd/MM/yy");
			while (line != null)
			{
				parts = line.split(", ");
				if (parts.length != 3)
				{
					System.out.print("");
					return null;
				}
				Date date = null;
				try
				{
					date = simpleformat.parse(parts[2]);
				} catch (ParseException e)
				{
					e.printStackTrace();
					return null;
				}
				User user = new User(parts[0], parts[1], date);
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
