package utils;

/**
 * Enum representing the gender of a person
 */
public enum Gender
{
	MALE("Male"),
	FEMALE("Female"),
	OTHER("Other");

	private String _name;

	/**
	 * Constructor
	 *
	 * @param name Name of the gender
	 */
	Gender(String name)
	{
		this._name = name;
	}

	/**
	 * Returns name of the gender
	 *
	 * @return Name of the gender
	 */
	public String getName()
	{
		return _name;
	}

	/**
	 * Get the gender enum from a string
	 *
	 * @param name Name of the gender
	 *
	 * @return Gender corresponding to the given name. If not Male or Female, return Other
	 */
	public static Gender getGenderFromString(String name)
	{
		if (name.length() > 0) {
			name = Character.toUpperCase(name.charAt(0)) + name.substring(1).toLowerCase();
		}

		if (Gender.MALE.getName().equals(name)) {
			return Gender.MALE;
		} else if (Gender.FEMALE.getName().equals(name)) {
			return Gender.FEMALE;
		} else {
			return Gender.OTHER;
		}
	}
}
