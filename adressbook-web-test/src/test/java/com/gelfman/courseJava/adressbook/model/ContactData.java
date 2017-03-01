package com.gelfman.courseJava.adressbook.model;

public class ContactData {
	private final String id;
	private final String firstName;
	private final String middlename;
	private final String lastName;
	private String group;

	public ContactData ( String id, String firstName, String middlename, String lastName, String group ) {
		this.id = id;
		this.firstName = firstName;
		this.middlename = middlename;
		this.lastName = lastName;
		this.group = group;
	}

	public ContactData ( String firstName, String middlename, String lastName, String group ) {
		this.id = null;
		this.firstName = firstName;
		this.middlename = middlename;
		this.lastName = lastName;
		this.group = group;
	}
	public String getGroup () {
		return group;
	}

	@Override
	public boolean equals ( Object o ) {
		if (this == o) return true;
		if (!(o instanceof ContactData)) return false;

		ContactData that = (ContactData) o;

		if (getId () != null ? !getId ().equals ( that.getId () ) : that.getId () != null) return false;
		if (getFirstName () != null ? !getFirstName ().equals ( that.getFirstName () ) : that.getFirstName () != null)
			return false;
		return getLastName () != null ? getLastName ().equals ( that.getLastName () ) : that.getLastName () == null;

	}

	@Override
	public int hashCode () {
		int result = getId () != null ? getId ().hashCode () : 0;
		result = 31 * result + (getFirstName () != null ? getFirstName ().hashCode () : 0);
		result = 31 * result + (getLastName () != null ? getLastName ().hashCode () : 0);
		return result;
	}

	@Override
	public String toString () {
		return "ContactData{" +
						"id='" + id + '\'' +
						", firstName='" + firstName + '\'' +
						", lastName='" + lastName + '\'' +
						'}';
	}

	public String getId () {
		return id;
	}

	public String getFirstName () {
		return firstName;
	}

	public String getMiddlename () {
		return middlename;
	}

	public String getLastName () {
		return lastName;
	}
}
