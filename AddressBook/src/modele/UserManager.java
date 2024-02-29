package modele;

import java.util.ArrayList;
import java.util.List;

import utils.CustomFileReader;

/**
 * Manage a list of users
 */
public class UserManager
{
	private List<User> _users;

	/**
	 * Constructor
	 *
	 * Note: This constructor initializes the list of users as empty.
	 */
	public UserManager()
	{
		_users = new ArrayList<>();
	}

	/**
	 * Initializes the list of users by reading data from the given file path
	 *
	 * @param filepath Path to the file containing data
	 */
	public void init(String filepath)
	{
		CustomFileReader reader = new CustomFileReader(filepath);
		_users = reader.read();
	}

	/**
	 * Gets the user from the list of users by his name
	 *
	 * @param name Name of the user to find
	 *
	 * @return User, or null if the user is not find
	 */
	public User getUserByName(String name)
	{
		if (_users == null)
			return null;
		
		for(User u : _users)
		{
			if (u.getName().equals(name)) {
				return u;
			}
		}
		return null;
	}

	/**
	 * Returns the list of users
	 *
	 * @return List of users
	 */
	public List<User> getUsers() {
		return _users;
	}

	/**
	 * Sets the list of users
	 *
	 * @param New list of users
	 */
	public void setUsers(List<User> users) {
		this._users = users;
	}
}
