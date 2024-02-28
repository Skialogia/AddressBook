package modele;

import java.util.Date;


/**
 * Based on the file text, we can define an user by a name, a gender and a birth date.
 * --> NAME, GENDER, dd/MM/yy
 */
public class User 
{
	private String _name;
	private String _gender;
	private Date _birthDate;
	
	/**
	 * Constructor
	 * 
	 * @param name Name of user
	 * @param gender Gender of user
	 * @param birthDate Birth date of user
	 */
	public User(String name, String gender, Date birthDate) {
		super();
		this._name = name;
		this._gender = gender;
		this._birthDate = birthDate;
	}

	/**
	 * Returns the name of the user
	 * 
	 * @return Name of the user
	 */
	public String get_name() {
		return _name;
	}

	/**
	 * Sets the name of the user
	 * 
	 * @param New name of the user
	 */
	public void set_user(String name) {
		this._name = name;
	}

	/**
	 * Returns the gender of the user
	 * 
	 * @return Gender of the user
	 */
	public String get_gender() {
		return _gender;
	}

	/**
	 * Sets the gender of the user
	 * 
	 * @param Gender of the user
	 */
	public void set_gender(String gender) {
		this._gender = gender;
	}

	/**
	 * Returns the birth date of the user
	 * 
	 * @return Birth date of the user
	 */
	public Date get_birthDate() {
		return _birthDate;
	}

	/**
	 * Sets the birth date of the user
	 * 
	 * @param Birth date of the user
	 */
	public void set_birthDate(Date birthDate) {
		this._birthDate = birthDate;
	}
	
	
}
